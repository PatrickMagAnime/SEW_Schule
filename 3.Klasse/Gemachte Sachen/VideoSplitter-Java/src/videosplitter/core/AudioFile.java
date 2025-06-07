package videosplitter.core;

//audiodatei erkennen usw. :3

public class AudioFile extends MediaFile {
    private AudioFormat format;
    private double duration;

    public AudioFile(String path, long size, AudioFormat format, double duration) {
        super(path, size);
        this.format = format;
        this.duration = duration;
    }

    public AudioFormat getFormat() {
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