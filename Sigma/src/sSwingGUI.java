import javax.swing.*;  // Import Swing components
import java.awt.*;     // Import AWT components for layout
import java.awt.event.ActionEvent;  // Import ActionEvent for button actions
import java.awt.event.ActionListener;  // Import ActionListener for button actions

public class sSwingGUI {
    // Main method to run the application
    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Simple Swing GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);  // Set the size of the window

        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());  // Set layout manager for the panel

        // Create a JLabel and add it to the panel
        JLabel label = new JLabel("Hello, Swing!", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        // Create a JTextField and add it to the panel
        JTextField textField = new JTextField();
        panel.add(textField, BorderLayout.NORTH);

        // Create a JPanel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Create a JButton to update the label and add it to the button panel
        JButton updateButton = new JButton("Update Label");
        buttonPanel.add(updateButton);

        // Create a JButton to clear the text field and add it to the button panel
        JButton clearButton = new JButton("Clear Text");
        buttonPanel.add(clearButton);

        // Add the button panel to the main panel
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);

        // Add action listener to the update button
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the label with the text from the text field
                label.setText(textField.getText());
            }
        });

        // Add action listener to the clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the text field
                textField.setText("");
            }
        });
    }
}
