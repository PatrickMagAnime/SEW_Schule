package hauptanforderungen.mittextarea.textfield;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditCardWindow extends JFrame {
    private JTextField tfFrage;
    private JTextField tfAntwort;
    private JTextField tfAnzahlGefragt;
    private JTextField tfAnzahlRichtig;
    private JButton speichernButton;
    private JPanel editCardPanel;

    boolean isOpen = false;

    public EditCardWindow(Karte karte, ArrayList<Karte> karten, CardManagerWindow cardManagerWindow) {
        isOpen = true;
        if(karte == null) { // Wenn keine Karte übergeben wird, dann ist es eine neue Karte
           this.setTitle("Karte hinzufügen");
        }
        else {
           this.setTitle("Karte bearbeiten");
        }

        this.setContentPane(editCardPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 400);

        if (karte != null) { // Wenn eine Karte bearbeitet wird, setzen wir die Textfelder gleich auf den aktuellen Inhalt
            tfFrage.setText(karte.getFrage());
            tfAntwort.setText(karte.getAntwort());
            tfAnzahlGefragt.setText(String.valueOf(karte.getAnzahlGefragt()));
            tfAnzahlRichtig.setText(String.valueOf(karte.getAnzahlRichtig()));
        }

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String frage = tfFrage.getText();
                String antwort = tfAntwort.getText();
                int anzahlGefragt = 0, anzahlRichtig = 0;

                try {
                    anzahlGefragt = Integer.parseInt(tfAnzahlGefragt.getText());
                    anzahlRichtig = Integer.parseInt(tfAnzahlRichtig.getText());
                    if (anzahlGefragt < 0 || anzahlRichtig < 0) {
                        JOptionPane.showMessageDialog(null, "Die Anzahl der Fragen und Antworten muss positiv sein.");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie eine gültige Zahl ein.");
                    return;
                }
                    if (karte == null) { // Wenn keine Karte übergeben wird, dann ist es eine neue Karte. Deswegen erstellen wir eine neue Karte und speichern diese in der ArrayList
                        Karte newKarte = new Karte(frage, antwort, false, anzahlGefragt, anzahlRichtig);
                        karten.add(newKarte);
                    } else { // Wenn eine Karte bearbeitet wird, dann setzen wir die Werte der Karte auf die neuen Werte
                        karte.setFrage(frage);
                        karte.setAntwort(antwort);
                        karte.setAnzahlGefragt(anzahlGefragt);
                        karte.setAnzahlRichtig(anzahlRichtig);
                    }
                    cardManagerWindow.updateTextArea(); // Aktualisieren der TextArea in der Hauptklasse
                    dispose(); // Unbedingt am Ende aufrufen, damit das Fenster geschlossen wird.
                }

        });
    }
}