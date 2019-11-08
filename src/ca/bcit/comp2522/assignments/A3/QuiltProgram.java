package ca.bcit.comp2522.assignments.A3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class QuiltProgram extends Application {
    // Records the number of times the button is pressed.
    private int count;

    // Displays the number of times the button is pressed.
    private Text countText;

    public void start(Stage primaryStage) {
        count = 0;
        countText = new Text("Pushes: 0");

        // Instantiate a button object
        Button push = new Button("Push Me!");

        // Determine what happens when we press the button
        push.setOnAction(this::processButtonPress); // Wow!

        FlowPane pane = new FlowPane(push, countText);
        pane.setAlignment(Pos.CENTER);

        final int horizontalGap = 20;
        pane.setHgap(horizontalGap);
        pane.setStyle("-fx-background-color: lightgrey");

        final int appWidth = 300;
        final int appHeight = 100;
        Scene scene = new Scene(pane, appWidth, appHeight);

        primaryStage.setTitle("Push Counter Demo 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Updates the counter and text when the button is pushed.
     * @param event invokes this method
     */
    public void processButtonPress(ActionEvent event) {
        // Increments the count
        count++;

        // Updates the display
        countText.setText("Pushes: " + count);
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
