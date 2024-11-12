package org.example.window;

import javax.swing.*;
import java.awt.*;

public class Background extends JFrame {
    String character = MyJPanel.getWchichCahracter();
    private Image skyImage = new ImageIcon("src/main/java/org/example/img/sky.jpg").getImage();
    private Image grassImage = new ImageIcon("src/main/java/org/example/img/grass.jpg").getImage();
    private Image characterImage = new ImageIcon("src/main/java/org/example/img/"+character).getImage();

    public Background() {
        int screenWidth = 1200;
        int screenHeight = 800;

        setTitle("Game");
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        JPanel skyPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(skyImage, 0, 0, getWidth(),getHeight(), this);
            }

        };
        skyPanel.setBounds(0, 0, 1200, 400);
        add(skyPanel);
        JPanel grassPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(grassImage, 0, 0, getWidth(),getHeight(), this);
            }

        };
        grassPanel.setBounds(0, 400, 1200, 400);
        add(grassPanel);


        JPanel characterPanel = new JPanel(){

        };


        setVisible(true);
    }
}
