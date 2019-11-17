package ca.bcit.comp2522.assignments.A3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class NbyN extends Block {

    private Group block;

    public NbyN() {
        super();
        this.block = NbyN();
    }

    @Override
    public Group getBlock() {
        return block;
    }

    private Group NbyN() {
        Group group = new Group();
        for (int x = 0; x < getSizeInCm(); x += (getSizeInCm()/10)) {
            for (int y = 0; y < getSizeInCm(); y += (getSizeInCm()/10)) {
                Rectangle rectangle = new Rectangle(x, y, getSizeInCm() / 10, getSizeInCm() / 10);
                rectangle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                group.getChildren().add(rectangle);
            }
        }
        return group;
    }
}
