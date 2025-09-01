package GraphicsBeispiele;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _4GUIColorPicker extends JPanel {
    private Color color = Color.BLACK;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
    }

    public void updateColor(Color newColor) {
        this.color = newColor;
        repaint();
    }

    public _4GUIColorPicker() {
        // Beispiel für das Öffnen des Farbwählers
        // JColorChooser ist ein Dialog, der es dem Benutzer ermöglicht, eine Farbe auszuwählen
        // showDialog() gibt die ausgewählte Farbe zurück
        // showDialog() gibt null zurück, wenn der Benutzer auf "Abbrechen" klickt

        // Hier wird ein Button und der ActionListener hinzugefügt, der dann das Dialogfenster für die Farbauswahl öffnet
        JButton colorButton = new JButton("Farbe wählen");

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(_4GUIColorPicker.this, "Wähle eine Farbe", color);

                if (newColor != null) { // Falls der Benutzer auf "Abbrechen" klickt, wird die Farbe nicht geändert und es wird null zurückgegeben
                    updateColor(newColor);
                }
            }
        });
        this.add(colorButton);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        _4GUIColorPicker panel = new _4GUIColorPicker();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setSize(500, 300);
        frame.setVisible(true);

    }
}