package angabe;

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



        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                dispose();
            }
        });
    }
}