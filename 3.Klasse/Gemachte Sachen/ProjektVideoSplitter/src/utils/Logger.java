package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private static final String LOG_DIR = "logs";
    private static final String LOG_FILE = "app.log";

    // Ensure the log directory exists.
    static {
        File logDirectory = new File(LOG_DIR);
        if (!logDirectory.exists()) {
            logDirectory.mkdirs();
        }
    }

    /**
     * schreibt eine log message mit timestamp, @param
     */

    public static void logMessage(String message) {
        try (FileWriter fw = new FileWriter(new File(LOG_DIR, LOG_FILE), true)) {
            fw.write(LocalDateTime.now() + ": " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}