package ca.bcit.comp2522.assignments.A3;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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

    Group tfs() {
        Polygon triangle = new Polygon(0,0,0,100,100,100);
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(180);
        triangle.fillProperty().bind(getColorProperty(0));
        triangle2.fillProperty().bind(getColorProperty(0));
        triangle.setStroke(Color.GRAY);
        triangle2.setStroke(Color.GRAY);
        Group quarter = new Group(triangle, triangle2);

        Polygon smallTri = new Polygon(50, 50, 100, 50, 100, 100);
        smallTri.fillProperty().bind(getColorProperty(1));
        smallTri.setStroke(Color.GREY);

        Line line = new Line(50, 0, 100, 50);
        line.setStroke(Color.GREY);

        Polygon firstColorPolygon = new Polygon(0, 0, 50, 0, 100, 50, 50, 50);
        firstColorPolygon.fillProperty().bind(getColorProperty(2));
        firstColorPolygon.setStroke(Color.GREY);

        Polygon secondColorPolygon = new Polygon(0, 50, 50, 50, 100, 100, 50, 100);
        secondColorPolygon.fillProperty().bind(getColorProperty(3));
        secondColorPolygon.setStroke(Color.GREY);

        return new Group(quarter, smallTri, line, firstColorPolygon, secondColorPolygon);
    }
}

