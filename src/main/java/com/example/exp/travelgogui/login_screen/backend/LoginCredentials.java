package com.example.exp.travelgogui.login_screen.backend;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "login_credentials")
public class LoginCredentials {
  private String username;
  private String password;

  // Default constructor
  public LoginCredentials() {
    // No-argument constructor for deserialization
  }

  // Constructor to initialize username and password
  public LoginCredentials(String username, String password) {
    this.username = username;
    this.password = password;
  }

  // Getter for username
  public String getUsername() {
    return username;
  }

  // Setter for username
  public void setUsername(String username) {
    this.username = username;
  }

  // Getter for password
  public String getPassword() {
    return password;
  }

  // Setter for password
  public void setPassword(String password) {
    this.password = password;
  }
}