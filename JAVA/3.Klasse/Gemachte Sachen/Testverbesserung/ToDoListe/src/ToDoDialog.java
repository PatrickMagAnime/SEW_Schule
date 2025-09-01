import javax.swing.*;
import java.util.ArrayList;

public class ToDoDialog extends JDialog {
    private JTextField tfBeschreibung;
    private JTextField tfPrioritaet;
    private JTextField tfTitel;
    private JButton speichernButton;
    private JComboBox<Category> cbKategorie;
    private JCheckBox erledigtCheckBox;
    private JPanel dialogPanel;
    private JButton farbeWaehlenButton; //hab die zusatzaufgabe doch nicht gemacht

    public ToDoDialog(ToDoItem existingItem, ArrayList<ToDoItem> todos, ToDoApp todoMainWindow) {
        this.setContentPane(dialogPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(350, 330);

        cbKategorie.setModel(new DefaultComboBoxModel<>(Category.values()));

        if (existingItem != null) {
            tfTitel.setText(existingItem.getTitel());
            tfBeschreibung.setText(existingItem.getBeschreibung());
            tfPrioritaet.setText(String.valueOf(existingItem.getPrioritaet()));
            erledigtCheckBox.setSelected(existingItem.isErledigt());
            cbKategorie.setSelectedItem(existingItem.getKategorie());
        }

        speichernButton.addActionListener(e -> {
            String titel = tfTitel.getText().trim();
            String beschreibung = tfBeschreibung.getText().trim();
            String prioritaetStr = tfPrioritaet.getText().trim();
            Category kategorie = (Category) cbKategorie.getSelectedItem();
            boolean erledigt = erledigtCheckBox.isSelected();

            if (titel.isEmpty() || prioritaetStr.isEmpty() || kategorie == null) {
                JOptionPane.showMessageDialog(this, "Titel, Priorität und Kategorie müssen ausgefüllt sein!");
                return;
            }
            int prioritaet;
            try {
                prioritaet = Integer.parseInt(prioritaetStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Priorität muss eine ganze Zahl sein!");
                return;
            }

            ToDoItem neuesItem = new ToDoItem(titel, beschreibung, erledigt, prioritaet, kategorie);

            if (existingItem == null) {
                todos.add(neuesItem);
            } else {
                int idx = todos.indexOf(existingItem);
                if (idx != -1) {
                    todos.set(idx, neuesItem);
                }
            }
            todoMainWindow.updateOutput();
            dispose();
        });
    }
}