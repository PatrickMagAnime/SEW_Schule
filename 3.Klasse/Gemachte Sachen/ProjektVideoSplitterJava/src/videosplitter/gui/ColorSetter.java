package videosplitter.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Hilfsklasse für Farbauswahl.
 */
public class ColorSetter {
    public static void setBackgroundColor(Component component, Color defaultColor) {
        Color c = JColorChooser.showDialog(null, "Farbe wählen", defaultColor);
        if (c != null) {
            component.setBackground(c);
        }
    }
}