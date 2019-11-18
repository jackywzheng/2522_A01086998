package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.shape.Polygon;

/**
 * Hourglass Block.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class Hourglass extends Block {

    private Group block;

    /**
     * Constructs an hourglass object.
     */
    public Hourglass() {
        super();
        this.block = hourglass();
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
        return hourglass();
    }

    /**
     * The hourglass design.
     *
     * @return a Group that has the hourglass design
     */
    private Group hourglass() {
        Group outerBlock = hourglassComponent();
        Group innerBlock = hourglassComponent();
        innerBlock.setScaleX(1 / (Math.pow(2, (double) 1 / 2)));
        innerBlock.setScaleY(1 / (Math.pow(2, (double) 1 / 2)));
        innerBlock.setRotate((double) QUARTER_CLOCKWISE_ROTATION / 2);
        return new Group(outerBlock, innerBlock);
    }

    /**
     * Hourglass layer.
     *
     * @return hourglass layer
     */
    private Group hourglassComponent() {
        Group tl = quadrant1();
        tl.setRotate(QUARTER_CLOCKWISE_ROTATION);
        Group br = quadrant1();
        br.setRotate(QUARTER_CLOCKWISE_ROTATION);
        br.setTranslateX((double) getSizeInPx() / 2);
        br.setTranslateY((double) getSizeInPx() / 2);
        Group tr = quadrant2();
        tr.setTranslateX((double) getSizeInPx() / 2);
        Group bl = quadrant2();
        bl.setTranslateY((double) getSizeInPx() / 2);
        bl.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);
        return new Group(tr, tl, br, bl);
    }

    /**
     * Hourglass first quadrant.
     *
     * @return Hourglass first quadrant.
     */
    private Group quadrant1() {
        Polygon triangle = triangle();
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);

        triangle.fillProperty().bind(getColorProperty(0));
        triangle2.fillProperty().bind(getColorProperty(0));
        return new Group(triangle, triangle2);
    }

    /**
     * Hourglass second quadrant.
     *
     * @return Hourglass second quadrant.
     */
    private Group quadrant2() {
        Polygon triangle = triangle();
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);

        triangle.fillProperty().bind(getColorProperty(1));
        triangle2.fillProperty().bind(getColorProperty(2));
        return new Group(triangle, triangle2);
    }

    /**
     * a triangle to be used in an hourglass quadrant.
     *
     * @return a triangle to be used in an hourglass quadrant
     */
    private Polygon triangle() {
        return new Polygon(0, (double) getSizeInPx() / 2,
                (double) getSizeInPx() / 2,
                (double) getSizeInPx() / 2,
                0, 0);
    }
}
