package hauptanforderungen.mittextarea.textfield;

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

    private JTextField tfIndexAuswahl;
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
                int selectedIndex = getSelectedIndexFromTF();
                if (selectedIndex != -1) { // -1 würde bedeuten, dass der Benutzer keine Karte ausgewählt hat und deswegen würden wir nichts löschen können
                    karten.remove(selectedIndex);
                    updateTextArea();
                }
            }
        });
        bearbeitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = getSelectedIndexFromTF();
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
        taKarten.setText("");
        for (int i = 0; i < karten.size(); i++) {
            Karte karte = karten.get(i);
            taKarten.append((i+1) + ". " + karte.toString() + "\n");
        }
    }

    public int getSelectedIndexFromTF(){
        try {
            int selectedIndex = Integer.parseInt(tfIndexAuswahl.getText()) - 1; // -1 weil die Liste bei 0 anfängt
            if (selectedIndex < 0 || selectedIndex >= karten.size()) {
                JOptionPane.showMessageDialog(mainPanel, "Bitte eine gültige Karte auswählen.");
                return -1;
            }
            return selectedIndex;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainPanel, "Bitte eine gültige Zahl eingeben.");
            return -1;
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
