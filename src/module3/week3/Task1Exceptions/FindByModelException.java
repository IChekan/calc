package module3.week3.Task1Exceptions;

/**
 * Created by Ihar_Chekan on 4/8/2015.
 */
public class FindByModelException extends Exception{

    private String msg;

    public FindByModelException(String msg) {
        this.msg = msg;
    }

    public String getFindByNameException() {
        return "[FindByModelException]: There are not records with name='" + msg + "'!";
    }

}
