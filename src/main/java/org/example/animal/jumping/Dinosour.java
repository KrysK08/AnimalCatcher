package org.example.animal.jumping;

import org.example.animal.Animal;

public class Dinosour extends Animal implements JumpingAnimal {
    private int speedX;
    private int speedY;
    private int jumpHeight;
    private boolean runup;

    public void setRunup(boolean runup) {
        this.runup = runup;
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
        if (getY() <= 0) {
            setRunup(false);
        }

        if (getY() >= 1200) {
            setRunup(true);
        }

        if (runup) {
            setY(getY() - speedY);
        } else {
            setY(getY() + speedY);
        }

    }
}
