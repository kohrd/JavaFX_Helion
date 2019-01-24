package pl.notatnik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {


    @FXML
    private Label label;

    @FXML
    Button button;

    @FXML
    private void handleButton(ActionEvent event) {
        System.out.println("you clicked me!");
        label.setText("hello world!!!!!$");
    }

    @Override
    public void initialize(URL location, ResourceBundle rb) {

    }
}
