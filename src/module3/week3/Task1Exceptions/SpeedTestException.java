package module3.week3.Task1Exceptions;

/**
 * Created by Ihar_Chekan on 4/8/2015.
 */
public class SpeedTestException extends Exception{

    private String msg;

    public SpeedTestException() {
    }

    public static String getSpeedTestException() {
        return "Number, that will be used for determine how large Array will be created has to be grater than 2!";
    }


}
