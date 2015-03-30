package module3.runner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("MyCalculator");

        stage.setScene(
                createScene(
                        loadMainPane()
                )
        );

        stage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(
                        Navigator.MAIN
                )
        );

        MainController mainController = loader.getController();

        Navigator.setMainController(mainController);
        Navigator.loadScene(Navigator.SCENE_1);

        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
                mainPane
        );

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

