package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

public class Tortoise {
    private int position;

    public int move() {
        Random rand = new Random();
        int rand_int = rand.nextInt(10);
        if (rand_int < 5) {
            position += 3;
        } else if (rand_int < 7) {
            position -=  6;
        } else {
            position += 1;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        position = newPosition;
    }

    @Override
    public String toString() {
        return "Tortoise{}";
    }

    public Tortoise() {
        position = 0;
    }
}
