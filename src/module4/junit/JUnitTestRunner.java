package module4.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Ihar_Chekan on 4/23/2015.
 */
public class JUnitTestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JUnitTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

    }



}
