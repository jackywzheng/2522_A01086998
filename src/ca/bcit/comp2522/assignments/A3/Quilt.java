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
    /**
     * There are 45 pixels in 1 centimetre, an int.
     */
    public static final int PIXELS_IN_A_CM = 45;

    /**
     * Quilt instance.
     */
    private static Quilt quiltInstance;

    /**
     * Number of rows.
     */
    private static int numberOfRows;

    /**
     * Number of columns.
     */
    private static int numberOfColumns;

    /**
     * Block size in pixels.
     */
    private static int blockSizeInPixels;

    /**
     * 2D array of designs.
     */
    private static ArrayList<ArrayList<Group>> designs;

    /**
     * Constructs a Quilt object.
     */
    private Quilt() {
        numberOfRows = QuiltProgram.DEFAULT_GRID_SIZE;
        numberOfColumns = QuiltProgram.DEFAULT_GRID_SIZE;
        setBlockSizeInCentimetres(QuiltProgram.DEFAULT_BLOCK_SIZE_IN_CM);
        designs = new ArrayList<>();
        populateEmptyQuilt();
    }

    /**
     * Returns the Quilt instance.
     *
     * @return quiltInstance, a Quilt
     */
    public static Quilt getQuilt() {
        if (quiltInstance == null) {
            quiltInstance = new Quilt();
        }
        return quiltInstance;
    }

    /**
     * Populates an empty Quilt with Blocks.
     */
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

    /**
     * Returns the number of rows as an int.
     *
     * @return numberOfRows as an int
     */
    public static int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * Sets the number of rows.
     *
     * @param numberOfRows an int representing the number of rows
     */
    public static void setNumberOfRows(int numberOfRows) {
        Quilt.numberOfRows = numberOfRows;
    }

    /**
     * Returns the number of columns.
     *
     * @return numberOfColumns as an int
     */
    public static int getNumberOfColumns() {
        return numberOfColumns;
    }

    /**
     * Sets the number of columns.
     *
     * @param numberOfColumns an int representing the number of columns
     */
    public static void setNumberOfColumns(int numberOfColumns) {
        Quilt.numberOfColumns = numberOfColumns;
    }

    /**
     * Returns the block size in centimetres.
     *
     * @return the block size in centimetres as an int
     */
    public static int getBlockSizeInCentimetres() {
        return Quilt.blockSizeInPixels / PIXELS_IN_A_CM;
    }

    /**
     * Sets the block size in centimetres.
     *
     * @param blockSizeInCentimetres an int representing the block size
     * in centimetres.
     */
    public static void setBlockSizeInCentimetres(int blockSizeInCentimetres) {
        Quilt.blockSizeInPixels = blockSizeInCentimetres * PIXELS_IN_A_CM;
        Block.setSizeInPx(getBlockSizeInPixels());
    }

    /**
     * Returns the block size in pixels.
     *
     * @return blockSizeInPixels as an int
     */
    public static int getBlockSizeInPixels() {
        return blockSizeInPixels;
    }

    /**
     * Returns the 2D ArrayList of designs.
     *
     * @return designs as an ArrayList<ArrayList<Group>>
     */
    public static ArrayList<ArrayList<Group>> getDesigns() {
        return designs;
    }

    /**
     * Replaces an existing design block with the specified block.
     *
     * @param design a Group representing a design
     * @param row an int representing the row
     * @param col an int representing the column
     */
    public static void replaceDesign(Group design, int row, int col) {
        designs.get(row).remove(col);
        designs.get(row).add(col, design);
    }

    /**
     * Replaces the entire design with the specified block.
     *
     * @param design a Block representing a design
     */
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

    /**
     * Resizes the size of the Quilt.
     *
     * @param newNofRows an int representing the number of rows
     * @param newNofCols an int representing the number of columns
     */
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
