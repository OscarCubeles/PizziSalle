package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {
    private BufferedImage biImage;
    public BackgroundPanel(JPanel panel) {
        try {
            biImage = ImageIO.read(new File("rsc/img/b1b.jpg"));
            setLayout(new GridBagLayout());
            panel.setPreferredSize(new Dimension(1000, 800));
            add(panel);
        } catch (IOException e) {
            System.out.println("Error reading image");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(biImage, 0, 0, this);
    }
}
