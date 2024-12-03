package org.example.animal.jumping;

import org.example.animal.Animal;

public class Rabbit extends Animal implements JumpingAnimal {
    private int jumpHeight;
    private boolean movingUp;

    public Rabbit() {
        super("Rabbit", 8, false);
        this.jumpHeight = 100;
        this.movingUp = true;
    }

    @Override
    public void jump() {
        if (movingUp) {
            if (getY() > 450 - jumpHeight) {
                setY(getY() - 2);
            } else {
                movingUp = false;
            }
        } else {
            if (getY() < 550) {
                setY(getY() + 2);
            } else {
                movingUp = true;
            }
        }
    }
}
