package ca.bcit.comp2522.assignments.A3;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class TwistedFourStar extends Block {

    private Group block;

    public TwistedFourStar(int sizeInCm) {
        super(sizeInCm);
        this.block = twistedFourStar();
    }

    @Override
    public Group getBlock() {
        return block;
    }

    private Group twistedFourStar() {
        Group twistedFourStar = new Group();
        for (int i = 0; i++ * QUARTER_CLOCKWISE_ROTATION < FULL_ROTATION;) {
            Group tile = tileInBox();
            tile.setRotate(i * QUARTER_CLOCKWISE_ROTATION);
            twistedFourStar.getChildren().add(tile);
        }
        return twistedFourStar;
    }

    private Group tileInBox() {
        Rectangle square = new Rectangle(0, 0, getSizeInCm(), getSizeInCm());
        square.setFill(Color.TRANSPARENT);
        return new Group(square, tfs());
    }

    private Group tfs() {
        Polygon triangle = new Polygon(0, 0,
                (double) getSizeInCm() / 2, (double) getSizeInCm() / 2,
                0, (double) getSizeInCm() / 2);
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);
        triangle.fillProperty().bind(getColorProperty(0));
        triangle2.fillProperty().bind(getColorProperty(0));
        Group quarter = new Group(triangle, triangle2);

        Polygon smallTri = new Polygon(
                (double) getSizeInCm() / (2 * 2),
                (double) getSizeInCm() / (2 * 2),
                (double) getSizeInCm() / 2, (double) getSizeInCm() / (2 * 2),
                (double) getSizeInCm() / 2, (double) getSizeInCm() / 2);
        smallTri.fillProperty().bind(getColorProperty(1));

        Polygon firstColorPolygon = new Polygon(0, 0,
                (double) getSizeInCm() / (2 * 2), 0,
                (double) getSizeInCm() / 2, (double) getSizeInCm() / (2 * 2),
                (double) getSizeInCm() / (2 * 2),
                (double) getSizeInCm() / (2 * 2));
        firstColorPolygon.fillProperty().bind(getColorProperty(2));

        Polygon secondColorPolygon = new Polygon(
                0, (double) getSizeInCm() / (2 * 2),
                (double) getSizeInCm() / (2 * 2),
                (double) getSizeInCm() / 2,
                (double) getSizeInCm() / 2, (double) getSizeInCm() / 2,
                (double) getSizeInCm() / (2 * 2),
                (double) getSizeInCm() / (2 * 2));
        secondColorPolygon.fillProperty().bind(getColorProperty(2 + 1));

        return new Group(quarter, smallTri,
                firstColorPolygon, secondColorPolygon);
    }
}

