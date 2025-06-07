package videosplitter.core;

import com.google.gson.Gson;
import java.io.*;

public class Settings {
    private String lastDirectory;
    private int defaultSegments = 2;
    private boolean splitByParts = true;
    private int splitSeconds = 30;
    private String bitrate = "auto";
    private String resolution = "auto";
    private String codec = "copy";
    private double speed = 1.0;
    private String customName = "output";
    private boolean extractAudio = false;
    private String audioFormat = "MP3";
    private String videoOutputFormat = "mp4";

    //getter und setter methoden
    //ist kompakt formatiert weil es einfach zu viele sind
    //diese werte sind alle für die einstellungen die man für das video einstellen kann
    //werden auch für das speichern der json config verwendet usw.
    public String getLastDirectory() { return lastDirectory; }
    public void setLastDirectory(String lastDirectory) { this.lastDirectory = lastDirectory; }
    public int getDefaultSegments() { return defaultSegments; }
    public void setDefaultSegments(int defaultSegments) { this.defaultSegments = defaultSegments; }
    public boolean isSplitByParts() { return splitByParts; }
    public void setSplitByParts(boolean splitByParts) { this.splitByParts = splitByParts; }
    public int getSplitSeconds() { return splitSeconds; }
    public void setSplitSeconds(int splitSeconds) { this.splitSeconds = splitSeconds; }
    public String getBitrate() { return bitrate; }
    public void setBitrate(String bitrate) { this.bitrate = bitrate; }
    public String getResolution() { return resolution; }
    public void setResolution(String resolution) { this.resolution = resolution; }
    public String getCodec() { return codec; }
    public void setCodec(String codec) { this.codec = codec; }
    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }
    public String getCustomName() { return customName; }
    public void setCustomName(String customName) { this.customName = customName; }
    public boolean isExtractAudio() { return extractAudio; }
    public void setExtractAudio(boolean extractAudio) { this.extractAudio = extractAudio; }
    public String getAudioFormat() { return audioFormat; }
    public void setAudioFormat(String audioFormat) { this.audioFormat = audioFormat; }
    public String getVideoOutputFormat() { return videoOutputFormat; }
    public void setVideoOutputFormat(String videoOutputFormat) { this.videoOutputFormat = videoOutputFormat; }

    //speicherung der einstellungen in json
    public void saveToFile(File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            new Gson().toJson(this, writer);
        }
    }

    //laden der einstellungen | wird immer automatisch aufgerufen(siehe unten)
    public static Settings loadFromFile(File file) throws IOException {
        try (Reader reader = new FileReader(file)) {
            return new Gson().fromJson(reader, Settings.class);
        }
    }

    //(ja hier)
    public static Settings autoLoadOrNew() {
        File file = new File("settings.json");
        if (file.exists()) {
            try {
                return loadFromFile(file);
            } catch (Exception ignored) {}
        }
        return new Settings();
    }
}