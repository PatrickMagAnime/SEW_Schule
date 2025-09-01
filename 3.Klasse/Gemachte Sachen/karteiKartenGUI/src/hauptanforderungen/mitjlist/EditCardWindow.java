package hauptanforderungen.mitjlist;

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

    public EditCardWindow(Karte karte, ArrayList<Karte> karten, DefaultListModel<Karte> listModel) {
        if(karte == null) {
           this.setTitle("Karte hinzufügen");
        }
        else {
           this.setTitle("Karte bearbeiten");
        }

        this.setContentPane(editCardPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 400);

        if (karte != null) {
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

                if (karte == null) {
                    Karte newKarte = new Karte(frage, antwort, false, anzahlGefragt, anzahlRichtig);
                    karten.add(newKarte);
                    listModel.addElement(newKarte);
                } else {
                    karte.setFrage(frage);
                    karte.setAntwort(antwort);
                    karte.setAnzahlGefragt(anzahlGefragt);
                    karte.setAnzahlRichtig(anzahlRichtig);
                    listModel.setElementAt(karte, karten.indexOf(karte));
                }
                dispose();
            }
        });
    }
}