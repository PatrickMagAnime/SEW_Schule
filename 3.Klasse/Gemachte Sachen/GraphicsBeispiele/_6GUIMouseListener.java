package GraphicsBeispiele;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class _6GUIMouseListener extends JPanel {
    private final ArrayList<Point> points = new ArrayList<>();
    private final JButton deleteButton;
    private final JPanel panel;

    public _6GUIMouseListener() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        deleteButton = new JButton("Löschen");
        deleteButton.addActionListener(e -> {
            points.clear(); // Löscht alle Punkte
            repaint();
        });

        panel.add(deleteButton, BorderLayout.NORTH);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { // Wenn Maus einmal gedrückt wird
                points.add(e.getPoint()); // Über Event kann die Position des Mausklicks abgefragt werden -> getPoint() gibt die x- und y-Koordinaten zurück
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) { // Wenn Maus gedrückt wird und bewegt wird
                points.add(e.getPoint());
                repaint();
            }
        };
        this.addMouseListener(mouseAdapter); // MouseAdapter muss im Gegensatz zu ActionListener extra zum Panel hinzugefügt werden
        this.addMouseMotionListener(mouseAdapter);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (Point point : points) { // For-each-Schleife, die alle Punkte durchgeht. Zeichnet für jeden Punkt einen blauen Kreis
            g.fillOval(point.x - 10, point.y - 10, 20, 20);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Listener");
        frame.setContentPane(new _6GUIMouseListener());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}