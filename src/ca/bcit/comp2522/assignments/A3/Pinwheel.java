package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Pinwheel extends Block {
    private double sizeInCm;
    private Group block;

    public Pinwheel(double sizeInCm, Color color1, Color color2) {
        this.sizeInCm = sizeInCm;
        block = pinwheel(color1, color2);
    }

    public double getSizeInCm() {
        return sizeInCm;
    }

    public Group getBlock() {
        return block;
    }

    private Group pinwheel(Color color1, Color color2) {
        Group theBlock = new Group();
        for (int i = 0; i * QUARTER_CLOCKWISE_ROTATION < FULL_ROTATION; i++) {
            Group tile = tileInBox(color1, color2);
            tile.setRotate(QUARTER_CLOCKWISE_ROTATION * i);
            theBlock.getChildren().add(tile);
        }
        return theBlock;
    }

    private Group tileInBox(Color color1, Color color2) {
        Rectangle square = new Rectangle(0, 0, getSizeInCm(), getSizeInCm());
        square.setFill(Color.TRANSPARENT);
        return new Group(square, tile(color1, color2));
    }

    private Group tile(Color color1, Color color2) {
        Polygon triangle = new Polygon(0, 0,
                                        0, getSizeInCm() / 2,
                                        getSizeInCm() / 2, getSizeInCm() / 2);
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);

        triangle.setFill(color1);
        triangle2.setFill(color2);

        triangle.setStroke(Color.GRAY);
        triangle2.setStroke(Color.GRAY);
        return new Group(triangle, triangle2);
    }
}
