package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();
        java.util.Scanner scanner = new Scanner(System.in);

        int order = scanner.nextInt();
        int length = scanner.nextInt();

        paintTree(pane, order, 200, 350, length, 180);

        primaryStage.setTitle("Recursive Tree");
        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.show();
    }

    private void paintTree(Pane pane, int order, int originX, int originY, int length, double angle){
        if (order == -1)
            return;

        Point endPoints = calculatePoint(originX, originY, length, angle);
        Line line = new Line(originX, originY, endPoints.x, endPoints.y);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(1);

        pane.getChildren().add(line);
        paintTree(pane, order - 1, endPoints.x, endPoints.y, length / 2 + 10, angle - 30);
        paintTree(pane, order - 1, endPoints.x, endPoints.y, length / 2 + 10, angle + 30);
    }

    private static Point calculatePoint(int x, int y, double size, double degree) {
        Point point = new Point(x, y);
        double radians = Math.PI / 180 * degree;

        point.x += (int) (size * Math.sin(radians)); //new x point for end of branch
        point.y += (int) (size * Math.cos(radians)); //new y point for end of branch
        return point;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
