package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorController {

    @FXML private Button btnOne;
    @FXML private Button btnTwo;
    @FXML private Button btnThree;
    @FXML private Button btnFour;
    @FXML private Button btnFive;
    @FXML private Button btnSix;
    @FXML private Button btnSeven;
    @FXML private Button btnEight;
    @FXML private Button btnNine;
    @FXML private Button btnZero;
    @FXML private Button btnDoubleZero;
    @FXML private Button btnPlus;
    @FXML private Button btnMinus;
    @FXML private Button btnMultiply;
    @FXML private Button btnDivide;
    @FXML private Button btnDot;
    @FXML private Button btnEqual;
    @FXML private Button btnClear;
    @FXML private Button btnClearOnAction;
    @FXML private Button btnOff;
    @FXML private TextField txtResult;
    @FXML private double memory;

    @FXML private void btnPlusOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "+");
    }

    @FXML private void btnMinusOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "-");
    }

    @FXML private void btnMultiplicationOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "*");
    }

    @FXML private void btnDivideOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "/");
    }

    @FXML private void btnPointOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + ".");
    }

    @FXML private void btnNullOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "00");
    }

    @FXML private void btnZeroOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "0");
    }

    @FXML private void btnOneOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "1");
    }

    @FXML private void btnTwoOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "2");
    }

    @FXML private void btnThreeOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "3");
    }

    @FXML private void btnFourOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "4");
    }

    @FXML private void btnFiveOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "5");
    }

    @FXML private void btnSixOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "6");
    }

    @FXML private void btnSevenOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "7");
    }

    @FXML private void btnEightOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "8");
    }

    @FXML private void btnNineOnAction(ActionEvent event) {
        txtResult.setText(txtResult.getText() + "9");
    }

    @FXML private void btnClearsOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (txtResult.getText().isBlank()) {
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("The field is empty");
            alert.show();
        }
        else {
            txtResult.clear();
        }
    }

    @FXML private void btnClearsLastOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (txtResult.getText().isBlank()) {
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("The field is empty");
            alert.show();
        } else {
            String updated = txtResult.getText();
            updated = updated.substring(0, updated.length() - 1);
            txtResult.setText(updated);
        }
    }

    @FXML private void btnMemoryOnAction(ActionEvent event){
        memory = checkResult();
    }
    @FXML private void btnClearMemoryOnAction(ActionEvent event){
        memory = 0;
        txtResult.setText(" ");
    }
    @FXML private void btnSumWithMemory(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (memory == 0){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("Your memory is empty");
            alert.show();
        }else{
            String result = String.valueOf(memory + checkResult());
            txtResult.setText(result);
        }
    }

    @FXML private void btnSubtractWithMemory(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (memory == 0){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("Your memory is empty");
            alert.show();
        }else{
            String result = String.valueOf(memory - checkResult());
            txtResult.setText(result);
        }
    }

    //To Fix: Random result: 10 + 000.25 throws exception
    @FXML private double checkResult() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        String expression = txtResult.getText();
        int length = txtResult.getLength();
        String endCharacter = Character.toString(expression.charAt(length - 1));

        if (expression.charAt(0) == '.') {
            txtResult.setText("0 " + txtResult.getText());
        }
        for (int i = 0; i < length - 1; i++) {
            String character = Character.toString(expression.charAt(i));
            String nextCharacter = Character.toString(expression.charAt(i + 1));

            if (Character.isLetter(character.charAt(0))) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Wrong format! You cant input letters.");
                alert.show();
            }

            if (character.matches("[+\\-*\\.\\/]]")|| endCharacter.equals(' ')) {
                if (character.equals(nextCharacter)) {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Wrong format! You can't have two math symbols next to each other.");
                    alert.show();
                }
            }
        }

        if (endCharacter.matches("[+\\-*\\.\\/\\ ]")) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Wrong format!");
            alert.show();
        }

        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
        try {
            Object result = engine.eval(expression);
            txtResult.setText(result.toString());
        }
        catch (ScriptException e) {
            e.printStackTrace();
        }
        double expressionResult = Double.parseDouble(txtResult.getText());
        return expressionResult;
    }

    @FXML private void btnQuitOnAction(ActionEvent event) {
        System.exit(0);
    }
}
