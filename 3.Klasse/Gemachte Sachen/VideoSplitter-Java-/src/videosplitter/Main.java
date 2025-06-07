package videosplitter;

import videosplitter.gui.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow main = new MainWindow();
            main.setLocationRelativeTo(null);
            main.setVisible(true);

            ProInfoWindow proInfo = new ProInfoWindow();
            proInfo.setVisible(true);

        });
    }
}