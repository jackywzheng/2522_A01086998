package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.shape.Polygon;

import java.util.Objects;

/**
 * Hourglass Block.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class Hourglass extends Block implements Rotatable {

    private Group block;
    private double rotation;

    /**
     * Constructs an hourglass object.
     */
    public Hourglass() {
        super();
        this.block = hourglass();
    }

    /**
     * Returns the block as a Group.
     *
     * @return block as a Group.
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
        Group newBlock = hourglass();
        newBlock.setRotate(rotation);
        return newBlock;
    }

    /**
     * Returns the hourglass design.
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
     * Returns an Hourglass layer.
     *
     * @return hourglass layer as a Group
     */
    private Group hourglassComponent() {
        Group tl = quadrant1();
        tl.setRotate(QUARTER_CLOCKWISE_ROTATION);
        Group br = quadrant1();
        br.setRotate(QUARTER_CLOCKWISE_ROTATION);
        br.setTranslateX(getSizeInPx() / 2);
        br.setTranslateY(getSizeInPx() / 2);
        Group tr = quadrant2();
        tr.setTranslateX(getSizeInPx() / 2);
        Group bl = quadrant2();
        bl.setTranslateY(getSizeInPx() / 2);
        bl.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);
        return new Group(tr, tl, br, bl);
    }

    /**
     * Returns the hourglass first quadrant.
     *
     * @return Hourglass first quadrant as a Group
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
     * Returns the hourglass second quadrant.
     *
     * @return Hourglass second quadrant as a Group
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
     * Returns a triangle to be used in an hourglass quadrant.
     *
     * @return a triangle to be used in an hourglass quadrant
     */
    private Polygon triangle() {
        return new Polygon(0, getSizeInPx() / 2,
                getSizeInPx() / 2,
                getSizeInPx() / 2,
                0, 0);
    }

    @Override
    public void setRotation(double newRotation) {
        this.rotation = newRotation;
    }

    @Override
    public double getRotation() {
        return this.rotation;
    }

    @Override
    public String toString() {
        return "Hourglass{" + "block=" + block
                + ",rotation=" + rotation + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hourglass hourglass = (Hourglass) o;
        return Double.compare(hourglass.getRotation(), getRotation()) == 0
                &&
                Objects.equals(getBlock(), hourglass.getBlock());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBlock(), getRotation());
    }
}
