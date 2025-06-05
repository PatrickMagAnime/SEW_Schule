package videosplitter.core;

import videosplitter.core.util.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Verwalten der Programmeinstellungen (JSON).
 */
public class ConfigManager {
    private static final String CONFIG_PATH = "resources/config/settings.json";
    private static Settings settings = new Settings();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void load() {
        File configFile = new File(CONFIG_PATH);
        if (!configFile.exists()) {
            Logger.logInfo("Keine Konfiguration gefunden, benutze Standardwerte.");
            return;
        }
        try (Reader r = new InputStreamReader(new FileInputStream(configFile), StandardCharsets.UTF_8)) {
            settings = gson.fromJson(r, Settings.class);
            Logger.logInfo("Konfiguration geladen.");
        } catch (Exception e) {
            Logger.logError("Fehler beim Laden der Konfiguration.", e);
        }
    }

    public static void save() {
        try (Writer w = new OutputStreamWriter(new FileOutputStream(CONFIG_PATH), StandardCharsets.UTF_8)) {
            gson.toJson(settings, w);
            Logger.logInfo("Konfiguration gespeichert.");
        } catch (Exception e) {
            Logger.logError("Fehler beim Speichern der Konfiguration.", e);
        }
    }

    public static Settings getSettings() {
        return settings;
    }

    public static class Settings {
        public String lastPath = "";
        public String theme = "default";
    }
}