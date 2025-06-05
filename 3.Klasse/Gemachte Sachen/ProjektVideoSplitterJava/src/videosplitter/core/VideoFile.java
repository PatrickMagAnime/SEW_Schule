package videosplitter.core;

import java.io.File;

/**
 * Datenklasse für eine Videodatei.
 */
public class VideoFile {
    private File file;
    private long duration; // in Sekunden

    public VideoFile(File file, long duration) {
        this.file = file;
        this.duration = duration;
    }

    public File getFile() { return file; }
    public long getDuration() { return duration; }
    public void setFile(File file) { this.file = file; }
    public void setDuration(long duration) { this.duration = duration; }
}