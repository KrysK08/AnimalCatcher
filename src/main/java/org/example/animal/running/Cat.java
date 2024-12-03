package org.example.animal.running;

import org.example.animal.Animal;

public class Cat extends Animal implements RunningAnimal {
    private int speedX;

    public Cat() {
        super("Cat", 2, false);
        this.speedX = 4;
    }

    @Override
    public void run() {

        if (getX() < 1200) {
            setX(getX() + speedX);
        } else {
            setX(0);
        }
    }
}
