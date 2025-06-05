package hauptanforderungen.mittextarea.comboboxjoptionpane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CardManagerWindow {
    private JPanel mainPanel;
    private JButton hinzufuegenButton;
    private JButton loeschenButton;
    private JButton bearbeitenButton;
    private JButton lernenButton;
    private JButton speichernButton;
    private JButton ladenButton;
    private JTextArea taKarten;
    private ArrayList<Karte> karten = new ArrayList<>();

    public CardManagerWindow() {

        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditCardWindow editWindow = new EditCardWindow(null, karten, CardManagerWindow.this); // Objekt von Fenster erstellen damit dieses geöffnet werden kann
                editWindow.setVisible(true); // Fenster sichtbar machen
                updateTextArea(); // TextArea aktualisieren, damit die neue Karte angezeigt wird
            }
        });
        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = getSelectedKarteWithDialog();
                if (selectedIndex != -1) { // -1 würde bedeuten, dass der Benutzer keine Karte ausgewählt hat und deswegen würden wir nichts löschen können
                    karten.remove(selectedIndex);
                    updateTextArea();
                }
            }
        });
        bearbeitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = getSelectedKarteWithDialog();
                if (selectedIndex != -1) {
                    Karte selectedKarte = karten.get(selectedIndex);
                    EditCardWindow editWindow = new EditCardWindow(selectedKarte, karten, CardManagerWindow.this);
                    editWindow.setVisible(true);
                    updateTextArea();
                }
            }
        });
        lernenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LernWindow lernWindow = new LernWindow(karten, CardManagerWindow.this);
                lernWindow.setVisible(true);
                updateTextArea();
            }
        });
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KartenManager.saveKarten(karten);
            }
        });
        ladenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                karten = KartenManager.loadKarten();
                updateTextArea();
            }
        });
    }

    public void updateTextArea() {
        for (int i = 0; i < karten.size(); i++) {
            Karte karte = karten.get(i);
            taKarten.append((i+1) + ". " + karte.toString() + "\n");
        }
    }

    public String[] getFragenWithIndex() {
        String[] fragen = new String[karten.size()];
        for (int i = 0; i < karten.size(); i++) {
            fragen[i] = (i + 1) + ". " + karten.get(i).getFrage();
        }
        return fragen;
    }

    public int getSelectedKarteWithDialog(){
        String[] selectionValues = getFragenWithIndex();
        String selected = (String) JOptionPane.showInputDialog(
                null,
                "Wählen Sie eine Karte aus der Liste:",
                "Karteikarte auswählen",
                JOptionPane.PLAIN_MESSAGE,
                null,
                selectionValues,
                selectionValues[0]
        ); // Wenn Fenster geschlossen wird --> null. Es ist einfacher danach den Index von der Auswahl zu holen

        if (selected != null) {
            String[] parts = selected.split("\\."); // Hier Regex anwenden, damit wir den Punkt als Trennzeichen verwenden können. Ansonsten wird der Punkt als Escape-Zeichen interpretiert. Wird automatisch von der IDE vorgeschlagen und müssen SIe nicht auswendig wissen.
            return Integer.parseInt(parts[0].trim()) - 1; // -1, weil die Liste bei 0 anfängt, wir aber beim Anzeigen bei 1 anfangen
        } else {
            return -1; // Wenn der Benutzer auf "Abbrechen" klickt oder das Dialogfeld schließt
        }
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("KartenManager");
        frame.setContentPane(new CardManagerWindow().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.setVisible(true);
    }
}
