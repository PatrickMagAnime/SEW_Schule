package app;

import utils.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SettingsWindow allows the user to change application settings.
 * Changes include segment duration, output format, and watermark activation.
 */
public class SettingsWindow extends JFrame {
    private JTextField txtSegmentDuration;
    private JTextField txtOutputFormat;
    private JCheckBox chkWatermark;
    private JButton btnSave;
    private Settings settings;

    public SettingsWindow(JFrame parent, Settings settings) {
        super("Einstellungen");
        this.settings = settings;
        setLayout(new GridLayout(4, 2, 5, 5));
        setSize(300, 200);
        setLocationRelativeTo(parent);

        add(new JLabel("Segment Dauer (sec):"));
        txtSegmentDuration = new JTextField(String.valueOf(settings.getSegmentDuration()));
        add(txtSegmentDuration);

        add(new JLabel("Output Format:"));
        txtOutputFormat = new JTextField(settings.getOutputFormat());
        add(txtOutputFormat);

        add(new JLabel("Wasserzeichen aktiv:"));
        chkWatermark = new JCheckBox();
        chkWatermark.setSelected(settings.isWatermarkEnabled());
        add(chkWatermark);

        btnSave = new JButton("Speichern");
        add(btnSave);

        // Save settings button action.
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int segDuration = Integer.parseInt(txtSegmentDuration.getText());
                    settings.setSegmentDuration(segDuration);
                    settings.setOutputFormat(txtOutputFormat.getText());
                    settings.setWatermarkEnabled(chkWatermark.isSelected());
                    settings.saveSettings();
                    JOptionPane.showMessageDialog(SettingsWindow.this, "Einstellungen gespeichert!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SettingsWindow.this, "Ungültige Zahl für Segmentdauer.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(SettingsWindow.this, "Fehler: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}