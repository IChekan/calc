package module6.week1.tests;

import module6.week1.steps.Steps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Ihar_Chekan on 6/24/2015.
 */
public class SampleTest {


    private Steps steps;


    @BeforeClass( description = "setup env" )
    public void setup() throws Exception {
        steps = new Steps();
        steps.init();
    }


    @Test()
    @Parameters({"result"})
    public void someTest1(String result) throws Exception {

        steps.doMath();
        steps.doAssert(result);
        steps.erase();
    }

    @Test()
    @Parameters({"result"})
    public void someTest2(String result) throws Exception {

        steps.doMath();
        steps.doAssert(result);
        steps.eraseDecorator();
    }

}
