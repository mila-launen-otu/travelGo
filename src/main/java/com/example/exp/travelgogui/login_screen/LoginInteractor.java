package com.example.exp.travelgogui.login_screen;

import com.example.exp.travelgogui.login_screen.backend.LoginCredentials;
import com.example.exp.travelgogui.login_screen.backend.LoginCredentialsDatabase;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelDatabase;
import java.io.IOException;
import javafx.concurrent.Task;

public class LoginInteractor {
    private LoginModel model;
    private Runnable runExample;
  private final LoginCredentialsDatabase database = new LoginCredentialsDatabase();

  public LoginInteractor(LoginModel model, Runnable runExample) {
            this.model = model;
            this.runExample = runExample;
    }
    private Boolean checkLogin(String userName,String password){
      try {
        LoginCredentials loginCredentials = database.loadLoginCredential();
        return
            loginCredentials.getUsername().equals(userName) &&
                loginCredentials.getPassword().equals(password);
      } catch (IOException e) {
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
