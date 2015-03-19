package module3week1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import module3week2.Module3Task2SpeedTest;
import org.apache.commons.lang3.StringUtils;

public class Module3Task1Calculator {

    //map of all controls
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
    @FXML
    CheckBox sortingCheckbox;
    @FXML
    Button buttonBackspace;
    @FXML
    Button buttonAddSpeedTest;
    @FXML
    Button buttonGetSpeedTest;
    @FXML
    Button buttonDelSpeedTest;
    @FXML
    Button buttonHelp;

    private String input = "";
    private String result = "0";
    private String math = "na";
    private float floatA = 0;

    //write something at launch
    @FXML
    void initialize() {
        inputField.setText(input);
        outputField.setText("Press something :)");
    }

    //set desired actions to all buttons
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
            else if (event.getTarget() == buttonBackspace) {
                input = StringUtils.chop(input);
                inputField.setText(input); }
            else if (event.getTarget() == buttonAddSpeedTest)
                buttonAddSpeedTestAction();
            else if (event.getTarget() == buttonGetSpeedTest)
                buttonGetSpeedTestAction();
            else if (event.getTarget() == buttonDelSpeedTest)
                buttonDelSpeedTestAction();
        }
    }

    private void buttonAction (String buttonNumber){
        input = input + buttonNumber;
        inputField.setText(input);
    }

    // clear button action
    private void buttonClearAction () {
        input = "";
        result = "0";
        inputField.setText(input);
        outputField.setText("cleared");
    }

    // "=" button action
    private void buttonEqualAction (String inputEqual) {

        String[] arraySymbolsEntered = inputEqual.split("([0-9]+)");
        String[] arrayNumbersEntered = inputEqual.split("(\\-|\\+|\\*|\\/)");

        //this "if" was added for Module3Task2Sorting hometask
        if (sortingCheckbox.isSelected()) {
            arrayNumbersEntered = Module3Task2Sorting.sortArrayNumbers(arrayNumbersEntered);
        }

        for(int n=0; n<arrayNumbersEntered.length -1; n++) {
            String splitString;
            if (n==0) {
                splitString = arrayNumbersEntered[n] + arraySymbolsEntered[n + 1] + arrayNumbersEntered[n + 1];
            }
            else {
                splitString = result + arraySymbolsEntered[n + 1] + arrayNumbersEntered[n + 1];
            }
            executeStart(splitString);
        }
        outputField.setText(result);
    }

    private void executeStart(String splitString) {
        mathAnalyzer(splitString);

        String strA = splitString.substring(0, splitString.indexOf(math));
        String strB = splitString.substring(splitString.indexOf(math) +1);

        floatA = new Float(strA);
        Float floatB = Float.parseFloat(strB);

        calculations(floatA, floatB);

        result = Float.toString(floatA);
    }

    private void mathAnalyzer (String splitString) {
        if (splitString.contains("/")) {
            math = "/";}
        else if (splitString.contains("*")) {
            math = "*";}
        else if (splitString.contains("+")) {
            math = "+";}
        else if (splitString.contains("-")) {
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

    //was added for module3 week2 2nd task hometask
    private void buttonAddSpeedTestAction () {
        Integer listsLength = new Integer(input);
        result = Module3Task2SpeedTest.testAddElement(listsLength);
        outputField.setText(result);
    }

    //was added for module3 week2 2nd task hometask
    private void buttonGetSpeedTestAction () {
        Integer listsLength = new Integer(input);
        result = Module3Task2SpeedTest.testGetElement(listsLength);
        outputField.setText(result);
    }

    //was added for module3 week2 2nd task hometask
    private void buttonDelSpeedTestAction () {
        Integer listsLength = new Integer(input);
        result = Module3Task2SpeedTest.testDelElement(listsLength);
        outputField.setText(result);
    }

}
