package videosplitter.core;

// die klasse ist für videodateien da
public class VideoFile extends MediaFile {
    private VideoFormat format;
    private double duration; // in Sekunden

    public VideoFile(String path, long size, VideoFormat format, double duration) {
        super(path, size);
        this.format = format;
        this.duration = duration;
    }

    public VideoFormat getFormat() {
        return format;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return path + " (" + format + ")";
    }
}