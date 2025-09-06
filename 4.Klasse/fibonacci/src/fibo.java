import javax.swing.*;

public class fibo {
    private JTextField textField1; //fiboeingabe
    private JButton fiboButton;    //fibo button
    private JTextArea ergebnissTextArea; //textarea
    private JPanel mainPanel; //panel

    public fibo() {

        fiboButton.addActionListener(e -> {
            try {
                int n = Integer.parseInt(textField1.getText());
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < n; i++) {
                    result.append(fiboRekursive(i)).append(" ,");
                }

                ergebnissTextArea.setText(result.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "zahl eingeben");
            }
        });
    }

    private int fiboRekursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fiboRekursive(n - 1) + fiboRekursive(n - 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("fibonacci");
        frame.setContentPane(new fibo().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
