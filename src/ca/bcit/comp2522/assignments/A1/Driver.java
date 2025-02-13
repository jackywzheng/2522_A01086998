package ca.bcit.comp2522.assignments.A1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Driver.
 *
 * @author Jacky Zheng
 * @version 1.0
 */
public class Driver {

    /**
     * Drives the function and asks the user to input how many weeks of
     * Ecosystem simulation to run for.
     *
     * @param args as String arguments on the command line
     */
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.print("How many weeks would you like to run the simulation for: ");
//        int numberOfWeeksInput = input.nextInt();
//        Ecosystem ecosystem = new Ecosystem();
//        ecosystem.setupSimulation();
//        ecosystem.simulate(numberOfWeeksInput);
        LinkedList<Integer> childrenAges = new LinkedList<Integer>(Arrays.asList(2, 4, 5, 7));
        childrenAges.forEach(age -> System.out.println("One of the children is " + age + " years old."));
    }
}
