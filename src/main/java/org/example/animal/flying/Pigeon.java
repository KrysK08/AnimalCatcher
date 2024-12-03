package org.example.animal.flying;

import org.example.animal.Animal;

public class Pigeon extends Animal implements FlyingAnimal {
    private int speedX;
    private int speedY;
    private boolean flyup;
    public void setFlyup(boolean flyup) {
        this.flyup = flyup;
    }

    public Pigeon() {
        super("Pigeon", 1, false);
        this.speedX = 8;
        this.speedY = 3;
    }

    @Override
    public void fly() {

        if (getX() < 1200) {
            setX(getX() + speedX);
        } else {
            setX(0);
        }
        if (getY() <= 50) {
            setFlyup(false);
        }

        if (getY() >= 190) {
            setFlyup(true);
        }

        if (flyup) {
            setY(getY() - speedY);
        } else {
            setY(getY() + speedY);
        }
    }
}
