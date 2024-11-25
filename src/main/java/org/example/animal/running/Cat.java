package org.example.animal.running;

import org.example.animal.Animal;

public class Cat extends Animal implements RunningAnimal {
    private int speed;

    public Cat() {
        super("Cat", 3);
        this.speed = 3;
    }

   @Override
    public void run() {
        /* += speed;

        if (catX > 1200) {
            catX = -70;
        }*/
    }

 /*    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return catX;
    }

    public int getY() {
        return catY;
    }

    public void setX(int x) {
        catX = x;
    }

    public void setY(int y) {
        catY = y;
    }*/
}
