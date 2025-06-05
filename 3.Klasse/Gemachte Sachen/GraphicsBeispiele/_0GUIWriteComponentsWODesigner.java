package GraphicsBeispiele;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _0GUIWriteComponentsWODesigner extends JFrame {
    private JLabel label;
    private JTextField textField;
    private JButton button;
    private JLabel resultLabel;
    private JPanel panel;

    public _0GUIWriteComponentsWODesigner() {

        // Panel erstellen und Layout setzen
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2)); // Gridlayout ordnet die Komponenten in einem Raster an (hier 3 Zeilen, 2 Spalten)

        // Komponenten hier manuell initialisieren, mittels Konstruktor. Als Übergabeparameter kann ein String für den Text des Labels oder Buttons übergeben werden.
        label = new JLabel("Namen eingeben:");
        textField = new JTextField();
        button = new JButton("Bestätigen");
        resultLabel = new JLabel("");

        // Button-Click-Event hinzufügen
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Wie gehabt, den Namen aus einem Textfeld holen
                String name = textField.getText();

                // Für erstelltes Label den Text setzen mit dem eingegebenen Namen
                resultLabel.setText("Hallo, " + name + "!");
            }
        });

        // Manuelles hinzufügen der Komponenten zum Panel notwendig
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.add(resultLabel);

        // Panel zum Frame hinzufügen. Hier ist add(panel) dasselbe wie this.add(panel). Wenn Sie eine Methode innerhalb einer Instanzmethode (z. B. einen Konstruktor) aufrufen, ohne ein Objekt anzugeben, bezieht sie sich implizit auf das aktuelle Objekt (this).
        // Die add Methode kommt davon, dass unsere Klasse von JFrame erbt und wir direkt auf die add-Methode vom JFrame zugreifen können.
        add(panel); // oder this.add(panel);
    }

    public static void main(String[] args) {
        // Main wie immer: zuerst ein JFrame mit dem Konstruktor der Klasse erstellen. Wir können einen String als Titel übergeben, der Oben im Fenster angezeigt wird.
        JFrame frame = new JFrame("Warenkorb");
        // ContentPane ist der Container, in dem alle sichtbaren Komponenten platziert werden. Hier setzen wir den ContentPane auf unser Panel, um alle Komponenten zu sehen. Um unser Panel auszuwählen, verwenden wir von unserer Klasse unser Attribut panel. Wir müssen jedoch zuerst noch den Konstruktor unserer Klasse aufrufen, um das Panel zu initialisieren. Wir können die Schritte in meiner Zeilen schreiben:
//        _0GUIWriteComponentsWODesigner gui = new _0GUIWriteComponentsWODesigner();
//        JPanel guiPanel = gui.panel;
//        frame.setContentPane(guiPanel);

        // oder in einer Zeile:
        frame.setContentPane(new _0GUIWriteComponentsWODesigner().panel);

        // Nicht unbedingt notwendig. Wenn das Fenster geschlossen wird (bei Klick auf das X oben rechts), wird das Programm beendet.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Pass die Größe des Fensters an die bevorzugten Größen und Layouts seiner Unterkomponenten an
        frame.pack();
        // Fenstergröße setzen
        frame.setSize(400, 200);
        // Das JFrame sichtbar machen
        frame.setVisible(true);


//        JFrame frame = new _0GUIWriteComponentsWODesigner();
//        frame.setVisible(true);
//        // Set the title of the window
//        frame.setTitle("Simple GUI Example");
//
//        // Set the size of the window
//        frame.setSize(400, 200);
//
//        // Set the default close operation
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}