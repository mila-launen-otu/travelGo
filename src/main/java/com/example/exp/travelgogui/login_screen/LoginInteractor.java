package com.example.exp.travelgogui.login_screen;

import com.example.exp.travelgogui.login_screen.backend.LoginCredentials;
import com.example.exp.travelgogui.login_screen.backend.LoginCredentialsDatabase;
import javafx.concurrent.Task;

public class LoginInteractor {
  private LoginModel model;
  protected Runnable runExample;

  /**
   * Constructor to initialize the LoginInteractor with the given model and runnable.
   *
   * @param model The LoginModel instance to be used.
   * @param runExample Runnable to be executed on successful login.
   */
  public LoginInteractor(LoginModel model, Runnable runExample) {
    this.model = model;
    this.runExample = runExample;
  }

  /**
   * Method to check the login credentials.
   *
   * @param userName Username to be checked.
   * @param password Password to be checked.
   * @return Boolean indicating whether the login is successful.
   */
  public Boolean checkLogin(String userName, String password) {
    try {
      LoginCredentialsDatabase db = new LoginCredentialsDatabase(); // uses default file
      LoginCredentials stored = db.loadLoginCredential();

      return stored.getUsername().equals(userName) && stored.getPassword().equals(password);

    } catch (Exception e) {
      System.err.println("Login failed due to error: " + e.getMessage());
      return false;
    }
  }

  /**
   * Method to check the login credentials asynchronously.
   *
   * @param userName Username to be checked.
   * @param password Password to be checked.
   */
  public void checkLoginTask(String userName, String password) {
    Task<Boolean> loginTask = new Task<>() {
      @Override
      protected Boolean call() throws Exception {
        return checkLogin(userName, password);
      }
    };

    loginTask.setOnSucceeded(evt -> {
      model.isAdmin.set(loginTask.getValue());
      if (model.isAdmin.get()) {
        runExample.run();
      }
    });

    Thread loginThread = new Thread(loginTask);
    loginThread.start();
  }
}