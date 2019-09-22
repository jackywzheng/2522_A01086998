package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

/**
 * Represents a Tortoise object.
 *
 * @author Jacky
 * @version 1.0
 */
public class Tortoise {
    /**
     * Used to generate a random number between 0 and 9 inclusive.
     */
    public static final int RANDOM_RANGE = 10;

    /**
     * The chance to fast plod is 50%.
     */
    public static final int CHANCE_FAST_PLOD = 5;

    /**
     * The chance to slip is 20%.
     */
    public static final int CHANCE_SLIP = 7;

    /**
     * A fast plod moves forward 3 units.
     */
    public static final int FAST_PLOD = 3;

    /**
     * A slip moves backward 6 units.
     */
    public static final int SLIP = -6;

    /**
     * A slow plod moves forward 1 unit.
     */
    public static final int SLOW_POD = 1;

    private int position;

    /**
     * Returns the position after a randomly selected movement.
     * 50% of the time the Tortoise moves forward 3 units with a fast plod.
     * 20% of the time the Tortoise slips and moves backward 6 units.
     * the rest of the time, the Tortoise moves forward 1 unit with a slow plod.
     * @return position as an int
     */
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

    /**
     * Returns the position.
     *
     * @return position as an int
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the position of this Tortoise.
     *
     * @param newPosition an int
     */
    public void setPosition(int newPosition) {
        position = newPosition;
    }

    /**
     * Zero-parameter constructor for objects of class Tortoise.
     */
    public Tortoise() {
        position = 0;
    }

    /**
     * Returns a String representation of this Tortoise.
     *
     * @return toString a String representation.
     */
    @Override
    public String toString() {
        return "Tortoise{" + "position=" + position + '}';
    }

    /**
     * Returns true if the specified object is equal to this Tortoise.
     * @param o an Object
     * @return true if this equals o, else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tortoise tortoise = (Tortoise) o;

        if (position != tortoise.getPosition()) {
            return false;
        }
        return true;
    }
}
