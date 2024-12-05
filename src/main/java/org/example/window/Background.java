package org.example.window;

import org.example.animal.flying.Pigeon;
import org.example.animal.flying.Sparrow;
import org.example.animal.jumping.Dinosour;
import org.example.animal.jumping.Rabbit;
import org.example.animal.running.Cat;
import org.example.animal.running.Dog;
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
    private Image catImage = new ImageIcon("src/main/java/org/example/img/cat.png").getImage();
    private Image dogImage = new ImageIcon("src/main/java/org/example/img/dog.png").getImage();
    private Image dinosaurImage = new ImageIcon("src/main/java/org/example/img/dinosaur.png").getImage();
    private Image rabbitImage = new ImageIcon("src/main/java/org/example/img/rabbit.png").getImage();
    private Image pigeonImage = new ImageIcon("src/main/java/org/example/img/pigeon.png").getImage();
    private Image sparrowImage = new ImageIcon("src/main/java/org/example/img/sparrow.png").getImage();


    private int characterX = 500;
    private int characterY = 500;
    private boolean jumping = false;
    private int jumpHeight = 0;
    private final int GRAVITY = 2;
    private int dinosaurX = 10;
    private int dinosaurY = 500;
    private int Score = 0;


    private final Player player;

    private Cat cat;
    private Pigeon pigeon;
    private Sparrow sparrow;
    private Dinosour dinosour;
    private Rabbit rabbit;
    private Dog dog;

    public Background() {

        int screenWidth = 1200;
        int screenHeight = 800;

        setTitle("Game");
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        ImageIcon logo = new ImageIcon("src/main/java/org/example/img/logo.png");
        setIconImage(logo.getImage());

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

        cat = new Cat();
        cat.setX(100);
        cat.setY(600);

        dog = new Dog();
        dog.setX(1000);
        dog.setY(650);

        pigeon = new Pigeon();
        pigeon.setX(400);
        pigeon.setY(100);

        sparrow = new Sparrow();
        sparrow.setX(800);
        sparrow.setY(300);

        rabbit = new Rabbit();
        rabbit.setX(700);
        rabbit.setY(550);

        dinosour = new Dinosour();
        dinosour.setX(10);
        dinosour.setY(500);


        new Thread(this::moveAnimals).start();

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


        Rectangle oldRect = new Rectangle(previousX, previousY, 150, 150);
        Rectangle newRect = new Rectangle(characterX, characterY, 150, 150);

        oldRect.add(newRect);

        repaint(oldRect.x, oldRect.y, oldRect.width, oldRect.height);
        checkCollisions();
    }

    private void jump() {
        jumping = true;
        new Thread(() -> {
            int startY = characterY;
            Rectangle jumpRect = new Rectangle(characterX, characterY, 100, 100);

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

    private void moveAnimals() {
        while (true) {
            cat.run();
            dog.run();
            pigeon.fly();
            sparrow.fly();
            rabbit.jump();
            dinosour.jump();

            repaint(cat.getX()-10, cat.getY()-10,80,90);
            repaint(dog.getX(), dog.getY(),80,80);
            repaint(pigeon.getX(), pigeon.getY(),120,80);
            repaint(sparrow.getX(), sparrow.getY(),80,80);
            repaint(rabbit.getX(), rabbit.getY(),100,100);
            repaint(dinosour.getX(), dinosour.getY(),100,100);

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void checkCollisions() {
        Rectangle playerRect = new Rectangle(characterX, characterY, 80, 80);

        if (!cat.getCaught() && playerRect.intersects(new Rectangle(cat.getX(), cat.getY(), 65, 75))) {
            cat.setCaught(true);
            Score(2);

        }

        if(!dog.getCaught() && playerRect.intersects(new Rectangle(dog.getX(), dog.getY(), 80, 70))) {
            dog.setCaught(true);
            Score(1);
        }

        if (!rabbit.getCaught() && playerRect.intersects(new Rectangle(rabbit.getX(), rabbit.getY(), 100, 100))) {
            rabbit.setCaught(true);
            Score(4);
        }

        if(!dinosour.getCaught() && playerRect.intersects(new Rectangle(dinosour.getX(), dinosour.getY(), 100, 70))) {
            dinosour.setCaught(true);
            Score(2);
        }

        if (!pigeon.getCaught() && playerRect.intersects(new Rectangle(pigeon.getX(), pigeon.getY(), 110, 80))) {
            pigeon.setCaught(true);
            Score(4);
        }
        if(!sparrow.getCaught() && playerRect.intersects(new Rectangle(sparrow.getX(), sparrow.getY(), 80, 80))) {
            sparrow.setCaught(true);
            Score(7);
        }


        repaint();
    }


    private void Score(int points){

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(skyImage, 0, 0, getWidth(), getHeight() / 2, this);
        g.drawImage(grassImage, 0, getHeight() / 2, getWidth(), getHeight() / 2, this);

        g.drawImage(characterImage, characterX, characterY, 150, 150, this);
        if (!cat.getCaught()) {
            g.drawImage(catImage, cat.getX(), cat.getY(), 70, 80, this);
        }
        if (!rabbit.getCaught()) {
            g.drawImage(rabbitImage, rabbit.getX(), rabbit.getY(), 100, 100, this);
        }
        if (!pigeon.getCaught()) {
            g.drawImage(pigeonImage, pigeon.getX(), pigeon.getY(), 120, 80, this);
        }
        if(!dog.getCaught()) {
            g.drawImage(dogImage, dog.getX(), dog.getY(), 80, 80, this);
        }
        if(!dinosour.getCaught()) {
            g.drawImage(dinosaurImage, dinosaurX, dinosaurY, 100, 100, this);
        }
        if(!sparrow.getCaught()) {
            g.drawImage(sparrowImage, sparrow.getX(), sparrow.getY(), 80, 80, this);
        }

    }
}
