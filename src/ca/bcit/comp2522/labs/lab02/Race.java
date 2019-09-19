package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

public class Race {
    private int length;
    private Hare hare;
    private Tortoise tortoise;
    private int clockTicks;
    private Object winner;

    public Race(int lengthOfRace) {
        length = lengthOfRace;
        hare = new Hare();
        tortoise = new Tortoise();
    }

    public void reset() {
        hare.setPosition(0);
        tortoise.setPosition(0);
    }

    public Object simulateRace() {
        reset();
        return race();
    }

    public int getClockTicks() {
        return clockTicks;
    }

    private Object race() {
        clockTicks = 0;
        do {
            clockTicks++;
            Random rand = new Random();
            int randInt = rand.nextInt(2);
            if (randInt == 0) {
                tortoise.move();
                if (tortoise.getPosition() >= length) {
                    winner = tortoise;
                    }
                hare.move();
                if (hare.getPosition() >= length) {
                    winner = hare;
                    }
            } else {
                hare.move();
                if (hare.getPosition() >= length) {
                    winner = hare;
                }
                tortoise.move();
                if (tortoise.getPosition() >= length) {
                    winner = tortoise;
                }
            }
        } while (hare.getPosition() < length
                && tortoise.getPosition() < length);
        return winner;
    }

}
