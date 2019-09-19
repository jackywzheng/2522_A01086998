package ca.bcit.comp2522.labs.lab02;

/*
Tortoise wins 99.9% of the time. Never give up!
 */
public class Driver {

    public static void simulateRaces(int numberOfRaces, int lengthOfRace) {
        int hareWins = 0;
        int tortoiseWins = 0;
        for (int i = 0; i < numberOfRaces; i++) {
            Race race = new Race(lengthOfRace);
            Object winner = race.simulateRace();
            if (winner.getClass() == Hare.class) {
                hareWins++;
            } else {
                tortoiseWins++;
            }
        }
        System.out.println("Tortoise wins:" + tortoiseWins + "times");
        System.out.println("Hare wins:" + hareWins + "times");
    }

    public static void main(String[] args) {
        simulateRaces(1000, 100);
    }
}
