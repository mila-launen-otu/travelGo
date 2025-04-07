package com.example.exp.travelgogui.login_screen;

import javafx.beans.property.BooleanProperty;
import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class LoginController {
    Builder<Region> viewBuilder;
    private LoginInteractor interactor;
    private LoginModel model;
    private Runnable logIn;

    /**
     * Constructor to initialize the LoginController with the given parameters.
     *
     * @param logIn Runnable to be executed on successful login.
     * @param isLoggedIn BooleanProperty to bind the login status.
     */
    public LoginController(Runnable logIn, BooleanProperty isLoggedIn) {
        this.logIn = logIn;
        model = new LoginModel();
        interactor = new LoginInteractor(model,logIn);
        viewBuilder = new LoginViewBuilder(model,
            logIn,
            this::checkLogin
        );
        model.isAdmin.bindBidirectional(isLoggedIn);
    }

    /**
     * Method to check the login credentials.
     *
     * @param onWrongLogin Runnable to be executed on wrong login.
     * @param userName Username to be checked.
     * @param password Password to be checked.
     */
    public void checkLogin(Runnable onWrongLogin, String userName, String password) {
        Task<Boolean> loginTask = new Task<>() {
            @Override
            protected Boolean call() {
                return interactor.checkLogin(userName, password);
            }
        };
        loginTask.setOnSucceeded(evt -> {
            if (loginTask.getValue()) {
                model.isAdmin.set(true);
                logIn.run();
            } else {
                onWrongLogin.run();
            }
        });
        Thread fetchThread = new Thread(loginTask);
        fetchThread.start();
    }

    /**
     * Method to get the view built by the viewBuilder.
     *
     * @return The built Region view.
     */
    public Region getView() {
        return viewBuilder.build();
    }
}