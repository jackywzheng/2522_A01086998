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


    private static int sizeInPx;
    private ArrayList<SimpleObjectProperty<Color>> colors;
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
     * @return block, a Group
     */
    public Group getBlock() {
        return block;
    }

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
    public static double getSizeInPx() {
        return (double) sizeInPx;
    }

    /**
     * Sets the size in pixels.
     *
     * @param newSizeInCm an int
     */
    public static void setSizeInPx(int newSizeInPx) {
        sizeInPx = newSizeInPx;
    }

    /**
     * Returns the color property.
     *
     * @param i index of color property
     *
     * @return a color property.
     */
    public SimpleObjectProperty<Color> getColorProperty(int i) {
        return colors.get(i);
    }
}
