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
public class BlockTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void containsStaticConstantCalledQUARTER_CLOCKWISE_ROTATION() {
        assertEquals(90, Block.QUARTER_CLOCKWISE_ROTATION);
    }

    @Test
    public void containsStaticConstantCalledFULL_ROTATION() {
        assertEquals(360, Block.FULL_ROTATION);
    }

    @Test
    public void setSizeAndGetSizeInCmWorks() {
        Block.setSizeInCm(10);
        assertEquals(10, Block.getSizeInCm());
    }
}