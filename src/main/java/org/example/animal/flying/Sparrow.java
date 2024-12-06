package org.example.animal.flying;

import org.example.animal.Animal;

import java.awt.*;

public class Sparrow extends Animal implements FlyingAnimal{
    private int speedX;
    private int speedY;
    private boolean flyup;
    public void setFlyup(boolean flyup) {
        this.flyup = flyup;
    }

    public Sparrow() {
        super("Sparrow", 4, false);
        this.speedX = 3;
        this.speedY = 2;
    }

    @Override
    public void fly() {
        if (getX() < 1200) {
            setX(getX() + speedX);
        } else {
            setX(0);
        }
        if (getY() <= 250) {
            setFlyup(false);
        }

        if (getY() >= 370) {
            setFlyup(true);
        }

        if (flyup) {
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
        return 4;
    }
}
