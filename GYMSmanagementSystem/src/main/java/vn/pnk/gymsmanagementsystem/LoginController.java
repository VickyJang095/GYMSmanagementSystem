package vn.pnk.gymsmanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private TextField UsernameTextField;
    @FXML
    private TextField enterPasswordField;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonClose;
    @FXML
    private Label loginMessageLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
    }
    
    public void loginButtonAction(ActionEvent event){
        if (UsernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false){
            loginMessageLabel.setText("You try to login.");
        }else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }
}
