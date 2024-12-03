package org.example.animal.running;

import org.example.animal.Animal;

public class Dog extends Animal implements RunningAnimal{
    public Dog() {
        super("Dog",1, false);
    }
    @Override
    public void run() {

    }
}
