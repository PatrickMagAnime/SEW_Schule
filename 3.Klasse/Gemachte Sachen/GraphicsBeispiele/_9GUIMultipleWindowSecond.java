package GraphicsBeispiele;

import javax.swing.*;

public class _9GUIMultipleWindowSecond extends JFrame {
    public _9GUIMultipleWindowSecond() {
        this.setTitle("2. Fenster"); // this -> JFrame
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setVisible(true);

        JLabel label = new JLabel("Wir befinden uns im 2.Fenster ", SwingConstants.CENTER); // Hier SwingConstants.CENTER, um den Text zentriert anzuzeigen, da wir kein LayoutManager verwenden
        this.add(label);
    }
}