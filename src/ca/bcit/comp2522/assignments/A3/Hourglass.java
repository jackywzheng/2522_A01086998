package ca.bcit.comp2522.assignments.A3;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Hourglass extends Block {

    private Group block;

    public Hourglass(int sizeInCm) {
        super(sizeInCm);
        this.block = hourglass();
    }

    @Override
    public Group getBlock() {
        return block;
    }


    Group hourglass() {
        Group outerBlock = hourglassComponent();
        Group innerBlock = hourglassComponent();
        innerBlock.setScaleX(1/(Math.pow(2, 0.5)));
        innerBlock.setScaleY(1/(Math.pow(2, 0.5)));
        innerBlock.setRotate(45);
        return new Group(outerBlock, innerBlock);
    }

    Group hourglassComponent() {
        Group tl = quadrant(Color.RED, Color.RED);
        tl.setRotate(QUARTER_CLOCKWISE_ROTATION);
        Group br = quadrant(Color.RED, Color.RED);
        br.setRotate(QUARTER_CLOCKWISE_ROTATION);
        br.setTranslateX(100);
        br.setTranslateY(100);

        Group tr = quadrant(Color.WHITE, Color.ORANGE);
        tr.setTranslateX(100);
        Group bl = quadrant(Color.WHITE, Color.ORANGE);
        bl.setTranslateY(100);
        bl.setRotate(QUARTER_CLOCKWISE_ROTATION * 2);

        return new Group(tr, tl, br, bl);
    }

    Group quadrant(Color color1, Color color2) {
        Polygon triangle = new Polygon(0, (double) getSizeInCm() / 2,
                                        (double) getSizeInCm() / 2,
                                        (double) getSizeInCm() / 2,
                                        0, 0);
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
