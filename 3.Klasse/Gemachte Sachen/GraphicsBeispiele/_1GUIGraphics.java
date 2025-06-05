package GraphicsBeispiele;

import javax.swing.*;
import java.awt.*;

public class _1GUIGraphics extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Verschiedene Objekte zeichnen
        g.drawLine(10, 10, 65, 65);
        g.drawRect(120, 10, 50, 50);
        g.drawOval(200, 10, 50, 50);
        g.drawArc(300, 10, 50, 50, 30, 120);
        g.drawRoundRect(400, 10, 50, 50, 10, 10);
        g.drawPolygon(new int[]{500, 550, 600}, new int[]{10, 60, 10}, 3); // int[] xPoints, int[] yPoints entspricht dann 3 Punkten. 1. Punkt wäre xPoints[0], yPoints[0] usw. Und dann wird eine Linie gezeichnent von: Punkt 1 -> Punkt 2, Punkt 2 -> Punkt 3, Punkt 3 -> Punkt 1
        // Hier in Farbe und einzelne Linien dargestellt und sollte dann genau über dem Polygon sein
        g.setColor(Color.BLUE);
        g.drawLine(500, 10, 550, 60);
        g.setColor(Color.RED);
        g.drawLine(550, 60, 600, 10);
        g.setColor(Color.GREEN);
        g.drawLine(600, 10, 500, 10);
        g.drawPolyline(new int[]{10, 20, 40}, new int[]{100, 50, 100}, 3); // Unterschied zwischen Polygon und Polyline ist, dass bei Polyline keine Linie vom letzten Punkt zum ersten Punkt gezeichnet wird


        // Text zeichnen
        g.drawString("Hello World", 10, 200);
        g.drawChars("Hello World Chars".toCharArray(), 0, 17, 10, 220); // Ist das gleiche wie drawString aber mit char Array
        g.drawBytes("Hello World Bytes".getBytes(), 0, 17, 10, 240); // Ist das gleiche wie drawString aber mit byte Array

        // Farbe setzen
        g.setColor(Color.RED);
        g.fillRect(10, 260, 50, 50);

        g.setColor(new Color(0, 255, 200));
        g.fillOval(100, 260, 50, 50);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Graphics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new _1GUIGraphics());
        frame.setSize(650, 500);
        frame.setVisible(true);
    }
}
