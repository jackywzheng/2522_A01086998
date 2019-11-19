package ca.bcit.comp2522.assignments.A3;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

/**
 * Block.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class Block {
    /**
     * A 90 degree clockwise rotation.
     */
    public static final int QUARTER_CLOCKWISE_ROTATION = 90;
    /**
     * A 360 degree rotation.
     */
    public static final int FULL_ROTATION = 360;

    // Size in pixels
    private static double sizeInPx;
    // ArrayList of Color properties
    private ArrayList<SimpleObjectProperty<Color>> colors;
    // Group
    private Group block;

    /**
     * Constructs a block object and add default colors.
     */
    public Block() {
        colors = new ArrayList<>();
        colors.add(new SimpleObjectProperty<>(Color.WHITE));
        colors.add(new SimpleObjectProperty<>(Color.BLACK));
        colors.add(new SimpleObjectProperty<>(Color.DARKGRAY));
        colors.add(new SimpleObjectProperty<>(Color.LIGHTGRAY));
        this.block = genericBlock();
    }

    /**
     * Returns the block as a Group.
     *
     * @return block as a Group
     */
    public Group getBlock() {
        return block;
    }

    /**
     * Returns a new block as a Group.
     *
     * @return block as a Group
     */
    public Group getNewBlock() {
        return genericBlock();
    }

    /**
     * Returns a transparent black rectangle.
     *
     * @return new Group(square)
     */
    private Group genericBlock() {
        Rectangle square = new Rectangle(0, 0, getSizeInPx(), getSizeInPx());
        square.setStroke(Color.BLACK);
        square.setFill(Color.WHITESMOKE);
        return new Group(square);
    }

    /**
     * Returns the size in pixels.
     *
     * @return sizeInCm as an int
     */
    static double getSizeInPx() {
        return sizeInPx;
    }

    /**
     * Sets the size in pixels.
     *
     * @param newSizeInPx a double representing the size in pixels
     */
    static void setSizeInPx(double newSizeInPx) {
        sizeInPx = newSizeInPx;
    }

    /**
     * Returns the color property.
     *
     * @param index of color property
     *
     * @return a color property.
     */
    SimpleObjectProperty<Color> getColorProperty(int index) {
        return colors.get(index);
    }
}
