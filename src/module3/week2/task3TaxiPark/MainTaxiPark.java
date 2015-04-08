package module3.week2.task3TaxiPark;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import module3.runner.Navigator;
import module3.week3.Task1Exceptions.AddCarToListException;
import module3.week3.Task1Exceptions.FindByModelException;
import module3.week3.Task2SaveLoad;
import module3.week4.LoadFromDB;
import module3.week4.LoadFromXml;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ihar_Chekan on 3/24/2015.
 */
public class MainTaxiPark {

    List<CarModel> listAllCars = new ArrayList<>();

    //map of TaxiPark controls
    @FXML
    private TextField fieldCarFuelConsuming;

    @FXML
    private Button buttonFindCar;

    @FXML
    private TextField fieldCarCost;

    @FXML
    private TextField fieldCarModel;

    @FXML
    public Label fieldOutput;

    @FXML
    private Button buttonCostAllCars;

    @FXML
    private Button switchBackToCalc;

    @FXML
    private Button buttonAddCar;

    @FXML
    private Button buttonListAllCars;

    @FXML
    private TextField fieldCarNumber;

    @FXML
    private Button Save;

    @FXML
    private Button Load;

    @FXML
    private Button LoadFromDataBase;


    //Doing on start
    @FXML
    void initialize() {
    }

    @FXML
    void buttonInit (ActionEvent event) {
    }

    //Switch to other Scene
    @FXML
    void gotoCalcScene(ActionEvent event) {
        Navigator.loadScene(Navigator.SCENE_1);
    }

    @FXML
    public void AddCarToList(ActionEvent event) throws AddCarToListException{

        try {
            if (fieldCarCost.getText().equalsIgnoreCase("") || fieldCarNumber.getText().equalsIgnoreCase("") || fieldCarFuelConsuming.getText().equalsIgnoreCase("")
                    || fieldCarModel.getText().equalsIgnoreCase("")) {
                throw new AddCarToListException();
            }

            Double carCost = Double.parseDouble(fieldCarCost.getText());
            String carNumber = fieldCarNumber.getText();
            Double carFuelConsuming = Double.parseDouble(fieldCarFuelConsuming.getText());
            String carModel = fieldCarModel.getText();

            listAllCars.add(new CarModel(carModel, carNumber, carFuelConsuming, carCost));

            fieldOutput.setText("Car with number #" + carNumber + " added to list");

        }catch (NumberFormatException | AddCarToListException e) {
            fieldOutput.setText(AddCarToListException.getAddCarToListException());
        }


        //clearing fields
        fieldCarCost.setText("");
        fieldCarFuelConsuming.setText("");
        fieldCarModel.setText("");
        fieldCarNumber.setText("");
    }

    public void CostOfAllCars(ActionEvent event) {
        Double out = 0.0;
        for (CarModel list : listAllCars) {
            out = out + list.getCarFuelConsuming();
        }
        fieldOutput.setText("Cost of All cars: " + Double.toString(out));
    }

    public void ListOfAllCarsSorted(ActionEvent event) {
        String out = "";
        List<CarModel> listAllCarsSorted = Util.Sort(listAllCars);

        for (CarModel list : listAllCarsSorted) {
            out += list.getCarInfo() + "\n";
        }

        fieldOutput.setText(out);
    }

    public void SearchByCarModel(ActionEvent event) {
        try {
            fieldOutput.setText(Util.findByCarModel(fieldCarModel.getText(), listAllCars));
        } catch (FindByModelException e) {
            fieldOutput.setText(e.getFindByNameException());
        }
    }

    //was added for week3 task2 SaveLoad
    public void Save (ActionEvent event) {
        File file = Task2SaveLoad.saveFileDialog();
        //convert to string
        String stringToSave = Task2SaveLoad.ListToString(listAllCars);
        //saving
        Task2SaveLoad.WriteString(file.getPath(), stringToSave);

        fieldOutput.setText("File " + file.getName() + " saved");
    }

    //was added for week3 task2 SaveLoad and modified for week4 hometask
    public void Load (ActionEvent event) {
        File file = Task2SaveLoad.loadFileDialog();
        //clearing list
        listAllCars.clear();
        //gain extention of the file
        String ext = FilenameUtils.getExtension(file.getName());
        //loading from xml
        if (ext.equalsIgnoreCase("xml")){
            listAllCars = LoadFromXml.LoadXml(file.getPath());
        }
        //loading from plain file
        else {
            listAllCars = Task2SaveLoad.LoadTxt(file.getPath());
        }

        fieldOutput.setText("File " + file.getName() + " loaded");
    }

    //was added for week4 hometask
    public void LoadFromDataBase (ActionEvent event) {
        //clearing list
        listAllCars.clear();
        //loading
        listAllCars = LoadFromDB.LoadDB();

        fieldOutput.setText("Data from Database loaded!");
    }
}
