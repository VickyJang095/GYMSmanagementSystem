/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vn.pnk.gymsmanagementsystem.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import vn.pnk.gymsmanagementsystem.App;
import vn.pnk.gymsmanagementsystem.App;
/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class LoginController implements Initializable {


    @FXML
    private AnchorPane brandingImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField enterPasswordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void login(ActionEvent event) throws IOException{
         if(usernameTextField.getText().equals("Admin") && enterPasswordField.getText().equals("Admin")){
            App.setRoot("primary");
         }  
         else {
             System.out.println("Sorry, Login Failed");
         }
    }
}
