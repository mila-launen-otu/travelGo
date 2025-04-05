package com.example.exp.travelgogui.login_screen;

import com.example.exp.travelgogui.login_screen.backend.LoginCredentials;
import com.example.exp.travelgogui.login_screen.backend.LoginCredentialsDatabase;
import javafx.concurrent.Task;

public class LoginInteractor {
  private LoginModel model;
  protected Runnable runExample;

  public LoginInteractor(LoginModel model, Runnable runExample) {
    this.model = model;
    this.runExample = runExample;
  }

  private Boolean checkLogin(String userName, String password) {
    try {
      LoginCredentialsDatabase db = new LoginCredentialsDatabase(); // uses default file
      LoginCredentials stored = db.loadLoginCredential();

      return stored.getUsername().equals(userName) && stored.getPassword().equals(password);

    } catch (Exception e) {
      System.err.println("Login failed due to error: " + e.getMessage());
      return false;
    }
  }

  public void checkLoginTask (String userName,String password){
    Task<Boolean> loginTask = new Task<Boolean>() {
      @Override
      protected Boolean call() throws Exception {
        return checkLogin(userName,password);
      }
    };

    loginTask.setOnSucceeded(evt -> {
      model.isLoggedIn.set(loginTask.getValue());
      if (model.isLoggedIn.get()){
        runExample.run();
      }
      else{

      }
    });

    Thread loginThread = new Thread(loginTask);
    loginThread.start();
  }
}