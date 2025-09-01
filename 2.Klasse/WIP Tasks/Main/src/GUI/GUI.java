package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JRadioButton rbPKW;
    private JRadioButton rbLKW;
    private JPanel mainPanel;



    public GUI() {
        rbPKW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        rbLKW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        // Erstellt ein neues JFrame mit dem Titel "Umweltdatenerfassung"
        JFrame frame = new JFrame("Umweltdatenerfassung");
        // Setzt die Standardoperation für das Schließen des Fensters auf EXIT_ON_CLOSE. Bedeutet, dass das Programm beendet wird, wenn das Fenster geschlossen wird.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Setzt das Hauptfenster auf das mainPanel der GUI Klasse. Das mainPanel enthält alle Komponenten des Fensters. mainPanel ist der Name den wir unserem JPanel in GUI.form als FieldName gegeben haben.
        frame.setContentPane(new GUI().mainPanel);
        // Packt die Komponenten des Fensters zusammen. Das bedeutet, dass die Größe des Fensters an die Größe der Komponenten angepasst wird.
        frame.pack();
        // Setzt die Größe des Fensters bei Programmstarts auf 800x300 Pixel.
        frame.setSize(800, 300);
        // Macht das Fenster sichtbar. Ohne diese Zeile würde das Fenster nicht angezeigt werden.
        frame.setVisible(true);
    }

    }

