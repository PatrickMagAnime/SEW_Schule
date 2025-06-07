package videosplitter.gui;

import videosplitter.core.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

//fancy name ich weis
//macht auch genau das so wie es heißt
public class VideoSplitSettingsDialog extends JDialog {
    private boolean confirmed = false;
    private Settings settings;

    public VideoSplitSettingsDialog(Frame parent, Settings currentSettings) {
        super(parent, "Video Split Einstellungen", true);
        // Immer gespeicherte einstellungen laden
        this.settings = Settings.autoLoadOrNew();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; c.gridy = 0; c.insets = new Insets(5,5,5,5);

        JCheckBox cbParts = new JCheckBox("Nach Anzahl Teile splitten", settings.isSplitByParts());
        JSpinner spParts = new JSpinner(new SpinnerNumberModel(settings.getDefaultSegments(), 2, 100, 1));
        JSpinner spSeconds = new JSpinner(new SpinnerNumberModel(settings.getSplitSeconds(), 1, 9999, 1));
        spParts.setEnabled(cbParts.isSelected());
        spSeconds.setEnabled(!cbParts.isSelected());

        cbParts.addItemListener(e -> {
            spParts.setEnabled(cbParts.isSelected());
            spSeconds.setEnabled(!cbParts.isSelected());
        });

        //dropdown menues
        String[] bitrateOptions = {"auto","500k","1000k","1500k","2000k","2500k","3000k","5000k","8000k"};
        JComboBox<String> bitrateDropdown = new JComboBox<>(bitrateOptions);
        bitrateDropdown.setEditable(true);
        bitrateDropdown.setSelectedItem(settings.getBitrate());

        String[] resolutionOptions = {"auto","1920x1080","1280x720","854x480","640x360","426x240"};
        JComboBox<String> resolutionDropdown = new JComboBox<>(resolutionOptions);
        resolutionDropdown.setEditable(true);
        resolutionDropdown.setSelectedItem(settings.getResolution());

        String[] codecOptions = {"copy", "libx264", "libx265", "mpeg4", "vp9", "hevc"};
        JComboBox<String> codecDropdown = new JComboBox<>(codecOptions);
        codecDropdown.setSelectedItem(settings.getCodec());

        JSpinner spSpeed = new JSpinner(new SpinnerNumberModel(settings.getSpeed(), 0.1, 10.0, 0.1));
        JTextField tfCustomName = new JTextField(settings.getCustomName(), 16);

        //checkbox für (in audio umwandeln)
        JCheckBox cbExtractAudio = new JCheckBox("Audio extrahieren", settings.isExtractAudio());
        String[] audioFormats = java.util.Arrays.stream(videosplitter.core.AudioFormat.values())
                .filter(f -> f != videosplitter.core.AudioFormat.UNKNOWN)
                .map(Enum::name)
                .toArray(String[]::new);
        JComboBox<String> audioFormatDropdown = new JComboBox<>(audioFormats);
        audioFormatDropdown.setSelectedItem(settings.getAudioFormat());
        audioFormatDropdown.setEnabled(cbExtractAudio.isSelected());
        cbExtractAudio.addItemListener(e -> audioFormatDropdown.setEnabled(cbExtractAudio.isSelected()));

        //Video Ausgabeformat Dropdown (alle unterstützten Videoformate)
        String[] videoFormats = java.util.Arrays.stream(videosplitter.core.VideoFormat.values())
                .filter(f -> f != videosplitter.core.VideoFormat.UNKNOWN)
                .map(f -> f.name().toLowerCase())
                .toArray(String[]::new);
        JComboBox<String> videoOutputDropdown = new JComboBox<>(videoFormats);
        videoOutputDropdown.setSelectedItem(settings.getVideoOutputFormat());

        JButton btnSaveSettings = new JButton("Einstellungen speichern");

        // Layout
        c.gridy = 0; c.gridx = 0; c.gridwidth = 2; add(new JLabel("Segmentierung:"), c);
        c.gridy = 1; c.gridwidth = 2; add(cbParts, c);
        c.gridy = 2; c.gridwidth = 1; add(new JLabel("Teile:"), c); c.gridx = 1; add(spParts, c); c.gridx = 0;
        c.gridy = 3; add(new JLabel("Sekunden:"), c); c.gridx = 1; add(spSeconds, c); c.gridx = 0;
        c.gridy = 4; add(new JLabel("Bitrate:"), c); c.gridx = 1; add(bitrateDropdown, c); c.gridx = 0;
        c.gridy = 5; add(new JLabel("Auflösung:"), c); c.gridx = 1; add(resolutionDropdown, c); c.gridx = 0;
        c.gridy = 6; add(new JLabel("Codec:"), c); c.gridx = 1; add(codecDropdown, c); c.gridx = 0;
        c.gridy = 7; add(new JLabel("Geschwindigkeit:"), c); c.gridx = 1; add(spSpeed, c); c.gridx = 0;
        c.gridy = 8; add(new JLabel("Custom Name:"), c); c.gridx = 1; add(tfCustomName, c); c.gridx = 0;
        c.gridy = 9; add(cbExtractAudio, c); c.gridx = 1; add(audioFormatDropdown, c); c.gridx = 0;
        c.gridy = 10; add(new JLabel("Video-Ausgabeformat:"), c); c.gridx = 1; add(videoOutputDropdown, c); c.gridx = 0;
        c.gridy = 11; c.gridwidth = 2; add(btnSaveSettings, c);

        c.gridy = 12; c.gridwidth = 2;
        JPanel btnPanel = new JPanel();
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Abbrechen");
        btnPanel.add(ok); btnPanel.add(cancel);
        add(btnPanel, c);

        btnSaveSettings.addActionListener(e -> {
            updateSettingsFromUI(cbParts, spParts, spSeconds, bitrateDropdown, resolutionDropdown, codecDropdown, spSpeed, tfCustomName, cbExtractAudio, audioFormatDropdown, videoOutputDropdown);
            try {
                settings.saveToFile(new File("settings.json"));
                JOptionPane.showMessageDialog(this, "Einstellungen gespeichert.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Speichern fehlgeschlagen: " + ex.getMessage());
            }
        });

        ok.addActionListener(e -> {
            updateSettingsFromUI(cbParts, spParts, spSeconds, bitrateDropdown, resolutionDropdown, codecDropdown, spSpeed, tfCustomName, cbExtractAudio, audioFormatDropdown, videoOutputDropdown);
            confirmed = true;
            dispose();
        });
        cancel.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(parent);
    }

