package ca.bcit.comp2522.labs.lab07;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;

/**
 * Demonstrates how to use JavaFX.
 *
 * @author Jacky Zheng
 * @author BCIT
 * @version 2019
 */
public class JackyFace extends Application {

    /**
     * Displays a self portrait of my face.
     *
     * @param primaryStage a Stage
     */
    public void start(Stage primaryStage) {
        // Setting up face
        Circle face = new Circle(250, 250, 80);
        Circle leftPupil = new Circle(200, 240, 10);
        Circle rightPupil = new Circle(300, 240, 10);

        Ellipse leftEye = new Ellipse(200, 240, 30, 10);
        Ellipse rightEye = new Ellipse(300, 240, 30, 10);

        Circle leftIris = new Circle(200, 240, 5);
        Circle rightIris = new Circle(300, 240, 5);

        Rectangle leftEyebrow = new Rectangle(170, 200, 50, 10);
        Rectangle rightEyebrow = new Rectangle(280, 200, 50, 10);

        Line stubble1 = new Line(230, 325, 230, 330);
        Line stubble2 = new Line(233, 325, 233, 330);
        Line stubble3 = new Line(236, 325, 236, 330);
        Line stubble4 = new Line(239, 325, 239, 330);
        Line stubble5 = new Line(242, 325, 242, 330);
        Line stubble6 = new Line(245, 325, 245, 330);
        Line stubble7 = new Line(248, 325, 248, 330);
        Line stubble8 = new Line(251, 325, 251, 330);
        Line stubble9 = new Line(254, 325, 254, 330);
        Group stubble = new Group(stubble1, stubble2, stubble3, stubble4, stubble5, stubble6, stubble7, stubble8, stubble9);

        // Mouth
        Arc mouth = new Arc();
        mouth.setCenterX(250);
        mouth.setCenterY(310);
        mouth.setRadiusX(25);
        mouth.setRadiusY(18);
        mouth.setStartAngle(0);
        mouth.setLength(180);
        mouth.setType(ArcType.ROUND);

        // Colours
        face.setFill(Color.PEACHPUFF);
        leftEye.setFill(Color.WHITE);
        rightEye.setFill(Color.WHITE);
        leftPupil.setFill(Color.BROWN);
        rightPupil.setFill(Color.BROWN);

        // Transformations
        // Shearing eyebrows
        Shear shearLeft = new Shear();
        shearLeft.setPivotX(170);
        shearLeft.setPivotY(200);
        shearLeft.setX(0.7);
        shearLeft.setY(0.0);
        leftEyebrow.getTransforms().add(shearLeft);

        Shear shearRight = new Shear();
        shearRight.setPivotX(270);
        shearRight.setPivotY(200);
        shearRight.setX(-0.7);
        shearRight.setY(0.0);
        rightEyebrow.getTransforms().add(shearRight);

        // Rotating Eyebrows
        rightEyebrow.setRotate(-15);
        leftEyebrow.setRotate(15);

        // Translating stubble and head
        stubble.setTranslateX(10);
        stubble.setTranslateY(5);

        // Add an image and immediately wrap it in a view
        Image gull = new Image("gull.jpg");
        ImageView gullImageView = new ImageView(gull);
        final int viewX = 0;
        final int viewY = 0;
        final int viewWidth = 400;
        final int viewHeight = 400;

        // Set the size of the ImageView using a Rectangle2D
        gullImageView.setViewport(new Rectangle2D(viewX, viewY, viewWidth, viewHeight));

        // Group together face features
        Group faceGroup = new Group(face, leftEye, rightEye, leftEyebrow,
                rightEyebrow, mouth, leftPupil, rightPupil, leftIris, rightIris, stubble);
        Group root = new Group(gullImageView, faceGroup);

        // Translate, scale, and rotate head
        faceGroup.setTranslateX(-85);
        faceGroup.setTranslateY(-10);
        faceGroup.setRotate(15);
        faceGroup.setScaleX(0.9);
        faceGroup.setScaleY(0.9);

        final int appWidth = 400;
        final int appHeight = 400;
        Scene scene = new Scene(root, appWidth, appHeight, Color.WHITE);

        primaryStage.setTitle("Jacky Face");
        primaryStage.setScene(scene);
        primaryStage.show();
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