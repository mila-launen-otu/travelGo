package com.example.exp.travelgogui.login_screen;

import javafx.beans.property.BooleanProperty;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class LoginController {
    Builder<Region> viewBuilder;
    private LoginInteractor interactor;
    private LoginModel model;

    public LoginController(Runnable runExample, BooleanProperty isLoggedIn) {
        model = new LoginModel();
        interactor = new LoginInteractor(model,runExample);
        viewBuilder = new LoginViewBuilder(model,
            runExample,
            interactor::checkLoginTask
        );
        model.isLoggedIn.bindBidirectional(isLoggedIn);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
