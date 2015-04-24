package module4.junit.tests;

import module3.week2.task3TaxiPark.CarModel;
import module3.week3.Task2SaveLoad;
import module4.junit.categories.FirstInterface;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ihar_Chekan on 4/24/2015.
 */

@RunWith(JUnit4.class)
public class TestListToString {

    @Category(FirstInterface.class)
    @Test
    public void testListToString(){

        List<CarModel> list = new ArrayList<>();
        list.add(new CarModel("Nissan", "TX-4567", 23.0 , 5000.0));

        Assert.assertEquals("List to String failed", "Nissan TX-4567 23.0 5000.0\n", Task2SaveLoad.ListToString(list));
    }

}
