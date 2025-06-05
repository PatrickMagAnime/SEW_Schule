package angabe;

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

            }
        });
        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bearbeitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        lernenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ladenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("KartenManager");
        frame.setContentPane(new CardManagerWindow().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.setVisible(true);
    }
}
