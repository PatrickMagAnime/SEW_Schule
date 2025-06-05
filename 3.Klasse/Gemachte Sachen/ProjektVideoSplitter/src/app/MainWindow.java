package app;

import utils.VideoProcessor;
import utils.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

//dev keybind menu
//ctrl+alt+s

public class MainWindow extends JFrame {
    private JButton btnStart;
    private JButton btnSettings;
    private JLabel lblStatus;

    private VideoProcessor processor;
    private Settings settings;

    public MainWindow() {
        super("Video Processing Application");
        settings = new Settings();
        try {
            settings.loadSettings();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, "Fehler beim Laden der Einstellungen: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Create UI components
        btnStart = new JButton("Processing Starten");
        btnSettings = new JButton("Einstellungen");
        lblStatus = new JLabel("Status: Idle");

        // Panel for buttons
        JPanel panelButtons = new JPanel();
        panelButtons.add(btnStart);
        panelButtons.add(btnSettings);

        add(panelButtons, BorderLayout.NORTH);
        add(lblStatus, BorderLayout.SOUTH);

        // Add action listeners
        btnStart.addActionListener(e -> startProcessing());

        btnSettings.addActionListener(e -> new SettingsWindow(MainWindow.this, settings));

        // Secret key combination: Ctrl+Alt+S opens WatermarkWindow
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.isControlDown() && e.isAltDown() && e.getKeyCode() == KeyEvent.VK_S) {
                    new WatermarkWindow(MainWindow.this, settings);
                }
            }
        });

        // Ensure the frame is focusable to capture key events.
        setFocusable(true);

        setVisible(true);
    }

    private void startProcessing() {
        lblStatus.setText("Status: Processing...");
        processor = new VideoProcessor(new File("input"), new File("output"), settings);
        // Start video processing in a new thread.
        new Thread(() -> {
            try {
                processor.processVideos();
                SwingUtilities.invokeLater(() -> lblStatus.setText("Status: Processing abgeschlossen!"));
            } catch(Exception ex) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(MainWindow.this, "Fehler: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                );
            }
        }).start();
    }
}