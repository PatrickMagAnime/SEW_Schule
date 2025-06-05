package GraphicsBeispiele;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class _8Graphics2D extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // 2D Graphics bietet mehr Funktionen als 1D Graphics

        // Hier wird Antialiasing aktiviert, um die Kanten der Formen weicher zu machen und somit die Qualität zu verbessern
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Wie gewohnt können wir Farben einstellen und Formen zeichnen
        g2d.setColor(Color.RED);
        g2d.fill(new Rectangle2D.Double(50, 50, 100, 100)); // Zuerst neues Objekt erstellen, danach mit 2D Graphics füllen

        g2d.setColor(Color.BLUE);
        g2d.fill(new Ellipse2D.Double(200, 50, 100, 100));

        g2d.setColor(Color.GREEN);
        g2d.draw(new Line2D.Double(50, 200, 300, 200));

        // Mit AffineTransform können wir Objekte transformieren (drehen, skalieren, verschieben)
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(45), 150, 150);
        g2d.setTransform(transform);

        // Wir müssen zuerst die Transformation setzen, bevor wir die Formen zeichnen
        g2d.setColor(Color.ORANGE);
        g2d.fill(new Rectangle2D.Double(100, 100, 100, 100));

        // Transformation zurücksetzen
        g2d.setTransform(new AffineTransform());

        // Text zeichnen, geht auch mit Graphics2D und Schriftart können eingestellt werden
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Serif", Font.BOLD, 20));
        g2d.drawString("Hello, Graphics2D!", 50, 250);

        // Farbverlauf
        GradientPaint gradient = new GradientPaint(10, 300, Color.RED, 100, 300, Color.BLUE);
        ((Graphics2D) g).setPaint(gradient);
        g.fillRect(10, 300, 100, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Graphics2D Example");
        frame.setContentPane(new _8Graphics2D());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}