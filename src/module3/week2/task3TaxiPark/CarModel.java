package module3.week2.task3TaxiPark;

/**
 * Created by Ihar_Chekan on 3/26/2015.
 */
public class CarModel extends CarSpecifications {

    protected String carModel;

    public CarModel(String carModel, String carNumber, Double carFuelConsuming, Double carPrice){
        super(carNumber, carFuelConsuming, carPrice);
        this.carModel = carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarInfo() {
        return "Car Model: " + getCarModel() + " " + super.getSpecificationsInfo();
    }
}
