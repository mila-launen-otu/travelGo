package com.example.exp.travelgogui.login_screen;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginModel {
    StringProperty userNameProperty = new SimpleStringProperty("");
    StringProperty passwordProperty = new SimpleStringProperty("");
    public BooleanProperty isLoggedIn = new SimpleBooleanProperty(false);
}
