package ca.bcit.comp2522.assignments.A3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;


public class Driver extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ColorPicker colorPicker1 = new ColorPicker(Color.RED);
        ColorPicker colorPicker2 = new ColorPicker(Color.WHITE);
        ColorPicker colorPicker3 = new ColorPicker(Color.ORANGE);
        colorPicker1.setOnAction(e -> {
            colorPicker1.getValue();
        });
        colorPicker2.setOnAction(e -> {
            colorPicker2.getValue();
        });
        colorPicker3.setOnAction(e -> {
            colorPicker3.getValue();
        });

        Pinwheel pinwheel = new Pinwheel(200);
        Pinwheel pinwheel2 = new Pinwheel(200);
        Hourglass hourglass = new Hourglass(200);
        TwistedFourStar twistedFourStar = new TwistedFourStar(100);
        pinwheel.getColorProperty(0).bind(colorPicker1.valueProperty());
        pinwheel.getColorProperty(1).bind(colorPicker2.valueProperty());
        HBox pickers = new HBox(colorPicker1, colorPicker2);


        VBox root = new VBox();
        root.setStyle("-fx-background-color: #0C0C32");
        root.getChildren().addAll(
                pickers,
                pinwheel.getBlock(),
                pinwheel2.getBlock(),
                hourglass.getBlock(),
                twistedFourStar.getBlock()
        );
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize.width);
        System.out.println(screenSize.height - 69);

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
