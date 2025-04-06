package com.example.exp.travelgogui.main;

import com.example.exp.travelgogui.login_screen.LoginController;
import com.example.exp.travelgogui.travel_database_screen.TravelDatabaseController;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class MainController {
    private final Builder<Region> viewBuilder;

    public MainController() {
        MainModel model = new MainModel();
        viewBuilder = new MainViewBuilder(model,
                new LoginController(model.logIn,model.isLoggedIn).getView(),
                new TravelDatabaseController(model.logOut,model.isLoggedIn).getView()
        );
    }

    public Region getView() {
        return viewBuilder.build();
    }
}