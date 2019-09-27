package ca.bcit.comp2522.labs.lab03;

public class Driver {
    public static void main(String[] args) {
        Plantation lotuslandLumber = new Plantation();
        for (int i = 0; i < 10; i++) {
            lotuslandLumber.seed();
        }
        System.out.println(lotuslandLumber.size() + " trees planted.");
        System.out.println(lotuslandLumber.harvest(
                80).size() + " trees harvested");
    }
}
