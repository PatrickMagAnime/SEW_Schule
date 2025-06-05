package videosplitter.core.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Einfache Logging-Utility.
 */
public class Logger {
    private static final String LOG_FILE = "videosplitter.log";

    public static void logInfo(String msg) {
        log("INFO", msg, null);
    }

    public static void logError(String msg, Throwable t) {
        log("ERROR", msg, t);
    }

    private static void log(String level, String msg, Throwable t) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMsg = String.format("[%s][%s] %s", time, level, msg);
        if (t != null) {
            logMsg += "\n" + t.toString();
        }
        System.out.println(logMsg);
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write(logMsg + "\n");
        } catch (IOException ignored) {
        }
    }
}