package ca.bcit.comp2522.assignments.A1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EcosystemTest {

    private Ecosystem defaultEcosystem;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {
        defaultEcosystem = new Ecosystem();
    }

    @Test
    public void ecosystemContainsAnEmptyArrayListOnInstantiation() {
        assertEquals(defaultEcosystem.getNumberOfPools(), 0);
    }

    @Test
    public void addDefaultPool() {
        Pool testPool = new Pool();
        defaultEcosystem.addPool(testPool);
        assertEquals("Ecosystem{pools=[Pool{name='Unnamed', volumeLitres=0.0, temperatureCelsius=40.0, pH=7.0,"
                + " nutrientCoefficient=0.5, identificationNumber=1, guppiesInPool=[]}]}",
        defaultEcosystem.toString());
    }

    @Test
    public void ecosystemIsReset() {
        defaultEcosystem.reset();
        assertEquals("Ecosystem{pools=[]}", defaultEcosystem.toString());
    }

    @Test
    public void setupSimulationAddsThreePools() {
        defaultEcosystem.setupSimulation();
        assertEquals(3, defaultEcosystem.getNumberOfPools());
    }

    @Test
    public void sixHundredGuppiesTotalAtStartOfSimulation() {
        defaultEcosystem.setupSimulation();
        assertEquals(600, defaultEcosystem.getGuppyPopulation());
    }
}
