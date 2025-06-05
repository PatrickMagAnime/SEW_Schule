package videosplitter.core;

/**
 * Datenklasse für einen Videoausschnitt.
 */
public class VideoSegment {
    private String startTime;
    private String endTime;

    public VideoSegment(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
}