package GraphicsBeispiele;

import javax.swing.*;
import java.awt.*;

public class _5GUIAnimation extends JPanel {
    private int x = 0;
    private int y = 0;

    public _5GUIAnimation() {
        Timer timer = new Timer(30, e -> { // Timer alle 30ms
            x += 5; // Verschiebung vom blauen Kreis um 5 Pixel nach rechts
            y += 5; // Verschiebung vom blauen Kreis um 5 Pixel nach unten
            repaint(); // Repaint ruft automatisch update und somit paintComponent auf
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 50, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation Beispiel");
        frame.setContentPane(new _5GUIAnimation());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}