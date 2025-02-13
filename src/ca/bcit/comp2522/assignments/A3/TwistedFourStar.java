package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

/**
 * Twisted Four Star Block.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class TwistedFourStar extends Block {
    // Triangle scaling factor
    private static final double TRI_SCALE_FACTOR = 0.25;
    // Group
    private Group block;

    /**
     * Constructs an twisted four star object.
     */
    public TwistedFourStar() {
        super();
        this.block = twistedFourStar();
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
        return twistedFourStar();
    }

    /**
     * Twisted four-star design.
     *
     * @return Twisted four-star design as a Group.
     */
    private Group twistedFourStar() {
        Group twistedFourStar = new Group();
        for (int i = 0; i++ * QUARTER_CLOCKWISE_ROTATION < FULL_ROTATION;) {
            Group tile = tileInBox();
            tile.setRotate(i * QUARTER_CLOCKWISE_ROTATION);
            twistedFourStar.getChildren().add(tile);
        }
        return twistedFourStar;
    }

    /**
     * Returns 1/4 of a Twisted 4-star but in another Group with a
     * transparent square.
     *
     * @return 1/4 of a twisted 4 star as a group.
     */
    private Group tileInBox() {
        Rectangle square = new Rectangle(0, 0, getSizeInPx(), getSizeInPx());
        square.setFill(Color.TRANSPARENT);
        return new Group(square, tfs());
    }

    /**
     * Returns 1/4 of a twisted 4-star.
     *
     * @return a Group as 1/4 of a twisted 4-star
     */
    private Group tfs() {
        double triangleSide = getSizeInPx() * TRI_SCALE_FACTOR;
        double quadrantSize = getSizeInPx() / 2;
        Polygon triangle = new Polygon(0, 0,
                quadrantSize, quadrantSize,
                0, quadrantSize);
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);
        triangle.fillProperty().bind(getColorProperty(0));
        triangle2.fillProperty().bind(getColorProperty(0));
        Group quarter = new Group(triangle, triangle2);
        Polygon smallTri = new Polygon(
                triangleSide, triangleSide, quadrantSize,
                triangleSide, quadrantSize, quadrantSize);
        smallTri.fillProperty().bind(getColorProperty(1));
        Polygon firstColorPolygon = new Polygon(0, 0,
                triangleSide, 0, quadrantSize, triangleSide,
                triangleSide, triangleSide);
        firstColorPolygon.fillProperty().bind(getColorProperty(2));
        Polygon secondColorPolygon = new Polygon(
                0, triangleSide, triangleSide, quadrantSize,
                quadrantSize, quadrantSize, triangleSide, triangleSide);
        secondColorPolygon.fillProperty().bind(getColorProperty(2 + 1));
        return new Group(quarter, smallTri,
                firstColorPolygon, secondColorPolygon);
    }

    /**
     * Returns a string representation of the block.
     *
     * @return a string representation of the block.
     */
    @Override
    public String toString() {
        return "TwistedFourStar{"
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
        TwistedFourStar that = (TwistedFourStar) o;
        return Objects.equals(getBlock(), that.getBlock());
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

