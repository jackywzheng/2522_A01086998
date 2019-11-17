package ca.bcit.comp2522.assignments.A3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class QuiltProgram extends Application {

    private static ArrayList<ColorPicker> colorPickers;

    // Numerical spinner
    private Spinner<Integer> colSpinner;
    private Spinner<Integer> rowSpinner;
    private Spinner<Integer> blockSizeSpinner;

    private int roW = 0;
    private int coL = 0;
    private Group selected;
    private ComboBox blockTypesDropdown;

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
        // Border Pane setup

        Block.setSizeInCm(100);

        // Labels
        Label columnsLabel = new Label("Enter number of columns:");
        Label rowsLabel = new Label("Enter number of rows:");
        Label blockSizeLabel = new Label("Enter Block Size in cm:");
        Label blockTypeLabel = new Label("Select Block Type:");

        // TextFields to input number of columns and rows, and block size
        final int maxSpinnerValue = 10;
        final int initialSpinnerValue = 5;
        SpinnerValueFactory.IntegerSpinnerValueFactory colSvf =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, maxSpinnerValue, initialSpinnerValue);
        colSpinner = new Spinner<>(colSvf);
        SpinnerValueFactory.IntegerSpinnerValueFactory rowSvf =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, maxSpinnerValue, initialSpinnerValue);
        rowSpinner = new Spinner<>(rowSvf);
        SpinnerValueFactory.IntegerSpinnerValueFactory blockSizeSvf =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, maxSpinnerValue, initialSpinnerValue);
        blockSizeSpinner = new Spinner<>(blockSizeSvf);

        TextField blockSizeText = new TextField("Block Size");

        // Types of blocks
        ObservableList<String> blockTypes = FXCollections.observableArrayList(
                "Pinwheel", "Hourglass", "Twisted four-star", "n x n grid", "Random");
        blockTypesDropdown = new ComboBox<>(blockTypes);
        blockTypesDropdown.getSelectionModel().selectFirst();
        selected = new Pinwheel().getBlock();
        // Create action event
        EventHandler<ActionEvent> event1 = e -> {
            selected.getChildren().clear();
            if (blockTypesDropdown.getValue().equals("Pinwheel")) {
                selected.getChildren().add(new Pinwheel().getBlock());
            } else if (blockTypesDropdown.getValue().equals("Hourglass")) {
                selected.getChildren().add(new Hourglass().getBlock());
            } else if (blockTypesDropdown.getValue().equals("Twisted four-star")) {
                selected.getChildren().add(new TwistedFourStar().getBlock());
            } else if (blockTypesDropdown.getValue().equals("n x n grid")) {
                selected.getChildren().add(new NbyN().getBlock());
            } else {
                selected.getChildren().add(new Custom().getBlock());
            }
        };

        blockTypesDropdown.setOnAction(event1);

        // Update Button
        Button update = new Button("Update");

        // Separators
        Separator separatorOne = new Separator();
        Separator separatorTwo = new Separator();

        // Left vertical column
        VBox userControls = new VBox(columnsLabel, colSpinner, rowsLabel, rowSpinner,
                blockSizeLabel, blockSizeSpinner, separatorOne, blockTypeLabel, blockTypesDropdown, selected,
                colorPickers.get(0), colorPickers.get(1), colorPickers.get(2), colorPickers.get(3), separatorTwo, update);
        userControls.setStyle("-fx-padding: 20px 20px;" + "-fx-background-color: #F2F2F2");
        userControls.setSpacing(10);
        userControls.setPrefWidth(200);

        GridPane gridPane = new GridPane();
        gridPane.setMaxSize(1, 1);
        gridPane.setGridLinesVisible(true);
        gridPane.setHgap(0);
        gridPane.setVgap(0);

        ArrayList<ArrayList<Group>> designs = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ArrayList<Group> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
//                Pinwheel p = new Pinwheel();
                Block b = new Block();
                row.add(b.getBlock());
            }
            designs.add(row);
        }

        for (ArrayList<Group> row : designs) {
            int y = designs.indexOf(row);
            for (Group design : row) {
                int x = row.indexOf(design);
                gridPane.add(design, x, y, 1, 1);
            }
        }

        gridPane.setOnMouseClicked(e -> {
            double posX = e.getX();
            double posY = e.getY();
            int col = (int) (posX / 100);
            int row = (int) (posY / 100);
            System.out.println(row);
            System.out.println(col);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    designs.get(i).get(j).setOpacity(1);
                    designs.get(i).get(j).setScaleX(1);
                    designs.get(i).get(j).setScaleY(1);
                }
            }
            roW = row;
            coL = col;
            designs.get(roW).get(coL).setScaleX(0.9);
            designs.get(roW).get(coL).setScaleY(0.9);
        });

        for (Node node : gridPane.getChildren()) {
            System.out.println(node.getProperties());
        }

        StackPane pane = new StackPane();
        pane.getChildren().add(gridPane);

        // Instantiating a BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(userControls);
        borderPane.setCenter(pane);
        borderPane.setStyle("-fx-background-color: #E5E5E5");
//        borderPane.setRight(colorControls);


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene = new Scene(borderPane, screenSize.width - 50, screenSize.height - 50, Color.BLACK);
        stage.setTitle("Quilt Maker 9000");
        stage.setScene(scene);
        stage.show();
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
