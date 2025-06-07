package videosplitter.gui;

import javax.swing.*;
import java.awt.*;

//fenster für die Pro Version
public class ProInfoWindow extends JFrame {
    public ProInfoWindow() {
        setTitle("Pro-Version");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Pro Version ist nicht aktiviert! :(", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnBuy = new JButton("Hier kaufen!");

        btnBuy.addActionListener(e -> {
            //zahlungsfehler fenster (links)
            JFrame failedFrame = new JFrame("Zahlung fehlgeschlagen");
            failedFrame.setSize(250, 120);
            failedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            failedFrame.setLocation(this.getX() - 260, this.getY() + 40);
            JLabel failedLabel = new JLabel(
                    "<html><center>Die Zahlung ist fehlgeschlagen.<br>Bitte überprüfen Sie Ihre Zahlungsdaten.</center></html>",
                    SwingConstants.CENTER
            );
            failedLabel.setFont(new Font("Arial", Font.PLAIN, 13));
            failedFrame.add(failedLabel);
            failedFrame.setVisible(true);

            //systemanforderungen zu niedrig Fenster (rechts)
            JFrame sysFrame = new JFrame("Systemanforderungen zu niedrig");
            sysFrame.setSize(250, 120);
            sysFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            sysFrame.setLocation(this.getX() + this.getWidth() + 10, this.getY() + 40);
            JLabel sysLabel = new JLabel(
                    "<html><center>Die Systemanforderungen sind zu niedrig!<br>Bitte führen Sie das Programm auf einem stärkeren System aus.</center></html>",
                    SwingConstants.CENTER
            );
            sysLabel.setFont(new Font("Arial", Font.PLAIN, 13));
            sysFrame.add(sysLabel);
            sysFrame.setVisible(true);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnBuy);

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}