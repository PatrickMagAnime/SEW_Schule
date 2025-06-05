package videosplitter;

import videosplitter.gui.MainWindow;
import videosplitter.core.util.Logger;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Logger.logInfo("Programmstart");
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                Logger.logError("LookAndFeel konnte nicht gesetzt werden.", e);
            }
            new MainWindow().setVisible(true);
        });
    }
}