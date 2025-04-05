package com.example.exp.travelgogui.login_screen.backend;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class LoginCredentialsDatabase {
  private final String filePath;
  private final XmlMapper xmlMapper;

  public LoginCredentialsDatabase() {
    this("login_credentials.xml"); // default
  }

  public LoginCredentialsDatabase(String filePath) {
    this.filePath = filePath;
    this.xmlMapper = new XmlMapper();
    this.xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
  }

  public void saveLoginCredentials(LoginCredentials loginCredentials) throws IOException {
    xmlMapper.writeValue(new File(filePath), loginCredentials);
  }

  public LoginCredentials loadLoginCredential() throws IOException {
    File file = new File(filePath);
    if (!file.exists()) {
      System.out.println("File Not Found");
      LoginCredentials defaultCreds = new LoginCredentials("AdminUser", "AdminAccess123");
      xmlMapper.writeValue(file, defaultCreds);
      System.out.println("File Created");
      return defaultCreds;
    }
    return xmlMapper.readValue(file, LoginCredentials.class);
  }
}


