package org.example.animal.running;

import org.example.animal.Animal;

import java.awt.*;

public class Cat extends Animal implements RunningAnimal {
    private int speedX;
    private int speedY;
    private boolean runup;
    public void setRunup(boolean runup) {
        this.runup = runup;
    }

    public Cat() {
        super("Cat", 2, false);
        this.speedX = 4;
        this.speedY = 2;
        this.runup = false;
    }

    @Override
    public void run() {

        if (getX() < 1200) {
            setX(getX() + speedX);
        } else {
            setX(0);
        }
        if (getY() <= 490) {
            setRunup(false);
        }

        if (getY() >= 720) {
            setRunup(true);
        }

        if (runup) {
            setY(getY() - speedY);
        } else {
            setY(getY() + speedY);
        }
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(getX(), getY(), 70, 80);
    }

    @Override
    public int getScore() {
        return 2;
    }
}
