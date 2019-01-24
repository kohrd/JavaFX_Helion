package pl.notatnik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main_Jfx_01_02  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/fxmlDocument.fxml"));
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Notatnik");
        stage.show();

    }
}
