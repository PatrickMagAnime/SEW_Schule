package hauptanforderungen.mittextarea.comboboxjoptionpane;

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

    public EditCardWindow(Karte karte, ArrayList<Karte> karten, CardManagerWindow cardManagerWindow) {
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
                int anzahlGefragt = Integer.parseInt(tfAnzahlGefragt.getText());
                int anzahlRichtig = Integer.parseInt(tfAnzahlRichtig.getText());

                if (karte == null) { // Wenn keine Karte übergeben wird, dann ist es eine neue Karte. Deswegen erstellen wir eine neue Karte und speichern diese in der ArrayList
                    Karte newKarte = new Karte(frage, antwort, false, anzahlGefragt, anzahlRichtig);
                    karten.add(newKarte);
                } else { // Wenn eine Karte bearbeitet wird, dann setzen wir die Werte der Karte auf die neuen Werte
                    karte.setFrage(frage);
                    karte.setAntwort(antwort);
                    karte.setAnzahlGefragt(anzahlGefragt);
                    karte.setAnzahlRichtig(anzahlRichtig);
                }
                dispose(); // Unbedingt am Ende aufrufen, damit das Fenster geschlossen wird.
                cardManagerWindow.updateTextArea(); // TextArea aktualisieren, damit die neue Karte angezeigt wird
            }
        });
    }
}