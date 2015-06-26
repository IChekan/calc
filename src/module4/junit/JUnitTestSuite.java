package module4.junit;

import module4.junit.categories.FirstInterface;
import module4.junit.categories.SecondInterface;
import module4.junit.tests.TestListToString;
import module4.junit.tests.TestSorting;
import module4.junit.tests.TestSpeed;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Ihar_Chekan on 4/23/2015.
 */

@RunWith(Suite.class)
//@RunWith(Categories.class)
@Categories.IncludeCategory(FirstInterface.class)
@Categories.ExcludeCategory(SecondInterface.class)
@Suite.SuiteClasses({TestSorting.class, TestSpeed.class, TestListToString.class})
public class JUnitTestSuite {

    @BeforeClass
    public static void doNothingBefore() {

    }

    @AfterClass
    public static void doNothingAfter() {

    }


}
