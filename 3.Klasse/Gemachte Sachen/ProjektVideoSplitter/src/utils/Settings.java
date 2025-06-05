package utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Settings manages the application configuration.
 * Configurations are saved in and loaded from a JSON file.
 */
public class Settings {
    private int segmentDuration;
    private String outputFormat;
    private boolean watermarkEnabled;
    private boolean proVersion;

    private File configFile;

    public Settings() {
        // Default values
        segmentDuration = 10;
        outputFormat = "mp4";
        watermarkEnabled = true;
        proVersion = false;
        // Ensure config directory exists.
        File configDir = new File("config");
        if (!configDir.exists()) {
            configDir.mkdirs();
        }
        configFile = new File(configDir, "master_config.json");
    }

    public int getSegmentDuration() {
        return segmentDuration;
    }

    public void setSegmentDuration(int segmentDuration) {
        this.segmentDuration = segmentDuration;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public boolean isWatermarkEnabled() {
        return watermarkEnabled;
    }

    public void setWatermarkEnabled(boolean watermarkEnabled) {
        this.watermarkEnabled = watermarkEnabled;
    }

    public boolean isProVersion() {
        return proVersion;
    }

    public void setProVersion(boolean proVersion) {
        this.proVersion = proVersion;
    }

    /**
     * Speichert einstellungen
     * @throws Exception wenn ein fehler aufkommt
     */
    public void saveSettings() throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("segmentDuration", segmentDuration);
        obj.put("outputFormat", outputFormat);
        obj.put("watermarkEnabled", watermarkEnabled);
        obj.put("proVersion", proVersion);
        try (FileWriter writer = new FileWriter(configFile)) {
            writer.write(obj.toString(4)); // 4-space indentation
        }
        // Log saved settings.
        Logger.logMessage("Einstellungen gespeichert: " + obj.toString());
    }

    /**
     * ladet settings vom json file
     * @throws Exception wenn ein fehler passiert
     */
    public void loadSettings() throws Exception {
        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                JSONTokener tokener = new JSONTokener(reader);
                JSONObject obj = new JSONObject(tokener);
                segmentDuration = obj.optInt("segmentDuration", 10);
                outputFormat = obj.optString("outputFormat", "mp4");
                watermarkEnabled = obj.optBoolean("watermarkEnabled", true);
                proVersion = obj.optBoolean("proVersion", false);
            }
            Logger.logMessage("Einstellungen geladen.");
        } else {
            Logger.logMessage("Keine Konfigurationsdatei gefunden; Standardwerte werden verwendet.");
        }
    }
}