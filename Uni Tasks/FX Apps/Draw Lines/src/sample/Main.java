package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group(); // Create a layout Panel
        Scene scene = new Scene(group, 600, 600);
        double width = scene.getWidth();
        double height = scene.getHeight();
        double distance = 240;

        for (int i = 1; i <= 12; i++)
        {
            Ellipse circle = new Ellipse(300, 300, distance, distance);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            group.getChildren().add(circle);
            distance -= 20;
        }

        Line verticalDiameter = new Line(300,300,300,60);
        verticalDiameter.setStroke(Color.RED);
        group.getChildren().add(verticalDiameter);

        Line horizontalDiameter = new Line(300, 300, 60, 300);
        horizontalDiameter.setStroke(Color.RED);
        group.getChildren().add(horizontalDiameter);

        primaryStage.setTitle("Drawing circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
