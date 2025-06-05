package app;

import utils.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//dev keybind menu
//Ctrl+Alt+S

public class WatermarkWindow extends JFrame {
    private JCheckBox chkWatermark;
    private JButton btnSave;
    private Settings settings;

    public WatermarkWindow(JFrame parent, Settings settings) {
        super("Wasserzeichen Einstellungen");
        this.settings = settings;
        setLayout(new FlowLayout());
        setSize(250, 150);
        setLocationRelativeTo(parent);

        // If Pro version is active, watermark is automatically disabled.
        if(settings.isProVersion()){
            JLabel lblInfo = new JLabel("Pro Version: Wasserzeichen deaktiviert.");
            add(lblInfo);
        } else {
            chkWatermark = new JCheckBox("Wasserzeichen aktivieren", settings.isWatermarkEnabled());
            add(chkWatermark);

            btnSave = new JButton("Speichern");
            add(btnSave);

            btnSave.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    settings.setWatermarkEnabled(chkWatermark.isSelected());
                    try {
                        settings.saveSettings();
                        JOptionPane.showMessageDialog(WatermarkWindow.this, "Einstellungen gespeichert!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    } catch(Exception ex) {
                        JOptionPane.showMessageDialog(WatermarkWindow.this, "Fehler: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    dispose();
                }
            });
        }

        setVisible(true);
    }
}