package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Scanner;

public class Main extends Application {

    private Scanner reader = new Scanner(System.in);

    @Override
    public void start(Stage primaryStage) throws Exception{
        double width = reader.nextDouble();
        double height = reader.nextDouble();
        Group group = new Group();
        Scene scene = new Scene(group, width, height);

        drawSquareSpiral(scene, group);

        primaryStage.setTitle("Draw square shaped spiral");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawSquareSpiral(Scene scene, Group group) {
        int timesToRotate = reader.nextInt(); // How many spirals loops to be done
        int lengthForPoints = reader.nextInt(); // How much the distance would be between the lines
        int lengthForLines = reader.nextInt(); // How long the lines will be
        int lengthForLinesOriginal = lengthForLines; // Keeping the original length of the first line length (used to customize further lengths)

        int currentX = (int)scene.getWidth() / 2; // center of the X at first
        int currentY = (int)scene.getHeight() / 2; // center of the Y at first

        Point downwardsStartingPoint = new Point(currentX, currentY); // Point which moves in every loop and corresponds to the lines that point downwards
        Point leftwardsStartingPoint = new Point(currentX, currentY + lengthForPoints); //Point which moves in every loop and corresponds to the lines that point leftwards
        Point upwardsStartingPoint = new Point(currentX - lengthForPoints, currentY + lengthForPoints); //Point which moves in every loop and corresponds to the lines that point upwards
        Point rightwardsStartingPoint = new Point(currentX - lengthForPoints, currentY - lengthForPoints); //Point which moves in every loop and corresponds to the lines that point rightwards

        while (timesToRotate > 0) {
            group.getChildren().add(drawLineDown(downwardsStartingPoint, lengthForLines));
            group.getChildren().add(drawLineLeft(leftwardsStartingPoint, lengthForLines));
            lengthForLines += lengthForLinesOriginal; // Increasing the length for the second pair of lines
            group.getChildren().add(drawLineUp(upwardsStartingPoint, lengthForLines));
            group.getChildren().add(drawLineRight(rightwardsStartingPoint, lengthForLines));

            timesToRotate--;
            lengthForLines += lengthForLinesOriginal;

            // Changing the points coordinates
            downwardsStartingPoint.x += lengthForPoints;
            downwardsStartingPoint.y -= lengthForPoints;
            leftwardsStartingPoint.x += lengthForPoints;
            leftwardsStartingPoint.y += lengthForPoints;
            upwardsStartingPoint.x -= lengthForPoints;
            upwardsStartingPoint.y += lengthForPoints;
            rightwardsStartingPoint.x -= lengthForPoints;
            rightwardsStartingPoint.y -= lengthForPoints;
        }
    }

    private Line drawLineDown(Point startingPoint, double lineLength) {
        double x = (double)startingPoint.x;
        double y = (double)startingPoint.y;

        Line lineDown = new Line(x, y, x, y + lineLength);
        lineDown.setStroke(Color.ORANGE);
        return lineDown;
    }

    private Line drawLineLeft(Point startingPoint, double lineLength){
        double x = (double)startingPoint.x;
        double y = (double)startingPoint.y;

        Line lineLeft = new Line(x, y, x - lineLength, y);
        lineLeft.setStroke(Color.ORANGE);
        return lineLeft;
    }

    private Line drawLineUp(Point startingPoint, double lineLength){
        double x = (double)startingPoint.x;
        double y = (double)startingPoint.y;

        Line lineUp = new Line(x, y, x, y - lineLength);
        lineUp.setStroke(Color.ORANGE);
        return lineUp;
    }

    private Line drawLineRight(Point startingPoint, double lineLength){
        double x = (double)startingPoint.x;
        double y = (double)startingPoint.y;

        Line lineRight = new Line(x, y, x + lineLength, y);
        lineRight.setStroke(Color.ORANGE);
        return lineRight;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
