package videosplitter.core.util;

import java.io.File;
import java.io.IOException;

/**
 * Hilfsklasse für FFmpeg-Aufrufe.
 */
public class FFMpegInvoker {

    /**
     * Schneidet ein Video mit FFmpeg.
     */
    public static void splitVideo(File input, File output, String start, String end) throws IOException, InterruptedException {
        // FFmpeg-Befehl: ffmpeg -i input -ss start -to end -c copy output
        ProcessBuilder pb = new ProcessBuilder(
                "ffmpeg",
                "-i", input.getAbsolutePath(),
                "-ss", start,
                "-to", end,
                "-c", "copy",
                output.getAbsolutePath()
        );
        pb.redirectErrorStream(true);
        Process process = pb.start();
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new IOException("FFmpeg Fehler, Exit Code: " + exitCode);
        }
    }
}