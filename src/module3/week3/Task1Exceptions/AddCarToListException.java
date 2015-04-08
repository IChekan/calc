package module3.week3.Task1Exceptions;

/**
 * Created by Ihar_Chekan on 4/8/2015.
 */
public class AddCarToListException extends Exception{

    private String msg;

    public AddCarToListException() {
    }

    public static String getAddCarToListException() {
        return "Please enter Number and Model of the car! Also enter Cost and Consuming in numbers!";
    }
}
