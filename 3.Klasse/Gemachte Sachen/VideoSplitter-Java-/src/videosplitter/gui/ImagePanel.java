package videosplitter.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImagePanel extends JPanel {
    private BufferedImage img;

    public ImagePanel(String path) {
        setImage(path);
        setPreferredSize(new Dimension(307, 120)); //16:9 //180, 120
    }

    public void setImage(String path) {
        try {
            if (path != null && !path.isEmpty()) {
                //Lese das Bild immer neu ein
                img = ImageIO.read(new File(path));
            } else {
                img = null;
            }
        } catch (Exception ex) {
            img = null;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int imgWidth = img.getWidth();
            int imgHeight = img.getHeight();

            double imgAspect = (double) imgWidth / imgHeight;
            double panelAspect = (double) panelWidth / panelHeight;
            int drawWidth, drawHeight, x, y;

            if (imgAspect > panelAspect) {
                drawWidth = panelWidth;
                drawHeight = (int) (panelWidth / imgAspect);
            } else {
                drawHeight = panelHeight;
                drawWidth = (int) (panelHeight * imgAspect);
            }
            x = (panelWidth - drawWidth) / 2;
            y = (panelHeight - drawHeight) / 2;
            g.drawImage(img, x, y, drawWidth, drawHeight, this);
        }
    }
}