package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * Block.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */

public abstract class Block {

    public static final int QUARTER_CLOCKWISE_ROTATION = 90;
    public static final int FULL_ROTATION = 360;
    private static double sizeInCm;
    private ColorPicker colorPicker1 = new ColorPicker(Color.RED);
    private ColorPicker colorPicker2 = new ColorPicker(Color.WHITE);
    private ColorPicker colorPicker3 = new ColorPicker(Color.ORANGE);

    Block(double newSizeInCm) {
        sizeInCm = newSizeInCm;
        colorPicker1.setOnAction(e -> {
            colorPicker1.getValue();
        });
        colorPicker2.setOnAction(e -> {
            colorPicker2.getValue();
        });
        colorPicker3.setOnAction(e -> {
            colorPicker3.getValue();
        });
    }

    public static double getSizeInCm() {
        return sizeInCm;
    }

    private static void setSizeInCm(double newSizeInCm) {
        sizeInCm = newSizeInCm;
    }

    public ColorPicker getColorPicker1() {
        return colorPicker1;
    }

    public ColorPicker getColorPicker2() {
        return colorPicker2;
    }

    public ColorPicker getColorPicker3() {
        return colorPicker3;
    }
}
