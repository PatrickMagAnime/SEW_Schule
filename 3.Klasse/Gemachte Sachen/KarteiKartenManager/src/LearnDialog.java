import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LearnDialog extends JDialog {
    private final ArrayList<Karteikarte> karten;
    private int currentCardIndex = 0;

    private JLabel frageLabel;
    private JLabel statusLabel;
    private JButton showAnswerButton;
    private JButton correctButton;
    private JButton incorrectButton;

    public LearnDialog(Frame owner, ArrayList<Karteikarte> karten) {
        super(owner, "Lernmodus", true);
        this.karten = karten;

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        frageLabel = new JLabel("", SwingConstants.CENTER);
        frageLabel.setFont(new Font("Arial", Font.BOLD, 16));

        statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        statusLabel.setForeground(Color.BLUE);

        showAnswerButton = new JButton("Antwort anzeigen");
        correctButton = new JButton("Richtig");
        incorrectButton = new JButton("Falsch");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showAnswerButton);
        buttonPanel.add(correctButton);
        buttonPanel.add(incorrectButton);

        add(frageLabel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        correctButton.setEnabled(false);
        incorrectButton.setEnabled(false);

        showAnswerButton.addActionListener(e -> showAnswer());
        correctButton.addActionListener(e -> markAsCorrect());
        incorrectButton.addActionListener(e -> markAsIncorrect());

        if (!karten.isEmpty()) {
            showQuestion();
        } else {
            frageLabel.setText("Keine Karten zum Lernen verfügbar.");
            showAnswerButton.setEnabled(false);
        }
    }

    private void showQuestion() {
        Karteikarte currentCard = karten.get(currentCardIndex);
        frageLabel.setText("<html><center>" + currentCard.getFrage() + "</center></html>");
        updateStatusLabel(currentCard);
        showAnswerButton.setEnabled(true);
        correctButton.setEnabled(false);
        incorrectButton.setEnabled(false);
    }

    private void showAnswer() {
        Karteikarte currentCard = karten.get(currentCardIndex);
        frageLabel.setText("<html><center>" + currentCard.getAntwort() + "</center></html>");
        showAnswerButton.setEnabled(false);
        correctButton.setEnabled(true);
        incorrectButton.setEnabled(true);
    }

    private void markAsCorrect() {
        Karteikarte currentCard = karten.get(currentCardIndex);
        currentCard.incrementAnzahlGefragt();
        currentCard.incrementAnzahlRichtig();
        updateStatusLabel(currentCard);
        nextCard();
    }

    private void markAsIncorrect() {
        Karteikarte currentCard = karten.get(currentCardIndex);
        currentCard.incrementAnzahlGefragt();
        updateStatusLabel(currentCard);
        nextCard();
    }

    private void nextCard() {
        currentCardIndex++;
        if (currentCardIndex < karten.size()) {
            showQuestion();
        } else {
            JOptionPane.showMessageDialog(this, "Lernsession abgeschlossen!", "Info", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }

    private void updateStatusLabel(Karteikarte card) {
        if (card.isGelernt()) {
            statusLabel.setText("Status: Gelernt :) ");
            statusLabel.setForeground(new Color(0, 128, 0));
        } else {
            statusLabel.setText("Status: Noch nicht gelernt :( ");
            statusLabel.setForeground(Color.BLUE);
        }
    }
}