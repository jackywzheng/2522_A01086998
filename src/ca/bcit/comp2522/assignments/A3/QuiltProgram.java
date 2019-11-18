package ca.bcit.comp2522.assignments.A3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Quilt Program.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class QuiltProgram extends Application {

    public static final int MAX_SPINNER_VALUE = 100;
    public static final int INITIAL_SPINNER_VALUE = 5;
    public static final int DEFAULT_GRID_SIZE = 5;
    public static final int DEFAULT_BLOCK_SIZE_IN_CM = 2;
    public static final int USER_CONTROL_SPACING = 10;
    public static final int USER_CONTROL_WIDTH = 200;
    public static final double APP_W = 900;
    public static final double APP_H = 700;

    // Numerical spinner
    private Spinner<Integer> colSpinner;
    private Spinner<Integer> rowSpinner;
    private Spinner<Integer> blockSizeSpinner;

    // To do with the grid
    private int rowNumberOfSelected = 0;
    private int colNumberOfSelected = 0;
    private boolean hasSelection = false;
    private Block currentDesign;
    private Group selectedGrid = new Group();
    private GridPane gridPane = new GridPane();
    private ScrollPane scrollPane = new ScrollPane();

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
        Scene scene = new Scene(getControls(), APP_W, APP_H, Color.BLACK);
        bindControl();
        stage.setTitle("Quilt Maker 9000");
        stage.setScene(scene);
        stage.show();
    }

    // Helper
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
        gridPane.setOnMouseClicked(this::processButtonPress);
        colSpinner.setOnMouseClicked(this::processRowColSpinnerPress);
        rowSpinner.setOnMouseClicked(this::processRowColSpinnerPress);
        updateBlockSize.setOnAction(this::processSizeUpdatePress);
    }

    // Set up methods
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
        // Left vertical column
        selectedGrid.getChildren().add(currentDesign.getBlock());
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

    // Helper
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
        colSpinner.setOnMouseClicked(this::processButtonPress);
        SpinnerValueFactory.IntegerSpinnerValueFactory rowSvf =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, MAX_SPINNER_VALUE, INITIAL_SPINNER_VALUE);
        rowSpinner = new Spinner<>(rowSvf);
        SpinnerValueFactory.IntegerSpinnerValueFactory blockSizeSvf =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, MAX_SPINNER_VALUE, DEFAULT_BLOCK_SIZE_IN_CM);
        blockSizeSpinner = new Spinner<>(blockSizeSvf);
    }

    // Event handlers
    private void processDropDownSelection(Event event) {
        selectedGrid.getChildren().clear();
        if (blockTypesDropdown.getValue().equals("Pinwheel")) {
            currentDesign = new Pinwheel();
            colorBinding(2);
            selectedGrid.getChildren().add(currentDesign.getBlock());
        } else if (blockTypesDropdown.getValue().equals("Hourglass")) {
            currentDesign = new Hourglass();
            colorBinding(2 + 1);
            selectedGrid.getChildren().add(currentDesign.getBlock());
        } else if (blockTypesDropdown.getValue().equals("Twisted four-star")) {
            currentDesign = new TwistedFourStar();
            colorBinding(2 + 2);
            selectedGrid.getChildren().add(currentDesign.getBlock());
        } else if (blockTypesDropdown.getValue().equals("n x n grid")) {
            currentDesign = new NbyN();
//            colorBinding(4);
            selectedGrid.getChildren().add(currentDesign.getBlock());
        } else {
            currentDesign = new Custom();
//            colorBinding(4);
            selectedGrid.getChildren().add(currentDesign.getBlock());
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

    private void processButtonPress(MouseEvent mouseEvent) {
        double posX = mouseEvent.getX();
        double posY = mouseEvent.getY();
        if (hasSelection
                && colNumberOfSelected == (int) (posX / Block.getSizeInPx())
                && rowNumberOfSelected == (int) (posY / Block.getSizeInPx())) {
            resetSelectionDisplay();
            hasSelection = false;
            return;
        }
        colNumberOfSelected = (int) (posX / Block.getSizeInPx());
        rowNumberOfSelected = (int) (posY / Block.getSizeInPx());
        System.out.println(rowNumberOfSelected);
        System.out.println(colNumberOfSelected);
        hasSelection = true;
        resetSelectionDisplay();
        selectionDisplay();
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
