package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

public class Tortoise {
    private static int position = 0;

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

    public static int getPosition() {
        return position;
    }

    public static void setPosition(int newPosition) {
        Tortoise.position = newPosition;
    }

    @Override
    public String toString() {
        return "Tortoise{}";
    }

    public Tortoise() {

    }
}
