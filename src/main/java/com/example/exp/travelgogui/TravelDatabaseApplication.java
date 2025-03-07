package com.example.exp.travelgogui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TravelDatabaseApplication extends Application {
    @Override
    public void start(Stage primaryStage){
        primaryStage.setScene(new Scene(new TravelDatabaseController().getView(),1280,720));
        primaryStage.setTitle("Travel Database");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}