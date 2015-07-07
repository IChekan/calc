package module7.week1.tests;

import module7.week1.steps.Steps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Ihar_Chekan on 7/6/2015.
 */
public class LoginTest {

    private Steps steps = new Steps();

    @BeforeClass( description = "setup env" )
    public void setup() throws Exception {
        steps.initFirefoxBrowser();
    }

    @AfterClass
    public void close() {
        steps.close();
    }

    @Test
    @Parameters({"username", "password"})
    public void someTest1 (String username, String password) throws Exception {
        steps.login(username, password);
    }
}
