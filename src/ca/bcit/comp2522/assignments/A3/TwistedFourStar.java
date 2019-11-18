package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * Twisted Four Star Block.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class TwistedFourStar extends Block {

    /**
     * Size of the triangle in twisted 4 star.
     */
    private static final int TRIANGLE_SIZE = getSizeInPx() / 4;
    /**
     * Size of a quadrant of a twisted 4 star.
     */
    private static final int QUADRANT_SIZE = getSizeInPx() / 2;


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
     * 1/4 of a Twisted 4-star but in another Group with a transparent square.
     *
     * @return 1/4 of a twisted 4 star as a group.
     */
    private Group tileInBox() {
        Rectangle square = new Rectangle(0, 0, getSizeInPx(), getSizeInPx());
        square.setFill(Color.TRANSPARENT);
        return new Group(square, tfs());
    }

    /**
     * 1/4 of a twisted 4-star.
     *
     * @return a Group as 1/4 of a twisted 4-star.
     */
    private Group tfs() {
        Polygon triangle = new Polygon(0, 0,
                QUADRANT_SIZE, QUADRANT_SIZE,
                0, QUADRANT_SIZE);
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);
        triangle.fillProperty().bind(getColorProperty(0));
        triangle2.fillProperty().bind(getColorProperty(0));
        Group quarter = new Group(triangle, triangle2);
        Polygon smallTri = new Polygon(
                TRIANGLE_SIZE, TRIANGLE_SIZE, QUADRANT_SIZE,
                TRIANGLE_SIZE, QUADRANT_SIZE, QUADRANT_SIZE);
        smallTri.fillProperty().bind(getColorProperty(1));
        Polygon firstColorPolygon = new Polygon(0, 0,
                TRIANGLE_SIZE, 0, QUADRANT_SIZE, TRIANGLE_SIZE,
                TRIANGLE_SIZE, TRIANGLE_SIZE);
        firstColorPolygon.fillProperty().bind(getColorProperty(2));
        Polygon secondColorPolygon = new Polygon(
                0, TRIANGLE_SIZE, TRIANGLE_SIZE, QUADRANT_SIZE,
                QUADRANT_SIZE, QUADRANT_SIZE, TRIANGLE_SIZE, TRIANGLE_SIZE);
        secondColorPolygon.fillProperty().bind(getColorProperty(2 + 1));
        return new Group(quarter, smallTri,
                firstColorPolygon, secondColorPolygon);
    }
}

