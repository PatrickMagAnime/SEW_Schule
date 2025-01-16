import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton ladenButton;
    private JButton suchenButton;
    private JButton speichernButton;
    private JTextArea textArea1;
    private JPanel mainPanel;
    private JComboBox kategorieCBox;

    public static void main(String[] args){
        JFrame frame = new JFrame("Produktverwaltung");
        frame.setContentPane(new GUI().mainPanel);
        frame.setVisible(true);
        frame.setSize(400,500);
    }

    public GUI(){
        kategorieCBox.setModel(new DefaultComboBoxModel(Kategorie.values()));
        suchenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; 1 < Kategorie.values().length; i++) {
                    textArea1.append(Kategorie.values()[i].toString() + "\n");
                }}});}}
// ctl + k
// ctl + shift + k

