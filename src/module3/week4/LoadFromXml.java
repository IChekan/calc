package module3.week4;

import module3.week2.task3TaxiPark.CarModel;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ihar_Chekan on 4/7/2015.
 */
public class LoadFromXml {

    public static List<CarModel> LoadXml(String fullPath) {

        List<String> loadedListString = null;
        SAXParserFactory spfac = SAXParserFactory.newInstance();
        SAXParser sp;
        LoadSAXParcer handler = null;
        try {
            sp = spfac.newSAXParser();
            handler = new LoadSAXParcer();
            sp.parse(new File(fullPath), handler);
            loadedListString = handler.getLoadedListString();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Parsing fails: " + e.getMessage());
        }
        return StringToList(loadedListString);
    }

    private static List<CarModel> StringToList (List<String> inputString) {
        List<CarModel> loadedList = new ArrayList<>();

        for (String s : inputString) {
            String[] words = s.split(" ");
            Double carCost = Double.parseDouble(words[3]);
            String carNumber = words[1];
            Double carFuelConsuming = Double.parseDouble(words[2]);
            String carModel = words[0];

            loadedList.add(new CarModel(carModel, carNumber, carFuelConsuming, carCost));
        }
        return loadedList;
    }
}
