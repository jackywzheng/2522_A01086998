package ca.bcit.comp2522.labs.lab06;

import java.util.Scanner;

/**
 * InputReader.
 */
public class InputReader {
    /**
     * Scanner object.
     */
    private Scanner scanner;

    /**
     * Zero-param constructor.
     */
    public InputReader() {
        scanner = new Scanner(System.in);
    }

    /**
     * Scans for an integer from user input.
     * Throws an error if no integer found.
     * @return a scanned integer
     * @throws NotAnIntegerException if no integer found
     */
    public int getNumber() throws NotAnIntegerException {
        try {
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
            throw new NotAnIntegerException("That’s not an integer!");
        }
    }
}
