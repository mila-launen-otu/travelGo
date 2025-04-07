package com.example.exp.travelgogui.login_screen.backend;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class LoginCredentialsDatabase {
  private final String filePath;
  private final XmlMapper xmlMapper;

  // Default constructor that initializes with the default file path
  public LoginCredentialsDatabase() {
    this("login_credentials.xml"); // default
  }

  // Constructor that accepts a custom file path
  public LoginCredentialsDatabase(String filePath) {
    this.filePath = filePath;
    this.xmlMapper = new XmlMapper();
    // Enable pretty printing of the XML output
    this.xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
  }

  // Method to save login credentials to an XML file
  public void saveLoginCredentials(LoginCredentials loginCredentials) throws IOException {
    xmlMapper.writeValue(new File(filePath), loginCredentials);
  }

  // Method to load login credentials from an XML file
  public LoginCredentials loadLoginCredential() throws IOException {
    File file = new File(filePath);
    // Check if the file exists
    if (!file.exists()) {
      System.out.println("File Not Found");
      // Create default credentials if the file does not exist
      LoginCredentials defaultCreds = new LoginCredentials("AdminUser", "AdminAccess123");
      xmlMapper.writeValue(file, defaultCreds);
      System.out.println("File Created");
      return defaultCreds;
    }
    // Read and return the login credentials from the file
    return xmlMapper.readValue(file, LoginCredentials.class);
  }
}