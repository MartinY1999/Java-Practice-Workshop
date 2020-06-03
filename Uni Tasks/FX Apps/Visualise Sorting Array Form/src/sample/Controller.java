package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Controller {
    private Integer[] unsortedArray;

    @FXML private Button buttonStart;
    @FXML private Button buttonQuit;
    @FXML private TextField txtFieldUnsortedArray;
    @FXML private TextField txtFieldSortingOption;
    @FXML private TextArea txtAreaSortedArray;
    @FXML private TextField txtFieldSearchElement;
    @FXML private TextField txtFieldSearchResult;

    @FXML private void buttonStartAction(ActionEvent handler){
        findElementInArray();
        sortArray();
    }

    @FXML private void generateArrayOnPressedKey(KeyEvent event){
        if (event.getCode() == KeyCode.E) {
            this.unsortedArray = generateArray();
            txtFieldUnsortedArray.setText(Arrays.toString(unsortedArray));
        }
    }

    @FXML private void buttonQuit(){
        Platform.exit();
    }

    private void sortArray(){
        if (txtFieldSortingOption.getText().equals("ascend"))
            Arrays.sort(this.unsortedArray);
        else if (txtFieldSortingOption.getText().equals("descend"))
            Arrays.sort(this.unsortedArray, Collections.reverseOrder());

        txtAreaSortedArray.setText(Arrays.toString(this.unsortedArray));
    }

    private void findElementInArray(){
        int element = Integer.valueOf(txtFieldSearchElement.getText());

        if (Arrays.asList(this.unsortedArray).contains(element)){
            int index = Arrays.asList(this.unsortedArray).indexOf(element);
            this.txtFieldSearchResult.setText(String.format("Found value in element %d", index + 1));
        }
        else
            this.txtFieldSearchResult.setText("Search key not found");
    }

    private Integer[] generateArray(){
        Random generator = new Random();

        int size = generator.nextInt(100);
        Integer[] array= new Integer[size + 2];

        for (int i = 0; i < array.length; i++){
            array[i] = generator.nextInt(1000);
        }

        return array;
    }
}
