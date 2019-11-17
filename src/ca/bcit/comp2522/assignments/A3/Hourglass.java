package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.shape.Polygon;

public class Hourglass extends Block {

    private Group block;

    public Hourglass() {
        super();
        this.block = hourglass();
    }

    @Override
    public Group getBlock() {
        return block;
    }

    private Group hourglass() {
        Group outerBlock = hourglassComponent();
        Group innerBlock = hourglassComponent();
        innerBlock.setScaleX(1 / (Math.pow(2, (double) 1 / 2)));
        innerBlock.setScaleY(1 / (Math.pow(2, (double) 1 / 2)));
        innerBlock.setRotate((double) QUARTER_CLOCKWISE_ROTATION / 2);
        return new Group(outerBlock, innerBlock);
    }

    private Group hourglassComponent() {
        Group tl = quadrant1();
        tl.setRotate(QUARTER_CLOCKWISE_ROTATION);
        Group br = quadrant1();
        br.setRotate(QUARTER_CLOCKWISE_ROTATION);
        br.setTranslateX((double) getSizeInCm() / 2);
        br.setTranslateY((double) getSizeInCm() / 2);
        Group tr = quadrant2();
        tr.setTranslateX((double) getSizeInCm() / 2);
        Group bl = quadrant2();
        bl.setTranslateY((double) getSizeInCm() / 2);
        bl.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);
        return new Group(tr, tl, br, bl);
    }

    private Group quadrant1() {
        Polygon triangle = triangle();
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);

        triangle.fillProperty().bind(getColorProperty(0));
        triangle2.fillProperty().bind(getColorProperty(0));
        return new Group(triangle, triangle2);
    }

    private Group quadrant2() {
        Polygon triangle = triangle();
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);

        triangle.fillProperty().bind(getColorProperty(1));
        triangle2.fillProperty().bind(getColorProperty(2));
        return new Group(triangle, triangle2);
    }

    private Polygon triangle() {
        return new Polygon(0, (double) getSizeInCm() / 2,
                (double) getSizeInCm() / 2,
                (double) getSizeInCm() / 2,
                0, 0);
    }
}
