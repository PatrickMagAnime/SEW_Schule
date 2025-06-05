import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class ToDoApp extends JFrame {
    private JPanel mainPanel;
    private JTextArea taOutput;
    private JTextField tfIndex;
    private JButton hinzufuegenButton;
    private JButton bearbeitenButton;
    private JButton loeschenButton;
    private JButton ladenButton;
    private JButton speichernButton;
    private JProgressBar progressBar;

    private ArrayList<ToDoItem> todos = new ArrayList<>();

    public ToDoApp() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        hinzufuegenButton.addActionListener(e -> {
            ToDoDialog dialog = new ToDoDialog(null, todos, this);
            dialog.setVisible(true);
        });

        bearbeitenButton.addActionListener(e -> {
            String idxStr = tfIndex.getText().trim();
            if (!idxStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Bitte eine gültige Nummer eingeben!");
                return;
            }
            int idx = Integer.parseInt(idxStr);
            if (idx < 1 || idx > todos.size()) {
                JOptionPane.showMessageDialog(this, "Nummer außerhalb des gültigen Bereichs!");
                return;
            }
            ToDoDialog dialog = new ToDoDialog(todos.get(idx - 1), todos, this);
            dialog.setVisible(true);
        });

        loeschenButton.addActionListener(e -> {
            String idxStr = tfIndex.getText().trim();
            if (!idxStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Bitte eine gültige Nummer eingeben!");
                return;
            }
            int idx = Integer.parseInt(idxStr);
            if (idx < 1 || idx > todos.size()) {
                JOptionPane.showMessageDialog(this, "Nummer außerhalb des gültigen Bereichs!");
                return;
            }
            todos.remove(idx - 1);
            updateOutput();
        });

        ladenButton.addActionListener(e -> {
            try {
                todos = ToDoJsonManager.loadToDos();
                updateOutput();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Fehler beim Laden: " + ex.getMessage());
            }
        });

        speichernButton.addActionListener(e -> {
            try {
                ToDoJsonManager.saveToDos(todos);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Fehler beim Speichern: " + ex.getMessage());
            }
        });

        updateOutput();
    }

    public void updateOutput() {
        todos.sort((a, b) -> Integer.compare(b.getPrioritaet(), a.getPrioritaet()));
        StringBuilder sb = new StringBuilder();
        int erledigtCount = 0;
        for (int i = 0; i < todos.size(); i++) {
            ToDoItem item = todos.get(i);
            sb.append((i + 1)).append(": ")
                    .append(item.getTitel()).append(" | ")
                    .append(item.isErledigt() ? "[X]" : "[ ]").append(" | Prio: ")
                    .append(item.getPrioritaet()).append(" | Kat: ")
                    .append(item.getKategorie());
            sb.append(System.lineSeparator());
            if (item.isErledigt()) erledigtCount++;
        }
        taOutput.setText(sb.toString());
        if (todos.size() > 0) {
            progressBar.setMaximum(todos.size());
            progressBar.setValue(erledigtCount);
            progressBar.setString(erledigtCount + " / " + todos.size() + " erledigt");
        } else {
            progressBar.setMaximum(1);
            progressBar.setValue(0);
            progressBar.setString("Keine Todos");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new ToDoApp();
        frame.setTitle("ToDoApp");
        frame.pack();
        frame.setVisible(true);
    }
}