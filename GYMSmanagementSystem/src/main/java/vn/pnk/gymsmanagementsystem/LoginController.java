package vn.pnk.gymsmanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        buttonLogin.setOnAction(event -> handleLogin());
        
        buttonClose.setOnAction(event -> handleClose());
    }    
    
    private void handleLogin() {
        String username = UsernameTextField.getText();
        String password = enterPasswordField.getText();

        if (username.equals("admin") && password.equals("1234")) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, " + username);
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password");
        }
    }

    private void handleClose() {
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
