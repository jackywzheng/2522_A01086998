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
    private static Quilt quiltInstance;

    private static int numberOfRows;
    private static int numberOfColumns;
    private static int blockSizeInPixels;
    private static ArrayList<ArrayList<Group>> designs;

    private Quilt() {
        numberOfRows = QuiltProgram.DEFAULT_GRID_SIZE;
        numberOfColumns = QuiltProgram.DEFAULT_GRID_SIZE;
        setBlockSizeInCentimetres(QuiltProgram.DEFAULT_BLOCK_SIZE_IN_CM);
        designs = new ArrayList<>();
        populateEmptyQuilt();
    }

    public static Quilt getQuilt() {
        if (quiltInstance == null) {
            quiltInstance = new Quilt();
        }
        return quiltInstance;
    }

    private static void populateEmptyQuilt() {
        for (int i = 0; i < Quilt.getNumberOfRows(); i++) {
            ArrayList<Group> row = new ArrayList<>();
            for (int j = 0; j < Quilt.getNumberOfColumns(); j++) {
                Block b = new Block();
                row.add(b.getBlock());
            }
            designs.add(row);
        }
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

    public static void setBlockSizeInCentimetres(int blockSizeInCentimetres) {
        Quilt.blockSizeInPixels = blockSizeInCentimetres * PIXELS_IN_A_CM;
        Block.setSizeInPx(getBlockSizeInPixels());
    }

    public static int getBlockSizeInPixels() {
        return blockSizeInPixels;
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
                row.add(newDesign);
            }
            designs.add(row);
        }
    }

    public static void resizeQuilt(int newNofRows, int newNofCols) {
        ArrayList<ArrayList<Group>> newDesigns = new ArrayList<>();
        for (int i = 0; i < newNofRows; i++) {
            ArrayList<Group> rowList = new ArrayList<>();
            for (int j = 0; j < newNofCols; j++) {
                rowList.add((i < designs.size() && j < designs.get(0).size())
                        ? designs.get(i).get(j)
                        : new Block().getBlock());
            }
            newDesigns.add(rowList);
        }
        designs = newDesigns;
    }
}
