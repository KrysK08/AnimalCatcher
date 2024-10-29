package org.example.animal.running;

import org.example.animal.Animal;

public class Dog extends Animal implements RunningAnimal{
    public Dog() {
        super("Dog",1);
    }
    @Override
    public void run() {

    }
}
