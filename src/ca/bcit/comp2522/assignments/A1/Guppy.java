package ca.bcit.comp2522.assignments.A1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a guppy with numerous traits.
 * @author Jacky Zheng
 * @version 2019
 */
public class Guppy {
    /**
     * A baby guppy starts at 0 weeks old.
     */
    public static final int BABY_FISH_AGE_IN_WEEKS = 0;
    /**
     * A guppy is young when it is 10 weeks old.
     */
    public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;
    /**
     * A guppy is mature when it is 30 weeks old.
     */
    public static final int MATURE_FISH_AGE_IN_WEEKS = 30;
    /**
     * A guppy's maximum age is 50 weeks old.
     */
    public static final int MAXIMUM_AGE_IN_WEEKS = 50;
    /**
     * Baby guppy generation is 1 + mother's generation number
     */
    public static final int BABY_GUPPY_GENERATION = 1;
    /**
     * The minimum water volume required measured in mL.
     */
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;
    /**
     * The default genus.
     */
    public static final String DEFAULT_GENUS = "Poecilia";
    /**
     * The default species.
     */
    public static final String DEFAULT_SPECIES = "reticulata";
    /**
     * The default health coefficient measures how healthy a guppy is.
     */
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;
    /**
     * The minimum health coefficient.
     */
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;
    /**
     * The maximum health coefficient.
     */
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;
    /**
     * A baby guppy's health coefficient must be divided by 2.0
     */
    public static final double BABY_HEALTH_COEFFICIENT_DIVISOR = 2.0;
    /**
     * The number of guppies born.
     */
    private static int numberOfGuppiesBorn;

    /**
     * Genus of this guppy.
     */
    private String genus;

    /**
     * Species of this guppy.
     */
    private String species;

    /**
     * Age in weeks of this guppy.
     */
    private int ageInWeeks;

    /**
     * Sex of this guppy, true if female.
     */
    private boolean isFemale;

    /**
     * Generation number of this guppy.
     */
    private int generationNumber;

    /**
     * Life status of this guppy, true if alive.
     */
    private boolean isAlive;

    /**
     * Health coefficient of this guppy.
     */
    private double healthCoefficient;

    /**
     * Identification number of this guppy.
     */
    private int identificationNumber;


    /**
     * Constructs a guppy object using the following default values.
     */
    public Guppy() {
        this.ageInWeeks = 0;
        this.generationNumber = 0;
        this.genus = DEFAULT_GENUS;
        this.species = DEFAULT_SPECIES;
        this.isFemale = true;
        this.isAlive = true;
        this.healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        numberOfGuppiesBorn += 1;
        this.identificationNumber = numberOfGuppiesBorn;
    }

