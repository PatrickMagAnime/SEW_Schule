import java.io.*;

public class VideoSplitterUtils {
    public static void splitVideo(File video, File ausgabeOrdner, int segmentDauer, String codec, int fps) throws IOException {
        // Get video duration
        int videoDauer = getVideoDauer(video.getAbsolutePath());
        System.out.println("Gesamtdauer des Videos: " + videoDauer + " Sekunden");

        // Get input file extension
        String fileExtension = getFileExtension(video.getName());

        // Calculate the number of segments
        int anzahlSegmente = (int) Math.ceil((double) videoDauer / segmentDauer);
        System.out.println("Das Video wird in " + anzahlSegmente + " Segmente unterteilt.");

        // Process each segment
        for (int i = 0; i < anzahlSegmente; i++) {
            int startZeit = i * segmentDauer;
            int segmentLaenge = segmentDauer;

            // Adjust last segment
            if (i == anzahlSegmente - 1 && videoDauer - startZeit < segmentDauer) {
                segmentLaenge = segmentDauer;
                startZeit = Math.max(0, videoDauer - segmentDauer);
            }

            String ausgabeDatei = new File(ausgabeOrdner,
                    String.format("%s_part%d_of_%d.%s",
                            video.getName().replaceFirst("\\.[a-zA-Z0-9]+$", ""),
                            i + 1,
                            anzahlSegmente,
                            fileExtension)).getAbsolutePath();

            // Skip processing if file already exists
            File outputFile = new File(ausgabeDatei);
            if (outputFile.exists()) {
                System.out.println("Datei existiert bereits, wird übersprungen: " + ausgabeDatei);
                continue;
            }

            // Build ffmpeg command
            ProcessBuilder processBuilder;
            if (fps > 0) {
                processBuilder = new ProcessBuilder(
                        "ffmpeg",
                        "-ss", String.valueOf(startZeit),
                        "-i", video.getAbsolutePath(),
                        "-t", String.valueOf(segmentLaenge),
                        "-r", String.valueOf(fps),
                        "-c", codec,
                        ausgabeDatei
                );
            } else {
                processBuilder = new ProcessBuilder(
                        "ffmpeg",
                        "-ss", String.valueOf(startZeit),
                        "-i", video.getAbsolutePath(),
                        "-t", String.valueOf(segmentLaenge),
                        "-c", codec,
                        ausgabeDatei
                );
            }

            // Execute ffmpeg process
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            try {
                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    throw new IOException("ffmpeg hat mit Fehlercode " + exitCode + " abgebrochen.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IOException("Prozess unterbrochen", e);
            }

            if (!outputFile.exists() || outputFile.length() == 0) {
                throw new IOException("Ausgabedatei wurde nicht erfolgreich erstellt: " + ausgabeDatei);
            }

            System.out.println("Erstellt: " + ausgabeDatei);
        }
    }

    public static int getVideoDauer(String videoPfad) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "ffprobe",
                "-i", videoPfad,
                "-show_entries", "format=duration",
                "-v", "quiet",
                "-of", "csv=p=0"
        );
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    return (int) Math.ceil(Double.parseDouble(line)); // Duration in seconds
                } catch (NumberFormatException e) {
                    System.err.println("Fehler beim Parsen der ffprobe-Ausgabe: " + line);
                }
            }
        }
        throw new IOException("Videodauer konnte nicht ermittelt werden.");
    }

    private static String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex == -1) {
            return ""; // No extension found
        }
        return fileName.substring(lastIndex + 1).toLowerCase();
    }
}