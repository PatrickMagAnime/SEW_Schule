package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * VideoProcessor processes video files recursively.
 * Simulates video processing by copying files from the input folder to the output folder.
 * If watermarking is enabled, appends "_wm" to the filename.
 * All significant actions are logged.
 */
public class VideoProcessor {
    private File inputDir;
    private File outputDir;
    private Settings settings;

    public VideoProcessor(File inputDir, File outputDir, Settings settings) {
        this.inputDir = inputDir;
        this.outputDir = outputDir;
        if (!this.inputDir.exists()) {
            this.inputDir.mkdirs();
            Logger.logMessage("Input-Verzeichnis erstellt: " + this.inputDir.getAbsolutePath());
        }
        if (!this.outputDir.exists()) {
            this.outputDir.mkdirs();
            Logger.logMessage("Output-Verzeichnis erstellt: " + this.outputDir.getAbsolutePath());
        }
        this.settings = settings;
    }

    /**
     * Processes video files starting in the input directory.
     * @throws Exception if processing fails.
     */
    public void processVideos() throws Exception {
        Logger.logMessage("Starte Video-Verarbeitung.");
        processDirectory(inputDir);
        Logger.logMessage("Video-Verarbeitung abgeschlossen.");
    }

    /**
     * Recursively scans the directory and processes each video file.
     * @param dir the current directory.
     * @throws Exception if an error occurs.
     */
    private void processDirectory(File dir) throws Exception {
        File[] files = dir.listFiles();
        if (files == null) return;
        for (File file : files) {
            if (file.isDirectory()) {
                //rekursiver Aufruf
                processDirectory(file);
            } else {
                if (isVideoFile(file)) {
                    Logger.logMessage("Verarbeite Datei: " + file.getAbsolutePath());
                    processFile(file);
                }
            }
        }
    }

    //schaut ob es ein videofile ist
    private boolean isVideoFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".mp4") || name.endsWith(".avi") || name.endsWith(".mkv");
    }

    /**
     * kopiert die Datei ins Output-Verzeichnis
     * falls das Wasserzeichen aktiv ist, wird der Dateiname entsprechend angepasst.
     */
    private void processFile(File file) {
        try {
            String name = file.getName();
            String newName;
            if (settings.isWatermarkEnabled()) {
                newName = name.substring(0, name.lastIndexOf('.')) + "_wm" + getExtension(name);
            } else {
                newName = name;
            }
            File outputFile = new File(outputDir, newName);
            Files.copy(file.toPath(), outputFile.toPath());
            Logger.logMessage("Datei verarbeitet: " + file.getAbsolutePath() + " → " + outputFile.getAbsolutePath());
            // Optional: Originaldatei löschen
            file.delete();
        } catch (IOException ex) {
            Logger.logMessage("Fehler bei der Verarbeitung von " + file.getName() + ": " + ex.getMessage());
            System.err.println("Fehler bei der Verarbeitung von " + file.getName() + ": " + ex.getMessage());
        }
    }

    private String getExtension(String filename) {
        int index = filename.lastIndexOf('.');
        if (index > 0) {
            return filename.substring(index);
        }
        return "";
    }
}