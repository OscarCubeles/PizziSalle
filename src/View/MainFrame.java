package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final String FRAME_TITLE = "PizziSalle";

    public MainFrame(){
        add(new BackgroundPanel(new InitialPanel()));
        configureFrame();
    }
    private void configureFrame() {
        setSize(1200,800);
        setTitle(FRAME_TITLE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
