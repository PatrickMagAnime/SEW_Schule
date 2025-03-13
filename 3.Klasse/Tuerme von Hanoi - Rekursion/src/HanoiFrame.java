import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HanoiFrame extends JFrame {
    private HanoiPanel hanoiPanel;
    private JTextField numDisksField;
    private JButton setDisksButton;
    private JButton solveButton;
    private JButton solveRecursivelyButton;

    public HanoiFrame(int numDisks) {
        hanoiPanel = new HanoiPanel(numDisks);
        add(hanoiPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        numDisksField = new JTextField(5);
        numDisksField.setText(String.valueOf(numDisks));
        setDisksButton = new JButton("Set Disks");
        solveButton = new JButton("Solve");
        solveRecursivelyButton = new JButton("Solve Recursively");

        controlPanel.add(new JLabel("Number of Disks:"));
        controlPanel.add(numDisksField);
        controlPanel.add(setDisksButton);
        controlPanel.add(solveButton);
        controlPanel.add(solveRecursivelyButton);

        add(controlPanel, BorderLayout.SOUTH);

        setDisksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numDisks = Integer.parseInt(numDisksField.getText());
                hanoiPanel.setNumDisks(numDisks);
            }
        });

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> iterativeSolve(hanoiPanel.numDisks, 0, 2, 1)).start();
            }
        });

        solveRecursivelyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> recursiveSolve(hanoiPanel.numDisks, 0, 2, 1)).start();
            }
        });

        setTitle("Tower of Hanoi");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void iterativeSolve(int numDisks, int from, int to, int aux) {
        int totalMoves = (int) Math.pow(2, numDisks) - 1;

        if (numDisks % 2 == 0) {
            int temp = to;
            to = aux;
            aux = temp;
        }

        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 1) {
                moveDiskIteratively(from, to);
            } else if (i % 3 == 2) {
                moveDiskIteratively(from, aux);
            } else if (i % 3 == 0) {
                moveDiskIteratively(aux, to);
            }
        }
    }

    private void moveDiskIteratively(int from, int to) {
        if (hanoiPanel.towers[from].isEmpty()) {
            hanoiPanel.moveDisk(to, from);
        } else if (hanoiPanel.towers[to].isEmpty()) {
            hanoiPanel.moveDisk(from, to);
        } else if (hanoiPanel.towers[from].peek() > hanoiPanel.towers[to].peek()) {
            hanoiPanel.moveDisk(to, from);
        } else {
            hanoiPanel.moveDisk(from, to);
        }
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void recursiveSolve(int numDisks, int from, int to, int aux) {
        if (numDisks == 1) {
            hanoiPanel.moveDisk(from, to);
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            return;
        }

        recursiveSolve(numDisks - 1, from, aux, to);
        hanoiPanel.moveDisk(from, to);
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        recursiveSolve(numDisks - 1, aux, to, from);
        // Fertig :)
        // Hinweis: Überprüfen Sie, ob numDisks 1 ist. Wenn ja, bewegen Sie die Scheibe vom from-Turm zum to-Turm mit hanoiPanel.moveDisk(from, to).
        // Wenn numDisks größer als 1 ist, lösen Sie das Problem rekursiv für numDisks - 1 Scheiben, indem Sie sie vom from-Turm zum aux-Turm bewegen.
        // Bewegen Sie die verbleibende Scheibe vom from-Turm zum to-Turm.
        // Lösen Sie das Problem rekursiv für numDisks - 1 Scheiben, indem Sie sie vom aux-Turm zum to-Turm bewegen.
        // Verwenden Sie hanoiPanel.moveDisk(from, to), um die Scheiben zu bewegen und das Panel neu zu zeichnen.
        // !! Rufe nach jedem hanoiPanel.moveDisk(from, to); unbedingt auf: try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }

    }

    public static void main(String[] args) {
        int numDisks = 3; // Default number of disks
        HanoiFrame frame = new HanoiFrame(numDisks);
        frame.setVisible(true);
    }
}