package com.example.exp.travelgogui.main;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;



public class MainModel {
    enum Screens {
        LOGIN,
        DATABASE,
    }
    private final BooleanProperty loginSelected = new SimpleBooleanProperty(true);
    private final BooleanProperty databaseSelected = new SimpleBooleanProperty(false);
    public final BooleanProperty isLoggedIn = new SimpleBooleanProperty(false);
    private final ObjectProperty<Screens> screescreenPropertynProperty = new SimpleObjectProperty<Screens>(Screens.LOGIN);
    public BooleanProperty LoginSelectedSelectedProperty() {
        return loginSelected;
    }
    public BooleanProperty DatabaseSelectedSelectedProperty() {
        return databaseSelected;
    }
    Runnable runExample = () -> {
        loginSelected.setValue(false);
        databaseSelected.setValue(true);
    };
}
