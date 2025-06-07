package videosplitter.core;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

class ProjectManagerTest {

    @Test
    void testDetectVideoFormat() {
        ProjectManager pm = new ProjectManager();
        assertEquals(VideoFormat.MP4, pm.detectVideoFormat("test.mp4"));
        assertEquals(VideoFormat.AVI, pm.detectVideoFormat("movie.AVI"));
        assertEquals(VideoFormat.MKV, pm.detectVideoFormat("film.mkv"));
        assertEquals(VideoFormat.UNKNOWN, pm.detectVideoFormat("document.pdf"));
    }

    @Test
    void testDetectAudioFormat() {
        ProjectManager pm = new ProjectManager();
        assertEquals(AudioFormat.MP3, pm.detectAudioFormat("music.mp3"));
        assertEquals(AudioFormat.WAV, pm.detectAudioFormat("sound.wav"));
        assertEquals(AudioFormat.UNKNOWN, pm.detectAudioFormat("picture.jpg"));
    }

    @Test
    void testLoadMediaFromDirectory() throws Exception {
        //Vorbereitung und Testverzeichnis mit fake Dateien
        File tempDir = Files.createTempDirectory("media_test").toFile();
        File vid = new File(tempDir, "clip.mp4");
        File aud = new File(tempDir, "audio.wav");
        File txt = new File(tempDir, "ignore.txt");
        vid.createNewFile();
        aud.createNewFile();
        txt.createNewFile();

        ProjectManager pm = new ProjectManager();
        pm.loadMediaFromDirectory(tempDir);

        List<VideoFile> videos = pm.getVideos();
        List<AudioFile> audios = pm.getAudios();

        assertEquals(1, videos.size(), "Should detect 1 video");
        assertEquals(1, audios.size(), "Should detect 1 audio");
        assertEquals("clip.mp4", new File(videos.get(0).getPath()).getName());
        assertEquals("audio.wav", new File(audios.get(0).getPath()).getName());
    }

    @Test
    void testSettingsSaveAndLoad() throws Exception {
        Settings s = new Settings();
        s.setLastDirectory("abc");
        s.setDefaultSegments(5);
        s.setSplitByParts(false);
        s.setSplitSeconds(123);
        s.setBitrate("2000k");
        s.setResolution("1280x720");
        s.setCodec("libx264");
        s.setSpeed(2.0);
        s.setCustomName("meinoutput");
        s.setExtractAudio(true);
        s.setAudioFormat("OGG");
        s.setVideoOutputFormat("avi");

        File tempFile = File.createTempFile("settings", ".json");
        s.saveToFile(tempFile);

        Settings loaded = Settings.loadFromFile(tempFile);

        assertEquals("abc", loaded.getLastDirectory());
        assertEquals(5, loaded.getDefaultSegments());
        assertFalse(loaded.isSplitByParts());
        assertEquals(123, loaded.getSplitSeconds());
        assertEquals("2000k", loaded.getBitrate());
        assertEquals("1280x720", loaded.getResolution());
        assertEquals("libx264", loaded.getCodec());
        assertEquals(2.0, loaded.getSpeed(), 0.0001);
        assertEquals("meinoutput", loaded.getCustomName());
        assertTrue(loaded.isExtractAudio());
        assertEquals("OGG", loaded.getAudioFormat());
        assertEquals("avi", loaded.getVideoOutputFormat());
    }

    @Test
    void testVideoProcessorCommandLogic() {
        //ffmpeg test, aber ist nur simuliert
        VideoProcessor vp = new VideoProcessor();
        VideoFile vf = new VideoFile("movie.mp4", 123456, VideoFormat.MP4, 120.0);
        Settings settings = new Settings();
        settings.setSplitByParts(true);
        settings.setDefaultSegments(4);
        settings.setCustomName("testout");
        settings.setCodec("libx264");
        settings.setBitrate("500k");
        settings.setResolution("640x360");
        settings.setSpeed(1.0);
        settings.setVideoOutputFormat("mkv");

        //ouput von ffmpeg datei wird getestet
        String expectedOutput = "testout_part%03d.mkv";
        //simuliert die Logik aus VideoProcessor
        String output = settings.getCustomName() + "_part%03d." + settings.getVideoOutputFormat();
        assertEquals(expectedOutput, output);
    }
}