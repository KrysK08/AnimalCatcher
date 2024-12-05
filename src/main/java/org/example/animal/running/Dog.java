package org.example.animal.running;

import org.example.animal.Animal;

import java.awt.*;

public class Dog extends Animal implements RunningAnimal{
    private int speedX;
    private int speedY;
    private boolean runup;
    public void setRunup(boolean runup) {
        this.runup = runup;
    }

    public Dog() {
        super("Dog",1, false);
        this.speedX = 2;
        this.speedY = 1;
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
        return new Rectangle(getX(), getY(), 80, 80);
    }

    @Override
    public int getScore() {
        return 1;
    }
}
