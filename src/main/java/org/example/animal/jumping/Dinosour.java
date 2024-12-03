package org.example.animal.jumping;

import org.example.animal.Animal;

public class Dinosour extends Animal implements JumpingAnimal {
    private int jumpHeight;
    private boolean movingUp;

    public Dinosour() {
        super("Dinosour",2, false);
        this.jumpHeight = 100;
    }

    @Override
    public void jump() {

    }

}
