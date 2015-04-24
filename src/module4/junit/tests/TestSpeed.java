package module4.junit.tests;

import module3.week2.Task4SpeedTest;
import module3.week3.Task1Exceptions.SpeedTestException;
import module4.junit.categories.SecondInterface;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Ihar_Chekan on 4/23/2015.
 */

@RunWith(Parameterized.class)
@Category(SecondInterface.class)
public class TestSpeed {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{1}, {2}, {0}});
    }

    @Parameter
    public int numberOfElements;


    @Test(expected = SpeedTestException.class)
    public void testSpeedAddElement () throws SpeedTestException {

        Assert.assertEquals("Exception was not handled", "", Task4SpeedTest.testAddElement(numberOfElements));
    }

}
