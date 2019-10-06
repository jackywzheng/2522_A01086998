package ca.bcit.comp2522.assignments.A1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Ecosystem.
 *
 * @author Jacky Zheng
 * @version 1.0
 */
public class Ecosystem {
    /**
     * Default volume in litres for Pool Skookumchuk.
     */
    public static final int SKOOKUMCHUK_VOLUME_IN_LITRES = 3000;
    /**
     * Default temperature in Celsius for Pool Skookumchuk.
     */
    public static final int SKOOKUMCHUK_TEMPERATURE_IN_CELSIUS = 42;
    /**
     * Default pH for Pool Skookumchuk.
     */
    public static final double SKOOKUMCHUK_PH = 7.9;
    /**
     * Default nutrient coefficient for Pool Skookumchuk.
     */
    public static final double SKOOKUMCHUK_NUTRIENT_COEFFICIENT = 0.9;

    /**
     * Default volume in litres for Pool Squamish.
     */
    public static final int SQUAMISH_VOLUME_IN_LITRES = 15000;
    /**
     * Default temperature in Celsius for Pool Squamish.
     */
    public static final int SQUAMISH_TEMPERATURE_IN_CELSIUS = 39;
    /**
     * Default pH for Pool Squamish.
     */
    public static final double SQUAMISH_PH = 7.7;
    /**
     * Default nutrient coefficient for Pool Squamish.
     */
    public static final double SQUAMISH_NUTRIENT_COEFFICIENT = 0.85;

    /**
     * Default volume in litres for Pool Semiahmoo.
     */
    public static final int SEMIAHMOO_VOLUME_IN_LITRES = 8500;
    /**
     * Default temperature in Celsius for Pool Semiahmoo.
     */
    public static final int SEMIAHMOO_TEMPERATURE_IN_CELSIUS = 37;
    /**
     * Default pH for Pool Semiahmoo.
     */
    public static final double SEMIAHMOO_PH = 7.5;
    /**
     * Default nutrient coefficient for Pool Semiahmoo.
     */
    public static final double SEMIAHMOO_NUTRIENT_COEFFICIENT = 1.0;

    private ArrayList<Pool> pools;

    /**
     * Zero-parameter constructor for objects of class Ecosystem.
     */
    public Ecosystem() {
        pools = new ArrayList<>();
    }

