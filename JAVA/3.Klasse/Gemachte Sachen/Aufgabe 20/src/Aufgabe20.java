import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Aufgabe20 extends JFrame {
    private DrawingPanel drawingPanel;
    private Color selectedColor = Color.BLACK;
    private String selectedShape = "Freehand";
    private int strokeWidth = 1;
    private boolean fillShapes = false;

    public Aufgabe20() {
        setTitle("Mein Zeichenprogramm");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout());

        //button um eine Farbe auszuwählen
        JButton colorButton = new JButton("Farbe wählen");
        colorButton.addActionListener(e -> {
            Color color = JColorChooser.showDialog(null, "Wähle eine Farbe", selectedColor);
            if (color != null) {
                selectedColor = color;
            }
        });
        controlPanel.add(colorButton);

        //Dropdown menü
        String[] shapes = {"Freehand", "Rectangle", "Circle", "Triangle"};
        JComboBox<String> shapeSelector = new JComboBox<>(shapes);
        shapeSelector.addActionListener(e -> selectedShape = (String) shapeSelector.getSelectedItem());
        controlPanel.add(shapeSelector);

        // Slider, um die Strichstärke einzustellen
        JSlider strokeSlider = new JSlider(1, 10, 1);
        strokeSlider.setMajorTickSpacing(1);
        strokeSlider.setPaintTicks(true);
        strokeSlider.setPaintLabels(true);
        strokeSlider.addChangeListener(e -> strokeWidth = strokeSlider.getValue());
        controlPanel.add(new JLabel("Strichstärke:"));
        controlPanel.add(strokeSlider);

        // Checkbox zum Angeben, ob die Formen gefüllt gezeichnet werden
        JCheckBox fillCheckbox = new JCheckBox("Gefüllt");
        fillCheckbox.addActionListener(e -> fillShapes = fillCheckbox.isSelected());
        controlPanel.add(fillCheckbox);

        // Button, um die Animation zu starten
        JButton animateButton = new JButton("Animation starten");
        animateButton.addActionListener(e -> drawingPanel.startAnimation());
        controlPanel.add(animateButton);

        add(controlPanel, BorderLayout.NORTH);

        // Untere Leiste mit WASD-Buttons zur Bewegung der Figuren
        JPanel wasdPanel = new JPanel();
        wasdPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 1;
        gbc.gridy = 0;
        wasdPanel.add(new JLabel(""), gbc);

        JButton buttonW = new JButton("W");
        gbc.gridx = 1;
        gbc.gridy = 1;
        wasdPanel.add(buttonW, gbc);
        buttonW.addActionListener(e -> drawingPanel.moveShapes(0, -5));

        JButton buttonA = new JButton("A");
        gbc.gridx = 0;
        gbc.gridy = 2;
        wasdPanel.add(buttonA, gbc);
        buttonA.addActionListener(e -> drawingPanel.moveShapes(-5, 0));

        JButton buttonS = new JButton("S");
        gbc.gridx = 1;
        gbc.gridy = 2;
        wasdPanel.add(buttonS, gbc);
        buttonS.addActionListener(e -> drawingPanel.moveShapes(0, 5));

        JButton buttonD = new JButton("D");
        gbc.gridx = 2;
        gbc.gridy = 2;
        wasdPanel.add(buttonD, gbc);
        buttonD.addActionListener(e -> drawingPanel.moveShapes(5, 0));

        gbc.gridx = 2;
        gbc.gridy = 0;
        wasdPanel.add(new JLabel(""), gbc);

        add(wasdPanel, BorderLayout.SOUTH);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int dx = 0, dy = 0;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:    dy = -5; break;
                    case KeyEvent.VK_DOWN:  dy = 5;  break;
                    case KeyEvent.VK_LEFT:  dx = -5; break;
                    case KeyEvent.VK_RIGHT: dx = 5;  break;
                }
                drawingPanel.moveShapes(dx, dy);
            }
        });
        setFocusable(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Aufgabe20 program = new Aufgabe20();
            program.setVisible(true);
        });
    }

    class DrawingPanel extends JPanel {
        private ArrayList<Shape> shapes = new ArrayList<>();
        private Shape currentShape;

        public DrawingPanel() {
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentShape = createShape(e.getX(), e.getY());
                    shapes.add(currentShape);
                    repaint();
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    currentShape = null;
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if ("Freehand".equals(selectedShape) && currentShape != null) {
                        currentShape.addPoint(e.getX(), e.getY());
                        repaint();
                    }
                }
            });
        }

        private Shape createShape(int x, int y) {
            switch (selectedShape) {
                case "Rectangle":
                    return new RectangleShape(x, y, selectedColor, strokeWidth, fillShapes);
                case "Circle":
                    return new CircleShape(x, y, selectedColor, strokeWidth, fillShapes);
                case "Triangle":
                    return new TriangleShape(x, y, selectedColor, strokeWidth, fillShapes);
                default:
                    return new FreehandShape(x, y, selectedColor, strokeWidth);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            // Jede Form wird gezeichnet
            for (Shape shape : shapes) {
                shape.draw(g2d);
            }
        }

        public void startAnimation() {
            Timer timer = new Timer(30, e -> {
                for (Shape shape : shapes) {
                    shape.move();
                }
                repaint();
            });
            timer.start();
        }

        public void moveShapes(int dx, int dy) {
            for (Shape shape : shapes) {
                shape.translate(dx, dy);
            }
            repaint();
        }
    }

    abstract class Shape {
        int x, y;
        Color color;
        int strokeWidth;
        int dx, dy;

        public Shape(int x, int y, Color color, int strokeWidth) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.strokeWidth = strokeWidth;
            Random rnd = new Random();
            dx = rnd.nextInt(7) - 3;  // Zufallswert im Bereich -3 bis 3
            while (dx == 0) { dx = rnd.nextInt(7) - 3; }
            dy = rnd.nextInt(7) - 3;
            while (dy == 0) { dy = rnd.nextInt(7) - 3; }
        }

        abstract void draw(Graphics2D g);

        void move() {
            translate(dx, dy);
        }

        void addPoint(int x, int y) {}

        void translate(int dx, int dy) {
            x += dx;
            y += dy;
        }
    }

    class FreehandShape extends Shape {
        private ArrayList<Point> points = new ArrayList<>();

        public FreehandShape(int x, int y, Color color, int strokeWidth) {
            super(x, y, color, strokeWidth);
            dx = 0;
            dy = 0;
            points.add(new Point(x, y));
        }

        @Override
        void draw(Graphics2D g) {
            g.setColor(color);
            g.setStroke(new BasicStroke(strokeWidth));
            for (int i = 1; i < points.size(); i++) {
                Point p1 = points.get(i - 1);
                Point p2 = points.get(i);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        @Override
        void addPoint(int x, int y) {
            points.add(new Point(x, y));
        }
    }

    class RectangleShape extends Shape {
        boolean filled;

        public RectangleShape(int x, int y, Color color, int strokeWidth, boolean filled) {
            super(x, y, color, strokeWidth);
            this.filled = filled;
        }

        @Override
        void draw(Graphics2D g) {
            g.setColor(color);
            g.setStroke(new BasicStroke(strokeWidth));
            if (filled) {
                g.fillRect(x - 25, y - 25, 50, 50);
            } else {
                g.drawRect(x - 25, y - 25, 50, 50);
            }
        }
    }

    class CircleShape extends Shape {
        boolean filled;

        public CircleShape(int x, int y, Color color, int strokeWidth, boolean filled) {
            super(x, y, color, strokeWidth);
            this.filled = filled;
        }

        @Override
        void draw(Graphics2D g) {
            g.setColor(color);
            g.setStroke(new BasicStroke(strokeWidth));
            if (filled) {
                g.fillOval(x - 25, y - 25, 50, 50);
            } else {
                g.drawOval(x - 25, y - 25, 50, 50);
            }
        }
    }

    class TriangleShape extends Shape {
        boolean filled;

        public TriangleShape(int x, int y, Color color, int strokeWidth, boolean filled) {
            super(x, y, color, strokeWidth);
            this.filled = filled;
        }

        @Override
        void draw(Graphics2D g) {
            g.setColor(color);
            g.setStroke(new BasicStroke(strokeWidth));
            int[] xPoints = {x, x - 30, x + 30};
            int[] yPoints = {y - 30, y + 30, y + 30};
            if (filled) {
                g.fillPolygon(xPoints, yPoints, 3);
            } else {
                g.drawPolygon(xPoints, yPoints, 3);
            }
        }
    }
}