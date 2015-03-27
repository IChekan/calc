package module3.week2.task3TaxiPark;

/**
 * Created by Ihar_Chekan on 3/25/2015.
 */
public class CarSpecifications {

    protected String carNumber;
    protected Double carFuelConsuming;
    protected Double carPrice;

    public CarSpecifications(String carNumber, Double carFuelConsuming, Double carPrice){
        this.carNumber = carNumber;
        this.carFuelConsuming = carFuelConsuming;
        this.carPrice = carPrice;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Double getCarFuelConsuming() {
        return carFuelConsuming;
    }

    public void setCarFuelConsuming(Double carFuelConsuming) {
        this.carFuelConsuming = carFuelConsuming;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }


    public String getSpecificationsInfo(){
        return "Number: " + this.carNumber + ", Fuel Consuming: " + this.carFuelConsuming + ", Price: " + this.carPrice;
    }


}
