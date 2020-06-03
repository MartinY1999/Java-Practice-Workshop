package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grid {
    private int horizontalLines;
    private int verticalLines;
    private BigInteger pathsCount;
    private Scene scene;
    private Group group;
    private final int sceneSize = 500;
    private int horLinesSpace;
    private int verLinesSpace;

    public Grid(){
        this.scene = new Scene(new Group(), sceneSize, sceneSize);
    }

    public Grid(int horizontalLines, int verticalLines){
        this.scene = new Scene(new Group(), sceneSize, sceneSize);
        this.group = new Group();
        this.horizontalLines = horizontalLines;
        this.verticalLines = verticalLines;
        this.horLinesSpace = sceneSize / horizontalLines;
        this.verLinesSpace = sceneSize / verticalLines;
    }

    public int getHorizontalLines() { return this.horizontalLines; }

    public int getVerticalLines() { return this.verticalLines; }

    public Scene getScene() { return this.scene;}

    public BigInteger getPathsCount(){
        BigInteger upResult = BigInteger.ONE;
        BigInteger downResult = BigInteger.ONE;

        for (int i = this.horizontalLines + this.verticalLines; i > Math.max(this.horizontalLines, this.verticalLines); i--){
            upResult = upResult.multiply(BigInteger.valueOf(i));
        }

        for (int i = Math.min(this.horizontalLines, this.verticalLines); i > 0; i--){
            downResult = downResult.multiply(BigInteger.valueOf(i));
        }

        return upResult.divide(downResult);
    }

    public void drawGrid(){
        drawLines();
        drawPath();

        this.scene = new Scene(this.group);
    }

    private void drawLines(){
        int horCoordY = 0;
        int verCoordX = 0;

        for (int i = 1; i <= this.horizontalLines; i++){
            Line line = new Line(0, horCoordY, sceneSize, horCoordY);
            line.setStroke(Color.BLACK);
            this.group.getChildren().add(line);

            horCoordY += horLinesSpace;
        }

        for (int i = 1; i <= this.verticalLines; i++){
            Line line = new Line(verCoordX, 0, verCoordX, sceneSize);
            line.setStroke(Color.BLACK);
            this.group.getChildren().add(line);

            verCoordX += verLinesSpace;
        }
    }

    public void drawPath(){

        List<String> path = createPath();
        double startPointX = 0;
        double startPointY = 0;
        for (int i = 0; i < path.size(); i++){
            if (path.get(i).equals("R")){
                Line horizontalLine = new Line(startPointX, startPointY, startPointX + horLinesSpace, startPointY);
                horizontalLine.setStroke(Color.RED);
                horizontalLine.setStrokeWidth(5.0f);
                this.group.getChildren().add(horizontalLine);

                startPointX += horLinesSpace;
            }
            else if (path.get(i).equals("D")){
                Line verticalLine = new Line(startPointX, startPointY, startPointX, startPointY + verLinesSpace);
                verticalLine.setStroke(Color.RED);
                verticalLine.setStrokeWidth(5.0f);
                this.group.getChildren().add(verticalLine);

                startPointY += verLinesSpace;
            }
        }
    }

    private List<String> createPath(){
        List<String> steps = new ArrayList<String>();
        for (int i = 1; i <= this.horizontalLines; i++){
            steps.add("R");
        }
        for (int i = 1; i <= this.verticalLines; i++){
            steps.add("D");
        }

        Collections.shuffle(steps);

        return steps;
    }
}
