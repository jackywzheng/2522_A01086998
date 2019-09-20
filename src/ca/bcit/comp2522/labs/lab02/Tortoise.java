package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

public class Tortoise {
    public static final int RANDOM_RANGE = 10;
    public static final int CHANCE_FAST_PLOD = 5;
    public static final int CHANCE_SLIP = 7;

    public static final int FAST_PLOD = 3;
    public static final int SLIP = -6;
    public static final int SLOW_POD = 1;

    private int position;

    public int move() {
        Random rand = new Random();
        int randInt = rand.nextInt(RANDOM_RANGE);
        if (randInt < CHANCE_FAST_PLOD) {
            position += FAST_PLOD;
        } else if (randInt < CHANCE_SLIP) {
            position += SLIP;
        } else {
            position += SLOW_POD;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        position = newPosition;
    }

    public Tortoise() {
        position = 0;
    }

    @Override
    public String toString() {
        return "Tortoise{" + "position=" + position + '}';
    }
}
