package com.example.exp.travelgogui.main;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public class MainViewBuilder implements Builder<Region> {

    private final MainModel model;
    private final Region loginContent;
    private final Region databaseContent;

    public MainViewBuilder(MainModel model, Region loginContent, Region databaseContent) {
        this.model = model;
        this.loginContent = loginContent;
        this.databaseContent = databaseContent;
    }

    @Override
    public Region build() {
        loginContent.visibleProperty().bind(model.LoginSelectedSelectedProperty());
        databaseContent.visibleProperty().bind(model.DatabaseSelectedSelectedProperty());
        return new StackPane(loginContent, databaseContent);
    }
}

