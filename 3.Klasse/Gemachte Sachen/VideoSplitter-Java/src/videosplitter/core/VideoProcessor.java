package videosplitter.core;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//hier drinnen befindet sich die hauptlogik der die videos zerteilt usw.

//video und audio mit ffmpeg
public class VideoProcessor {

    //findet die dauer heraus mit ffmpeg
    public static double getVideoDuration(String path) {
        try {
            ProcessBuilder pb = new ProcessBuilder("ffprobe", "-v", "error", "-show_entries",
                    "format=duration", "-of", "default=noprint_wrappers=1:nokey=1", path);
            Process p = pb.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line = br.readLine();
                if (line != null) {
                    return Double.parseDouble(line.trim());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.log("Fehler bei getVideoDuration: " + ex.getMessage());
        }
        return 0;
    }

    //die methode ist dafür da die eingesetllten optionen zu übergeben und den dateien namen zu geben
    public void splitVideo(VideoFile file, int parts, String customName, Settings settings) {
        String ffmpegPath = "ffmpeg"; //Pfad (weil linux)
        String input = file.getPath();

        String ext = settings.getVideoOutputFormat();
        //Zielverzeichnis gleich wie quelldatei
        File inputFile = new File(input);
        File outputDir = inputFile.getParentFile();
        if (outputDir == null) outputDir = new File(".");
        String output = new File(outputDir, customName + "_part%03d." + ext).getAbsolutePath(); // Format aus den Settings

        //segment zeit bestimmen
        int segmentTime;
        if (settings.isSplitByParts()) {
            double duration = file.getDuration();
            if (duration <= 0) duration = getVideoDuration(file.getPath());
            segmentTime = (int)Math.ceil(duration / parts); //teilt hier das video in teile
        } else {
            segmentTime = settings.getSplitSeconds();
        }

        List<String> cmd = new ArrayList<>();
        cmd.add(ffmpegPath);
        cmd.add("-y"); // immer überschreiben
        cmd.add("-i");
        cmd.add(input);

        //codec einstellungen für video formate
        String codec = settings.getCodec();
        if ("webm".equalsIgnoreCase(ext) && "copy".equals(codec)) codec = "libvpx-vp9";
        if ("mkv".equalsIgnoreCase(ext) && "copy".equals(codec)) codec = "libx264";
        if ("avi".equalsIgnoreCase(ext) && "copy".equals(codec)) codec = "mpeg4";

        //codec (ist die dekodierung) //haben wir in MED besprochen
        cmd.add("-c:v");
        cmd.add(codec);

        // audiocodec explizit setzen
        if (!"copy".equals(codec)) {
            cmd.add("-c:a");
            cmd.add("aac"); // Standard Audio-Codec, ggf. abhängig vom Format machen
        }

        //bitrate
        if (settings.getBitrate() != null && !"auto".equals(settings.getBitrate())) {
            cmd.add("-b:v");
            cmd.add(settings.getBitrate());
        }

        //auflösung
        if (settings.getResolution() != null && !"auto".equals(settings.getResolution())) {
            cmd.add("-s");
            cmd.add(settings.getResolution());
        }

        //geschwindigkeit
        boolean hasSpeed = (settings.getSpeed() != 1.0);
        if (hasSpeed) {
            cmd.add("-filter:v");
            cmd.add(String.format("setpts=%.6f*PTS", (1.0 / settings.getSpeed())));
        }

        //segmentierung (teilung)
        cmd.add("-f");
        cmd.add("segment");
        cmd.add("-segment_time");
        cmd.add(String.valueOf(segmentTime));
        cmd.add("-reset_timestamps");
        cmd.add("1");
        // für sauberes Mapping aller Streams
        cmd.add("-map");
        cmd.add("0");

        cmd.add(output);

        try {
            ProcessBuilder pb = new ProcessBuilder(cmd); //processbuilder baut einen command zusammen der dann ausgeführt wird
            pb.redirectErrorStream(true);
            Process p = pb.start();

            //FFmpeg Ausgabe anzeigen
            StringBuilder ffmpegOut = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    ffmpegOut.append(line).append('\n');
                }
            }

            int exitCode = p.waitFor();
            if (exitCode == 0) {
                JOptionPane.showMessageDialog(null,
                        "Video erfolgreich gesplittet!\nAusgabedateien wie " + output);
                Logger.log("Video gesplittet: " + file.getPath() + " in " + parts + " Teile, Name: " + customName
                        + ", OutputFormat: " + ext
                        + ", Bitrate: " + settings.getBitrate() + ", Auflösung: " + settings.getResolution()
                        + ", Codec: " + codec + ", Geschwindigkeit: " + settings.getSpeed());
            } else {
                JOptionPane.showMessageDialog(null,
                        "FFmpeg Fehler beim Splitten!\n\n" + ffmpegOut);
                Logger.log("Fehler beim Splitten: " + ffmpegOut);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler: " + ex.getMessage());
            Logger.log("Fehler beim Splitten: " + ex.getMessage());
        }
    }

    public static String extractPreviewImage(String videoPath, String outPath) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "ffmpeg", "-y", "-i", videoPath, "-ss", "00:00:01.000", "-vframes", "1", outPath
                    //hier wird nur der erste frame des videos entnommen(für preview)
            );
            pb.redirectErrorStream(true);
            Process p = pb.start();
            p.waitFor();
            if (new java.io.File(outPath).exists()) {
                return outPath;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.log("Fehler bei extractPreviewImage: " + ex.getMessage());
        }
        return null;
    }

    //Audio aus Video extrahieren
    public void extractAudioFromVideo(VideoFile videoFile, String customAudioName, File targetDir, AudioFormat af) {
        String ffmpegPath = "ffmpeg";
        String input = videoFile.getPath();
        String format = af == AudioFormat.UNKNOWN ? "mp3" : af.name().toLowerCase();
        String outputFile = new File(targetDir, customAudioName + "." + format).getAbsolutePath();

        List<String> cmd = new ArrayList<>();
        cmd.add(ffmpegPath);
        cmd.add("-y"); // überschreiben
        cmd.add("-i");
        cmd.add(input);
        cmd.add("-vn");
        cmd.add("-acodec");
        cmd.add(af == AudioFormat.UNKNOWN ? "mp3" : af.name().toLowerCase());
        cmd.add(outputFile);

        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.redirectErrorStream(true);
            Process p = pb.start();

            //ffmpeg ausgabe anzeigen
            StringBuilder ffmpegOut = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    ffmpegOut.append(line).append('\n');
                }
            }

            int exitCode = p.waitFor();
            if (exitCode == 0) {
                JOptionPane.showMessageDialog(null,
                        "Audio erfolgreich extrahiert:\n" + outputFile);
                Logger.log("Audio extrahiert: " + videoFile.getPath() + " als " + outputFile);
            } else {
                JOptionPane.showMessageDialog(null,
                        "FFmpeg Fehler beim Audio-Extrahieren!\n\n" + ffmpegOut);
                Logger.log("Fehler beim Audio-Extrahieren: " + ffmpegOut);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler: " + ex.getMessage());
            Logger.log("Fehler beim Audio-Extrahieren: " + ex.getMessage());
        }
    }
}