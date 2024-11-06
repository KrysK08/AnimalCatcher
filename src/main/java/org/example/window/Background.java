package org.example.window;

import javax.swing.*;
import java.awt.*;

public class Background extends JFrame {
    public Background() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setTitle("Game");
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(0,0);



        setVisible(true);
    }
}
