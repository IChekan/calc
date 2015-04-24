package module4.junit.tests;

import module3.week1.Task2Sorting;
import module4.junit.categories.FirstInterface;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Ihar_Chekan on 4/23/2015.
 */

@RunWith(JUnit4.class)
@Category(FirstInterface.class)
public class TestSorting {

    @Test
    @Ignore
    public void testSortingNumbers() {

        String[] inputString = {"12", "4444", "6"};
        String[] referenceString = {"6", "12", "4444"};

        Assert.assertArrayEquals("Sorting of numbers failed", referenceString, Task2Sorting.sortArrayNumbers(inputString));
    }

    @Test
    public void testSortingChars() {

        String[] inputString = {"zzzz", "ab", "t"};
        String[] referenceString = {"t", "ab", "zzzz"};

        Assert.assertArrayEquals("Sorting of chars failed", referenceString, Task2Sorting.sortArrayNumbers(inputString));
    }

    @Test
    public void testSortingSpecial() {

        String[] inputString = {"!@#$", "%^", "&"};
        String[] referenceString = {"&", "%^", "!@#$"};

        Assert.assertArrayEquals("Sorting of chars failed", referenceString, Task2Sorting.sortArrayNumbers(inputString));
    }



}
