package zusatzaufgaben;

import javax.swing.*;
import java.awt.*;
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
    private JComboBox<Kategorie> cbKategorie;
    private JButton farbeAuswaehlenButton;

    private Color selectedColor = Color.WHITE;

    public EditCardWindow(Karte karte, ArrayList<Karte> karten, CardManagerWindow cardManagerWindow) {
        // ComboBox für die Kategorien mit allen Enum-Werten von Kategorie füllen:
        cbKategorie.setModel(new DefaultComboBoxModel<>(Kategorie.values()));


        if(karte == null) { // Wenn keine Karte übergeben wird, dann ist es eine neue Karte
           this.setTitle("Karte hinzufügen");
        }
        else {
           this.setTitle("Karte bearbeiten");
        }

        this.setContentPane(editCardPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(450, 400);

        if (karte != null) { // Wenn eine Karte bearbeitet wird, setzen wir die Textfelder gleich auf den aktuellen Inhalt
            tfFrage.setText(karte.getFrage());
            tfAntwort.setText(karte.getAntwort());
            tfAnzahlGefragt.setText(String.valueOf(karte.getAnzahlGefragt()));
            tfAnzahlRichtig.setText(String.valueOf(karte.getAnzahlRichtig()));
            cbKategorie.setSelectedItem(karte.getKategorie()); // Die Kategorie der Karte in die ComboBox setzen
            if (karte.getFarbe() != null) { // Wenn die Karte eine Farbe hat, dann setzen wir diese in den Button
                selectedColor = karte.getFarbeAsColor();
            }
            farbeAuswaehlenButton.setBackground(selectedColor);
        }

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String frage = tfFrage.getText();
                String antwort = tfAntwort.getText();
                int anzahlGefragt = Integer.parseInt(tfAnzahlGefragt.getText());
                int anzahlRichtig = Integer.parseInt(tfAnzahlRichtig.getText());
                Kategorie kategorie = (Kategorie) cbKategorie.getSelectedItem(); // Die ausgewählte Kategorie aus der ComboBox holen

                if (karte == null) { // Wenn keine Karte übergeben wird, dann ist es eine neue Karte. Deswegen erstellen wir eine neue Karte und speichern diese in der ArrayList
                    Karte newKarte = new Karte(frage, antwort, false, anzahlGefragt, anzahlRichtig, kategorie);
                    newKarte.setFarbe(selectedColor);
                    karten.add(newKarte);
                } else { // Wenn eine Karte bearbeitet wird, dann setzen wir die Werte der Karte auf die neuen Werte
                    karte.setFrage(frage);
                    karte.setAntwort(antwort);
                    karte.setAnzahlGefragt(anzahlGefragt);
                    karte.setAnzahlRichtig(anzahlRichtig);
                    karte.setKategorie(kategorie);
                    karte.setFarbe(selectedColor);
                }
                cardManagerWindow.updateTextArea(); // TextArea aktualisieren, damit die neue Karte angezeigt wird
                dispose(); // Unbedingt am Ende aufrufen, damit das Fenster geschlossen wird.
            }
        });
        farbeAuswaehlenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (karte != null && karte.getFarbe() != null) {
                    farbeAuswaehlenButton.setBackground(selectedColor);
                }

                selectedColor = JColorChooser.showDialog(null, "Farbe auswählen", selectedColor);
                if (selectedColor != null && karte != null) {
                    karte.setFarbe(selectedColor);
                }
            }
        });
    }
}