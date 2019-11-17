package ca.bcit.comp2522.assignments.A3;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


import java.awt.*;
import java.util.ArrayList;

/**
 * Block.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */

public class Block {

    public static final int QUARTER_CLOCKWISE_ROTATION = 90;
    public static final int FULL_ROTATION = 360;
    private static int sizeInCm;

    private ArrayList<SimpleObjectProperty<Color>> colors;
    private Group block;


    public Block() {
        colors = new ArrayList<>();
        colors.add(new SimpleObjectProperty<>(Color.WHITE));
        colors.add(new SimpleObjectProperty<>(Color.BLACK));
        colors.add(new SimpleObjectProperty<>(Color.DARKGRAY));
        colors.add(new SimpleObjectProperty<>(Color.LIGHTGRAY));
        this.block = genericBlock();
    }

    public Group getBlock() {
        return block;
    }

    private Group genericBlock() {
        Rectangle square = new Rectangle(0, 0, getSizeInCm(), getSizeInCm());
        square.setStroke(Color.BLACK);
        square.setFill(Color.TRANSPARENT);
        return new Group(square);
    }

    public static int getSizeInCm() {
        return sizeInCm;
    }

    public static void setSizeInCm(int newSizeInCm) {
        sizeInCm = newSizeInCm;
    }

    public SimpleObjectProperty<Color> getColorProperty(int i) {
        return colors.get(i);
    }
}
