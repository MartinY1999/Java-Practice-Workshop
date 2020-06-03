package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField firstNum;

    @FXML
    private TextField secondNum;

    @FXML
    private TextField gcdResult;

    @FXML
    private Button computeGCD;

    @FXML
    private int getFirstNum(){
        return Integer.parseInt(firstNum.getText());
    }

    @FXML
    private int getSecondNum(){
        return Integer.parseInt(secondNum.getText());
    }

    @FXML
    private void computeGCDClick(){
        int gcd = returnGCD(getFirstNum(), getSecondNum());
        gcdResult.setText(String.valueOf(gcd));
    }

    @FXML
    private void quitClick(){
        Platform.exit();
    }

    private int returnGCD(int number1, int number2){
        if(number2 == 0){
            return number1;
        }

        return returnGCD(number2, number1%number2);
    }
}
