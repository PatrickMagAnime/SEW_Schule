package zusatzaufgaben;

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
    private JProgressBar progressBarLernen;

    private ArrayList<Karte> karten;
    private int currentIndex = 0;

    private CardManagerWindow cardManagerWindow;

    public LernWindow(ArrayList<Karte> karten, CardManagerWindow cardManagerWindow) {
        this.karten = karten;
        this.cardManagerWindow = cardManagerWindow;
        setTitle("Lernen");
        setContentPane(lernPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        progressBarLernen.setMinimum(0);
        progressBarLernen.setMaximum(karten.size());
        progressBarLernen.setValue(0);

        if (!karten.isEmpty()) {
            lblFrage.setText(karten.get(currentIndex).getFrage());
            lblFrage.setForeground(karten.get(currentIndex).getFarbeAsColor());
            lblAntwort.setText("");
        }

        antwortAnzeigenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblAntwort.setText(karten.get(currentIndex).getAntwort());
                falschBtn.setVisible(true);
                richtigBtn.setVisible(true);
            }
        });

        richtigBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Karte karte = karten.get(currentIndex);
                karte.setAnzahlRichtig(karte.getAnzahlRichtig() + 1);
                karte.setAnzahlGefragt(karte.getAnzahlGefragt() + 1);
                nextCard();
            }
        });

        falschBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Karte karte = karten.get(currentIndex);
                karte.setAnzahlGefragt(karte.getAnzahlGefragt() + 1);
                nextCard();
            }
        });
    }

    private void nextCard() {
        currentIndex++;
        progressBarLernen.setValue(currentIndex);
        if (currentIndex < karten.size()) {
            lblFrage.setText(karten.get(currentIndex).getFrage());
            lblFrage.setForeground(karten.get(currentIndex).getFarbeAsColor());
            lblAntwort.setText("");
            falschBtn.setVisible(false);
            richtigBtn.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Lernen abgeschlossen!");
            cardManagerWindow.updateTextArea();
            dispose();
        }
    }
}
