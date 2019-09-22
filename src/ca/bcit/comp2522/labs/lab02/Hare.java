package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

/**
 * Represents a Hare object.
 *
 * @author Jacky
 * @version 1.0
 */
public class Hare {
    /**
     * Used to generate a random number between 0 and 9 inclusive.
     */
    public static final int RANDOM_RANGE = 10;

    /**
     * The chance to sleep is 20%.
     */
    public static final int CHANCE_SLEEP = 2;

    /**
     * The chance to slip is 10%.
     */
    public static final int CHANCE_SLIP = 3;

    /**
     * The chance to small hop is 30%.
     */
    public static final int CHANCE_SMALL_HOP = 7;

    /**
     * A big hop moves forward 9 units.
     */
    public static final int BIG_HOP = 9;

    /**
     * A big slip moves backward 12 units.
     */
    public static final int BIG_SLIP = -12;

    /**
     * A small hop moves forward 1 unit.
     */
    public static final int SMALL_HOP = 1;

    /**
     * A small slip moves backward 2 units.
     */
    public static final int SMALL_SLIP = -2;

    private static int position;

    /**
     * Returns the position after a randomly selected movement.
     * 20% of the time the Hare sleeps and does not move.
     * 10% of the time the Hare take a big hop and moves forward 9 units.
     * 10% of the time the Hare suffers a big slip and moves backward 12 units.
     * 30% of the time the Hare takes a small hop and moves forward 1 unit.
     * the rest of the time, the Hard suffers a small slip and moves backward
     * 2 units.
     *
     * @return position as an int
     */
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

    /**
     * Returns the position.
     *
     * @return position as an int
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the position of this Hare.
     *
     * @param newPosition an int
     */
    public void setPosition(int newPosition) {
        position = newPosition;
    }

    /**
     * Zero-parameter constructor for objects of class Hare.
     */
    public Hare() {
        position = 0;
    }

    /**
     * Returns a String representation of this Hare.
     *
     * @return toString a String representation.
     */
    @Override
    public String toString() {
        return "Hare{" + "position=" + position + '}';
    }

    /**
     * Returns true if the specified object is equal to this Hare.
     * @param o an Object
     * @return true if this equals o, else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hare hare = (Hare) o;

        if (position != hare.getPosition()) {
            return false;
        }
        return true;
    }
}
