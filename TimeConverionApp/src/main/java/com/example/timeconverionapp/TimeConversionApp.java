package com.example.timeconverionapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TimeConversionApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file that you arranged in Scene Builder
        Parent root = FXMLLoader.load(getClass().getResource("time_conversion.fxml"));
        primaryStage.setTitle("Time Conversion by Country");

        // Create a Scene without specifying fixed dimensions
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}