package vn.pnk.gymsmanagementsystem;

import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vn.pnk.gymsmanagementsystem.User.UserXMLHandler;

public class LoginController implements Initializable {

    @FXML
    private TextField UsernameTextField;
    @FXML
    private TextField enterPasswordField;
    @FXML
    private TextField showPasswordTextField;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonClose;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private CheckBox showPasswordCheckBox; 
    @FXML
    private Hyperlink RegisterLink;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPasswordTextField.setVisible(false);
    }

    @FXML
    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void loginButtonAction(ActionEvent event) throws JAXBException, IOException{
        String username = UsernameTextField.getText();
        String password;

        if (showPasswordCheckBox.isSelected()) {
            password = showPasswordTextField.getText(); 
        } else {
            password = enterPasswordField.getText(); 
        }
        
        if (!username.isBlank() && !password.isBlank()) {
            boolean isValid = UserXMLHandler.validateLogin(username, password);
            if (isValid){
                loginMessageLabel.setText("Login Successfully!");
                Stage currentStage = (Stage) buttonLogin.getScene().getWindow(); 
                App.setRoot(currentStage, "main", 600, 400);
            } else {
                loginMessageLabel.setText("Invalid username or password.");
            }
        } else {
            loginMessageLabel.setText("Please enter username and password.");
        }
    }

    @FXML
    private void showPasswordAction(ActionEvent event) {
        if (showPasswordCheckBox.isSelected()) {
            showPasswordTextField.setText(enterPasswordField.getText());
            showPasswordTextField.setVisible(true);
            enterPasswordField.setVisible(false);
        } else {
            enterPasswordField.setText(showPasswordTextField.getText());
            enterPasswordField.setVisible(true);
            showPasswordTextField.setVisible(false);
        }
    }

    @FXML
    private void openResgiterForm(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) buttonLogin.getScene().getWindow();
        App.setRoot(currentStage, "register", 585, 600);
    }
}
