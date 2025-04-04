package com.example.exp.travelgogui.login_screen.backend;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class LoginCredentialsDatabase {
  private static final String FILE_PATH = "login_credentials.xml";
  private final XmlMapper xmlMapper;

  public LoginCredentialsDatabase() {
    xmlMapper = new XmlMapper();
    xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); // Enable pretty-printing
  }

  // Save list of travel packages to XML
  public void saveLoginCredentials(LoginCredentials loginCredentials) throws IOException {
    xmlMapper.writeValue(new File(FILE_PATH), loginCredentials);
  }

  // Load travel packages from XML
  public LoginCredentials loadLoginCredential() throws IOException {
    if (!new File(FILE_PATH).exists()) {
      // Write object directly to file
      System.out.println("File Not Found");
      try {
        xmlMapper.writeValue(new File(FILE_PATH), new LoginCredentials("AdminUser","AdminAccess123"));
      } catch (Exception e) {
        System.out.println("ExceptionThrown");
        System.out.println(e.getMessage());
        throw new RuntimeException(e);
      }
      System.out.println("File Created");
      return new LoginCredentials("AdminUser","AdminAccess123");
    }
    return xmlMapper.readValue(new File(FILE_PATH), LoginCredentials.class);
  }
}

