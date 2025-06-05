import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToDoDialog extends JDialog {
    private JTextField tfBeschreibung;
    private JTextField tfPrioritaet;
    private JTextField tfTitel;
    private JButton speichernButton;
    private JComboBox<Category> cbKategorie;
    private JCheckBox erledigtCheckBox;
    private JPanel dialogPanel;

    public ToDoDialog(ToDoItem existingItem, ArrayList<ToDoItem> todos, ToDoApp todoMainWindow) {
        this.setContentPane(dialogPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 400);

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
    }
}
