package GraphicsBeispiele;

import javax.swing.*;
import java.awt.*;

public class _3GUIRepaintTimer extends JPanel {
    private String text = "Hello World"; // Attribute in einer Klasse können auch gleich initialisiert werden
    private Color color = Color.BLACK;

    public _3GUIRepaintTimer() {
        // Beispiel für das Aktualisieren des Textes und der Farbe nach 2 Sekunden
        // Timer ist ein Swing Timer und kein normaler Timer. Timer ist ein Event, der in Swing verwendet wird, um z.B. Animationen zu machen

        new Timer(2000, e -> { // hier mit Lambda Expression geschrieben
            this.updateText("Updated Text");
            this.updateColor(Color.BLUE);
        }).start();

        // Sie könnten es auch so schreiben:
//        Timer timer = new Timer(2000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                updateText("Updated Text");
//                updateColor(Color.BLUE);
//            }
//        });
//        timer.start();


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawString(text, 100, 100);

    }

    public void updateText(String newText) {
        this.text = newText;
        repaint(); // repaint() ruft paintComponent() auf
    }

    public void updateColor(Color newColor) {
        this.color = newColor;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        frame.setContentPane(new _3GUIRepaintTimer());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
