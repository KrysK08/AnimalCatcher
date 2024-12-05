package org.example.animal.jumping;

import org.example.animal.Animal;

import java.awt.*;

public class Dinosour extends Animal implements JumpingAnimal {
    private int speedX;
    private int speedY;
    private int jumpHeight;
    private boolean jumpup;

    public void setJumpup(boolean jumpup) {
        this.jumpup = jumpup;
    }

    public Dinosour() {
        super("Dinosour", 2, false);
        this.jumpHeight = 80;
        this.speedX = 1;
        this.speedY = 2;

    }

    @Override
    public void jump() {
        if (getX() > 0) {
            setX(getX() - speedX);
        } else {
            setX(1200);
        }

        if (getY() <= 50) {
            setJumpup(false);
        }

        if (getY() >= 500) {
            setJumpup(true);
        }

        if (jumpup) {
            setY(getY() - speedY);
        } else {
            setY(getY() + speedY);
        }
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(getX(), getY(), 100, 100);

    }

    @Override
    public int getScore() {
        return 2;
    }
}
