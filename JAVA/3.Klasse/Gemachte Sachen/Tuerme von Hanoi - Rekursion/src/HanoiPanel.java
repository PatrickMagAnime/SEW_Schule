import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class HanoiPanel extends JPanel {
    private Stack<Integer>[] towers;
    int numDisks;

    public HanoiPanel(int numDisks) {
        this.numDisks = numDisks;
        towers = new Stack[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<>();
        }
        for (int i = numDisks; i > 0; i--) {
            towers[0].push(i);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int towerWidth = width / 8;
        int towerHeight = height / 2;
        int diskHeight = towerHeight / (numDisks * 2); // Decreased height of disks

        // Draw towers
        for (int i = 0; i < 3; i++) {
            int x = (i * 2 + 1) * width / 6;
            g.fillRect(x, height - towerHeight, towerWidth / 10, towerHeight);
        }

        // Draw disks
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.CYAN, Color.MAGENTA};
        for (int i = 0; i < 3; i++) {
            Stack<Integer> tower = towers[i];
            for (int j = 0; j < tower.size(); j++) {
                int disk = tower.get(j);
                int diskWidth = disk * towerWidth / numDisks;
                int x = (i * 2 + 1) * width / 6 - diskWidth / 2;
                int y = height - (j + 1) * diskHeight;
                g.setColor(colors[disk % colors.length]);
                g.fillRect(x, y, diskWidth, diskHeight);
            }
        }
    }

    public void moveDisk(int from, int to) {
        towers[to].push(towers[from].pop());
        repaint();
    }

    public void setNumDisks(int numDisks) {
        this.numDisks = numDisks;
        for (Stack<Integer> tower : towers) {
            tower.clear();
        }
        for (int i = numDisks; i > 0; i--) {
            towers[0].push(i);
        }
        repaint();
    }
}