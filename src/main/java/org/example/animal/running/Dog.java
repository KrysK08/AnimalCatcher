package org.example.animal.running;

import org.example.animal.Animal;

public class Dog extends Animal implements RunningAnimal{
    private int speedX;

    public Dog() {
        super("Dog",1, false);
        this.speedX = 2;
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
