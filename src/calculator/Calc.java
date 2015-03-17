package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Calc {

    @FXML
    Button button0;
    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button4;
    @FXML
    Button button5;
    @FXML
    Button button6;
    @FXML
    Button button7;
    @FXML
    Button button8;
    @FXML
    Button button9;
    @FXML
    Button buttonMinus;
    @FXML
    Button buttonPlus;
    @FXML
    Button buttonMultiply;
    @FXML
    Button buttonDivide;
    @FXML
    Button buttonEqual;
    @FXML
    Button buttonClear;
    @FXML
    Label outputField;
    @FXML
    Label inputField;

    private String input = "";
    private String result = "0";
    private String math = "na";
    private float floatA = 0;
    private float floatB = 0;

    @FXML
    void initialize() {
        inputField.setText(input);
        outputField.setText("Press something :)");
    }

    @FXML
    void buttonInit (ActionEvent event) {
        if (event.getTarget() instanceof Button) {
            if (event.getTarget() == button0)
                buttonAction("0");
            else if (event.getTarget() == button1)
                buttonAction("1");
            else if (event.getTarget() == button2)
                buttonAction("2");
            else if (event.getTarget() == button3)
                buttonAction("3");
            else if (event.getTarget() == button4)
                buttonAction("4");
            else if (event.getTarget() == button5)
                buttonAction("5");
            else if (event.getTarget() == button6)
                buttonAction("6");
            else if (event.getTarget() == button7)
                buttonAction("7");
            else if (event.getTarget() == button8)
                buttonAction("8");
            else if (event.getTarget() == button9)
                buttonAction("9");
            else if (event.getTarget() == buttonMinus)
                buttonAction("-");
            else if (event.getTarget() == buttonPlus)
                buttonAction("+");
            else if (event.getTarget() == buttonMultiply)
                buttonAction("*");
            else if (event.getTarget() == buttonDivide)
                buttonAction("/");
            else if (event.getTarget() == buttonClear)
                buttonClearAction();
            else if (event.getTarget() == buttonEqual)
                buttonEqualAction(input);
        }
    }

    private void buttonAction (String buttonNumber){
        input = input + buttonNumber;
        inputField.setText(input);
    }

    private void buttonClearAction () {
        input = "";
        result = "0";
        inputField.setText(input);
        outputField.setText("cleared");
    }

    private void buttonEqualAction (String inputEqual) {
        mathAnalyzer(inputEqual);

        String strA = inputEqual.substring(0, inputEqual.indexOf(math));
        String strB = inputEqual.substring(inputEqual.indexOf(math) +1);

        floatA = new Float(strA);
        floatB = Float.parseFloat(strB);

        calculations(floatA, floatB);

        result = Float.toString(floatA);

        outputField.setText(result);
    }

    private void mathAnalyzer (String inputEqual) {
        if (inputEqual.contains("/")) {
            math = "/";}
        else if (inputEqual.contains("*")) {
            math = "*";}
        else if (inputEqual.contains("+")) {
            math = "+";}
        else if (inputEqual.contains("-")) {
            math = "-";}
        else {
            outputField.setText("ERROR");
        }
    }

    private void calculations (Float aFloat, Float bFloat) {
        if (math == "/") {
            floatA = aFloat / bFloat;
        }
        else if (math == "*") {
            floatA = aFloat * bFloat;
        }
        else if (math == "+") {
            floatA = aFloat + bFloat;
        }
        else if (math == "-") {
            floatA = aFloat - bFloat;
        }
    }

}
