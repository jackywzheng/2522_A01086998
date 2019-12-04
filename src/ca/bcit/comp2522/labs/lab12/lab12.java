package ca.bcit.comp2522.labs.lab12;

import java.io.File;
import java.util.Scanner;

public class lab12 {

    public static void readFile() {
        try {
            System.out.print("Enter the file name with extension : ");

            Scanner input = new Scanner(System.in);

            File file = new File("./" + input.nextLine());

            input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        lab12.readFile();
    }
}
