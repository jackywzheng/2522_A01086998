package ca.bcit.comp2522.assignments.A3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;


public class Driver extends Application {

    private static ColorPicker colorPicker1;
    private static ColorPicker colorPicker2;

    public static ColorPicker getColorPicker1() {
        return colorPicker1;
    }

    public static ColorPicker getColorPicker2() {
        return colorPicker2;
    }

    /**
     * Gets the color specified in the color picker and sets the
     * color of the displayed message.
     *
     * @param event invokes this method
     */
    private void processColorChoice1(ActionEvent event) {
        colorPicker1.getValue();
    }

    private void processColorChoice2(ActionEvent event) {
        colorPicker2.getValue();
    }

    @Override
    public void start(Stage stage) throws Exception {
        colorPicker1 = new ColorPicker(Color.BLACK);
        colorPicker1.setOnAction(this::processColorChoice1);
        colorPicker2 = new ColorPicker(Color.BLACK);
        colorPicker2.setOnAction(this::processColorChoice2);

        Pinwheel pinwheel = new Pinwheel(200, Color.RED, Color.WHITE);
        Pinwheel pinwheel2 = new Pinwheel(200, Color.BLUE, Color.WHITE);

        HBox pickers = new HBox(colorPicker1, colorPicker2);

        VBox root = new VBox();
        root.setStyle("-fx-background-color: #0C0C32");
        root.getChildren().addAll(
                pickers,
                pinwheel.getBlock(),
                pinwheel2.getBlock()
        );
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize.width);
        System.out.println(screenSize.height);

        Scene scene = new Scene(root, screenSize.width, screenSize.height - 50);
        // Creates that window thingy
        stage.setTitle("Trung Bui");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
