package videosplitter.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//verwaltet des projekts und lädt videos und audios rekursiv.

public class ProjectManager {
    private List<VideoFile> videos = new ArrayList<>();
    private List<AudioFile> audios = new ArrayList<>();

    public void loadMediaFromDirectory(File dir) {
        if (!dir.exists() || !dir.isDirectory()) return;
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                loadMediaFromDirectory(file); // rekursion, weil methode ruft sich selber auf
            } else {
                VideoFormat vf = detectVideoFormat(file.getName());
                if (vf != VideoFormat.UNKNOWN) {
                    videos.add(new VideoFile(
                            file.getAbsolutePath(),
                            file.length(),
                            vf,
                            0.0 //dummy, weil es nicht leer sein darf
                    ));
                } else {
                    AudioFormat af = detectAudioFormat(file.getName());
                    if (af != AudioFormat.UNKNOWN) {
                        audios.add(new AudioFile(
                                file.getAbsolutePath(),
                                file.length(),
                                af,
                                0.0// dummy
                        ));
                    }
                }
            }
        }
    }

    public VideoFormat detectVideoFormat(String name) {
        String ext = name.toLowerCase();
        if (ext.endsWith(".mp4")) return VideoFormat.MP4;
        if (ext.endsWith(".avi")) return VideoFormat.AVI;
        if (ext.endsWith(".mov")) return VideoFormat.MOV;
        if (ext.endsWith(".mkv")) return VideoFormat.MKV;
        if (ext.endsWith(".flv")) return VideoFormat.FLV;
        if (ext.endsWith(".wmv")) return VideoFormat.WMV;
        if (ext.endsWith(".mpeg")) return VideoFormat.MPEG;
        if (ext.endsWith(".mpg")) return VideoFormat.MPG;
        if (ext.endsWith(".webm")) return VideoFormat.WEBM;
        if (ext.endsWith(".m4v")) return VideoFormat.M4V;
        if (ext.endsWith(".vob")) return VideoFormat.VOB;
        if (ext.endsWith(".ogv")) return VideoFormat.OGV;
        // if (ext.endsWith(".3gp")) return VideoFormat._3GP; // ist entfernt im enum
        // if (ext.endsWith(".3g2")) return VideoFormat._3G2; // ist entfernt im enum
        if (ext.endsWith(".mts")) return VideoFormat.MTS;
        if (ext.endsWith(".m2ts")) return VideoFormat.M2TS;
        if (ext.endsWith(".ts")) return VideoFormat.TS;
        if (ext.endsWith(".f4v")) return VideoFormat.F4V;
        if (ext.endsWith(".mxf")) return VideoFormat.MXF;
        if (ext.endsWith(".rm")) return VideoFormat.RM;
        if (ext.endsWith(".swf")) return VideoFormat.SWF;
        if (ext.endsWith(".divx")) return VideoFormat.DIVX;
        return VideoFormat.UNKNOWN;
    }

    public AudioFormat detectAudioFormat(String name) {
        String ext = name.toLowerCase();
        if (ext.endsWith(".mp3")) return AudioFormat.MP3;
        if (ext.endsWith(".wav")) return AudioFormat.WAV;
        if (ext.endsWith(".aac")) return AudioFormat.AAC;
        if (ext.endsWith(".flac")) return AudioFormat.FLAC;
        if (ext.endsWith(".ogg")) return AudioFormat.OGG;
        if (ext.endsWith(".wma")) return AudioFormat.WMA;
        if (ext.endsWith(".m4a")) return AudioFormat.M4A;
        if (ext.endsWith(".alac")) return AudioFormat.ALAC;
        if (ext.endsWith(".aiff")) return AudioFormat.AIFF;
        if (ext.endsWith(".opus")) return AudioFormat.OPUS;
        if (ext.endsWith(".amr")) return AudioFormat.AMR;
        if (ext.endsWith(".ape")) return AudioFormat.APE;
        if (ext.endsWith(".dsf")) return AudioFormat.DSF;
        if (ext.endsWith(".dsd")) return AudioFormat.DSD;
        if (ext.endsWith(".pcm")) return AudioFormat.PCM;
        if (ext.endsWith(".ac3")) return AudioFormat.AC3;
        if (ext.endsWith(".eac3")) return AudioFormat.EAC3;
        if (ext.endsWith(".mp2")) return AudioFormat.MP2;
        if (ext.endsWith(".au")) return AudioFormat.AU;
        if (ext.endsWith(".caf")) return AudioFormat.CAF;
        if (ext.endsWith(".mid")) return AudioFormat.MID;
        if (ext.endsWith(".mod")) return AudioFormat.MOD;
        if (ext.endsWith(".xm")) return AudioFormat.XM;
        if (ext.endsWith(".it")) return AudioFormat.IT;
        if (ext.endsWith(".s3m")) return AudioFormat.S3M;
        return AudioFormat.UNKNOWN;
    }

    public List<VideoFile> getVideos() {
        return videos;
    }
    public List<AudioFile> getAudios() {
        return audios;
    }
}