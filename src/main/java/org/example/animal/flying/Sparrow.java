package org.example.animal.flying;

import org.example.animal.Animal;

public class Sparrow extends Animal implements FlyingAnimal{
    public Sparrow() {
        super("Sparrow", 7);
    }

    @Override
    public void fly() {

    }
}
