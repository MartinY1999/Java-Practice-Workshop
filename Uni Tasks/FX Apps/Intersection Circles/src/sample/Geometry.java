package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Scanner;
public class Geometry extends Application {

    public static Scanner reader = new Scanner(System.in);

    @Override
    public void start(Stage primaryStage) throws Exception{
        double width = reader.nextDouble();
        double height = reader.nextDouble();

        Group group = new Group();
        Scene scene = new Scene(group, width, height);

        double radiusOfCenterCircle = Math.min(scene.getWidth(), scene.getHeight()) / 3;
        double centerX = scene.getWidth() / 2;
        double centerY = scene.getHeight() / 2;
        Circle circle = drawCircleInCenterOfScene(radiusOfCenterCircle, centerX, centerY);
        Line orthogonalLine = drawOrthogonalLine(scene);

        group.getChildren().add(circle);
        group.getChildren().add(orthogonalLine);

        if (intersection(group))
        {
            Shape collisionArea = Shape.intersect((Circle)group.getChildren().get(0), (Line)group.getChildren().get(1));
            Point upperPoint = new Point((int)orthogonalLine.getBoundsInParent().getMaxX(), (int)collisionArea.getBoundsInParent().getMinY());
            Point lowerPoint = new Point((int)orthogonalLine.getBoundsInParent().getMaxX(), (int)collisionArea.getBoundsInParent().getMaxY());

            group.getChildren().add(drawCircleInCenterOfScene(radiusOfCenterCircle / 3, upperPoint.x, upperPoint.y));
            group.getChildren().add(drawCircleInCenterOfScene(radiusOfCenterCircle / 3, lowerPoint.x, lowerPoint.y));
            group.getChildren().add(printTextCoordinates(upperPoint));
            group.getChildren().add(printTextCoordinates(lowerPoint));

            primaryStage.setTitle("IntersectionCircleShow");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else
            messageAlertForNotIntersection();
    }

    private static Circle drawCircleInCenterOfScene(double radius, double centerX, double centerY){
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.RED);
        return circle;
    }

    private static Line drawOrthogonalLine(Scene scene){
        double xAxis = reader.nextDouble();
        Line line = new Line(xAxis, 0, xAxis, scene.getHeight());
        line.setStroke(Color.BLUE);
        return line;
    }

    private static boolean intersection(Group group){
        if (group.getChildren().get(0).getBoundsInParent().intersects(group.getChildren().get(1).getBoundsInParent()))
            return true;

        return false;
    }

    private static void messageAlertForNotIntersection(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("WARNING!");
        alert.setContentText("Cannot proceed!");
        alert.showAndWait();
    }

    private static Text printTextCoordinates(Point point){
        Text pointCoordinates = new Text();
        pointCoordinates.setX(point.x - 55);
        pointCoordinates.setY(point.y);
        pointCoordinates.setText(String.format("[%d, %d]", point.x, point.y));
        pointCoordinates.setStroke(Color.BLACK);
        return pointCoordinates;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
