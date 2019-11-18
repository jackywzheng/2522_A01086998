package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * n x n Block.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class NbyN extends Block {

    /**
     * Square root of number of squares in a n by n block.
     */
    private static final int NUMBER_OF_SQUARES_PER_LINE = 10;

    /**
     * The block as a group.
     */
    private Group block;

    /**
     * Constructs an n x n object.
     */
    public NbyN() {
        super();
        this.block = nByN();
    }

    /**
     * Returns the block as a Group.
     */
    @Override
    public Group getBlock() {
        return block;
    }

    /**
     * Returns new block as a Group.
     *
     * @return block, a Group
     */
    @Override
    public Group getNewBlock() {
        return nByN();
    }

    /**
     * Returns a Group that contains n x n rectangles and assigns
     * a random colour to each rectangle.
     *
     * @return group, a Group
     */
    private Group nByN() {
        Group group = new Group();
        for (int x = 0; x < getSizeInPx();
             x += (getSizeInPx() / NUMBER_OF_SQUARES_PER_LINE)) {
            for (int y = 0; y < getSizeInPx();
                 y += (getSizeInPx() / NUMBER_OF_SQUARES_PER_LINE)) {
                // Create a rectangle
                Rectangle rectangle = new Rectangle(x, y,
                        (double) getSizeInPx() / NUMBER_OF_SQUARES_PER_LINE,
                        (double) getSizeInPx() / NUMBER_OF_SQUARES_PER_LINE);
                // Randomly assign a color
                rectangle.setFill(assignRandomColor());
                // Add it to the group
                group.getChildren().add(rectangle);
            }
        }
        return group;
    }

    /**
     * Returns a random colour.
     *
     * @return Color.color(Math.random(), Math.random(), Math.random())
     */
    private Color assignRandomColor() {
        return Color.color(Math.random(), Math.random(), Math.random());
    }
}
