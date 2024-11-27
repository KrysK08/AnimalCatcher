package org.example.animal;

public abstract class Animal {
    private String name;
    private int points;
    private boolean caught;
    private int x; // Współrzędne X
    private int y; // Współrzędne Y

    public Animal(String name, int points) {
        this.name = name;
        this.points = points;
        this.caught = false;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public boolean isCaught() {
        return caught;
    }

    public void setCaught(boolean caught) {
        this.caught = caught;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}