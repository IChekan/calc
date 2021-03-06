package module3.week4;

import module3.week2.task3TaxiPark.CarModel;

import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Ihar_Chekan on 4/4/2015.
 */
public class LoadFromDB extends AbstractLoad{

    static Properties pr = new Properties();

    static String databaseURL;
    static String user;
    static String password;
    static String driverName;

    private static Connection con = null;

    private void SetDatabaseProperties(String fullPath){
        try {
            FileInputStream inp = new FileInputStream(fullPath);
            pr.load(inp);
            inp.close();
        } catch (IOException e) {e.printStackTrace();}
        databaseURL = pr.getProperty("dbURL");
        user = pr.getProperty("user");
        password = pr.getProperty("password");
        driverName = pr.getProperty("driver");
    }

    private void StartDriverAndConnection (){
        try {
            Class.forName(driverName);
            System.out.println("JDBC driver found");
        } catch (ClassNotFoundException e) {
            System.out.println("Postgresql JDBC driver not found");
        }

        try {
            con = DriverManager.getConnection(databaseURL, user, password);
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }

    @Override
    public List<CarModel> Load(String fullPath) {
        SetDatabaseProperties(fullPath);
        StartDriverAndConnection();

        Statement stmt = null;
        String query = "select * from carlist";
        List<CarModel> loadedList = new ArrayList<>();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Double carCost = rs.getDouble("carcost");
                String carNumber = rs.getString("carnumber");
                Double carFuelConsuming = rs.getDouble("carfuelconsuming");
                String carModel = rs.getString("carmodel");

                loadedList.add(new CarModel(carModel, carNumber, carFuelConsuming, carCost));
            }
        } catch (SQLException e ) {
            System.out.println(e);
        } finally {
            try {
                if (stmt != null) {stmt.close();}
            } catch (SQLException e) {
                System.out.println(e);
                }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println(e);
                }
        }

        return loadedList;
    }

}
