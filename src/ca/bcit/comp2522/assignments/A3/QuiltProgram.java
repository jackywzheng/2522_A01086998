package ca.bcit.comp2522.assignments.A3;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;

/**
 * Quilt Program.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class QuiltProgram extends Application {
    /**
     * Default grid size (n by n).
     */
    public static final int DEFAULT_GRID_SIZE = 5;
    /**
     * Default size for each block in Cm.
     */
    public static final int DEFAULT_BLOCK_SIZE_IN_CM = 2;

    private static final int MAX_SPINNER_VALUE = 100;
    private static final int INITIAL_SPINNER_VALUE = 5;
    private static final int USER_CONTROL_SPACING = 10;
    private static final int USER_CONTROL_WIDTH = 200;
    private static final double APP_W = 900;
    private static final double APP_H = 700;

    // Numerical spinner
    private Spinner<Integer> colSpinner;
    private Spinner<Integer> rowSpinner;
    private Spinner<Integer> blockSizeSpinner;

    // To do with the grid
    private int rowNumberOfSelected;
    private int colNumberOfSelected;
    private double currentRotation;
    private boolean hasSelection;
    private Block currentDesign;
    private Group selectedGrid = new Group();
    private GridPane gridPane = new GridPane();
    private ScrollPane scrollPane = new ScrollPane();
    private Scene scene;

    // Controls
    private ArrayList<ColorPicker> colorPickers = new ArrayList<>();
    private ComboBox blockTypesDropdown;
    private Button updateBlock = new Button("Update Selected");
    private Button updateAll = new Button("Update All");
    private Button updateBlockSize = new Button("Use New Block Size");

    @Override
    public void start(Stage stage) {
        Quilt.getQuilt();
        transferGroupsToGridPane();
        gridPane.setStyle("-fx-border-width: 1px;"
                + "-fx-border-color: black;"
                + "-fx-background-color: #6A6AFF");
        scene = new Scene(getControls(), APP_W, APP_H, Color.BLACK);
        bindControl();
        stage.setTitle("Quilt Maker 9000");
        stage.setScene(scene);
        stage.show();
    }

    private void transferGroupsToGridPane() {
        gridPane.getChildren().clear();
        for (ArrayList<Group> row : Quilt.getDesigns()) {
            int y = Quilt.getDesigns().indexOf(row);
            for (Group design : row) {
                int x = row.indexOf(design);
                gridPane.add(design, x, y, 1, 1);
            }
        }
    }

    private void bindControl() {
        updateAll.setOnAction(this::processUpdateAll);
        updateBlock.setOnAction(this::processUpdateSelected);
        gridPane.setOnMouseClicked(this::processMouseClick);
        colSpinner.setOnMouseClicked(this::processRowColSpinnerPress);
        rowSpinner.setOnMouseClicked(this::processRowColSpinnerPress);
        colSpinner.setOnKeyPressed(e -> processRowColSpinnerPress(null));
        rowSpinner.setOnKeyPressed(e -> processRowColSpinnerPress(null));
        updateBlockSize.setOnAction(this::processSizeUpdatePress);
        scrollPane.setOnKeyPressed(this::processKeyPress);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.R) {
                currentRotation = selectedGrid.getRotate()
                        + Block.QUARTER_CLOCKWISE_ROTATION;
                selectedGrid.setRotate(currentRotation);
            }
        });
    }

    private void processKeyPress(KeyEvent event) {
        if (!hasSelection) {
            return;
        }
        resetSelectionDisplay();
        switch (event.getCode()) {
            case UP:
                if (rowNumberOfSelected > 0) {
                    --rowNumberOfSelected;
                    System.out.println("Moved UP by 1");
                }
                break;
            case DOWN:
                if (rowNumberOfSelected < Quilt.getDesigns().size() - 1) {
                    ++rowNumberOfSelected;
                    System.out.println("Moved DOWN by 1");
                }
                break;
            case RIGHT:
                if (colNumberOfSelected
                        < Quilt.getDesigns().get(0).size() - 1) {
                    ++colNumberOfSelected;
                    System.out.println("Moved RIGHT by 1");
                }
                break;
            case LEFT:
                if (colNumberOfSelected > 0) {
                    --colNumberOfSelected;
                    System.out.println("Moved LEFT by 1");
                }
                break;
            case SPACE:
                processUpdateSelected(null);
                break;
            default:
                selectionDisplay();
                return;
        }
        selectionDisplay();
    }

    private void colorPickersVisibilityModifier(int numberOfColors) {
        colorBinding(numberOfColors);
        for (int i = 0; i < numberOfColors; i++) {
            colorPickers.get(i).setVisible(true);
        }
        for (int i = numberOfColors; i < colorPickers.size(); i++) {
            colorPickers.get(i).setVisible(false);
        }
    }

    private void colorBinding(int numberToBind) {
        for (int i = 0; i < numberToBind; i++) {
            currentDesign.getColorProperty(i)
                    .bind(colorPickers.get(i).valueProperty());
        }
    }

    private void colorUnbinding(int numberToUnbind) {
        for (int i = 0; i < numberToUnbind; i++) {
            currentDesign.getColorProperty(i).unbind();
        }
    }

    private void resetSelectionDisplay() {
        for (int i = 0; i < Quilt.getNumberOfRows(); i++) {
            for (int j = 0; j < Quilt.getNumberOfColumns(); j++) {
                Quilt.getDesigns().get(i).get(j).setScaleX(1);
                Quilt.getDesigns().get(i).get(j).setScaleY(1);
                Quilt.getDesigns().get(i).get(j).setRotate(0);
            }
        }
    }

    private void selectionDisplay() {
        final double selectionScaleFactor = 0.93;
        Quilt.getDesigns().get(rowNumberOfSelected).get(colNumberOfSelected)
                .setScaleX(selectionScaleFactor);
        Quilt.getDesigns().get(rowNumberOfSelected).get(colNumberOfSelected)
                .setScaleY(selectionScaleFactor);
    }

    private void processDropDownSelection(Event event) {
        selectedGrid.getChildren().clear();
        if (blockTypesDropdown.getValue().equals("Pinwheel")) {
            currentDesign = new Pinwheel();
            colorPickersVisibilityModifier(2);
        } else if (blockTypesDropdown.getValue().equals("Hourglass")) {
            currentDesign = new Hourglass();
            colorPickersVisibilityModifier(2 + 1);
        } else if (blockTypesDropdown.getValue().equals("Twisted four-star")) {
            currentDesign = new TwistedFourStar();
            colorPickersVisibilityModifier(2 + 2);
        } else if (blockTypesDropdown.getValue().equals("n x n grid")) {
            currentDesign = new NbyN();
            colorPickersVisibilityModifier(2 + 2);
        } else {
            currentDesign = new Custom();
            colorPickersVisibilityModifier(2 + 2);
        }
        selectedGrid.getChildren().add(currentDesign.getBlock());
    }

    private void processMouseClick(MouseEvent mouseEvent) {
        double posX = mouseEvent.getX();
        double posY = mouseEvent.getY();
        if (hasSelection
                && colNumberOfSelected == (int) (posX / Block.getSizeInPx())
                && rowNumberOfSelected == (int) (posY / Block.getSizeInPx())) {
            processUpdateSelected(null);
            return;
        }
        colNumberOfSelected = (int) (posX / Block.getSizeInPx());
        rowNumberOfSelected = (int) (posY / Block.getSizeInPx());
        hasSelection = true;
        System.out.println("Row: " + rowNumberOfSelected);
        System.out.println("Col: " + colNumberOfSelected);
        resetSelectionDisplay();
        selectionDisplay();
    }

    private void processRowColSpinnerPress(MouseEvent mouseEvent) {
        Quilt.setNumberOfColumns(colSpinner.getValue());
        Quilt.setNumberOfRows(rowSpinner.getValue());
        Quilt.resizeQuilt(rowSpinner.getValue(), colSpinner.getValue());
        transferGroupsToGridPane();
    }

    private void processSizeUpdatePress(ActionEvent event) {
        Quilt.setBlockSizeInCentimetres(blockSizeSpinner.getValue());
        Quilt.replaceDesign(new Block());
        transferGroupsToGridPane();
        processDropDownSelection(null);
    }

    private void processUpdateAll(ActionEvent event) {
        Quilt.replaceDesign(currentDesign);
        transferGroupsToGridPane();
        colorUnbinding(colorPickers.size());
        processDropDownSelection(null);
        hasSelection = false;
    }

    private void processUpdateSelected(ActionEvent event) {
        if (!hasSelection) {
            return;
        }
        Quilt.replaceDesign(new Group(currentDesign.getBlock()),
                rowNumberOfSelected, colNumberOfSelected);
        transferGroupsToGridPane();
        colorUnbinding(colorPickers.size());
        processDropDownSelection(null);
        selectionDisplay();
        System.out.println("Design added");
    }

    private BorderPane getControls() {
        setSpinners();
        setColorPickers();
        scrollPane = new ScrollPane(gridPane);
        Label columnsLabel = new Label("Choose number of columns:");
        Label rowsLabel = new Label("Choose number of rows:");
        Label blockSizeLabel = new Label("Enter Block Size in Cm:");
        Label blockSizeUpdateLabel = new Label("( Will reset the quilt!! )");
        Label blockTypeLabel = new Label("Select Block Type:");
        ObservableList<String> blockTypes = FXCollections.observableArrayList(
                "Pinwheel", "Hourglass", "Twisted four-star",
                "n x n grid", "Random");
        blockTypesDropdown = new ComboBox<>(blockTypes);
        // Types of blocks
        blockTypesDropdown.getSelectionModel().selectFirst();
        blockTypesDropdown.setOnAction(this::processDropDownSelection);
        currentDesign = new Pinwheel();
        selectedGrid.getChildren().add(currentDesign.getBlock());
        colorPickersVisibilityModifier(2);
        VBox userControls = new VBox(
                columnsLabel, colSpinner, rowsLabel, rowSpinner,
                blockSizeLabel, blockSizeSpinner, updateBlockSize,
                blockSizeUpdateLabel, new Separator(),
                blockTypeLabel, blockTypesDropdown, selectedGrid,
                colorPickers.get(0), colorPickers.get(1),
                colorPickers.get(2), colorPickers.get(2 + 1),
                new Separator(), updateBlock, updateAll);
        userControls.setStyle("-fx-padding: 20px 20px;"
                + "-fx-background-color: #F2F2F2;");
        userControls.setSpacing(USER_CONTROL_SPACING);
        userControls.setPrefWidth(USER_CONTROL_WIDTH);
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(new ScrollPane(userControls));
        borderPane.setCenter(scrollPane);
        borderPane.getCenter().setStyle("-fx-padding: 100 0 100 100");
        borderPane.setStyle("-fx-background-color: #E5E5E5");
        return borderPane;
    }

    private void setColorPickers() {
        ColorPicker colorPicker1 = new ColorPicker(Color.WHITE);
        colorPickers.add(colorPicker1);
        colorPicker1.setOnAction(e -> colorPicker1.getValue());
        ColorPicker colorPicker2 = new ColorPicker(Color.BLACK);
        colorPickers.add(colorPicker2);
        colorPicker2.setOnAction(e -> colorPicker2.getValue());
        ColorPicker colorPicker3 = new ColorPicker(Color.LIGHTGRAY);
        colorPickers.add(colorPicker3);
        colorPicker3.setOnAction(e -> colorPicker3.getValue());
        ColorPicker colorPicker4 = new ColorPicker(Color.DARKGRAY);
        colorPickers.add(colorPicker4);
        colorPicker4.setOnAction(e -> colorPicker4.getValue());
    }

    private void setSpinners() {
        SpinnerValueFactory.IntegerSpinnerValueFactory colSvf =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, MAX_SPINNER_VALUE, INITIAL_SPINNER_VALUE);
        colSpinner = new Spinner<>(colSvf);
        colSpinner.setOnMouseClicked(this::processMouseClick);
        SpinnerValueFactory.IntegerSpinnerValueFactory rowSvf =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, MAX_SPINNER_VALUE, INITIAL_SPINNER_VALUE);
        rowSpinner = new Spinner<>(rowSvf);
        SpinnerValueFactory.IntegerSpinnerValueFactory blockSizeSvf =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, MAX_SPINNER_VALUE, DEFAULT_BLOCK_SIZE_IN_CM);
        blockSizeSpinner = new Spinner<>(blockSizeSvf);
    }


    /**
         * Launches the JavaFX application.
         *
         * @param args command line arguments
         */
    public static void main(String[] args) {
        launch(args);
    }
}
