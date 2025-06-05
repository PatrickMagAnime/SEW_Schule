package GraphicsBeispiele;

import javax.swing.*;
import java.awt.*;

public class _1GUIGraphicsHouse extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawHouse(g);
        drawTree(g);
    }

    public void drawHouse(Graphics g) {
        // Dach
        g.setColor(Color.RED);
        int[] x = {100, 250, 400};
        int[] y = {100, 20, 100};
        g.fillPolygon(x, y, 3);

        // Gebäude
        g.setColor(Color.PINK);
        g.fillRect(100, 100, 300, 100);

        // Türe mit top farbe
        g.setColor(Color.GREEN);
        g.fillRect(120, 140, 40, 60);

        // Fenster
        g.setColor(Color.BLUE);
        g.fillRect(300, 140, 40, 40);

        // Linie Fenster1
        g.setColor(Color.BLACK);
        g.drawLine(320, 140, 320, 180);
        g.drawLine(300, 160, 340, 160);
    }

    public void drawTree(Graphics g) {
        // Stamm
        g.setColor(new Color(105, 70, 42));
        g.fillRect(500, 100, 20, 100);

        // Blätter
        g.setColor(Color.GREEN);
        g.fillOval(460, 50, 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new _1GUIGraphicsHouse());
        frame.setSize(600, 500);
        frame.setVisible(true);
    }
}
