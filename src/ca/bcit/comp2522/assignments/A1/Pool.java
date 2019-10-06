package ca.bcit.comp2522.assignments.A1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * Pool.
 *
 * @author Jacky Zheng
 * @version 1.0
 */
public class Pool {
    /**
     * Default pool name.
     */
    public static final String DEFAULT_POOL_NAME = "Unnamed";

    /**
     * Default pool temperature in Celsius,
     */
    public static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;

    /**
     * Minimum pool temperature in Celsius.
     */
    public static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;

    /**
     * Maximum pool temperature in Celsius.
     */
    public static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;

    /**
     * Neutral pH.
     */
    public static final double NEUTRAL_PH = 7.0;

    /**
     * Default nutrient coefficient.
     */
    public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;

    /**
     * Minimum nutrient coefficient.
     */
    public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;

    /**
     * Maximum nutrient coefficient.
     */
    public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;

    /**
     * Conversion between millilitre and litre.
     */
    public static final int MILLILITRE_TO_LITRE_CONVERSION = 1000;

    // Tracks number of Pools created during program lifetime.
    private static int numberOfPools;

    private String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private int identificationNumber;
    private ArrayList<Guppy> guppiesInPool;
    private Random randomNumberGenerator;


    /**
     * Zero-parameter constructor for objects of class Pool.
     */
    public Pool() {
        this(DEFAULT_POOL_NAME, MINIMUM_NUTRIENT_COEFFICIENT,
                DEFAULT_POOL_TEMP_CELSIUS, NEUTRAL_PH,
                DEFAULT_NUTRIENT_COEFFICIENT);
    }

    /**
     * Multi-parameter constructor for objects of class Pool. Invalid arguments
     * will generate IllegalArgumentExceptions.
     *
     * @param newName cannot be null, empty, or whitespace
     * @param newVolumeLitres must be greater than 0
     * @param newTemperatureCelsius must be between MINIMUM_POOL_TEMP_CELSIUS
     *                              and MAXIMUM_POOL_TEMP_CELSIUS
     * @param newPH must be greater or equal to 0 and less than or equal to 14
     * @param newNutrientCoefficient must be between MINIMUM_NUTRIENT_COEFFICIENT
     *                               and MAXIMUM_NUTRIENT_COEFFICIENT
     */
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

