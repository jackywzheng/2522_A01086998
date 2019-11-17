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
     * The block as a group.
     */
    private Group block;

    /**
     * Constructs an n x n object.
     */
    public NbyN() {
        super();
        this.block = NbyN();
    }

    /**
     * Returns block as a Group.
     *
     * @return block, a Group
     */
    @Override
    public Group getBlock() {
        return block;
    }

    /**
     * Returns a Group that contains n x n rectangles and assigns
     * a random colour to each rectangle.
     *
     * @return group, a Group
     */
    private Group NbyN() {
        Group group = new Group();
        for (int x = 0; x < getSizeInCm(); x += (getSizeInCm() / 10)) {
            for (int y = 0; y < getSizeInCm(); y += (getSizeInCm() / 10)) {
                // Create a rectangle
                Rectangle rectangle = new Rectangle(x, y,
                        (double) getSizeInCm() / 10,
                        (double) getSizeInCm() / 10);
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
    public Color assignRandomColor() {
        return Color.color(Math.random(), Math.random(), Math.random());
    }
}
