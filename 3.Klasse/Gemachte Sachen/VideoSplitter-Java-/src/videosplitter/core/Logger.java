package videosplitter.core;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

//einfaches loggen in Datei
//erstellt ein .log file im projekt ordner um fehler nachvollziehen zu können
public class Logger {
    private static final String LOG_FILE = "app.log";
    public static void log(String msg) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.printf("[%s] %s%n", LocalDateTime.now(), msg);
        } catch (IOException e) {
            //ignorieren
        }
    }
}