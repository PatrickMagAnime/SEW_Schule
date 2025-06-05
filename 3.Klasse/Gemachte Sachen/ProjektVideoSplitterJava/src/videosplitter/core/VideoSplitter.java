package videosplitter.core;

import videosplitter.core.util.FFMpegInvoker;
import videosplitter.core.util.Logger;

import java.io.File;

/**
 * Klasse zum Splitten von Videos mit FFmpeg.
 */
public class VideoSplitter {

    /**
     * Führt einen Split-Vorgang durch.
     * @param input Ursprungsdatei
     * @param output Zieldatei
     * @param start Startzeit (hh:mm:ss)
     * @param end Endzeit (hh:mm:ss)
     * @throws Exception bei Fehlern
     */
    public static void split(File input, File output, String start, String end) throws Exception {
        Logger.logInfo("Starte Split: " + input + ", Start: " + start + ", Ende: " + end);
        FFMpegInvoker.splitVideo(input, output, start, end);
    }
}