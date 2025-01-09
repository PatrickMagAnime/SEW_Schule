import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI { // ich habe die Textfelder usw. bischen gekürzt und nebeneinander geschrieben
    private JFrame frame;
    private JTextField gewichtField, laengeField, breiteField, hoeheField, geschwindigkeitField;
    private JTextArea outputArea;
    private JRadioButton pkwButton, lkwButton;

    public GUI() { // position der elemente
        frame = new JFrame("Fahrzeug Transportprüfung");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel gewichtLabel = new JLabel("Gewicht:");
        gewichtLabel.setBounds(10, 10, 80, 25);
        frame.add(gewichtLabel);

        gewichtField = new JTextField();
        gewichtField.setBounds(100, 10, 160, 25);
        frame.add(gewichtField);

        JLabel laengeLabel = new JLabel("Länge:");
        laengeLabel.setBounds(10, 40, 80, 25);
        frame.add(laengeLabel);

        laengeField = new JTextField();
        laengeField.setBounds(100, 40, 160, 25);
        frame.add(laengeField);

        JLabel breiteLabel = new JLabel("Breite:");
        breiteLabel.setBounds(10, 70, 80, 25);
        frame.add(breiteLabel);

        breiteField = new JTextField();
        breiteField.setBounds(100, 70, 160, 25);
        frame.add(breiteField);

        JLabel hoeheLabel = new JLabel("Höhe:");
        hoeheLabel.setBounds(10, 100, 80, 25);
        frame.add(hoeheLabel);

        hoeheField = new JTextField();
        hoeheField.setBounds(100, 100, 160, 25);
        frame.add(hoeheField);

        JLabel geschwindigkeitLabel = new JLabel("Geschwindigkeit:");
        geschwindigkeitLabel.setBounds(10, 130, 120, 25);
        frame.add(geschwindigkeitLabel);

        geschwindigkeitField = new JTextField();
        geschwindigkeitField.setBounds(140, 130, 120, 25);
        frame.add(geschwindigkeitField);

        pkwButton = new JRadioButton("PKW");
        pkwButton.setBounds(10, 160, 80, 25);
        lkwButton = new JRadioButton("LKW");
        lkwButton.setBounds(100, 160, 80, 25);

        ButtonGroup group = new ButtonGroup();
        group.add(pkwButton);
        group.add(lkwButton);

        frame.add(pkwButton);
        frame.add(lkwButton);

        JButton pruefenButton = new JButton("Prüfen");
        pruefenButton.setBounds(10, 190, 100, 25);
        frame.add(pruefenButton);

        outputArea = new JTextArea();
        outputArea.setBounds(10, 220, 360, 120);
        outputArea.setEditable(false);
        frame.add(outputArea);
        //das wurde auto generiert von itelliJ
        pruefenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double gewicht = Double.parseDouble(gewichtField.getText());
                double laenge = Double.parseDouble(laengeField.getText());
                double breite = Double.parseDouble(breiteField.getText());
                double hoehe = Double.parseDouble(hoeheField.getText());
                double geschwindigkeit = Double.parseDouble(geschwindigkeitField.getText());
                //if- else verzweigung für initialisierung der werte
                Fahrzeug fahrzeug;
                if (pkwButton.isSelected()) {
                    fahrzeug = new PKW(gewicht, laenge, breite, hoehe, geschwindigkeit);
                } else if (lkwButton.isSelected()) {
                    fahrzeug = new LKW(gewicht, laenge, breite, hoehe, geschwindigkeit);
                } else {
                    outputArea.setText("Bitte wählen Sie einen Fahrzeugtyp aus.");
                    return;
                }

                outputArea.setText(fahrzeug.toString() + "\n");
                if (fahrzeug.isTransportierbar()) {
                    outputArea.append("Das Fahrzeug ist transportierbar.");
                } else {
                    outputArea.append("Das Fahrzeug ist nicht transportierbar.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}