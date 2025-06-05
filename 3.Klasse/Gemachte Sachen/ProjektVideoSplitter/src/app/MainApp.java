package app;

import javax.swing.SwingUtilities;

public class MainApp {
    public static void main(String[] args) {
        //startet die GUI
        SwingUtilities.invokeLater(() -> {
            new MainWindow();
        });
    }
}