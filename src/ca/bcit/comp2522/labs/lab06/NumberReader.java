package ca.bcit.comp2522.labs.lab06;

/**
 * NumberReader.
 */
public class NumberReader {
    /**
     * InputReader to read input.
     */
    private InputReader inputReader;

    /**
     * Zero-param constructor.
     */
    public NumberReader() {
        inputReader = new InputReader();
    }

    /**
     * Asks the user the enter an integer.
     * Adds it to a total and prints the total upon user entering 0.
     * Throws exception if not an integer.
     */
    public void guessNumber() {
        int total = 0;
        while (true) {
            try {
                System.out.println("Enter an integer, 0 to stop: ");
                int input = inputReader.getNumber();
                if (input == 0) {
                    break;
                }
                total += input;
            } catch (NotAnIntegerException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("The sum of numbers entered is: " + total);
    }

    /**
     * Drives the program.
     * @param args, a String
     */
    public static void main(String[] args) {
        NumberReader numberReader = new NumberReader();
        numberReader.guessNumber();
    }
}
