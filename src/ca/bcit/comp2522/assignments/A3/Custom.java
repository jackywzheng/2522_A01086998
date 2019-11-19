package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

/**
 * Custom block design that Trung and Jacky made.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class Custom extends Block implements Rotatable {

    private Group block;
    private double rotation;

    /**
     * Constructs a custom object.
     */
    public Custom() {
        super();
        this.block = custom();
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
        Group newBlock = custom();
        newBlock.setRotate(rotation);
        return newBlock;
    }
    /**
     * The whole custom design.
     *
     * @return the whole custom design as a Group.
     */
    private Group custom() {
        Group outerBlock = customComponent();
        Group innerBlock = customComponent();
        innerBlock.setScaleX(1 / (Math.pow(2, (double) 1 / 2)));
        innerBlock.setScaleY(1 / (Math.pow(2, (double) 1 / 2)));
        innerBlock.setRotate((double) QUARTER_CLOCKWISE_ROTATION / 2);
        Group last = new Group(outerBlock, innerBlock);
        last.setScaleX(2.0 / (2 + 1));
        last.setScaleY(2.0 / (2 + 1));
        return last;
    }

    /**
     * The custom component.
     *
     * @return custom design component as a Group.
     */
    private Group customComponent() {
        Rectangle background = new Rectangle(getSizeInPx() * (2 + 1) / 2,
                getSizeInPx() * (2 + 1) / 2);
        background.fillProperty().bind(getColorProperty(2 + 1));
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
     * 1st quadrant of the custom design.
     *
     * @return 1st quadrant of the custom design as a Group.
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
     * 2nd quadrant of the custom design.
     *
     * @return 2nd quadrant of the custom design as a Group.
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
     * A triangle.
     *
     * @return just a Triangle as a Polygon
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
        return "Custom{" + "block=" + block + ", rotation=" + rotation + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Custom custom = (Custom) o;
        return Double.compare(custom.getRotation(), getRotation()) == 0
                &&
                Objects.equals(getBlock(), custom.getBlock());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBlock(), getRotation());
    }
}
