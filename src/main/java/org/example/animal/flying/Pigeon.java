package org.example.animal.flying;

import org.example.animal.Animal;

public class Pigeon extends Animal implements FlyingAnimal {
    public Pigeon() {
        super("Pigeon",3);
    }

    @Override
    public void fly() {

    }
}
