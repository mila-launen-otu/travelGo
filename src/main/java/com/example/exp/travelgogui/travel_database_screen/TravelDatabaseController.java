package com.example.exp.travelgogui.travel_database_screen;

import javafx.beans.property.BooleanProperty;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class TravelDatabaseController {
    private final Builder<Region> viewBuilder;
    private TravelDatabaseInteractor interactor;

    public TravelDatabaseController(BooleanProperty isLoggedIn) {
        TravelDatabaseModel model = new TravelDatabaseModel();
        model.isLoggedIn.bind(isLoggedIn);
        interactor = new TravelDatabaseInteractor(model);
        viewBuilder = new TravelDatabaseViewBuilder(model,interactor::writeTravelPackagesToDB);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}