// TodoApp.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

public class ToDoApp extends JFrame {
    private JTextField tfIndex;
    private JTextArea taOutput;
    private JButton hinzufuegenButton;
    private JButton bearbeitenButton;
    private JButton loeschenButton;
    private JButton ladenButton;
    private JPanel mainPanel;
    private JButton speichernButton;
    private ArrayList<ToDoItem> todos = new ArrayList<>();

    public ToDoApp() {
        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bearbeitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ladenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ToDoApp");
        frame.setContentPane(new ToDoApp().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 300);
        frame.setVisible(true);
    }
}
