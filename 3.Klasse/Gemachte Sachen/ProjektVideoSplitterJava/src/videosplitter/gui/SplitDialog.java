package videosplitter.gui;

import videosplitter.core.VideoSplitter;
import videosplitter.core.util.ExceptionHandler;
import videosplitter.core.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Dialogfenster zum Splitten eines Videos.
 */
public class SplitDialog extends JDialog {

    private JTextField startField;
    private JTextField endField;
    private JButton splitButton;
    private JLabel statusLabel;
    private File videoFile;

    public SplitDialog(Frame owner, File videoFile) {
        super(owner, "Video Splitten", true);
        this.videoFile = videoFile;
        setSize(400, 200);
        setLocationRelativeTo(owner);

        initComponents();
    }

    private void initComponents() {
        startField = new JTextField("00:00:00");
        endField = new JTextField("00:00:10");
        splitButton = new JButton("Splitten");
        statusLabel = new JLabel(" ", SwingConstants.CENTER);

        splitButton.addActionListener(this::onSplit);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Startzeit (hh:mm:ss):"));
        inputPanel.add(startField);
        inputPanel.add(new JLabel("Endzeit (hh:mm:ss):"));
        inputPanel.add(endField);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.CENTER);
        add(splitButton, BorderLayout.SOUTH);
        add(statusLabel, BorderLayout.NORTH);
    }

    private void onSplit(ActionEvent e) {
        String start = startField.getText();
        String end = endField.getText();

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Ziel für geschnittenes Video wählen");
        int result = chooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File output = chooser.getSelectedFile();

            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() {
                    statusLabel.setText("Splitte...");
                    try {
                        VideoSplitter.split(videoFile, output, start, end);
                        statusLabel.setText("Fertig: " + output.getName());
                    } catch (Exception ex) {
                        ExceptionHandler.handle(ex, SplitDialog.this);
                        statusLabel.setText("Fehler beim Splitten!");
                    }
                    return null;
                }
            };
            worker.execute();
        }
    }
}