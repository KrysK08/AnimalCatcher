package org.example.animal.flying;

import org.example.animal.Animal;

public class Sparrow extends Animal implements FlyingAnimal{
    private int speedX;

    public Sparrow() {
        super("Sparrow", 7, false);
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
