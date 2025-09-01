import javax.swing.*;
import java.awt.*;

public class bspGUI extends JPanel {

    public bspGUI() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);

        g.setColor(Color.BLUE);
        g.fillRect(120, 150, 100, 100);

        g.setColor(Color.RED);
        int[] xPoints = {110, 170, 230};
        int[] yPoints = {150, 100, 150};
        g.fillPolygon(xPoints, yPoints, 3);

        g.setColor(Color.black);
        g.fillRect(160, 200, 20, 50);

        g.setColor(new Color(139, 69, 19)); //Braun
        g.fillRect(250, 190, 25, 75);
        g.setColor(Color.GREEN);
        g.fillOval(230, 145, 60, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Haus mit dach und tür");
        bspGUI panel = new bspGUI();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
