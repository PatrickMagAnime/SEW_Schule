import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton ladenButton;
    private JButton suchenButton;
    private JButton speichernButton;
    private JTextArea textArea1;
    private JPanel mainPanel;
    private JComboBox<Kategorien> kategorieCBox;
    private JRadioButton radioJson;
    private JRadioButton radioXml;
    private ButtonGroup formatButtonGroup;

    private ArrayList<Produkt> produkte = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Produktverwaltung");
        frame.setContentPane(new GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 600);
    }

    public GUI() {
        // Kategorie-ComboBox initialisieren
        kategorieCBox.setModel(new DefaultComboBoxModel<>(Kategorien.values()));

        // Radio Buttons gruppieren
        formatButtonGroup = new ButtonGroup();
        formatButtonGroup.add(radioJson);
        formatButtonGroup.add(radioXml);
        radioJson.setSelected(true); // JSON ist das Standardformat

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
                    if (radioJson.isSelected()) {
                        ProduktManager.saveProdukte(produkte, filePath); // JSON speichern
                        textArea1.append("Produkt gespeichert (JSON): " + produkt + "\n");
                    } else if (radioXml.isSelected()) {
                        ProduktXMLManager.saveProdukte(produkte, filePath); // XML speichern
                        textArea1.append("Produkt gespeichert (XML): " + produkt + "\n");
                    }
                } catch (NumberFormatException ex) {
                    textArea1.append("Ungültiger Preis.\n");
                }
            }
        });

        ladenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = textField3.getText();
                if (radioJson.isSelected()) {
                    produkte = ProduktManager.loadProdukte(filePath); // JSON laden
                    textArea1.setText("Produkte geladen (JSON):\n");
                } else if (radioXml.isSelected()) {
                    produkte = ProduktXMLManager.loadProdukte(filePath); // XML laden
                    textArea1.setText("Produkte geladen (XML):\n");
                }

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
