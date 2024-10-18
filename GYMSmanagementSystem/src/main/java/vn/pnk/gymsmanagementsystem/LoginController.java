package vn.pnk.gymsmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    public void loginButtonAction(ActionEvent event){
        String username = UsernameTextField.getText();
        String password;

        if (showPasswordCheckBox.isSelected()) {
            password = showPasswordTextField.getText(); 
        } else {
            password = enterPasswordField.getText(); 
        }
        
        if (!username.isBlank() && !password.isBlank()) {
            boolean isValid = validateLogin(username, password);
            if (isValid){
                loginMessageLabel.setText("Login Successfully!");
            } else {
                loginMessageLabel.setText("Invalid username or password.");
            }
        } else {
            loginMessageLabel.setText("Please enter username and password.");
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] encodeHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder(2 * encodeHash.length);
            for (byte b : encodeHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validateLogin(String username, String password) {
        String hashedPassword = hashPassword(password);

        return "admin".equals(username) && 
               "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8".equals(hashedPassword); 
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
        Parent registerForm = loader.load();
        Stage registerStage = new Stage();
        registerStage.setTitle("register");
        registerStage.setScene(new Scene(registerForm));
        registerStage.initModality(Modality.APPLICATION_MODAL); // Optional
        registerStage.showAndWait(); // Op
    }
}
