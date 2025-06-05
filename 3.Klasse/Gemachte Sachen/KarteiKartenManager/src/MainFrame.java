import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
//220227
public class MainFrame extends JFrame {
    private DefaultListModel<Karteikarte> listModel;
    private JList<Karteikarte> kartenList;
    private ArrayList<Karteikarte> karten;

    public MainFrame() {
        super("Karteikarten Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        karten = new ArrayList<>();
        listModel = new DefaultListModel<>();
        kartenList = new JList<>(listModel);
        kartenList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(kartenList);

        // hab die sortiert :3

        JButton addButton = new JButton("Hinzufügen");
        JButton editButton = new JButton("Bearbeiten");
        JButton deleteButton = new JButton("Löschen");
        JButton saveButton = new JButton("Speichern");
        JButton loadButton = new JButton("Laden");
        JButton learnButton = new JButton("Lernen");

        addButton.addActionListener(e -> openAddCardDialog());
        editButton.addActionListener(e -> openEditCardDialog());
        deleteButton.addActionListener(e -> deleteSelectedCard());
        saveButton.addActionListener(e -> saveCardsToFile());
        loadButton.addActionListener(e -> loadCardsFromFile());
        learnButton.addActionListener(e -> openLearnDialog());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 6));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(learnButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void openAddCardDialog() {
        CardDialog dialog = new CardDialog(this, "Karte hinzufügen", null);
        dialog.setVisible(true);
        if (dialog.isSaved()) {
            Karteikarte newCard = dialog.getCard();
            karten.add(newCard);
            listModel.addElement(newCard);
        }
    }

    private void openEditCardDialog() {
        Karteikarte selectedCard = kartenList.getSelectedValue();
        if (selectedCard == null) {
            JOptionPane.showMessageDialog(this, "Bitte wählen sie eine Karte aus.", "fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CardDialog dialog = new CardDialog(this, "Karte bearbeiten", selectedCard);
        dialog.setVisible(true);
        if (dialog.isSaved()) {
            kartenList.repaint();
        }
    }

    private void deleteSelectedCard() {
        Karteikarte selectedCard = kartenList.getSelectedValue();
        if (selectedCard == null) {
            JOptionPane.showMessageDialog(this, "Bitte wählen Sie eine Karte aus.", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Sind Sie sicher, dass Sie diese Karte löschen möchten?", "Bestätigung", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            karten.remove(selectedCard);
            listModel.removeElement(selectedCard);
        }
    }

    private void saveCardsToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("karten.dat"))) {
            out.writeObject(new ArrayList<>(karten));
            JOptionPane.showMessageDialog(this, "Karten erfolgreich gespeichert");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Fehler beim Speichern der Karten: " + e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCardsFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("karten.dat"))) {
            ArrayList<Karteikarte> loadedCards = (ArrayList<Karteikarte>) in.readObject();
            karten.clear();
            listModel.clear();
            karten.addAll(loadedCards);
            for (Karteikarte card : loadedCards) {
                listModel.addElement(card);
            }
            JOptionPane.showMessageDialog(this, "Karten erfolgreich geladen");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Fehler beim Laden der Karten: " + e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openLearnDialog() {
        if (karten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Keine Karten zum Lernen vorhanden", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LearnDialog learnDialog = new LearnDialog(this, karten);
        learnDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}