package com.example.exp.travelgogui.login_screen;

@FunctionalInterface
interface functionalInterface {
  /**
   * Abstract method to be implemented by the functional interface.
   *
   * @param onWrongLogin Runnable to be executed on wrong login.
   * @param message Message to be displayed or processed.
   * @param count Count or number of attempts.
   */
  void execute(Runnable onWrongLogin, String message, String count);
}