package ca.bcit.comp2522.assignments.A3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class QuiltProgram extends Application {

    // Numerical spinner
    private Spinner<Integer> colSpinner;
    private Spinner<Integer> rowSpinner;

    private int roW = 0;
    private int coL = 0;


    @Override
    public void start(Stage stage) throws Exception {
        // Border Pane setup

        // Labels
        Label columnsLabel = new Label("Enter number of columns:");
        Label rowsLabel = new Label("Enter number of rows:");
        Label blockSizeLabel = new Label("Enter Block Size:");
        Label blockTypeLabel = new Label("Select Block Type:");

        // TextFields to input number of columns and rows
        final int maxSpinnerValue = 10;
        final int initialSpinnerValue = 5;
        SpinnerValueFactory.IntegerSpinnerValueFactory colSvf =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, maxSpinnerValue, initialSpinnerValue);
        colSpinner = new Spinner<Integer>(colSvf);
        SpinnerValueFactory.IntegerSpinnerValueFactory rowSvf =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        1, maxSpinnerValue, initialSpinnerValue);
        rowSpinner = new Spinner<Integer>(rowSvf);

        TextField numberOfRowsText = new TextField("Rows");
        TextField blockSizeText = new TextField("Block Size");

        // Types of blocks
        Pinwheel pinwheel = new Pinwheel(150);

        // Left vertical column
        VBox userControls = new VBox(columnsLabel, colSpinner, rowsLabel, rowSpinner, blockSizeLabel, blockSizeText, blockTypeLabel, pinwheel.getBlock());
        userControls.setStyle("-fx-padding: 20px 20px;" + "-fx-background-color: skyblue");
        userControls.setSpacing(10);
        userControls.setPrefWidth(200);

        // Right vertical column
        VBox colorControls = new VBox();

        colorControls.setStyle("-fx-padding: 30px 30px;" + "-fx-background-color: skyblue");
        userControls.setSpacing(10);

        GridPane gridPane = new GridPane();
        gridPane.setMaxSize(1, 1);
        gridPane.setGridLinesVisible(true);
        gridPane.setHgap(0);
        gridPane.setVgap(0);

        ArrayList<ArrayList<Group>> designs = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ArrayList<Group> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add(pinwheel(Color.RED, Color.WHITE));
            }
            designs.add(row);
        }

        for (ArrayList<Group> row : designs) {
            int y = designs.indexOf(row);
            for (Group design : row) {
                int x = row.indexOf(design);
                // Add takes 5 parameters:
                // 1. What we're adding
                // 2. Column index x
                // 3. Row index y
                // 4. Column span
                // 5. Row span
                gridPane.add(design, x, y, 1, 1);
            }
        }

        gridPane.setOnMouseClicked(e -> {
            double posX = e.getX();
            double posY = e.getY();
            int col = (int) (posX / 200);
            int row = (int) (posY / 200);
            System.out.println(row);
            System.out.println(col);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    designs.get(i).get(j).setOpacity(1);
                }
            }
            designs.get(row).get(col).setOpacity(0.8);
            roW = row;
            coL = col;

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
        borderPane.setRight(colorControls);


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene = new Scene(borderPane, screenSize.width - 50, screenSize.height - 50, Color.BLACK);
        scene.setOnKeyPressed(event -> {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    designs.get(i).get(j).setOpacity(1);
                    designs.get(i).get(j).setScaleX(1);
                    designs.get(i).get(j).setScaleY(1);

                }
            }
            switch (event.getCode()) {
                case UP:
                    designs.get(--roW).get(coL).setOpacity(1);
                    break;
                case DOWN:
                    designs.get(++roW).get(coL).setOpacity(1);
                    break;
                case RIGHT:
                    designs.get(roW).get(++coL).setOpacity(1);
                    break;
                case LEFT:
                    designs.get(roW).get(--coL).setOpacity(1);
                    break;
                default:
                    break; // Does nothing if it's not an arrow key
            }
            designs.get(roW).get(coL).setScaleX(0.9);
            designs.get(roW).get(coL).setScaleY(0.9);
            designs.get(roW).get(coL).toFront();
        });
        stage.setTitle("Quilt Maker 9000");
        stage.setScene(scene);
        stage.show();
    }


    Group pinwheel(Color color1, Color color2) {
        Group theBlock = new Group();
        for (int i = 0; i < 4; i++) {
            Group tile = tileInBox(color1, color2);
            tile.setRotate(90 * i);
            theBlock.getChildren().add(tile);
        }
        return theBlock;
    }

    Group tileInBox(Color color1, Color color2) {
        Rectangle square = new Rectangle(0, 0, 200, 200);
        square.setFill(Color.rgb(255,255,255,0.0));
        return new Group(square, tile(color1, color2));
    }

    Group tile(Color color1, Color color2) {
        Polygon triangle = new Polygon(0,0,0,100,100,100);
        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(triangle.getPoints());
        triangle2.setRotate(180);

        triangle.setFill(color1);
        triangle2.setFill(color2);

        triangle.setStroke(Color.GRAY);
        triangle2.setStroke(Color.GRAY);
        return new Group(triangle, triangle2);
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
