package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

public class Hare {
    private static int position;

    public int move() {
        Random rand = new Random();
        int randInt = rand.nextInt(10);
        if (randInt < 2) {
            return position;
        } else if (randInt == 2) {
            position += 9;
        } else if (randInt == 3) {
            position -= 12;
        } else if (randInt < 7) {
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

    public Hare() {
        position = 0;
    }

    @Override
    public String toString() {
        return "Hare{" + "position=" + position + '}';
    }

}
