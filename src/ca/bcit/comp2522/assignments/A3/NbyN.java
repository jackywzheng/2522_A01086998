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
public class NbyN extends Block implements Rotatable {

    // Default number of squares per line
    private static final int DEFAULT_NUMBER_OF_SQUARES_PER_LINE = 5;
    // Group
    private Group block;
    // Number of squares per line
    private int numberOfSquaresPerLine;

    /**
     * Constructs an n x n object.
     */
    public NbyN() {
        super();
        this.numberOfSquaresPerLine = DEFAULT_NUMBER_OF_SQUARES_PER_LINE;
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
     * Returns the number of square per line.
     *
     * @return numberOfSquaresPerLine as an int
     */
    public int getNumberOfSquaresPerLine() {
        return numberOfSquaresPerLine;
    }

    /**
     * Sets the number of squares per line.
     *
     * @param numberOfSquaresPerLine an int representing
     * the number of squares per line
     */
    public void setNumberOfSquaresPerLine(int numberOfSquaresPerLine) {
        this.numberOfSquaresPerLine = numberOfSquaresPerLine;
    }

    /**
     * Returns a Group that contains n x n rectangles and assigns
     * a random colour to each rectangle.
     *
     * @return group as a Group
     */
    private Group nByN() {
        Group group = new Group();
        for (double x = 0; x < getSizeInPx();
             x += ((double) getSizeInPx() / numberOfSquaresPerLine)) {
            for (double y = 0; y < getSizeInPx();
                 y += ((double) getSizeInPx() / numberOfSquaresPerLine)) {
                // Create a rectangle
                Rectangle rectangle = new Rectangle(x, y,
                        (double) getSizeInPx() / numberOfSquaresPerLine,
                        (double) getSizeInPx() / numberOfSquaresPerLine);
                System.out.println((double) getSizeInPx()
                        / numberOfSquaresPerLine);
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
