import javax.swing.*;
import java.awt.*;

public class CardDialog extends JDialog {
    private JTextField frageField;
    private JTextField antwortField;
    private boolean saved;
    private Karteikarte card;

    public CardDialog(Frame owner, String title, Karteikarte card) {
        super(owner, title, true);
        this.card = card;

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 200);

        frageField = new JTextField();
        antwortField = new JTextField();

        if (card != null) {
            frageField.setText(card.getFrage());
            antwortField.setText(card.getAntwort());
        }

        JButton saveButton = new JButton("Speichern");
        JButton cancelButton = new JButton("Abbrechen");

        saveButton.addActionListener(e -> saveCard());
        cancelButton.addActionListener(e -> dispose());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Frage:"));
        inputPanel.add(frageField);
        inputPanel.add(new JLabel("Antwort:"));
        inputPanel.add(antwortField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void saveCard() {
        String frage = frageField.getText();
        String antwort = antwortField.getText();

        if (frage.isEmpty() || antwort.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte füllen Sie alle Felder aus", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (card == null) {
            card = new Karteikarte(frage, antwort);
        } else {
            card.setFrage(frage);
            card.setAntwort(antwort);
        }

        saved = true;
        dispose();
    }

    public boolean isSaved() {
        return saved;
    }

    public Karteikarte getCard() {
        return card;
    }
}