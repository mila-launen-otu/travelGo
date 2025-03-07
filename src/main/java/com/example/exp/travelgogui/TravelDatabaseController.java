package com.example.exp.travelgogui;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public class TravelDatabaseController {
    private Builder<Region> viewBuilder;
    private TravelDatabaseInteractor interactor;

    public TravelDatabaseController() {
        TravelDatabaseModel model = new TravelDatabaseModel();
        interactor = new TravelDatabaseInteractor(model);
        viewBuilder = new TravelDatabaseViewBuilder(model,interactor::writeTravelPackagesToDB);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}