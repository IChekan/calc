package module3.week2.task3TaxiPark;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ihar_Chekan on 3/24/2015.
 */
public class Util {

    public static List<CarModel> Sort(List<CarModel> listToSort) {
        Collections.sort(listToSort, new Comparator<CarModel>() {
            @Override
            public int compare(CarModel o1, CarModel o2) {
                return o1.getCarFuelConsuming().compareTo(o2.getCarFuelConsuming());
            }
        });
        return listToSort;
    }

    public static String findByCarModel(String searchValue, List<CarModel> list) {
        String out = "";
        for (CarModel carList : list) {
            if(searchValue.equals(carList.getCarModel())){
                out = out + carList.getCarInfo() + "\n";
            }
        }
        return out;
    }
}
