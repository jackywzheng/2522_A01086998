package ca.bcit.comp2522.labs.lab06;

/**
 * NotAnIntegerException, checked exception.
 */
public class NotAnIntegerException extends Exception {
    /**
     * Zero-param constructor.
     */
    public NotAnIntegerException() {

    }

    /**
     * Constructs a NotAnIntegerException.
     * @param msg, a String
     */
    public NotAnIntegerException(String msg) {
        super(msg);
    }
}
