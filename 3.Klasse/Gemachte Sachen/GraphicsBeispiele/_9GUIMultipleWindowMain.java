package GraphicsBeispiele;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _9GUIMultipleWindowMain extends JFrame {
    private JButton zweitesFensterButton;

    private JPanel mainPanel;
    public _9GUIMultipleWindowMain() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 1));

        zweitesFensterButton = new JButton("2. Fenster öffnen");

        zweitesFensterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new _9GUIMultipleWindowSecond(); // Hier Konstruktor von 2. Fenster aufrufen
            }
        });

        mainPanel.add(zweitesFensterButton);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hauptfenster");
        frame.setContentPane(new _9GUIMultipleWindowMain().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}