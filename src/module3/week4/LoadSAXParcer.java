package module3.week4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ihar_Chekan on 4/7/2015.
 */
public class LoadSAXParcer extends DefaultHandler {

    private List<String> listOfCars = new ArrayList<String>();
    private String newString = "";

    boolean bModel = false;
    boolean bNumber = false;
    boolean bFuel = false;
    boolean bCost = false;


    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML document with Cars Info...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("car")) {
            //set newString to empty
            newString = "";
            //set string values
        } else {
            if (qName.equalsIgnoreCase("carmodel")) {
                bModel = true;
            } else if (qName.equalsIgnoreCase("carnumber")) {
                bNumber = true;
            } else if (qName.equalsIgnoreCase("carfuelconsuming")) {
                bFuel = true;
            } else if (qName.equalsIgnoreCase("carcost")) {
                bCost = true;
            }
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bModel) {
            //age element, set Employee age
            newString += (new String(ch, start, length));
            bModel = false;
        } else if (bNumber) {
            newString += " " + (new String(ch, start, length));
            bNumber = false;
        } else if (bFuel) {
            newString += " " + (new String(ch, start, length));
            bFuel = false;
        } else if (bCost) {
            newString += " " + (new String(ch, start, length));
            bCost = false;
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("car")) {
            //add new car to list
            listOfCars.add(newString);
        }
    }

    public List<String> getLoadedListString () {
        return listOfCars;
    }

}
