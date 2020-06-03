package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main extends Application {

    private TextArea txaInputArr;
    private TextField txtOrderInput;
    private TextArea txaOutputArr;

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane root = new AnchorPane();
        GridPane pane = new GridPane();
        root.getChildren().add(pane);

        Random random = new Random();
        int size = random.nextInt(1000);
        int[] readArray = generateArray(size);
        CountingSortController countingSort = new CountingSortController(readArray);

        txaInputArr = new TextArea();
        txaInputArr.setPrefColumnCount(60);
        txaInputArr.setPrefRowCount(2);
        txaInputArr.setWrapText(true);
        txaInputArr.setEditable(false);
        txaInputArr.setText(countingSort.toString());

        txtOrderInput = new TextField();
        txtOrderInput.setPrefColumnCount(60);

        txaOutputArr = new TextArea();
        txaOutputArr.setPrefColumnCount(60);
        txaOutputArr.setPrefRowCount(2);
        txaOutputArr.setWrapText(true);
        txaOutputArr.setEditable(false);

        Label lblInputArr = new Label();
        lblInputArr.setText("The unsorted array:");

        Label lblOrderInput = new Label();
        lblOrderInput.setText("Ascending order [yY]?");

        Label lblOutputArr = new Label();
        lblOutputArr.setText("The sorted array:");

        Button btnSort = new Button();
        btnSort.setText("Sort");
        btnSort.setOnAction(event -> sortAndOutput(countingSort));

        Button btnQuit = new Button();
        btnQuit.setText("Quit");
        btnQuit.setOnAction(event -> Platform.exit());

        pane.add(lblInputArr, 0, 0);
        pane.add(txaInputArr, 1, 0);
        pane.add(lblOrderInput, 0, 1);
        pane.add(txtOrderInput, 1, 1);
        pane.add(lblOutputArr, 0, 2);
        pane.add(txaOutputArr, 1, 2);
        pane.add(btnSort, 0, 3);
        pane.add(btnQuit, 1, 3);

        pane.setHgap(8);
        pane.setVgap(8);

        AnchorPane.setLeftAnchor(root, 8.0);
        AnchorPane.setRightAnchor(root, 8.0);
        AnchorPane.setTopAnchor(root, 8.0);
        AnchorPane.setBottomAnchor(root, 8.0);

        primaryStage.setTitle("Counting Sort");
        primaryStage.setScene(new Scene(root, 1000, 200));
        primaryStage.show();
    }

    private void sortAndOutput(CountingSortController countingSort) {
        String userChoice = txtOrderInput.getText();
        boolean sortingChoice = userChoice.equals("true") ? true : false;
        countingSort.sort(sortingChoice);
        txaOutputArr.setText(countingSort.toString());
    }

    public static int[] generateArray(int size){
        int[] array = new int[size];
        Random generator = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = generator.nextInt(1000);
        }

        return array;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
