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
public class LoadFromDB {

    private static final String DATABASE_PROPERTIES = "src/module3/resources/database.prop";

    static Properties pr = new Properties();

    static {
        try {
            FileInputStream inp = new FileInputStream(DATABASE_PROPERTIES);
            pr.load(inp);
            inp.close();
        } catch (IOException e) {e.printStackTrace();}
    }

    static String databaseURL = pr.getProperty("dbURL");
    static String user = pr.getProperty("user");
    static String password = pr.getProperty("password");
    static String driverName = pr.getProperty("driver");

    private static Connection con = null;

    private static void StartDriverAndConnection (){
        try {
            Class.forName(driverName);
            System.out.println("OK !!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql JDBC driver not found");
        }

        try {
            con = DriverManager.getConnection(databaseURL, user, password);
            System.out.println("Connect");
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
    }

    public static List<CarModel> LoadDB() {
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