    private void updateSettingsFromUI(JCheckBox cbParts, JSpinner spParts, JSpinner spSeconds, JComboBox<String> bitrateDropdown,
                                      JComboBox<String> resolutionDropdown, JComboBox<String> codecDropdown, JSpinner spSpeed,
                                      JTextField tfCustomName, JCheckBox cbExtractAudio, JComboBox<String> audioFormatDropdown,
                                      JComboBox<String> videoOutputDropdown) {
        settings.setSplitByParts(cbParts.isSelected());
        settings.setDefaultSegments((Integer)spParts.getValue());
        settings.setSplitSeconds((Integer)spSeconds.getValue());
        settings.setBitrate((String)bitrateDropdown.getSelectedItem());
        settings.setResolution((String)resolutionDropdown.getSelectedItem());
        settings.setCodec((String)codecDropdown.getSelectedItem());
        settings.setSpeed((Double)spSpeed.getValue());
        settings.setCustomName(tfCustomName.getText().trim());
        settings.setExtractAudio(cbExtractAudio.isSelected());
        settings.setAudioFormat((String)audioFormatDropdown.getSelectedItem());
        settings.setVideoOutputFormat((String)videoOutputDropdown.getSelectedItem());
    }

    public boolean isConfirmed() { return confirmed; }
    public Settings getSettings() { return settings; }
}