package com.example.exp.travelgogui.login_screen;

import javafx.concurrent.Task;

public class LoginInteractor {
    private LoginModel model;
    private Runnable runExample;
    public LoginInteractor(LoginModel model, Runnable runExample) {
            this.model = model;
            this.runExample = runExample;
    }
    private Boolean checkLogin(String userName,String password){
      return true;
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
