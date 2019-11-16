package ca.bcit.comp2522.assignments.A3;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

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

    private Group block;

    private static double sizeInCm;

    private static ArrayList<SimpleObjectProperty<Color>> COLORS;

    static {
        COLORS = new ArrayList<>();
        COLORS.add(new SimpleObjectProperty<>(Color.RED));
        COLORS.add(new SimpleObjectProperty<>(Color.WHITE));
        COLORS.add(new SimpleObjectProperty<>(Color.ORANGE));
    }

    public Block(double newSizeInCm, Group newBlock) {
        sizeInCm = newSizeInCm;
        this.block = newBlock;

    }

    public Group getBlock() {
        return block;
    }

    public static double getSizeInCm() {
        return sizeInCm;
    }

    private static void setSizeInCm(double newSizeInCm) {
        sizeInCm = newSizeInCm;
    }


    public static SimpleObjectProperty<Color> getColorProperty(int i) {
        return COLORS.get(i);
    }
}
