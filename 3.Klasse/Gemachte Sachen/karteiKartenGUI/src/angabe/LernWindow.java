package angabe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LernWindow extends JFrame {
    private JButton antwortAnzeigenBtn;
    private JButton richtigBtn;
    private JButton falschBtn;
    private JLabel lblAntwort;
    private JLabel lblFrage;
    private JPanel lernPanel;

    private ArrayList<Karte> karten;
    private int currentIndex = 0;

    public LernWindow(ArrayList<Karte> karten) {
        this.karten = karten;
        setTitle("Lernen");
        setContentPane(lernPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);



        antwortAnzeigenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        richtigBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        falschBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
