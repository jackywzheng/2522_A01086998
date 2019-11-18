package ca.bcit.comp2522.assignments.A3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 * Quilt Program.
 *
 * @author Jacky Zheng
 * @author Trung Bui
 * @version 1.0
 */
public class QuiltProgram extends Application {

    private static final int MAX_SPINNER_VALUE = 100;
    private static final int INITIAL_SPINNER_VALUE = 5;
    public static final int DEFAULT_GRID_SIZE = 5;
    public static final int DEFAULT_BLOCK_SIZE_IN_CM = 2;
    private static final int USER_CONTROL_SPACING = 10;
    private static final int USER_CONTROL_WIDTH = 200;

    private static ArrayList<ColorPicker> colorPickers;

    // Numerical spinner
    private Spinner<Integer> colSpinner;
    private Spinner<Integer> rowSpinner;
    private Spinner<Integer> blockSizeSpinner;
    private int numberOfRows = 0;
    private int numberOfColumns = 0;

    private Group selected;
    private GridPane gridPane = new GridPane();

    private Label columnsLabel = new Label("Choose number of columns:");
    private Label rowsLabel = new Label("Choose number of rows:");
    private Label blockSizeLabel = new Label("Enter Block Size in Cm:");
    private Label blockTypeLabel = new Label("Select Block Type:");

    private ObservableList<String> blockTypes = FXCollections.observableArrayList(
            "Pinwheel", "Hourglass", "Twisted four-star",
            "n x n grid", "Random");
    private ComboBox blockTypesDropdown = new ComboBox<>(blockTypes);
    private Button updateBlock = new Button("Update Selected");
    private Button updateAll = new Button("Update All");

    static {
        // Color pickers
        colorPickers = new ArrayList<>();
        ColorPicker colorPicker1 = new ColorPicker(Color.WHITE);
        colorPickers.add(colorPicker1);
        ColorPicker colorPicker2 = new ColorPicker(Color.BLACK);
        colorPickers.add(colorPicker2);
        ColorPicker colorPicker3 = new ColorPicker(Color.LIGHTGRAY);
        colorPickers.add(colorPicker3);
        ColorPicker colorPicker4 = new ColorPicker(Color.DARKGRAY);
        colorPickers.add(colorPicker4);
        colorPicker1.setOnAction(e -> {
            colorPicker1.getValue();
        });
        colorPicker2.setOnAction(e -> {
            colorPicker2.getValue();
        });
        colorPicker3.setOnAction(e -> {
            colorPicker3.getValue();
        });
        colorPicker4.setOnAction(e -> {
            colorPicker4.getValue();
        });
    }

    @Override
    public void start(Stage stage) throws Exception {
        Quilt.getQuilt();

        // Instantiating components
        transferGroupsToGridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setOnMouseClicked(this::processButtonPress);

        // Instantiating the scene
        final double appWidth = 900;
        final double appHeight = Toolkit.getDefaultToolkit()
                .getScreenSize().getWidth() / 2;
        Scene scene = new Scene(getControls(),
                appWidth, appHeight, Color.BLACK);
        stage.setTitle("Quilt Maker 9000");
        stage.setScene(scene);
        stage.show();
    }

    private void spinnerFactory() {
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

    private BorderPane getControls() {
        ScrollPane scrollPane = new ScrollPane(gridPane);
        spinnerFactory();
        // Types of blocks
        blockTypesDropdown.getSelectionModel().selectFirst();
        blockTypesDropdown.setOnAction(this::processDropDownSelection);
        selected = new Pinwheel().getBlock();
        // Left vertical column
        VBox userControls = new VBox(
                columnsLabel, colSpinner, rowsLabel, rowSpinner,
                blockSizeLabel, blockSizeSpinner, new Separator(),
                blockTypeLabel, blockTypesDropdown, selected,
                colorPickers.get(0), colorPickers.get(1),
                colorPickers.get(2), colorPickers.get(2 + 1),
                new Separator(), updateBlock, updateAll);
        userControls.setStyle("-fx-padding: 20px 20px;"
                + "-fx-background-color: #F2F2F2;");
        userControls.setSpacing(USER_CONTROL_SPACING);
        userControls.setPrefWidth(USER_CONTROL_WIDTH);

        // Instantiating a BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(userControls);
        borderPane.setCenter(scrollPane);
        borderPane.getCenter().setStyle("-fx-padding: 100 0 100 100");
        borderPane.setStyle("-fx-background-color: #E5E5E5");
        return borderPane;
    }

    private void processDropDownSelection(Event event) {
        selected.getChildren().clear();
        if (blockTypesDropdown.getValue().equals("Pinwheel")) {
            selected.getChildren().add(new Pinwheel().getBlock());
        } else if (blockTypesDropdown.getValue().equals("Hourglass")) {
            selected.getChildren().add(new Hourglass().getBlock());
        } else if (blockTypesDropdown.getValue().equals("Twisted four-star")) {
            selected.getChildren().add(new TwistedFourStar().getBlock());
        } else if (blockTypesDropdown.getValue().equals("n x n grid")) {
            selected.getChildren().add(new Pinwheel().getBlock());
        } else {
            selected.getChildren().add(new Custom().getBlock());
        }
    }

    private void processButtonPress(javafx.scene.input.MouseEvent mouseEvent) {
        double posX = mouseEvent.getX();
        double posY = mouseEvent.getY();
        numberOfColumns = (int) (posX / Block.getSizeInCm());
        numberOfRows = (int) (posY / Block.getSizeInCm());
        System.out.println(numberOfRows);
        System.out.println(numberOfColumns);
        for (int i = 0; i < Quilt.getNumberOfRows(); i++) {
            for (int j = 0; j < Quilt.getNumberOfColumns(); j++) {
                Quilt.getDesigns().get(i).get(j).setOpacity(1);
                Quilt.getDesigns().get(i).get(j).setScaleX(1);
                Quilt.getDesigns().get(i).get(j).setScaleY(1);
            }
        }
        final double selectionScaleFactor = 0.9;
        Quilt.getDesigns().get(numberOfRows).get(numberOfColumns)
                .setScaleX(selectionScaleFactor);
        Quilt.getDesigns().get(numberOfRows).get(numberOfColumns)
                .setScaleY(selectionScaleFactor);
    }

    private void transferGroupsToGridPane() {
        // Transferring from ArrayList to gridPane
        for (ArrayList<Group> row : Quilt.getDesigns()) {
            int y = Quilt.getDesigns().indexOf(row);
            for (Group design : row) {
                int x = row.indexOf(design);
                gridPane.add(design, x, y, 1, 1);
            }
        }
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
