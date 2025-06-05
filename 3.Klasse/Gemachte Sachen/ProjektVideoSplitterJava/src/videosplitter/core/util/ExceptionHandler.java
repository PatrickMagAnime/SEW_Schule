package videosplitter.core.util;

import javax.swing.*;

/**
 * Fehlerbehandlung (Dialog + Logging).
 */
public class ExceptionHandler {
    public static void handle(Exception e, java.awt.Component parent) {
        Logger.logError("Fehler: " + e.getMessage(), e);
        JOptionPane.showMessageDialog(parent, "Ein Fehler ist aufgetreten:\n" + e.getMessage(),
                "Fehler", JOptionPane.ERROR_MESSAGE);
    }
}