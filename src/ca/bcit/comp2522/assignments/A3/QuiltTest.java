package ca.bcit.comp2522.assignments.A3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

/**
 * Block Tests.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class QuiltTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void defaultNumberOfRowsIsZero() {
        assertEquals(0, Quilt.getNumberOfRows());
    }

    @Test
    public void defaultNumberOfColumnsIsZero() {
        assertEquals(0, Quilt.getNumberOfColumns());
    }

    @Test
    public void defaultBlockSizeInPixelsIs0() {
        assertEquals(0, Quilt.getBlockSizeInPixels());
    }

    @Test
    public void setBlockSizeInCentimetresCorrectlySets() {
        Quilt.setBlockSizeInCentimetres(10);
        assertEquals(10, Quilt.getBlockSizeInCentimetres());
    }

    @Test
    public void setNumberOfRowsCorrectlySets() {
        Quilt.setNumberOfRows(10);
        assertEquals(10, Quilt.getNumberOfRows());
    }

    @Test
    public void setNumberOfColumnsCorrectlySets() {
        Quilt.setNumberOfColumns(10);
        assertEquals(10, Quilt.getNumberOfColumns());
    }
}
