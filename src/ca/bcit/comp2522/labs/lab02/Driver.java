package ca.bcit.comp2522.labs.lab02;

/** Tortoise wins 99.9% of the time. Moral of the story is never give up!
 *
 * Driver class.
 *
 * @author Jacky
 * @version 1.0
 */
public class Driver {
    /**
     * Simulates races between a Hare object and a Tortoise object and prints
     * the results of the race.
     * @param numberOfRaces an int
     * @param lengthOfRace an int
     */
    public static void simulateRaces(int numberOfRaces, int lengthOfRace) {
        int hareWins = 0;
        int tortoiseWins = 0;
        for (int i = 0; i < numberOfRaces; i++) {
            Race race = new Race(lengthOfRace);
            Object winner = race.simulateRace();
            if (winner.getClass() == Hare.class) {
                hareWins++;
                System.out.println("Hare wins after: "
                        + race.getClockTicks()
                        + " clock ticks at position "
                        + race.getHarePosition()
                        + ". The tortoise is at position "
                        + race.getTortoisePosition());
            } else {
                tortoiseWins++;
                System.out.println("Tortoise wins after: "
                        + race.getClockTicks()
                        + " clock ticks at position "
                        + race.getTortoisePosition()
                        + ". The hare is at position "
                        + race.getHarePosition());
            }
        }
        System.out.println("Tortoise wins: " + tortoiseWins + " times");
        System.out.println("Hare wins: " + hareWins + " times");
    }

    /**
     * Drives the program/
     * @param args a String[]
     */
    public static void main(String[] args) {
        simulateRaces(100,
                100);
    }
}
