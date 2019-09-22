package ca.bcit.comp2522.labs.lab02;

import java.util.Random;


/**
 * Represents a Race object.
 *
 * @author Jacky
 * @version 1.0
 */
public class Race {
    private int length;
    private Hare hare;
    private Tortoise tortoise;
    private int clockTicks;

    /**
     * Single-parameter constructor for objects of class Race.
     *
     * @param lengthOfRace must be an int greater than 0
     */
    public Race(int lengthOfRace) {
        length = lengthOfRace;
        hare = new Hare();
        tortoise = new Tortoise();
    }

    /**
     * Resets the position of the Hare and Tortoise objects to 0.
     */
    public void reset() {
        hare.setPosition(0);
        tortoise.setPosition(0);
    }

    /**
     * Returns the Hare's position.
     *
     * @return position as an int
     */
    public int getHarePosition() {
        return hare.getPosition();
    }

    /**
     * Returns the Tortoise's position
     *
     * @return position as an int
     */
    public int getTortoisePosition() {
        return tortoise.getPosition();
    }

    /**
     * Resets positions and calls the race method.
     *
     * @return a reference to the winner of the race, either Tortoise or Hare
     */
    public Object simulateRace() {
        reset();
        return race();
    }

    /**
     * Returns the number of clock ticks
     *
     * @return clockTicks as an int
     */
    public int getClockTicks() {
        return clockTicks;
    }

    /**
     * Simulates a race between a Hare and Tortoise object. Ends when either
     * object crosses the finish line as designated by length.
     *
     * @return a reference to the winner of the race, either Tortoise or Hare
     */
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
