package ca.bcit.comp2522.assignments.A1;

import java.util.ArrayList;
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

    private static int numberOfPools = 0;

    private String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private int identificationNumber;
    private ArrayList<Guppy> guppiesInPool;
    private Random randomNumberGenerator;

    public Pool() {

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
    }


}