    /**
     *Constructs a guppy object by defining its genus, species, age in weeks,
     * if it's female, generation number, and health coefficient.
     *
     * @param newGenus a String representing the Genus name
     * @param newSpecies a String representing the Species name
     * @param newAgeInWeeks an int representing the age in weeks
     * @param newIsFemale a boolean representing if the guppy is a female
     * @param newGenerationNumber an int representing the generation number
     * @param newHealthCoefficient a double representing the health coefficient
     */
    public Guppy(String newGenus, String newSpecies,
                 final int newAgeInWeeks, final boolean newIsFemale,
                 final int newGenerationNumber,
                 final double newHealthCoefficient) {
        if (newGenus == null || newGenus.trim().isEmpty()) {
            this.genus = DEFAULT_GENUS;
        } else {
            newGenus = newGenus.trim();
            this.genus = newGenus.substring(0, 1).toUpperCase()
                    + newGenus.substring(1).toLowerCase();
        }

        if (newSpecies == null || newSpecies.trim().isEmpty()) {
            this.species = DEFAULT_SPECIES;
        } else {
            newSpecies = newSpecies.trim();
            this.species = newSpecies.toLowerCase();
        }

        if (newAgeInWeeks < 0) {
            this.ageInWeeks = 0;
        } else {
            this.ageInWeeks = newAgeInWeeks;
        }

        this.isFemale = newIsFemale;

        if (newGenerationNumber < 0) {
            this.generationNumber = 1;
        } else {
            this.generationNumber = newGenerationNumber;
        }

        if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
        } else if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        } else {
            this.healthCoefficient = newHealthCoefficient;
        }

        this.isAlive = true;

        this.identificationNumber = numberOfGuppiesBorn;

        numberOfGuppiesBorn++;
    }

    /**
     * Increments the guppy's age in weeks by 1, and sets isAlive to false if
     * age in weeks exceeds the maximum age in weeks.
     */
    public void incrementAge() {
        this.ageInWeeks += 1;
        if (this.ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            this.isAlive = false;
        }
    }

    /**
     * Returns the genus as a String.
     *
     * @return genus as a String
     */
    public String getGenus() {
        return genus;
    }

    /**
     * Returns the species as a String.
     *
     * @return species as a String
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Returns the age in weeks as an int.
     *
     * @return ageInWeeks as an int
     */
    public int getAgeInWeeks() {
        return ageInWeeks;
    }

    /**
     * Returns true if the guppy is a female.
     *
     * @return isFemale as a boolean
     */
    public boolean getIsFemale() {
        return isFemale;
    }

    /**
     * Returns the generation number as an int.
     *
     * @return generationNumber as an int
     */
    public int getGenerationNumber() {
        return generationNumber;
    }

    /**
     * Returns true if the guppy is alive.
     *
     * @return isAlive as a boolean
     */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * Returns the health coefficient as a double.
     *
     * @return healthCoefficient as a double
     */
    public double getHealthCoefficient() {
        return healthCoefficient;
    }

    /**
     * Returns the identification number as an int.
     *
     * @return identificationNumber as an int
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Returns the number of guppies born as an int.
     *
     * @return numberOfGuppiesBorn as an int
     */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    /**
     * Returns the water volume needed in mL as a double.
     *
     * @return water volume needed in mL as a double.
     */
    public double getVolumeNeeded() {
        if (this.ageInWeeks < YOUNG_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (this.ageInWeeks <= MATURE_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * ageInWeeks
                    / YOUNG_FISH_AGE_IN_WEEKS;
        } else if (this.ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * 1.5;
        } else {
            return 0.0;
        }
    }

    /**
     * Sets the age in weeks.
     *
     * @param ageInWeeks an int representing the age in weeks
     */
    public void setAgeInWeeks(int ageInWeeks) {
        if (ageInWeeks >= 0 && ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = ageInWeeks;
        }
    }

    /**
     * Sets the life status.
     *
     * @param alive a boolean representing the life status
     */
    public void setIsAlive(boolean alive) {
        this.isAlive = alive;
    }

    /**
     * Sets the health coefficient.
     *
     * @param healthCoefficient a double representing the health coefficient
     */
    public void setHealthCoefficient(double healthCoefficient) {
        if (healthCoefficient >= MINIMUM_HEALTH_COEFFICIENT
                && healthCoefficient <= MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = healthCoefficient;
        }
    }

    /**
     * Changes the health coefficient by adding a positive or negative value.
     *
     * @param delta a double representing the change in health coefficient.
     */
    public void changeHealthCoefficient(double delta) {
        this.healthCoefficient += delta;
        if (this.healthCoefficient <= MINIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = 0.0;
            this.isAlive = false;
        }
        if (this.healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        }
    }

    public ArrayList<Guppy> spawn() {
        if (this.isFemale && this.ageInWeeks >= 8) {
            ArrayList<Guppy> babyGuppies = new ArrayList<>();
            Random rand = new Random();
            int haveBabiesChance = rand.nextInt(2);
            if (haveBabiesChance == 1) {
                int numberOfBabies = rand.nextInt(101);
                boolean isAFemale;
                for (int i = 0; i < numberOfBabies; i++) {
                    int isFemaleChance = rand.nextInt(2);
                    if (isFemaleChance == 1) {
                        isAFemale = true;
                    } else {
                        isAFemale = false;
                    }
                    Guppy baby = new Guppy(this.genus,
                            this.species,
                            BABY_FISH_AGE_IN_WEEKS,
                            isAFemale,
                            BABY_GUPPY_GENERATION
                                    + this.generationNumber,
                            (MAXIMUM_HEALTH_COEFFICIENT
                                    + this.healthCoefficient)
                                    / (BABY_HEALTH_COEFFICIENT_DIVISOR));
                    babyGuppies.add(baby);
                }
            }
            return babyGuppies;
        } else {
            return null;
        }
    }

    /**
     * Returns a string description of this guppy object.
     *
     * @return description a String
     */
    @Override
    public String toString() {
        return "Guppy{"
                + "genus='" + genus + '\''
                + ", species='" + species + '\''
                + ", ageInWeeks=" + ageInWeeks
                + ", isFemale=" + isFemale
                + ", generationNumber=" + generationNumber
                + ", isAlive=" + isAlive
                + ", healthCoefficient=" + healthCoefficient
                + ", identificationNumber=" + identificationNumber
                + '}';
    }

    /**
     * Compares if two guppy objects are equal.
     *
     * @param o an object representing a guppy
     * @return a boolean representing if two guppy objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Guppy)) {
            return false;
        }
        Guppy guppy = (Guppy) o;
        return ageInWeeks == guppy.ageInWeeks
                && isFemale == guppy.isFemale
                && generationNumber == guppy.generationNumber
                && isAlive == guppy.isAlive
                && Double.compare(
                        guppy.healthCoefficient, healthCoefficient) == 0
                && identificationNumber == guppy.identificationNumber
                && genus.equals(guppy.genus)
                && species.equals(guppy.species);
    }
}
