package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * Pinwheel Block.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class Pinwheel extends Block {

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
        return pinwheel();
    }

    /**
     * Pinwheel design.
     *
     * @return the Pinwheel design.
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
     * 1/4 of a Pinwheel, but in a transparent Square.
     *
     * @return 1/4 of a Pinwheel, but in a transparent Square, as a Group.
     */
    private Group tileInBox() {
        Rectangle square = new Rectangle(0, 0, getSizeInPx(), getSizeInPx());
        square.setFill(Color.TRANSPARENT);
        return new Group(square, tile());
    }

    /**
     * 1/4 of a Pinwheel.
     *
     * @return 1/4 of a Pinwheel as a Group.
     */
    private Group tile() {
        Polygon triangle = new Polygon(0, 0,
                                        0, getSizeInPx() / 2,
                                        getSizeInPx() / 2,
                                        getSizeInPx() / 2);
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);

        triangle.fillProperty().bind(getColorProperty(0));
        triangle2.fillProperty().bind(getColorProperty(1));

        return new Group(triangle, triangle2);
    }
}