        identificationNumber = ++numberOfPools;
    }

    /**
     * Returns name.
     *
     * @return name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns volumeLitres.
     *
     * @return volumeLitres as a double
     */
    public double getVolumeLitres() {
        return volumeLitres;
    }

    /**
     * Returns temperatureCelsius
     *
     * @return temperatureCelsius as a double
     */
    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    /**
     * Returns pH.
     *
     * @return pH as a double
     */
    public double getPH() {
        return pH;
    }

    /**
     * Returns nutrientCoefficient.
     *
     * @return nutrientCoefficient as a double
     */
    public double getNutrientCoefficient() {
        return nutrientCoefficient;
    }

    /**
     * Returns identificationNumber.
     *
     * @return identificationNumber as an int
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Returns numberOfPools.
     *
     * @return numberOfPools as an int
     */
    public static int getNumberCreated() {
        return numberOfPools;
    }

    /**
     * Returns the population of guppies in the pool.
     *
     * @return guppiesInPool.size() as an int
     */
    public int getPopulation() {
        return guppiesInPool.size();
    }

    /**
     * Sets the volume. Ignores values < MINIMUM_POOL_TEMP_CELSIUS(0).
     *
     * @param newVolumeLitres a double
     */
    public void setVolumeLitres(double newVolumeLitres) {
        if (newVolumeLitres >= MINIMUM_POOL_TEMP_CELSIUS) {
            volumeLitres = newVolumeLitres;
        }
    }

    /**
     * Sets the temperature. Ignores values < MINIMUM_POOL_TEMP_CELSIUS and
     * ignores values > MAXIMUM_POOL_TEMP_CELSIUS.
     *
     * @param newTemperatureCelsius a double
     */
    public void setTemperatureCelsius(double newTemperatureCelsius) {
        if (newTemperatureCelsius >= MINIMUM_POOL_TEMP_CELSIUS
                && newTemperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS) {
            temperatureCelsius = newTemperatureCelsius;
        }
    }

    /**
     * Sets the pH. Ignores values < 0 and values > 14.
     *
     * @param newpH a double
     */
    public void setpH(double newpH) {
        if (newpH >= (NEUTRAL_PH - NEUTRAL_PH)
                && newpH <= (NEUTRAL_PH + NEUTRAL_PH)) {
            pH = newpH;
        }
    }

    /**
     * Sets the nutirent coefficient. Ignores values < MINIMUM_NUTRIENT_COEFFICIENT
     * and values > MAXIMUM_NUTRIENT_COEFFICIENT,
     *
     * @param newNutrientCoefficient a double
     */
    public void setNutrientCoefficient(double newNutrientCoefficient) {
        if (newNutrientCoefficient >= MINIMUM_NUTRIENT_COEFFICIENT
                && newNutrientCoefficient <= MAXIMUM_NUTRIENT_COEFFICIENT) {
            nutrientCoefficient = newNutrientCoefficient;
        }
    }

    /**
     * Changes the nutrient coefficient by the specified delta. The nutrient
     * coefficient cannot exceed the bounds [0.0, 1.0].
     *
     * @param delta a double
     */
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


    /**
     * Changes the temperature by the specified delta. The temperature cannot
     * exceed the bounds [MINIMUM_POOL_TEMP_CELSIUS, MAXIMUM_POOL_TEMP_CELSIUS].
     *
     * @param delta a double
     */
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

    /**
     * Adds a Guppy object to the pool.
     *
     * @param guppy a Guppy that is not null
     *
     * @return true if added successfully, else false as a boolean
     */
    public boolean addGuppy(Guppy guppy) {
        if (guppy != null) {
            guppiesInPool.add(guppy);
            return true;
        }
        return false;
    }

    /**
     * Calculates which Guppies in the Pool have died of malnutrition this week.
     *
     * @return numberOfGuppyDeaths as an int
     */
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

    /**
     * Removes dead Guppies from the pool.
     *
     * @return numberOfDeadGuppiesRemoved as an int
     */
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

    /**
     * Returns the volume required in Litres for the Guppies in the Pool.
     *
     * @return volume required in Litres as a double
     */
    public double getGuppyVolumeRequirementInLitres() {
        double volumeRequiredInMilliLitres = 0.0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            Guppy guppy = it.next();
            if (guppy.getIsAlive()) {
                volumeRequiredInMilliLitres += guppy.getVolumeNeeded();
            }
        }
        return volumeRequiredInMilliLitres
                / (double) MILLILITRE_TO_LITRE_CONVERSION;
    }

    /**
     * Returns the average age in weeks of the Guppies in the Pool.
     *
     * @return average age in weeks as a double
     */
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
        if (numberOfLivingGuppies == 0) {
            return 0;
        }
        return (double) sumOfGuppyAges / (double) numberOfLivingGuppies;
    }

    /**
     * Returns the average health coefficient of the Guppies in the Pool.
     *
     * @return average health coefficient as a double
     */
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
        if (numberOfLivingGuppies == 0) {
            return 0;
        }
        return sumOfGuppyHealthCoefficients / (double) numberOfLivingGuppies;
    }

    /**
     * Returns the percentage of female Guppies in the Pool.
     *
     * @return percentage of female Guppies as a double
     */
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
        if (numberOfLivingGuppies == 0) {
            return 0;
        }
        return (double) numberOfFemales / (double) numberOfLivingGuppies;
    }

    /**
     * Prints the pool's information in an informative way.
     */
    public void printDetails() {
        System.out.println(name + " Pond information:");
        System.out.println(volumeLitres + " Litres");
        System.out.println(temperatureCelsius + " Degrees Celsius");
        System.out.println(pH + " pH");
        System.out.println(nutrientCoefficient + " Nutrient Coefficient");
        System.out.println(identificationNumber + " ID Number");
        System.out.println(guppiesInPool.size() + " Guppies in the pool");
    }

    /**
     * Returns the median age of the Guppies in the Pool.
     *
     * @return medianAge as a double
     */
    public double getMedianAge() {
        // First get the number of living guppies by looping through
        int numberOfLivingGuppies = 0;
        double medianAge;
        int counter = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();
        while (it.hasNext()) {
            it.next();
            numberOfLivingGuppies++;
        }
        if (numberOfLivingGuppies == 0) {
            return 0;
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
            medianAge = sumOfMiddleElements / 2.0;
        // Else it's the middle element
        } else {
            medianAge = doubleArray[doubleArray.length / 2];
        }
        return medianAge;
    }

    /**
     * Returns a String representation of this Pool.
     *
     * @return toString a String representation
     */
    @Override
    public String toString() {
        return "Pool{"
                + "name='" + name + '\''
                + ", volumeLitres=" + volumeLitres
                + ", temperatureCelsius=" + temperatureCelsius
                + ", pH=" + pH
                + ", nutrientCoefficient=" + nutrientCoefficient
                + ", identificationNumber=" + identificationNumber
                + ", guppiesInPool=" + guppiesInPool + '}';
    }

    /**
     * Calls the Guppy spawn() method on all of the Guppies in the Pool and
     * returns the number of fry spawned.
     *
     * @return guppiesAdded as an int
     */
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

    /**
     * Calls the Guppy incrementAge() method on all of the Guppies in the Pool
     * and returns the number of Guppies that died of old age.
     *
     * @return numberOfGuppiesDiedOfOldAge as an int
     */
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

    /**
     * Extinguishes the Guppies that have suffocated due to overcrowding if the
     * total volume needed by the Guppies exceeds the volume of the Pool, and
     * returns the number of Guppies that died of overcrowding.
     *
      * @return numberOfGuppiesDiedOfCrowding as an int
     */
    public int adjustForCrowding() {
        int numberOfGuppiesDiedOfCrowding = 0;
        double guppyVolumeRequirement = getGuppyVolumeRequirementInLitres();
        while (guppyVolumeRequirement > volumeLitres) {
            Iterator<Guppy> it = guppiesInPool.iterator();
            Guppy weakestGuppy = null;
            double lowestHealthCoefficient = 1.0;
            while (it.hasNext()) {
                Guppy guppy = it.next();
                if (guppy.getIsAlive()
                        && (guppy.getHealthCoefficient()
                        < lowestHealthCoefficient)) {
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
