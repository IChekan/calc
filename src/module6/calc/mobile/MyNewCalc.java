//package module6.calc.mobile;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//
//public class MyNewCalc extends Activity {
//    /**
//     * Called when the activity is first created.
//     */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        inputField = (TextView)findViewById(R.id.inputField);
//        outputField = (TextView)findViewById(R.id.outputField);
//    }
//
//
//    public String input ="";
//    private String result = "0";
//    private String math = "na";
//    private float floatA = 0;
//    public TextView inputField;
//    public TextView outputField;
//
//    public void btn1(View view) {
//        buttonAction("1");
//    }
//
//    public void btn2(View view) {
//        buttonAction("2");
//    }
//
//    public void btnPlus(View view) {
//        buttonAction("+");
//    }
//
//    private void buttonAction (String buttonNumber){
//        input = input + buttonNumber;
//        inputField.setText(input);
//    }
//
//    public void btnEquals(View view) {
//
//        String inputEqual = input;
//
//        String[] arraySymbolsEntered = inputEqual.split("([0-9]+)");
//        String[] arrayNumbersEntered = inputEqual.split("(\\-|\\+|\\*|\\/)");
//
//            for(int n=0; n<arrayNumbersEntered.length -1; n++) {
//                String splitString;
//                if (n==0) {
//                    splitString = arrayNumbersEntered[n] + arraySymbolsEntered[n + 1] + arrayNumbersEntered[n + 1];
//                }
//                else {
//                    splitString = result + arraySymbolsEntered[n + 1] + arrayNumbersEntered[n + 1];
//                }
//                executeStart(splitString);
//            }
//            outputField.setText(result);
//
//    }
//
//    public void btnErase(View view) {
//        input = "";
//        inputField.setText("Erased");
//        result = "0";
//        outputField.setText("Erased");
//    }
//
//    private void executeStart(String splitString) {
//        mathAnalyzer(splitString);
//
//        String strA = splitString.substring(0, splitString.indexOf(math));
//        String strB = splitString.substring(splitString.indexOf(math) +1);
//
//        floatA = new Float(strA);
//        Float floatB = Float.parseFloat(strB);
//
//        calculations(floatA, floatB);
//
//        result = Float.toString(floatA);
//    }
//
//    private void mathAnalyzer (String splitString) {
//        if (splitString.contains("/")) {
//            math = "/";}
//        else if (splitString.contains("*")) {
//            math = "*";}
//        else if (splitString.contains("+")) {
//            math = "+";}
//        else if (splitString.contains("-")) {
//            math = "-";}
//        else {
//            outputField.setText("ERROR");
//        }
//    }
//
//    private void calculations (Float aFloat, Float bFloat) {
//        if (math == "/") {
//            floatA = aFloat / bFloat;
//        }
//        else if (math == "*") {
//            floatA = aFloat * bFloat;
//        }
//        else if (math == "+") {
//            floatA = aFloat + bFloat;
//        }
//        else if (math == "-") {
//            floatA = aFloat - bFloat;
//        }
//    }
//}
