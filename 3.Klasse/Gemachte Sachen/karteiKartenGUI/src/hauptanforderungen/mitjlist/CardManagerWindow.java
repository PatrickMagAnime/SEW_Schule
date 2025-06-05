package hauptanforderungen.mitjlist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CardManagerWindow {
    private JPanel mainPanel;
    private JButton hinzufuegenButton;
    private JButton loeschenButton;
    private JButton bearbeitenButton;
    private JList listKarten;
    private JButton lernenButton;
    private JButton speichernButton;
    private JButton ladenButton;

    private DefaultListModel<Karte> listModel = new DefaultListModel<>();
    private ArrayList<Karte> karten = new ArrayList<>();

    public CardManagerWindow() {
        listKarten.setModel(listModel);

        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditCardWindow editWindow = new EditCardWindow(null, karten, listModel);
                editWindow.setVisible(true);
            }
        });
        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listKarten.getSelectedIndex();
                if (selectedIndex != -1) {
                    karten.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                }
            }
        });
        bearbeitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listKarten.getSelectedIndex();
                if (selectedIndex != -1) {
                    Karte selectedKarte = karten.get(selectedIndex);
                    EditCardWindow editWindow = new EditCardWindow(selectedKarte, karten, listModel);
                    editWindow.setVisible(true);
                }
            }
        });
        lernenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LernWindow lernWindow = new LernWindow(karten);
                lernWindow.setVisible(true);
                updateJList();
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
                updateJList();
            }
        });
    }

    public void updateJList(){
        if (karten != null) {
            listModel.clear();
            for (Karte karte : karten) {
                listModel.addElement(karte);
            }
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
