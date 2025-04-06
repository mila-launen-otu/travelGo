package com.example.exp.travelgogui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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
    // scene object for unit tests
    public static class ClickPane extends StackPane {
        public ClickPane() {
            super();
            Button button = new Button("click me!");
            button.setOnAction(actionEvent -> button.setText("clicked!"));
            getChildren().add(new TravelDatabaseController().getView());
        }
    }
}