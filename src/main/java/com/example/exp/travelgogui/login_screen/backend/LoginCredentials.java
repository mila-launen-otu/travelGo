package com.example.exp.travelgogui.login_screen.backend;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "login_credentials")
public class LoginCredentials {
  private String username;
  private String password;

  // Constructors
  public LoginCredentials() {

  }

  public LoginCredentials(String username, String password) {
    this.username = username;
    this.password = password;
  }
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) { // ADD THIS
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) { // ADD THIS
    this.password = password;
  }
}
