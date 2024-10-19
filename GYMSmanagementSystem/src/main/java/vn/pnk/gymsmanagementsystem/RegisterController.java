/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vn.pnk.gymsmanagementsystem;

import jakarta.xml.bind.JAXBException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vn.pnk.gymsmanagementsystem.User.UserXMLHandler;
/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class RegisterController implements Initializable {


    @FXML
    private TextField firstnameTextField;
    @FXML
    private ImageView ishieldImageView;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private Button registerButton;
    @FXML
    private Button closeButton;
    @FXML
    private TextField showPassword;
    @FXML
    private CheckBox showPasswordCheckBox;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField showConfirmPassword;
    @FXML
    private Label registrationMessageLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPassword.setVisible(false);
        showConfirmPassword.setVisible(false);
    }    

    @FXML
    private void registerButtonAction(ActionEvent event) {
        try {
            String username = usernameTextField.getText();
            String password = setPasswordField.getText();
            String confirmPassword = confirmPasswordField.getText();
            String lastname = lastnameTextField.getText();
            String firstname = firstnameTextField.getText();

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                registrationMessageLabel.setText("Please fill in all the information.");
                return; 
            }

            if (UserXMLHandler.isUsernameTaken(username)) {
                registrationMessageLabel.setText("Username already exists. Please choose another one.");
                return;
            }

            if (!password.equals(confirmPassword)) {
                registrationMessageLabel.setText("Passwords do not match.");
                return;
            }
            int id;

            UserXMLHandler.registerUser(username, password, lastname, firstname);
            registrationMessageLabel.setText("Registration successful! You can log in.");
            Stage currentStage = (Stage) registerButton.getScene().getWindow(); 
            App.setRoot(currentStage, "login", 600, 400); 


        } catch (JAXBException e) {
            registrationMessageLabel.setText("An error occurred during registration.");
            e.printStackTrace(); 
        } catch (Exception e) {
            registrationMessageLabel.setText("An unexpected error occurred.");
            e.printStackTrace();
        }
    }


    @FXML
    private void closeButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void showPasswordAction(ActionEvent event) {
        if (showPasswordCheckBox.isSelected()){
            showPassword.setText(setPasswordField.getText());
            showPassword.setVisible(true);
            setPasswordField.setVisible(false);
            
            showConfirmPassword.setText(confirmPasswordField.getText());
            showConfirmPassword.setVisible(true);
            confirmPasswordField.setVisible(false);
        }
        else {
            setPasswordField.setText(showPassword.getText());
            setPasswordField.setVisible(true);
            showPassword.setVisible(false);
            
            confirmPasswordField.setText(showConfirmPassword.getText());
            confirmPasswordField.setVisible(true);
            showConfirmPassword.setVisible(false);
        }
    }
}
