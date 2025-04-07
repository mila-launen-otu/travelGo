package com.example.exp.travelgogui;

import com.example.exp.travelgogui.main.MainController;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main application class for the TravelGo GUI application.
 * This class extends the JavaFX Application class and serves as the entry point for the application.
 */
public class MainApplication extends Application {

    /**
     * The main entry point for all JavaFX applications.
     * This method is called when the application is launched.
     *
     * @param stage The primary stage for this application, onto which
     *              the application scene can be set.
     * @throws IOException If an input or output exception occurred.
     */
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Multi-MVCI Application");
        stage.setScene(new Scene(new MainController().getView()));
        stage.show();
    }

    /**
     * The main method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}