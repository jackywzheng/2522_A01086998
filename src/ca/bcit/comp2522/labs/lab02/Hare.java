package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

public class Hare {
    public static final int RANDOM_RANGE = 10;
    public static final int CHANCE_SLEEP = 2;
    public static final int CHANCE_SLIP = 3;
    public static final int CHANCE_SMALL_HOP = 7;

    public static final int BIG_HOP = 9;
    public static final int BIG_SLIP = -12;
    public static final int SMALL_HOP = 1;
    public static final int SMALL_SLIP = -2;

    private static int position;

    public int move() {
        Random rand = new Random();
        int randInt = rand.nextInt(RANDOM_RANGE);
        if (randInt < CHANCE_SLEEP) {
            return position;
        } else if (randInt == CHANCE_SLEEP) {
            position += BIG_HOP;
        } else if (randInt == CHANCE_SLIP) {
            position += BIG_SLIP;
        } else if (randInt < CHANCE_SMALL_HOP) {
            position += SMALL_HOP;
        } else {
            position += SMALL_SLIP;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        position = newPosition;
    }

    public Hare() {
        position = 0;
    }

    @Override
    public String toString() {
        return "Hare{" + "position=" + position + '}';
    }

}
