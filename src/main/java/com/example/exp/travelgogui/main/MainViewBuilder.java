package com.example.exp.travelgogui.main;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public class MainViewBuilder implements Builder<Region> {

    private final MainModel model;
    private final Region loginContent;
    private final Region databaseContent;

    /**
     * Constructor to initialize the MainViewBuilder with the given parameters.
     *
     * @param model The MainModel instance to be used.
     * @param loginContent The Region representing the login screen content.
     * @param databaseContent The Region representing the database screen content.
     */
    public MainViewBuilder(MainModel model, Region loginContent, Region databaseContent) {
        this.model = model;
        this.loginContent = loginContent;
        this.databaseContent = databaseContent;
    }

    /**
     * Method to build the main view.
     * It binds the visibility of the login and database content to the respective properties in the model.
     *
     * @return The built Region view.
     */
    @Override
    public Region build() {
        // Bind the visibility of the login content to the loginSelected property
        loginContent.visibleProperty().bind(model.LoginSelectedSelectedProperty());
        // Bind the visibility of the database content to the databaseSelected property
        databaseContent.visibleProperty().bind(model.DatabaseSelectedSelectedProperty());
        // Return a StackPane containing both the login and database content
        return new StackPane(loginContent, databaseContent);
    }
}