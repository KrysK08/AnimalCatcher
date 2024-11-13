package org.example.window;

import org.example.player.Boy;
import org.example.player.Girl;
import org.example.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Background extends JFrame {
    String character = MyJPanel.getWchichCahracter();
    private Image skyImage = new ImageIcon("src/main/java/org/example/img/sky.jpg").getImage();
    private Image grassImage = new ImageIcon("src/main/java/org/example/img/grass.jpg").getImage();
    private Image characterImage = new ImageIcon(character).getImage();

    private int characterX = 500;
    private int characterY = 500;

    private final Player player;

    public Background() {
        int screenWidth = 1200;
        int screenHeight = 800;

        setTitle("Game");
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        if (character.equals("src/main/java/org/example/img/boy.png")) {
            player = new Boy("Central Cee", 16, 110);
        } else {
            player = new Girl("Ice Spice", 20, 100);
        }

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                moveCharacter(key);
            }
        });

        setFocusable(true);


        setVisible(true);
    }

    private void moveCharacter(int keyCode) {
        int speed = player.getSpeed();

        switch (keyCode) {
            case KeyEvent.VK_W:  // Move up
                if (characterY - speed >= 400) {
                    characterY -= speed;
                }
                break;
            case KeyEvent.VK_S:  // Move down
                if (characterY + 200 + speed <= 800) {
                    characterY += speed;
                }
                break;
            case KeyEvent.VK_A:  // Move left
                if (characterX - speed >= 0) {
                    characterX -= speed;
                }
                break;
            case KeyEvent.VK_D:  // Move right
                if (characterX + 200 + speed <= 1200) {
                    characterX += speed;
                }
                break;
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(skyImage, 0, 0, getWidth(), getHeight() / 2, this);

        g.drawImage(grassImage, 0, getHeight() / 2, getWidth(), getHeight() / 2, this);

        g.drawImage(characterImage, characterX, characterY, 200, 200, this);
    }
}
