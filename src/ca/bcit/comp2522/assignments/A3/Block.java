package ca.bcit.comp2522.assignments.A3;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

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

    private ArrayList<SimpleObjectProperty<Color>> COLORS;
    private Group block;


    public Block(int newSizeInCm) {
        sizeInCm = newSizeInCm;
        COLORS = new ArrayList<>();
        COLORS.add(new SimpleObjectProperty<>(Color.RED));
        COLORS.add(new SimpleObjectProperty<>(Color.WHITE));
        COLORS.add(new SimpleObjectProperty<>(Color.ORANGE));
        COLORS.add(new SimpleObjectProperty<>(Color.GOLD));
    }

    public Group getBlock() {
        return block;
    }

//    private Group genericBlock() {
//        Rectangle square = new Rectangle(0, 0, getSizeInCm(), getSizeInCm());
//    }

    public static int getSizeInCm() {
        return sizeInCm;
    }

    private static void setSizeInCm(int newSizeInCm) {
        sizeInCm = newSizeInCm;
    }

    public SimpleObjectProperty<Color> getColorProperty(int i) {
        return COLORS.get(i);
    }
}
