package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Pinwheel extends Block {


    private double sizeInCm;
    private Group block;
    private Color color1;
    private Color color2;

    public Pinwheel(double sizeInCm, Color color1, Color color2) {
        this.sizeInCm = sizeInCm;
        this.color1 = color1;
        this.color2 = color2;
        this.block = pinwheel();
    }

    public double getSizeInCm() {
        return sizeInCm;
    }

    public Group getBlock() {
        return block;
    }

    private Group pinwheel() {
        Group theBlock = new Group();
        for (int i = 0; i * QUARTER_CLOCKWISE_ROTATION < FULL_ROTATION; i++) {
            Group tile = tileInBox();
            tile.setRotate(QUARTER_CLOCKWISE_ROTATION * i);
            theBlock.getChildren().add(tile);
        }
        return theBlock;
    }

    private Group tileInBox() {
        Rectangle square = new Rectangle(0, 0, getSizeInCm(), getSizeInCm());
        square.setFill(Color.TRANSPARENT);
        return new Group(square, tile());
    }

    private Group tile() {
        Polygon triangle = new Polygon(0, 0,
                                        0, getSizeInCm() / 2,
                                        getSizeInCm() / 2, getSizeInCm() / 2);
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);

        triangle.fillProperty().bind(Driver.getColorPicker1().valueProperty());
        triangle2.fillProperty().bind(Driver.getColorPicker2().valueProperty());

//        triangle.setFill(this.color1);
//        triangle2.setFill(this.color2);

        triangle.setStroke(Color.GRAY);
        triangle2.setStroke(Color.GRAY);
        return new Group(triangle, triangle2);
    }
}
