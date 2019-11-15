package ca.bcit.comp2522.assignments.A3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;


public class Driver extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Pinwheel pinwheel = new Pinwheel(200);
        Pinwheel pinwheel2 = new Pinwheel(200);

        HBox pickers = new HBox(pinwheel.getColorPicker1(), pinwheel.getColorPicker2());
        HBox pickers2 = new HBox(pinwheel2.getColorPicker1(), pinwheel2.getColorPicker2());

        VBox root = new VBox();
        root.setStyle("-fx-background-color: #0C0C32");
        root.getChildren().addAll(
                pickers,
                pinwheel.getBlock(),
                pickers2,
                pinwheel2.getBlock()
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
