package ca.bcit.comp2522.assignments.A1;

import java.util.ArrayList;
import java.util.Random;

public class Ecosystem {
    private ArrayList<Pool> pools;

    public Ecosystem() {
        pools = new ArrayList<Pool>();
    }

    public void addPool(Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    public void reset() {
        pools.clear();
    }

    public int getGuppyPopulation() {
        int guppyPopulation = 0;
        for (Pool pool: pools) {
            guppyPopulation += pool.getPopulation();
        }
        return guppyPopulation;
    }

    public int adjustForCrowding() {
        int guppiesRemoved = 0;
        for (Pool pool: pools) {
            guppiesRemoved += pool.adjustForCrowding();
        }
        return guppiesRemoved;
    }

    public void setupSimulation() {
        Pool Skookumchuk = new Pool(
                "Skookumcuk",
                3000,
                42,
                7.9,
                0.9);
        Pool Squamish = new Pool("Squamish",
                15000,
                39,
                7.7,
                0.85);
        Pool Semiahmoo = new Pool(
                "Semiahmoo",
                8500,
                37,
                7.5,
                1.0);

        String genus = "Poecilia";
        String species = "reticulata";
        Random random = new Random();

        for (int i = 0; i < 300; i++) {
            int ageInWeeks = random.nextInt(16) + 10;
            boolean isFemale;
            if (random.nextDouble() < 0.75) {
                isFemale = true;
            } else {
                isFemale = false;
            }
            int generationNumber = 0;
            double healthCoefficient = 0.5 + (0.8 - 0.5) * random.nextDouble();
            Guppy guppy = new Guppy(genus, species, ageInWeeks,
                    isFemale, generationNumber, healthCoefficient);
            Skookumchuk.addGuppy(guppy);
        }

        for (int i = 0; i < 100; i++) {
            int ageInWeeks = random.nextInt(6) + 10;
            boolean isFemale;
            if (random.nextDouble() < 0.75) {
                isFemale = true;
            } else {
                isFemale = false;
            }
            int generationNumber = 0;
            double healthCoefficient = 0.8 + (1.0 - 0.8) * random.nextDouble();
            Guppy guppy = new Guppy(genus, species, ageInWeeks,
                    isFemale, generationNumber, healthCoefficient);
            Squamish.addGuppy(guppy);
        }

        for (int i = 0; i < 200; i++) {
            int ageInWeeks = random.nextInt(35) + 15;
            boolean isFemale;
            if (random.nextDouble() < 0.35) {
                isFemale = true;
            } else {
                isFemale = false;
            }
            int generationNumber = 0;
            double healthCoefficient = random.nextDouble();
            Guppy guppy = new Guppy(genus, species, ageInWeeks,
                    isFemale, generationNumber, healthCoefficient);
            Semiahmoo.addGuppy(guppy);
        }
        pools.add(Skookumchuk);
        pools.add(Squamish);
        pools.add(Semiahmoo);
    }

    public void simulate(int numberOfWeeks) {
        for (int i = 0; i < numberOfWeeks; i++) {
            System.out.println("It is week: " + i);
            simulateOneWeek();
        }
    }

    public void simulateOneWeek() {
        int diedOfOldAge = 0;
        int numberRemoved = 0;
        int starvedToDeath = 0;
        int newFry = 0;
        int crowdedOut = 0;
        for (Pool pool: pools) {
            diedOfOldAge += pool.incrementAges();
            numberRemoved += pool.removeDeadGuppies();
            starvedToDeath += pool.applyNutrientCoefficient();
            numberRemoved += pool.removeDeadGuppies();
            newFry += pool.spawn();
            crowdedOut += pool.adjustForCrowding();
            numberRemoved += pool.removeDeadGuppies();
            if (diedOfOldAge + starvedToDeath + crowdedOut == numberRemoved) {
                System.out.println("Logic is correct");
            }
        }
        System.out.println(diedOfOldAge + " guppies died to old age.");
        System.out.println(starvedToDeath + " guppies died to starvation.");
        System.out.println(diedOfOldAge + " guppies died to overcrowding.");
        System.out.println(newFry + " new fry were born.");
        System.out.println(pools.get(0).getName() + "'s current population is: " + pools.get(0).getPopulation());
        System.out.println(pools.get(1).getName() + "'s current population is: " + pools.get(1).getPopulation());
        System.out.println(pools.get(2).getName() + "'s current population is: " + pools.get(2).getPopulation());
        System.out.println("The total population of the ecosystem is: " + pools.get(0).getPopulation() + pools.get(1).getPopulation() + pools.get(2).getPopulation());
    }
}
