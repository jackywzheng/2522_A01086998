package ca.bcit.comp2522.assignments.A1;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many weeks would you like to run the simulation for: ");
        int number = input.nextInt();
        Ecosystem ecosystem = new Ecosystem();
        ecosystem.setupSimulation();
        ecosystem.simulate(number);
    }
}
