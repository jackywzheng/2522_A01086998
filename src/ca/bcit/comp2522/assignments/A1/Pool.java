package ca.bcit.comp2522.assignments.A1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Pool {
    public static final String DEFAULT_POOL_NAME = "Unnamed";
    public static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;
    public static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;
    public static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;
    public static final double NEUTRAL_PH = 7.0;
    public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;
    public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;
    public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;

    private static int numberOfPools;

    private String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private int identificationNumber;
    private ArrayList<Guppy> guppiesInPool;
    private Random randomNumberGenerator;

    public Pool() {
        this(DEFAULT_POOL_NAME, MINIMUM_NUTRIENT_COEFFICIENT,
                DEFAULT_POOL_TEMP_CELSIUS, NEUTRAL_PH,
                DEFAULT_NUTRIENT_COEFFICIENT);
    }

    public Pool(String newName, final double newVolumeLitres,
                final double newTemperatureCelsius, final double newPH,
                final double newNutrientCoefficient) {

        if (newName != null && newName.trim().length() > 0) {
            String firstLetter = newName.trim().toUpperCase().substring(0, 1);
            String theRest = newName.trim().toLowerCase().substring(1);
            name = firstLetter + theRest;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty!");
        }

        if (newVolumeLitres >= MINIMUM_POOL_TEMP_CELSIUS) {
            volumeLitres = newVolumeLitres;
        } else {
            volumeLitres = MINIMUM_POOL_TEMP_CELSIUS;
        }

        if (newTemperatureCelsius >= MINIMUM_POOL_TEMP_CELSIUS
                && newTemperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS) {
            temperatureCelsius = newTemperatureCelsius;
        } else {
            temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        }

        if (newPH >= (NEUTRAL_PH - NEUTRAL_PH)
                && newPH <= (NEUTRAL_PH + NEUTRAL_PH)) {
            pH = newPH;
        } else {
            pH = NEUTRAL_PH;
        }

        if (newNutrientCoefficient >= MINIMUM_NUTRIENT_COEFFICIENT
                && newNutrientCoefficient <= MAXIMUM_NUTRIENT_COEFFICIENT) {
            nutrientCoefficient = newNutrientCoefficient;
        } else {
            nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        }

        guppiesInPool = new ArrayList<>();

        randomNumberGenerator = new Random();

        identificationNumber = ++identificationNumber;

        numberOfPools++;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getVolumeLitres() {
        return volumeLitres;
    }

    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public double getpH() {
        return pH;
    }

    public double getNutrientCoefficient() {
        return nutrientCoefficient;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public static int getNumberCreated() {
        return numberOfPools;
    }

    public int getPopulation() {
        return guppiesInPool.size();
    }
    // Setters
    public void setVolumeLitres(double newVolumeLitres) {
        if (newVolumeLitres >= MINIMUM_POOL_TEMP_CELSIUS) {
            volumeLitres = newVolumeLitres;
        }
    }

    public void setTemperatureCelsius(double newTemperatureCelsius) {
        if (newTemperatureCelsius >= MINIMUM_POOL_TEMP_CELSIUS
                && newTemperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS) {
            temperatureCelsius = newTemperatureCelsius;
        }
    }

    public void setpH(double newpH) {
        if (newpH >= (NEUTRAL_PH - NEUTRAL_PH)
                && newpH <= (NEUTRAL_PH + NEUTRAL_PH)) {
            pH = newpH;
        }
    }

    public void setNutrientCoefficient(double newNutrientCoefficient) {
        if (newNutrientCoefficient >= MINIMUM_NUTRIENT_COEFFICIENT
                && newNutrientCoefficient <= MAXIMUM_NUTRIENT_COEFFICIENT) {
            nutrientCoefficient = newNutrientCoefficient;
        }
    }

    public void changeNutrientCoefficient(double delta) {
        double newNutrientCoefficient = this.nutrientCoefficient + delta;
        if (newNutrientCoefficient < MINIMUM_NUTRIENT_COEFFICIENT) {
            setNutrientCoefficient(MINIMUM_NUTRIENT_COEFFICIENT);
        } else if (newNutrientCoefficient > MAXIMUM_NUTRIENT_COEFFICIENT) {
            setNutrientCoefficient(MAXIMUM_NUTRIENT_COEFFICIENT);
        } else {
            setNutrientCoefficient(newNutrientCoefficient);
        }
    }

    public void changeTemperature(double delta) {
        double newTemperature = this.temperatureCelsius + delta;
        if (newTemperature < MINIMUM_POOL_TEMP_CELSIUS) {
            setTemperatureCelsius(MINIMUM_POOL_TEMP_CELSIUS);
        } else if (newTemperature > MAXIMUM_POOL_TEMP_CELSIUS) {
            setTemperatureCelsius(MAXIMUM_POOL_TEMP_CELSIUS);
        } else {
            setTemperatureCelsius(newTemperature);
        }
    }

    public boolean addGuppy(Guppy guppy) {
        if (guppy != null) {
            guppiesInPool.add(guppy);
            return true;
        }
        return false;
    }

    public int applyNutrientCoefficient() {
        int numberOfGuppyDeaths = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (randomNumberGenerator.nextDouble()
                    > nutrientCoefficient) {
                guppy.setIsAlive(false);
                numberOfGuppyDeaths++;
            }
        }
        return numberOfGuppyDeaths;
    }

    public int removeDeadGuppies() {
        int numberOfDeadGuppiesRemoved = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (!guppy.getIsAlive()) {
                it.remove();
                numberOfDeadGuppiesRemoved++;
            }
            }
        return numberOfDeadGuppiesRemoved;
        }

    public double getGuppyVolumeRequirementInLitres() {
        double volumeRequiredInMilliLitres = 0.0;
        int milliLitresToLitresConversion = 1000;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (guppy.getIsAlive()) {
                volumeRequiredInMilliLitres += guppy.getVolumeNeeded();
            }
        }
        return volumeRequiredInMilliLitres / milliLitresToLitresConversion;
    }

    public double getAverageAgeInWeeks() {
        int sumOfGuppyAges = 0;
        int numberOfLivingGuppies = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (guppy.getIsAlive()) {
                sumOfGuppyAges += guppy.getAgeInWeeks();
                numberOfLivingGuppies++;
            }
        }
        return (double) sumOfGuppyAges / (double) numberOfLivingGuppies;
    }

    public double getAverageHealthCoefficient() {
        double sumOfGuppyHealthCoefficients = 0;
        int numberOfLivingGuppies = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (guppy.getIsAlive()) {
                sumOfGuppyHealthCoefficients += guppy.getHealthCoefficient();
                numberOfLivingGuppies++;
            }
        }
        return sumOfGuppyHealthCoefficients / (double) numberOfLivingGuppies;
    }

    public double getFemalePercentage() {
        int numberOfFemales = 0;
        int numberOfLivingGuppies = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (guppy.getIsAlive()) {
                numberOfLivingGuppies++;
            }
            if (guppy.getIsFemale()) {
                numberOfFemales++;
            }
        }
        return (double) numberOfFemales / (double) numberOfLivingGuppies;
    }

    public void printDetails() {
        System.out.println(name + " Pond information:");
        System.out.println(volumeLitres + " Litres");
        System.out.println(temperatureCelsius + " Degrees Celsius");
        System.out.println(pH + " pH");
        System.out.println(nutrientCoefficient + " Nutrient Coefficient");
        System.out.println(identificationNumber + " ID Number");
        System.out.println(guppiesInPool.size() + " Guppies in the pool");
    }

    public double getMedianAge() {
        // First get the number of living guppies by looping through
        int numberOfLivingGuppies = 0;
        double median;
        int counter = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            it.next();
            numberOfLivingGuppies++;
        }
        // Reset the iterator, create an array the same size as the
        // number of living guppies, and populate it with their ages
        it = guppiesInPool.iterator();
        double[] doubleArray = new double[numberOfLivingGuppies];
        while (it.hasNext()) {
            Guppy guppy = it.next();
            doubleArray[counter] = guppy.getAgeInWeeks();
            counter++;
        }
        // Sort the array
        Arrays.sort(doubleArray);
        // If length of array is even, median is avg of the two middle elements
        if (doubleArray.length % 2 == 0) {
            double sumOfMiddleElements = doubleArray[doubleArray.length / 2]
                    + doubleArray[doubleArray.length / 2 - 1];
            median = sumOfMiddleElements / 2.0;
        // Else it's the middle element
        } else {
            median = doubleArray[doubleArray.length / 2];
        }
        return median;
    }

    @Override
    public String toString() {
        return "Pool{" +
                "name='" + name + '\'' +
                ", volumeLitres=" + volumeLitres +
                ", temperatureCelsius=" + temperatureCelsius +
                ", pH=" + pH +
                ", nutrientCoefficient=" + nutrientCoefficient +
                ", identificationNumber=" + identificationNumber +
                ", guppiesInPool=" + guppiesInPool +
                '}';
    }

    public int spawn() {
        int guppiesAdded = 0;
        ArrayList<Guppy> newBabies = new ArrayList<>();
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (guppy.getIsAlive()) {
                ArrayList<Guppy> newFry = guppy.spawn();
                if (newFry != null) {
                    guppiesAdded += newFry.size();
                    newBabies.addAll(newFry);
                }
            }
        }
        guppiesInPool.addAll(newBabies);
        return guppiesAdded;
    }

    public int incrementAges() {
        int numberOfGuppiesDiedOfOldAge = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            guppy.incrementAge();
            boolean isAlive = guppy.getIsAlive();
            if (!isAlive) {
                numberOfGuppiesDiedOfOldAge++;
            }
        }
        return numberOfGuppiesDiedOfOldAge;
    }

    public int adjustForCrowding() {
        int numberOfGuppiesDiedOfCrowding = 0;
        double guppyVolumeRequirement = getGuppyVolumeRequirementInLitres();
        while (guppyVolumeRequirement > volumeLitres) {
            Iterator<Guppy> it = guppiesInPool.iterator();
            Guppy weakestGuppy = null;
            double lowestHealthCoefficient = 1.0;
            while (it.hasNext()) {
                Guppy guppy = it.next();
                if (guppy.getIsAlive() &&
                        (guppy.getHealthCoefficient() <
                                lowestHealthCoefficient)) {
                    weakestGuppy = guppy;
                    lowestHealthCoefficient = guppy.getHealthCoefficient();
                }
            }
            if (weakestGuppy != null) {
                weakestGuppy.setIsAlive(false);
                numberOfGuppiesDiedOfCrowding++;
            }
            guppyVolumeRequirement = getGuppyVolumeRequirementInLitres();
        }
        return numberOfGuppiesDiedOfCrowding;
    }

}
