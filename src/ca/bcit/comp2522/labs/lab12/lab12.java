package ca.bcit.comp2522.labs.lab12;

import java.io.File;
import java.util.Scanner;

public class lab12 {

    public void readFile() {
        try {
            System.out.println("Enter the file name with extension: ");
            Scanner input = new Scanner(System.in);
            File file = new File("src/ca/bcit/comp2522/labs/lab12/" + input.nextLine());
            input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (Exception e) {
            System.out.println("Could not find file, double check filename and make sure file is in lab12 package");
        }
    }

    public static void main(String[] args) {

    }
}
