package org.example.window;

import org.example.animal.Animal;
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
    private static final String image_path = "src/main/java/org/example/img/";
    private static final Image skyImage = new ImageIcon(image_path + "sky.jpg").getImage();
    private static final Image grassImage = new ImageIcon(image_path + "grass.jpg").getImage();
    private Image characterImage = new ImageIcon(character).getImage();
    private static Image catImage = new ImageIcon(image_path + "cat.png").getImage();
    private static Image dogImage = new ImageIcon(image_path + "dog.png").getImage();
    private static Image dinosaurImage = new ImageIcon(image_path + "dinosaur.png").getImage();
    private static Image rabbitImage = new ImageIcon(image_path + "rabbit.png").getImage();
    private static Image pigeonImage = new ImageIcon(image_path + "pigeon.png").getImage();
    private static Image sparrowImage = new ImageIcon(image_path + "sparrow.png").getImage();


    private int characterX = 500;
    private int characterY = 500;
    private boolean jumping = false;
    private int jumpHeight = 0;
    private final int GRAVITY = 2;
    private int Score = 0;

    private int timeLeft = 20;
    private Timer timer;
    private boolean lose = false;
    private boolean win = false;

    private final Player player;

    private Cat cat;
    private Pigeon pigeon;
    private Sparrow sparrow;
    private Dinosour dinosour;
    private Rabbit rabbit;
    private Dog dog;

    private Image doubleBufferingImage;
    private Graphics doubleBufferingGraphics;

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
            player = new Boy("Central Cee", 7, 300);
            jumpHeight = 300;
        } else {
            player = new Girl("Ice Spice", 9, 280);
            jumpHeight = 280;
        }

        timer = new Timer(1000, e -> {
            if (timeLeft > 0) {
                timeLeft--;
                repaint();
            } else if (!lose) {
                lose = true;
                timer.stop();
                repaint();
            }
        });
        timer.start();

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

            repaint(jumpRect.x, jumpRect.y, 100, 100);
        }).start();
    }

    private void moveAnimals() {
        while (true) {
            if(lose || win) {
                break;
            }
            cat.run();
            dog.run();
            pigeon.fly();
            sparrow.fly();
            rabbit.jump();
            dinosour.jump();

            repaintAnimal(cat);
            repaintAnimal(dog);
            repaintAnimal(pigeon);
            repaintAnimal(sparrow);
            repaintAnimal(rabbit);
            repaintAnimal(dinosour);

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void repaintAnimal(Animal animal) {
        if (!animal.getCaught()) {
            repaint(animal.getX() - 10, animal.getY() - 10, 100, 100);
        }
    }

    public void checkCollisions() {
        Rectangle playerRect = new Rectangle(characterX, characterY, 80, 80);

        Animal[] animals = {cat, dog, pigeon, sparrow, rabbit, dinosour};

        for (Animal animal : animals) {
            if (!animal.getCaught() && playerRect.intersects(animal.getBoundingBox())) {
                animal.setCaught(true);
                Score(animal.getScore());
            }
        }
        repaint();


    }


    private void Score(int points) {
        Score += points;
        if (Score >= 20 && !win) {
            win = true;
            timer.stop();
            repaint();
            System.out.println("Score: " + Score);
        }
        repaint();
    }

    @Override
    public void paint(Graphics g){
        doubleBufferingImage = createImage(getWidth(), getHeight());
        doubleBufferingGraphics = doubleBufferingImage.getGraphics();
        paintComponent(doubleBufferingGraphics);
        g.drawImage(doubleBufferingImage, 0, 0, this);
    }

    public void paintComponent(Graphics g) {
        super.paint(g);

        g.drawImage(skyImage, 0, 0, getWidth(), getHeight() / 2, this);
        g.drawImage(grassImage, 0, getHeight() / 2, getWidth(), getHeight() / 2, this);
        if (lose) {
            g.setColor(Color.RED);
            g.setFont(new Font("Times New Roman", Font.BOLD, 100));
            g.drawString("GAME OVER LOSER", getWidth() / 2 -470, getHeight() / 2);
        } else if (win) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("Times New Roman", Font.BOLD, 100));
            g.drawString("YOU WON", getWidth() / 2 - 300, getHeight() / 2);
        } else  {

            g.drawImage(characterImage, characterX, characterY, 150, 150, this);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Wynik: " + Score, 10, 55);

            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Czas: " + timeLeft, getWidth() - 100, 55);

            if (!cat.getCaught()) {
                g.drawImage(catImage, cat.getX(), cat.getY(), 70, 80, this);
            }
            if (!rabbit.getCaught()) {
                g.drawImage(rabbitImage, rabbit.getX(), rabbit.getY(), 100, 100, this);
            }
            if (!pigeon.getCaught()) {
                g.drawImage(pigeonImage, pigeon.getX(), pigeon.getY(), 120, 80, this);
            }
            if (!dog.getCaught()) {
                g.drawImage(dogImage, dog.getX(), dog.getY(), 80, 80, this);
            }
            if (!dinosour.getCaught()) {
                g.drawImage(dinosaurImage, dinosour.getX(), dinosour.getY(), 100, 100, this);
            }
            if (!sparrow.getCaught()) {
                g.drawImage(sparrowImage, sparrow.getX(), sparrow.getY(), 80, 80, this);
            }
        }
    }
}