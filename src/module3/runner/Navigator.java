package module3.runner;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class Navigator {

    public static final String MAIN    = "../resources/main.fxml";
    public static final String SCENE_1 = "../resources/calc.fxml";
    public static final String SCENE_2 = "../resources/taxiPark.fxml";

    private static MainController mainController;

    public static void setMainController(MainController mainController) {
        Navigator.mainController = mainController;
    }

    public static void loadScene(String fxml) {
        try {
            mainController.setScene(
                    (Node) FXMLLoader.load(           /***<----***/
                            Navigator.class.getResource(
                                    fxml
                            )
                    ));
        } catch (IOException e) {
            //e.printStackTrace();          /***<----***/
        }
    }

}

