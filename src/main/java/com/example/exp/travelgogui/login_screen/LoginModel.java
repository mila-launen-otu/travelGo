package com.example.exp.travelgogui.login_screen;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginModel {
    StringProperty userName = new SimpleStringProperty("");
    StringProperty password = new SimpleStringProperty("");

    /**
     * Constructor to initialize the LoginModel.
     */
    public BooleanProperty isAdmin = new SimpleBooleanProperty(false);
}
