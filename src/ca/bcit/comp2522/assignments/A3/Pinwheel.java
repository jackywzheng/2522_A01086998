package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

/**
 * Pinwheel Block.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class Pinwheel extends Block {
    // Pinwheel contains a Group
    private Group block;

    /**
     * Constructs a pinwheel object.
     */
    public Pinwheel() {
        super();
        this.block = pinwheel();
    }

    /**
     * Returns the block as a Group.
     *
     * @return block as a Group
     */
    @Override
    public Group getBlock() {
        return block;
    }

    /**
     * Returns new block as a Group.
     *
     * @return block as a Group
     */
    @Override
    public Group getNewBlock() {
        return pinwheel();
    }

    /**
     * Returns the Pinwheel design.
     *
     * @return the Pinwheel design as a Group
     */
    private Group pinwheel() {
        Group theBlock = new Group();
        for (int i = 0; i * QUARTER_CLOCKWISE_ROTATION < FULL_ROTATION; i++) {
            Group tile = tileInBox();
            tile.setRotate(QUARTER_CLOCKWISE_ROTATION * i);
            theBlock.getChildren().add(tile);
        }
        return theBlock;
    }

    /**
     * Returns 1/4 of a Pinwheel, but in a transparent Square.
     *
     * @return 1/4 of a Pinwheel in a transparent Square as a Group.
     */
    private Group tileInBox() {
        Rectangle square = new Rectangle(0, 0, getSizeInPx(), getSizeInPx());
        square.setFill(Color.TRANSPARENT);
        return new Group(square, tile());
    }

    /**
     * Returns 1/4 of a Pinwheel.
     *
     * @return 1/4 of a Pinwheel as a Group.
     */
    private Group tile() {
        Polygon triangle = new Polygon(0, 0, 0, getSizeInPx() / 2,
                                        getSizeInPx() / 2, getSizeInPx() / 2);
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);
        triangle.fillProperty().bind(getColorProperty(0));
        triangle2.fillProperty().bind(getColorProperty(1));
        return new Group(triangle, triangle2);
    }

    /**
     * Returns a string representation of the block.
     *
     * @return a string representation of the block.
     */
    @Override
    public String toString() {
        return "Pinwheel{"
                + "block=" + block
                + '}';
    }

    /**
     * Returns true if two objects are equal.
     *
     * @param o an object
     *
     * @return true if two objects are equal, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pinwheel pinwheel = (Pinwheel) o;
        return Objects.equals(getBlock(), pinwheel.getBlock());
    }

    /**
     * Returns the hashcode of the object.
     *
     * @return hashcode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getBlock());
    }
}
