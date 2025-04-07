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
    public void checkLogin(Runnable onWrongLogin,String userName,String password) {
        Task<Boolean> loginTask = new Task<>() {
            @Override
            protected Boolean call() {
                return interactor.checkLogin(userName,password);
            }
        };
        loginTask.setOnSucceeded(evt -> {
            if (loginTask.getValue()){
                model.isAdmin.set(true);
                logIn.run();
            }
            else {
                onWrongLogin.run();
            }
        });
        Thread fetchThread = new Thread(loginTask);
        fetchThread.start();
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
