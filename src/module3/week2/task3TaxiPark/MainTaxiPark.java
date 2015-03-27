package module3.week2.task3TaxiPark;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import module3.main.Navigator;

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
    public void AddCarToList(ActionEvent event){
        Double carCost = Double.parseDouble(fieldCarCost.getText());
        String carNumber = fieldCarNumber.getText();
        Double carFuelConsuming = Double.parseDouble(fieldCarFuelConsuming.getText());
        String carModel = fieldCarModel.getText();

        listAllCars.add(new CarModel(carModel, carNumber, carFuelConsuming, carCost));

        fieldOutput.setText("Car with number #" + carNumber + " added to list");

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
            out = out + "\n" + list.getCarInfo();
        }

        fieldOutput.setText(out);
    }

    public void SearchByCarModel(ActionEvent event) {
        fieldOutput.setText(Util.findByCarModel(fieldCarModel.getText(), listAllCars));
    }
}
