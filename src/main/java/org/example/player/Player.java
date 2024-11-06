package org.example.player;

public abstract class Player {
    private String name;
    private int speed;
    private int jump;

    public Player(String name, int speed, int jump) {
        this.name = name;
        this.speed = speed;
        this.jump = jump;
    }
    public String getName() {return name;}
    public int getSpeed() {return speed;}
    public int getJump() {return jump;}
}
