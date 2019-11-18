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
    /**
     * The block as a group.
     */
    private Group block;

    /**
     * Constructs a pinwheel object.
     */
    public Pinwheel() {
        super();
        this.block = pinwheel();
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
     * ???
     *
     * @return
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
     * ???
     *
     * @return
     */
    private Group tileInBox() {
        Rectangle square = new Rectangle(0, 0, getSizeInCm(), getSizeInCm());
        square.setFill(Color.TRANSPARENT);
        return new Group(square, tile());
    }

    /**
     * ???
     *
     * @return
     */
    private Group tile() {
        Polygon triangle = new Polygon(0, 0,
                                        0, (double) getSizeInCm() / 2,
                                        (double) getSizeInCm() / 2,
                                        (double) getSizeInCm() / 2);
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);

        triangle.fillProperty().bind(getColorProperty(0));
        triangle2.fillProperty().bind(getColorProperty(1));

        return new Group(triangle, triangle2);
    }
}
