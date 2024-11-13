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

        if (character.equals("src/main/java/org/example/img/boy.jpg")) {
            player = new Boy("Central Cee", 16, 110);
        } else {
            player = new Girl("Ice Spice", 20, 100);
        }

        // KeyListener for WASD movement
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                moveCharacter(key);
            }
        });

        setFocusable(true);

        // Panel for the character
        JPanel characterPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the character at the current position (characterX, characterY)
                g.drawImage(characterImage, characterX, characterY, 200, 200, this);
            }
        };
        characterPanel.setBounds(0, 0, 1200, 800);  // Set the panel to the full size of the window
        add(characterPanel);

        // Sky panel
        JPanel skyPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(skyImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        skyPanel.setBounds(0, 0, 1200, 400);
        add(skyPanel);

        // Grass panel (where the character moves)
        JPanel grassPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(grassImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        grassPanel.setBounds(0, 400, 1200, 400);
        add(grassPanel);

        setVisible(true);
    }

    // Method to move the character based on WSAD key presses
    private void moveCharacter(int keyCode) {
        int speed = player.getSpeed();

        switch (keyCode) {
            case KeyEvent.VK_W:  // Move up
                if (characterY - speed >= 400) {  // Prevent moving out of bounds
                    characterY -= speed;
                }
                break;
            case KeyEvent.VK_S:  // Move down
                if (characterY + 200 + speed <= 800) {  // Prevent moving out of bounds
                    characterY += speed;
                }
                break;
            case KeyEvent.VK_A:  // Move left
                if (characterX - speed >= 0) {  // Prevent moving out of bounds
                    characterX -= speed;
                }
                break;
            case KeyEvent.VK_D:  // Move right
                if (characterX + 200 + speed <= 1200) {  // Prevent moving out of bounds
                    characterX += speed;
                }
                break;
        }
        repaint();  // Trigger a repaint to update the position of the character
    }
}
