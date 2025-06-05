package test;

import org.junit.Test;
import static org.junit.Assert.*;
import utils.Settings;

import java.io.File;

public class TestSettings {
    @Test
    public void testSaveAndLoadSettings() throws Exception {
        Settings settings = new Settings();
        settings.setSegmentDuration(20);
        settings.setOutputFormat("avi");
        settings.setWatermarkEnabled(false);
        settings.setProVersion(true);

        settings.saveSettings();

        Settings loaded = new Settings();
        loaded.loadSettings();
        assertEquals(20, loaded.getSegmentDuration());
        assertEquals("avi", loaded.getOutputFormat());
        assertFalse(loaded.isWatermarkEnabled());
        assertTrue(loaded.isProVersion());

        // Aufräumen: Konfigurationsdatei löschen.
        File configFile = new File("config/master_config.json");
        if (configFile.exists()) {
            configFile.delete();
        }
    }
}