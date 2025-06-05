import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    private JTextField textField1; // Produktname
    private JTextField textField2; // Preis
    private JTextField textField3; // Dateipfad
    private JButton ladenButton;
    private JButton suchenButton;
    private JButton speichernButton;
    private JTextArea textArea1;
    private JPanel mainPanel;
    private JComboBox<Kategorien> kategorieCBox;

    private ArrayList<Produkt> produkte = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Produktverwaltung");
        frame.setContentPane(new GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 600);
    }

    public GUI() {
        kategorieCBox.setModel(new DefaultComboBoxModel<>(Kategorien.values()));

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = textField1.getText();
                    double preis = Double.parseDouble(textField2.getText());
                    Kategorien kategorie = (Kategorien) kategorieCBox.getSelectedItem();

                    Produkt produkt = new Produkt(name, preis, kategorie);
                    produkte.add(produkt);

                    String filePath = textField3.getText();
                    ProduktManager.saveProdukte(produkte, filePath);
                    textArea1.append("Produkt gespeichert: " + produkt + "\n");
                } catch (NumberFormatException ex) {
                    textArea1.append("Ungültiger Preis.\n");
                }
            }
        });

        ladenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = textField3.getText();
                produkte = ProduktManager.loadProdukte(filePath);
                textArea1.setText("Produkte geladen:\n");
                for (Produkt produkt : produkte) {
                    textArea1.append(produkt + "\n");
                }
            }
        });

        suchenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchQuery = textField1.getText().toLowerCase();
                textArea1.setText("Suchergebnisse:\n");
                for (Produkt produkt : produkte) {
                    if (produkt.getName().toLowerCase().contains(searchQuery)) {
                        textArea1.append(produkt + "\n");
                    }
                }
            }
        });
    }
}
