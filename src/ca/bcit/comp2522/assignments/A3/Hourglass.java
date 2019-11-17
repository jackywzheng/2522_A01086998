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
    /**
     * The block as a group.
     */
    private Group block;

    /**
     * Constructs an hourglass object.
     */
    public Hourglass() {
        super();
        this.block = hourglass();
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
    private Group hourglass() {
        Group outerBlock = hourglassComponent();
        Group innerBlock = hourglassComponent();
        innerBlock.setScaleX(1 / (Math.pow(2, (double) 1 / 2)));
        innerBlock.setScaleY(1 / (Math.pow(2, (double) 1 / 2)));
        innerBlock.setRotate((double) QUARTER_CLOCKWISE_ROTATION / 2);
        return new Group(outerBlock, innerBlock);
    }

    /**
     * ???
     *
     * @return
     */
    private Group hourglassComponent() {
        Group tl = quadrant1();
        tl.setRotate(QUARTER_CLOCKWISE_ROTATION);
        Group br = quadrant1();
        br.setRotate(QUARTER_CLOCKWISE_ROTATION);
        br.setTranslateX((double) getSizeInCm() / 2);
        br.setTranslateY((double) getSizeInCm() / 2);
        Group tr = quadrant2();
        tr.setTranslateX((double) getSizeInCm() / 2);
        Group bl = quadrant2();
        bl.setTranslateY((double) getSizeInCm() / 2);
        bl.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);
        return new Group(tr, tl, br, bl);
    }

    /**
     * ???
     *
     * @return
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
     * ???
     *
     * @return
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
     * ???
     *
     * @return
     */
    private Polygon triangle() {
        return new Polygon(0, (double) getSizeInCm() / 2,
                (double) getSizeInCm() / 2,
                (double) getSizeInCm() / 2,
                0, 0);
    }
}
