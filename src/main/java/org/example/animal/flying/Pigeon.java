package org.example.animal.flying;

import org.example.animal.Animal;

public class Pigeon extends Animal implements FlyingAnimal {
    private int speedX;

    public Pigeon() {
        super("Pigeon", 1, false);
        this.speedX = 3;
    }

    @Override
    public void fly() {

        if (getX() < 1200) {
            setX(getX() + speedX);
        } else {
            setX(0);
        }
    }
}
