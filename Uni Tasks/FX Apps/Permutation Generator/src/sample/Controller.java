package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class Controller {
    @FXML
    private TextField generatedArray;

    @FXML
    private Button generateArrayButton;

    @FXML
    private TextArea printResultsField;

    @FXML
    private Button computePermutationsButton;

    @FXML
    private Button quitButton;

    private boolean integerMethodHasRun = false;
    private boolean stringMethodHasRun = false;
    private int[] numbers;
    private String characters;
    private HashSet<String> integerPermutations = new HashSet<String>();

    @FXML
    private void generateArray(){
        this.integerMethodHasRun = true;
        this.stringMethodHasRun = false;

        this.numbers = generate();
        String arrayText = Arrays.toString(this.numbers);
        generatedArray.setText(arrayText);
    }

    @FXML
    private void generateString(){
        this.stringMethodHasRun = true;
        this.integerMethodHasRun = false;

        byte[] array = new byte[3];
        new Random().nextBytes(array);
        this.characters = new String(array, Charset.forName("UTF-8"));
    }

    @FXML
    private void computePermutations(){
        if (integerMethodHasRun) {
            permute(this.numbers, 0, 0);
            for (String permutation : this.integerPermutations) {
                printResultsField.appendText(permutation + "\n");
            }
        }

        if (stringMethodHasRun){

        }
    }

    @FXML
    private void quitButton(){
        Platform.exit();
    }

    private static int[] generate(){
        Random generator = new Random();
        int[] array= new int[4];
        for (int i = 0; i < array.length; i++){
            array[i] = generator.nextInt(9);
        }

        return array;
    }

    private int[] swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

        return arr;
    }

    private void permute(int[] array, int i, int j) {
        for (; j < array.length && i < array.length; j++) {
            int[] temp = null;
            if (i != j) {
                temp =  swap(array, i, j);
                integerPermutations.add(Arrays.toString(temp));
            }else{
                temp = array;
            }
            permute(temp, i + 1, i + 1);
        }
    }

    //TO DO: Add string permutation availability;
}
