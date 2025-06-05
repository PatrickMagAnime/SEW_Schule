package videosplitter.core;

import videosplitter.core.util.ExceptionHandler;
import videosplitter.core.util.Logger;

import java.io.File;

/**
 * Runnable-Klasse für einen Split-Vorgang (z.B. für Threads oder Executor).
 */
public class SplitTask implements Runnable {
    private File input, output;
    private String start, end;

    public SplitTask(File input, File output, String start, String end) {
        this.input = input;
        this.output = output;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            VideoSplitter.split(input, output, start, end);
            Logger.logInfo("Split abgeschlossen: " + output.getAbsolutePath());
        } catch (Exception e) {
            ExceptionHandler.handle(e, null);
        }
    }
}