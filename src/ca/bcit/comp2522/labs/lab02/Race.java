package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

public class Race {
    private int length;
    private Hare hare;
    private Tortoise tortoise;

    public Race(int lengthOfRace) {
        length = lengthOfRace;
        hare = new Hare();
        tortoise = new Tortoise();
    }

    public void reset() {
        hare.setPosition(0);
        tortoise.setPosition(0);
    }

    public Object simulateRace () {
        reset();
        return race();
    }

    private Object race() {
        Random rand = new Random();
        int rand_int = rand.nextInt(2);
        if (rand_int == 0) {
            Tortoise first = tortoise;
            Hare second = hare;
        } else {
            Hare first = hare;
            Tortoise second = tortoise;
        }
        do {

        } while (hare.getPosition() < length
                || tortoise.getPosition() < length);
        return tortoise;
    }

}
