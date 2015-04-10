package module3.week3;


import javafx.stage.FileChooser;
import javafx.stage.Stage;
import module3.week2.task3TaxiPark.CarModel;
import module3.week4.AbstractLoad;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ihar_Chekan on 4/3/2015.
 */
public class Task2SaveLoad extends AbstractLoad {

    public static File loadFileDialog() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Load File dialog. Please choose file to load...");
        return chooser.showOpenDialog(new Stage());
    }

    public static File saveFileDialog() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save File dialog. Please choose where to save...and file name too.");
        return chooser.showSaveDialog(new Stage());
    }

    public static String ListToString(List<CarModel> listToString){
        String stringToSave = "";
        for (CarModel list : listToString) {
            stringToSave += list.getCarModel() + " " + list.getCarNumber() + " " + list.getCarFuelConsuming() + " " + list.getCarPrice() + "\n";
        }

        return stringToSave;
    }

    public static void WriteString(String fullPath, String stringToWrite) {

        File file = new File(fullPath);

        try {
            //Is not needed as new file is created by javafx library
//            if(!file.exists()){
//                file.createNewFile();
//            }
            //file writer
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(stringToWrite);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CarModel> Load(String fullPath) {

        File file = new File(fullPath);
        List<CarModel> loadedList = new ArrayList<>();

        try {
            //Reads file into buffer
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    String[] words = s.split(" ");
                    Double carCost = Double.parseDouble(words[3]);
                    String carNumber = words[1];
                    Double carFuelConsuming = Double.parseDouble(words[2]);
                    String carModel = words[0];

                    loadedList.add(new CarModel(carModel, carNumber, carFuelConsuming, carCost));
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return loadedList;
    }

}
