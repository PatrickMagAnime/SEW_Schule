package videosplitter.gui;

import videosplitter.core.ConfigManager;
import videosplitter.core.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Hauptfenster der Anwendung.
 */
public class MainWindow extends JFrame {

    private JButton openButton;
    private JButton splitButton;
    private JButton settingsButton;
    private JLabel videoLabel;

    private File selectedVideo;

    public MainWindow() {
        setTitle("VideoSplitter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/icons/app_icon.png")).getImage());

        initComponents();
    }

    private void initComponents() {
        openButton = new JButton("Video öffnen");
        splitButton = new JButton("Splitten");
        settingsButton = new JButton("Einstellungen");
        videoLabel = new JLabel("Kein Video ausgewählt", SwingConstants.CENTER);

        openButton.addActionListener(this::onOpen);
        splitButton.addActionListener(this::onSplit);
        settingsButton.addActionListener(e -> new AboutDialog(this).setVisible(true));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(splitButton);
        buttonPanel.add(settingsButton);

        add(videoLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void onOpen(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Video-Dateien", "mp4", "avi", "mkv"));
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedVideo = chooser.getSelectedFile();
            videoLabel.setText("Ausgewählt: " + selectedVideo.getName());
            Logger.logInfo("Video ausgewählt: " + selectedVideo.getAbsolutePath());
        }
    }

    private void onSplit(ActionEvent e) {
        if (selectedVideo == null) {
            JOptionPane.showMessageDialog(this, "Bitte erst ein Video auswählen!", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }
        new SplitDialog(this, selectedVideo).setVisible(true);
    }
}