package org.example.animal.running;

import org.example.animal.Animal;

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
        speedY = 1;
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
}
