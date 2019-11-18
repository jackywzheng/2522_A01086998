package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import java.util.ArrayList;

/**
 * Quilt.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public final class Quilt {
    public static final int PIXELS_IN_A_CM = 45;
    // static variable single_instance of type Singleton
    private static Quilt quiltInstance;

    private static int numberOfRows;
    private static int numberOfColumns;
    private static int blockSizeInPixels;
    private static ArrayList<ArrayList<Group>> designs;

    // private constructor restricted to this class itself
    private Quilt() {
        numberOfRows = QuiltProgram.DEFAULT_GRID_SIZE;
        numberOfColumns = QuiltProgram.DEFAULT_GRID_SIZE;
        setBlockSizeInCentimetres(QuiltProgram.DEFAULT_BLOCK_SIZE_IN_CM);
        designs = new ArrayList<>();
        Block.setSizeInCm(Quilt.getBlockSizeInPixels());
        populateEmptyQuilt();
    }

    private static void populateEmptyQuilt() {
        // Populating the ArrayList (Empty Quilt)
        for (int i = 0; i < Quilt.getNumberOfRows(); i++) {
            ArrayList<Group> row = new ArrayList<>();
            for (int j = 0; j < Quilt.getNumberOfColumns(); j++) {
                Block b = new Block();
                row.add(b.getBlock());
            }
            designs.add(row);
        }
    }

    // static method to create instance of Singleton class
    public static Quilt getQuilt() {
        if (quiltInstance == null) {
            quiltInstance = new Quilt();
        }
        return quiltInstance;
    }

    public static int getNumberOfRows() {
        return numberOfRows;
    }

    public static void setNumberOfRows(int numberOfRows) {
        Quilt.numberOfRows = numberOfRows;
    }

    public static int getNumberOfColumns() {
        return numberOfColumns;
    }

    public static void setNumberOfColumns(int numberOfColumns) {
        Quilt.numberOfColumns = numberOfColumns;
    }

    public static int getBlockSizeInCentimetres() {
        return blockSizeInPixels / PIXELS_IN_A_CM;
    }

    public static void setBlockSizeInCentimetres(int blockSizeInCentimetres) {
        Quilt.blockSizeInPixels = blockSizeInCentimetres * PIXELS_IN_A_CM;
    }

    public static int getBlockSizeInPixels() {
        return blockSizeInPixels;
    }

    public static void setBlockSizeInPixels(int blockSizeInPixels) {
        Quilt.blockSizeInPixels = blockSizeInPixels;
    }

    public static ArrayList<ArrayList<Group>> getDesigns() {
        return designs;
    }

    public static void replaceDesign(Group design, int row, int col) {
        designs.get(row).remove(col);
        designs.get(row).add(col, design);
    }

    public static void replaceDesign(Block design) {
        designs.clear();
        for (int i = 0; i < Quilt.getNumberOfRows(); i++) {
            ArrayList<Group> row = new ArrayList<>();
            for (int j = 0; j < Quilt.getNumberOfColumns(); j++) {
                Group newDesign = new Group(design.getNewBlock());
//                newDesign.getChildren().addAll(design.getBlock());
//                Group b = new Pinwheel().getBlock();
                row.add(newDesign);
            }
            designs.add(row);
        }
    }

    private static Group designSwitch() {
        return new Group();
    }
}
