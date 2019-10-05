package ca.bcit.comp2522.assignments.A1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.w3c.dom.ls.LSOutput;

import static org.junit.Assert.*;

public class EcosystemTest {

    private Ecosystem defaultEcosystem;
    private Ecosystem testEcosystem;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {

        defaultEcosystem = new Ecosystem();
        testEcosystem = new Ecosystem();
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
    public void setupSimulation() {

    }

}