    /**
     * Adds an object of Pool class to Ecosystem.
     *
     * @param newPool a Pool object
     */
    public void addPool(Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    /**
     * Returns the number of pools.
     *
     * @return number of pools as an int
     */
    public int getNumberOfPools() {
        return pools.size();
    }

    /**
     * Resets the Ecosystem.
     */
    public void reset() {
        pools.clear();
    }

    /**
     * Returns the total Guppy population in all of the Pools in the Ecosystem.
     *
     * @return guppyPopulation as an int
     */
    public int getGuppyPopulation() {
        int guppyPopulation = 0;
        for (Pool pool: pools) {
            guppyPopulation += pool.getPopulation();
        }
        return guppyPopulation;
    }

    /**
     * Calls the Pool adjustForCrowding method on each Pool and returns the
     * number of Guppies that died of overcrowding.
     *
     * @return numberOfGuppiesDiedOfCrowding as an int
     */
    public int adjustForCrowding() {
        int numberOfGuppiesDiedOfCrowding = 0;
        for (Pool pool: pools) {
            numberOfGuppiesDiedOfCrowding += pool.adjustForCrowding();
        }
        return numberOfGuppiesDiedOfCrowding;
    }

    /**
     * Sets up the Ecosystem with predetermined values.
     */
    public void setupSimulation() {
        Pool poolSkookumchuk = new Pool(
                "Skookumchuk",
                SKOOKUMCHUK_VOLUME_IN_LITRES,
                SKOOKUMCHUK_TEMPERATURE_IN_CELSIUS,
                SKOOKUMCHUK_PH,
                SKOOKUMCHUK_NUTRIENT_COEFFICIENT);
        Pool poolSquamish = new Pool("Squamish",
                SQUAMISH_VOLUME_IN_LITRES,
                SQUAMISH_TEMPERATURE_IN_CELSIUS,
                SQUAMISH_PH,
                SQUAMISH_NUTRIENT_COEFFICIENT);
        Pool poolSemiahmoo = new Pool("Semiahmoo",
                SEMIAHMOO_VOLUME_IN_LITRES,
                SEMIAHMOO_TEMPERATURE_IN_CELSIUS,
                SEMIAHMOO_PH,
                SEMIAHMOO_NUTRIENT_COEFFICIENT);

        String genus = "Poecilia";
        String species = "reticulata";
        boolean isFemale;
        Random random = new Random();

        for (int i = 0; i < 300; i++) {
            // Ages between 10 and 25 inclusive
            int ageInWeeks = random.nextInt(16) + 10;
            // 75% chance of being female
            if (random.nextDouble() < 0.75) {
                isFemale = true;
            } else {
                isFemale = false;
            }
            int generationNumber = 0;
            // Health coefficient between 0.5 and 0.8 inclusive
            double healthCoefficient = 0.5 + (0.8 - 0.5) * random.nextDouble();
            Guppy guppy = new Guppy(genus, species, ageInWeeks,
                    isFemale, generationNumber, healthCoefficient);
            poolSkookumchuk.addGuppy(guppy);
        }

        for (int i = 0; i < 100; i++) {
            // Ages between 10 and 15 weeks inclusive
            int ageInWeeks = random.nextInt(6) + 10;
            // 75% chance of being female
            if (random.nextDouble() < 0.75) {
                isFemale = true;
            } else {
                isFemale = false;
            }
            int generationNumber = 0;
            // Health coefficient between 0.8 and 1.0 inclusive
            double healthCoefficient = 0.8 + (1.0 - 0.8) * random.nextDouble();
            Guppy guppy = new Guppy(genus, species, ageInWeeks,
                    isFemale, generationNumber, healthCoefficient);
            poolSquamish.addGuppy(guppy);
        }

        for (int i = 0; i < 200; i++) {
            // Ages between 35 and 49 weeks inclusive
            int ageInWeeks = random.nextInt(35) + 15;
            // 35% chance of being female
            if (random.nextDouble() < 0.35) {
                isFemale = true;
            } else {
                isFemale = false;
            }
            int generationNumber = 0;
            // Health coefficient between 0.0 and 1.0 inclusive
            double healthCoefficient = random.nextDouble();
            Guppy guppy = new Guppy(genus, species, ageInWeeks,
                    isFemale, generationNumber, healthCoefficient);
            poolSemiahmoo.addGuppy(guppy);
        }
        addPool(poolSkookumchuk);
        addPool(poolSquamish);
        addPool(poolSemiahmoo);
    }

    /**
     * Calls simulateOneWeek() method for however many weeks. Ignores negative
     * values.
     *
     * @param numberOfWeeks the number of weeks to simulate as an int
     */
    public void simulate(int numberOfWeeks) {
        if (numberOfWeeks > 0) {
            for (int i = 1; i <= numberOfWeeks; i++) {
                System.out.println("It is week: " + i);
                simulateOneWeek();
            }
        }
    }

    /**
     * Simulates one week.
     * Every week, incrementAges(), applyNutrientCoefficient(), spawn(), and
     * adjustForCrowding() are called. removeDeadGuppies() is also called
     * after each call. Prints a summary of the pools at the end of a week.
     */
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
            // Check if values add up correctly
            if ((diedOfOldAge + starvedToDeath + crowdedOut) != numberRemoved) {
                System.out.println("Logic error!");
            }
        }
        // Summary of the week
        System.out.println(diedOfOldAge + " guppies died to old age.");
        System.out.println(starvedToDeath + " guppies died to starvation.");
        System.out.println(crowdedOut + " guppies died to overcrowding.");
        System.out.println(newFry + " new fry were born.");
        System.out.println(pools.get(0).getName() + "'s current population is: "
                + pools.get(0).getPopulation());
        System.out.println(pools.get(1).getName() + "'s current population is: "
                + pools.get(1).getPopulation());
        System.out.println(pools.get(2).getName() + "'s current population is: "
                + pools.get(2).getPopulation());
        System.out.println("The total population of the ecosystem is: "
                + getGuppyPopulation());
        System.out.println("=================================================");
    }

    /**
     * Returns a String representation of this Pool.
     *
     * @return toString a String representation
     */
    @Override
    public String toString() {
        return "Ecosystem{"
                + "pools=" + pools
                + '}';
    }
}
