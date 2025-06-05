package videosplitter.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Über-Dialog mit Programminfos.
 */
public class AboutDialog extends JDialog {
    public AboutDialog(Frame owner) {
        super(owner, "Über VideoSplitter", true);
        setSize(300, 150);
        setLocationRelativeTo(owner);

        JLabel label = new JLabel("<html><center>VideoSplitter V1.0<br>© 2025 PatrickMagAnime<br>Mit FFmpeg und Swing</center></html>", SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        JButton close = new JButton("Schließen");
        close.addActionListener(e -> setVisible(false));
        add(close, BorderLayout.SOUTH);
    }
}