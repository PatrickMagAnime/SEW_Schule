package videosplitter.gui;

import videosplitter.core.*;
import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import java.io.File;
import java.util.List;

public class MainWindow extends JFrame {
    private ProjectManager manager = new ProjectManager();
    private Settings settings = Settings.autoLoadOrNew();
    private ImagePanel imagePanel;
    private static final String PREVIEW_PATH = "preview.jpg";
    private JProgressBar progressBar;

    public MainWindow() {
        setTitle("VideoSplitter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(900, 500);

        imagePanel = new ImagePanel("resources/sample.jpg");
        add(imagePanel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel();
        JButton btnLoad = new JButton("Verzeichnis laden");
        JButton btnSplit = new JButton("Video splitten");
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSplit);
        add(buttonPanel, BorderLayout.SOUTH);

        //Fortschrittsbalken
        progressBar = new JProgressBar();
        progressBar.setIndeterminate(false);
        progressBar.setVisible(false);
        add(progressBar, BorderLayout.NORTH); // Oder SOUTH, wie du magst

        DefaultListModel<MediaFile> listModel = new DefaultListModel<>();
        JList<MediaFile> mediaList = new JList<>(listModel);
        mediaList.setCellRenderer((list, value, index, isSelected, cellHasFocus) -> {
            JLabel label = new JLabel(value.toString());
            if (isSelected) {
                label.setOpaque(true);
                label.setBackground(new Color(200,230,255));
            }
            return label;
        });
        add(new JScrollPane(mediaList), BorderLayout.CENTER);

        // Drag & Drop für Dateien und Ordner
        mediaList.setDropTarget(new DropTarget() {
            @Override
            public synchronized void drop(DropTargetDropEvent dtde) {
                try {
                    dtde.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> droppedFiles = (List<File>) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    for (File file : droppedFiles) {
                        if (file.isDirectory()) {
                            manager.loadMediaFromDirectory(file);
                        } else {
                            VideoFormat vf = manager.detectVideoFormat(file.getName());
                            if (vf != VideoFormat.UNKNOWN) {
                                manager.getVideos().add(new VideoFile(file.getAbsolutePath(), file.length(), vf, 0.0));
                            } else {
                                AudioFormat af = manager.detectAudioFormat(file.getName());
                                if (af != AudioFormat.UNKNOWN) {
                                    manager.getAudios().add(new AudioFile(file.getAbsolutePath(), file.length(), af, 0.0));
                                }
                            }
                        }
                    }
                    reloadList(listModel);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Vorschau beim auswählen eines videos erzeugen/anzeigen
        mediaList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { //Nur reagieren wenn endgültig ausgewählt
                MediaFile mf = mediaList.getSelectedValue();
                if (mf instanceof VideoFile) {
                    String previewPath = VideoProcessor.extractPreviewImage(mf.getPath(), PREVIEW_PATH);
                    if (previewPath != null) {
                        imagePanel.setImage(previewPath);
                    } else {
                        imagePanel.setImage("resources/sample.jpg");
                    }
                } else {
                    imagePanel.setImage("resources/sample.jpg");
                }
            }
        });

        btnLoad.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File dir = chooser.getSelectedFile();
                try {
                    manager.getVideos().clear();
                    manager.getAudios().clear();
                    manager.loadMediaFromDirectory(dir);
                    reloadList(listModel);
                    settings.setLastDirectory(dir.getAbsolutePath());
                    Logger.log("Directory loaded: " + dir.getAbsolutePath());
                } catch (Exception ex) {
                    Logger.log("Fehler beim Laden: " + ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Fehler beim Laden: " + ex.getMessage());
                }
            }
        });

        btnSplit.addActionListener(e -> {
            MediaFile mf = mediaList.getSelectedValue();
            if (!(mf instanceof VideoFile)) {
                JOptionPane.showMessageDialog(this, "Bitte wählen Sie ein Video aus.");
                return;
            }
            VideoSplitSettingsDialog dialog = new VideoSplitSettingsDialog(this, settings);
            dialog.setVisible(true);
            if (!dialog.isConfirmed()) return;
            settings = dialog.getSettings();

            // Split startet im Hintergrund Thread!
            //das herauszufinden hat zu lange gedauert
            //stackoverflow und llm's mussten bischen helfen
            new Thread(() -> {
                try {
                    SwingUtilities.invokeLater(() -> {
                        progressBar.setIndeterminate(true);
                        progressBar.setVisible(true);
                    });

                    int parts;
                    if (settings.isSplitByParts()) {
                        parts = settings.getDefaultSegments();
                    } else {
                        double duration = ((VideoFile)mf).getDuration();
                        if (duration <= 0) {
                            duration = VideoProcessor.getVideoDuration(mf.getPath());
                        }
                        parts = (int)Math.ceil(duration / settings.getSplitSeconds());
                    }
                    Logger.log("Split: " + mf.getPath() + " -> " + parts + " parts, name=" + settings.getCustomName());
                    new VideoProcessor().splitVideo((VideoFile)mf, parts, settings.getCustomName(), settings);

                    //audio extrahieren falls gewünscht
                    if (settings.isExtractAudio()) {
                        SwingUtilities.invokeLater(() -> {
                            JFileChooser chooser = new JFileChooser();
                            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                            chooser.setDialogTitle("Zielordner für extrahiertes Audio wählen");
                            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                                File dir = chooser.getSelectedFile();
                                AudioFormat af = AudioFormat.valueOf(settings.getAudioFormat());
                                new VideoProcessor().extractAudioFromVideo((VideoFile)mf, settings.getCustomName(), dir, af);
                            }
                        });
                    }
                } catch (Exception ex) {
                    Logger.log("Ungültige Eingabe: " + ex.getMessage());
                    SwingUtilities.invokeLater(() ->
                            JOptionPane.showMessageDialog(this, "Ungültige Eingabe.")
                    );
                } finally {
                    SwingUtilities.invokeLater(() -> {
                        progressBar.setIndeterminate(false);
                        progressBar.setVisible(false);
                    });
                }
            }).start();
        });

        //Einstellungen automatisch laden & medienliste füllen(also anzeigen von inhalt des ordners)
        if (settings.getLastDirectory() != null) {
            File dir = new File(settings.getLastDirectory());
            if (dir.exists() && dir.isDirectory()) {
                manager.loadMediaFromDirectory(dir);
                reloadList(listModel);
            }
        }
    }

    //ladet neu falls neue dateien hinein kommen
    private void reloadList(DefaultListModel<MediaFile> listModel) {
        listModel.clear();
        for (VideoFile vf : manager.getVideos()) listModel.addElement(vf);
        for (AudioFile af : manager.getAudios()) listModel.addElement(af);
    }


}