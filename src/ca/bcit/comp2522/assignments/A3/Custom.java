package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * Custom block design that Trung and Jacky made.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class Custom extends Block implements Rotatable {

    private Group block;

    /**
     * Constructs a custom object.
     */
    public Custom() {
        super();
        this.block = custom();
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
        return custom();
    }
    /**
     * ???
     * @return
     */
    Group custom() {
        Group outerBlock = customComponent();
        Group innerBlock = customComponent();
        innerBlock.setScaleX(1 / (Math.pow(2, (double) 1 / 2)));
        innerBlock.setScaleY(1 / (Math.pow(2, (double) 1 / 2)));
        innerBlock.setRotate((double) QUARTER_CLOCKWISE_ROTATION / 2);
        Group last = new Group(outerBlock, innerBlock);
        last.setScaleX(2.0/3.0);
        last.setScaleY(2.0/3.0);
        return last;
    }

    /**
     * ???
     * @return
     */
    Group customComponent() {
        Rectangle background = new Rectangle((double) getSizeInPx() * 1.5,
                (double) getSizeInPx() * 1.5);
        background.fillProperty().bind(getColorProperty(3));
        Group tl = quadrant1();
        tl.setRotate(QUARTER_CLOCKWISE_ROTATION);
        Group br = quadrant1();
        br.setRotate(QUARTER_CLOCKWISE_ROTATION);
        br.setTranslateX(getSizeInPx());
        br.setTranslateY(getSizeInPx());
        Group tr = quadrant2();
        tr.setTranslateX(getSizeInPx());
        Group bl = quadrant2();
        bl.setTranslateY(getSizeInPx());
        bl.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);
        return new Group(background, tr, tl, br, bl);
    }

    /**
     * ???
     * @return
     */
    private Group quadrant1() {
        Polygon triangle = triangle();
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle.fillProperty().bind(getColorProperty(0));
        triangle2.fillProperty().bind(getColorProperty(0));
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);
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
        triangle.fillProperty().bind(getColorProperty(1));
        triangle2.fillProperty().bind(getColorProperty(2));
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);
        return new Group(triangle, triangle2);
    }

    /**
     * ???
     *
     * @return
     */
    private Polygon triangle() {
        return new Polygon(0, (double) getSizeInPx() / 2,
                (double) getSizeInPx() / 2,
                (double) getSizeInPx() / 2,
                0, 0);
    }
}