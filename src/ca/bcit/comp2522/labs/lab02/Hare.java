package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

public class Hare {
    private static int position;

    public int move() {
        Random rand = new Random();
        int rand_int = rand.nextInt(10);
        if (rand_int < 2) {
            return position;
        } else if (rand_int == 2) {
            position += 9;
        } else if (rand_int == 3) {
            position -= 12;
        } else if (rand_int < 7){
            position += 1;
        } else {
            position -= 2;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        position = newPosition;
    }

    @Override
    public String toString() {
        return "Hare{}";
    }

    public Hare () {
        position = 0;
    }
}
