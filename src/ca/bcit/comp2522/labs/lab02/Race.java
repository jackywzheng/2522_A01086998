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

    public int getHarePosition() {
        return hare.getPosition();
    }

    public int getTortoisePosition() {
        return tortoise.getPosition();
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
                if (tortoise.getPosition() < length) {
                    hare.move();
                }
            } else {
                hare.move();
                if (hare.getPosition() < length) {
                    tortoise.move();
                }
            }
        } while (hare.getPosition() < length
                && tortoise.getPosition() < length);
        if (hare.getPosition() >= length) {
            return hare;
        } else {
            return tortoise;
        }
    }
}
