package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();
        Scene scene = new Scene(group, 600, 600);

        double lowerSize = Math.min(scene.getHeight(), scene.getWidth());

        upperLeftPart(group, lowerSize);
        upperRightPart(group, lowerSize);
        lowerLeftPart(group, lowerSize);
        lowerRightPart(group, lowerSize);

        primaryStage.setTitle("Shapes Scene");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void upperLeftPart(Group group, double size){
        int dLine = 0;
        while (dLine <= size){
            Line line = new Line(0, dLine, dLine, size);
            line.setStroke(Color.ORANGE);
            group.getChildren().add(line);
            dLine += 20;
        }
    }

    private static void upperRightPart(Group group, double size){
        int dLine = 0;
        while (dLine <= size){
            Line line = new Line(size, dLine, size - dLine, size);
            line.setStroke(Color.ORANGE);
            group.getChildren().add(line);
            dLine += 20;
        }
    }

    private static void lowerLeftPart(Group group, double size){
        int dLine = 0;
        while (dLine <= size){
            Line line = new Line(0, dLine, size - dLine, 0);
            line.setStroke(Color.ORANGE);
            group.getChildren().add(line);
            dLine += 20;
        }
    }

    private static void lowerRightPart(Group group, double size){
        int dLine = 0;
        while (dLine <= size){
            Line line = new Line(size, dLine, dLine, 0);
            line.setStroke(Color.ORANGE);
            group.getChildren().add(line);
            dLine += 20;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
