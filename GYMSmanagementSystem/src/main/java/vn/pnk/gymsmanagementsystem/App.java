package vn.pnk.gymsmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Gym Management System - Login");

        scene = new Scene(loadFXML("main"), 1100, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(Stage currentStage, String fxml, int width, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();

        if (currentStage != null) {
            currentStage.setScene(new Scene(root, width, height));
        } else {
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root, width, height));
            newStage.show();
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            System.err.println("Error loading FXML file: " + fxml);
            throw e;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

