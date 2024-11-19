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
    private boolean jumping = false;
    private int jumpHeight = 0;
    private final int GRAVITY = 2;

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
            player = new Boy("Central Cee", 7, 500);
            jumpHeight = 300;
        } else {
            player = new Girl("Ice Spice", 9, 250);
            jumpHeight = 280;
        }

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                moveCharacter(key);

                if (key == KeyEvent.VK_SPACE && !jumping) {
                    jump();
                }
            }
        });

        setFocusable(true);

        setVisible(true);
    }

    private void moveCharacter(int keyCode) {
        int speed = player.getSpeed();

        int previousX = characterX;
        int previousY = characterY;

        switch (keyCode) {
            case KeyEvent.VK_W:
                if (characterY - speed >= 400) {
                    characterY -= speed;
                }
                break;
            case KeyEvent.VK_S:
                if (characterY + 200 + speed <= 800) {
                    characterY += speed;
                }
                break;
            case KeyEvent.VK_A:
                if (characterX - speed >= 0) {
                    characterX -= speed;
                }
                break;
            case KeyEvent.VK_D:
                if (characterX + 200 + speed <= 1200) {
                    characterX += speed;
                }
                break;
        }

        Rectangle oldRect = new Rectangle(previousX, previousY, 200, 200);
        Rectangle newRect = new Rectangle(characterX, characterY, 200, 200);

        oldRect.add(newRect);

        repaint(oldRect.x, oldRect.y, oldRect.width, oldRect.height);
    }

    private void jump() {
        jumping = true;
        new Thread(() -> {
            int startY = characterY;
            Rectangle jumpRect = new Rectangle(characterX, characterY, 200, 200);

            for (int i = 0; i < jumpHeight; i++) {
                characterY--;
                jumpRect.setLocation(characterX, characterY);
                repaint(jumpRect.x, jumpRect.y, jumpRect.width, jumpRect.height);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < jumpHeight; i++) {
                characterY++;
                jumpRect.setLocation(characterX, characterY);
                repaint(jumpRect.x, jumpRect.y, jumpRect.width, jumpRect.height);
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            characterY = startY;
            jumping = false;

            repaint(jumpRect.x, jumpRect.y, jumpRect.width, jumpRect.height);
        }).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(skyImage, 0, 0, getWidth(), getHeight() / 2, this);
        g.drawImage(grassImage, 0, getHeight() / 2, getWidth(), getHeight() / 2, this);

        g.drawImage(characterImage, characterX, characterY, 200, 200, this);
    }
}
