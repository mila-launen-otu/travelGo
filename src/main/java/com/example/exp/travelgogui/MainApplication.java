package com.example.exp.travelgogui;

import com.example.exp.travelgogui.main.MainController;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Multi-MVCI Application");
        stage.setScene(new Scene(new MainController().getView()));
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}