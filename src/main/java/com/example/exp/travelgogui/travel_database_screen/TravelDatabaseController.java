package com.example.exp.travelgogui.travel_database_screen;

import javafx.beans.property.BooleanProperty;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class TravelDatabaseController {
    private final Builder<Region> viewBuilder;
    private TravelDatabaseInteractor interactor;

    /**
     * Constructor to initialize the TravelDatabaseController with the given parameters.
     *
     * @param logOutofTravelDatabase A Runnable to handle logging out of the travel database.
     * @param isLoggedIn A BooleanProperty indicating the login status.
     */
    public TravelDatabaseController(Runnable logOutofTravelDatabase, BooleanProperty isLoggedIn) {
        TravelDatabaseModel model = new TravelDatabaseModel();
        model.isLoggedIn.bind(isLoggedIn);
        interactor = new TravelDatabaseInteractor(model);
        viewBuilder = new TravelDatabaseViewBuilder(model, interactor::writeTravelPackagesToDB, logOutofTravelDatabase);
    }

    /**
     * Method to get the view built by the view builder.
     *
     * @return The built Region view.
     */
    public Region getView() {
        return viewBuilder.build();
    }
}