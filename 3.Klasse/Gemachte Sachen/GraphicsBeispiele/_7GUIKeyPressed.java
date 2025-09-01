package GraphicsBeispiele;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class _7GUIKeyPressed extends JPanel {
    private int x = 200;
    private int y = 200;

    private JPanel panel;

    public _7GUIKeyPressed() {
        panel = new JPanel();
        panel.setFocusable(true); // Um KeyEvents zu empfangen, muss das Panel fokussierbar sein
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode(); // Keycodes sind Konstanten, die die Tasten repräsentieren
                switch (key) { // VK steht für Virtual Key, hier sind VK_LEFT, VK_RIGHT, VK_UP und VK_DOWN die Pfeiltasten
                    case KeyEvent.VK_LEFT:
                        x -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        x += 10;
                        break;
                    case KeyEvent.VK_UP:
                        y -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        y += 10;
                        break;
                }
                repaint(); // Immer wenn sich die Position ändert, wird das Panel neu gezeichnet
            }
        });

        this.add(panel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Pressed Example");
        frame.setContentPane(new _7GUIKeyPressed());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}