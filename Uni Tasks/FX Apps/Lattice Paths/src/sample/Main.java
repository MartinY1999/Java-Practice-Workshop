package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Grid grid = new Grid(20, 20);
        grid.drawGrid();

        System.out.println(grid.getPathsCount());

        primaryStage.setTitle("Lattice Paths");
        primaryStage.setScene(grid.getScene());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
