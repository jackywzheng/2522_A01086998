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

    private static final double TRI_SCALE_FACTOR = 0.25;

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
        double triangle_side = getSizeInPx() * TRI_SCALE_FACTOR;
        double quadrant_size = getSizeInPx() / 2;
        Polygon triangle = new Polygon(0, 0,
                quadrant_size, quadrant_size,
                0, quadrant_size);
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);
        triangle.fillProperty().bind(getColorProperty(0));
        triangle2.fillProperty().bind(getColorProperty(0));
        Group quarter = new Group(triangle, triangle2);
        Polygon smallTri = new Polygon(
                triangle_side, triangle_side, quadrant_size,
                triangle_side, quadrant_size, quadrant_size);
        smallTri.fillProperty().bind(getColorProperty(1));
        Polygon firstColorPolygon = new Polygon(0, 0,
                triangle_side, 0, quadrant_size, triangle_side,
                triangle_side, triangle_side);
        firstColorPolygon.fillProperty().bind(getColorProperty(2));
        Polygon secondColorPolygon = new Polygon(
                0, triangle_side, triangle_side, quadrant_size,
                quadrant_size, quadrant_size, triangle_side, triangle_side);
        secondColorPolygon.fillProperty().bind(getColorProperty(2 + 1));
        return new Group(quarter, smallTri,
                firstColorPolygon, secondColorPolygon);
    }
}

