package com.example.exp.travelgogui.main;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

public class MainModel {
    /**
     * Enum representing the different screens in the application.
     */
    enum Screens {
        LOGIN,
        DATABASE,
    }

    private final BooleanProperty loginSelected = new SimpleBooleanProperty(true);
    private final BooleanProperty databaseSelected = new SimpleBooleanProperty(false);
    public final BooleanProperty isLoggedIn = new SimpleBooleanProperty(false);
    private final ObjectProperty<Screens> screenProperty = new SimpleObjectProperty<Screens>(Screens.LOGIN);

    /**
     * Method to get the property representing whether the login screen is selected.
     *
     * @return The BooleanProperty representing the login screen selection.
     */
    public BooleanProperty LoginSelectedSelectedProperty() {
        return loginSelected;
    }

    /**
     * Method to get the property representing whether the database screen is selected.
     *
     * @return The BooleanProperty representing the database screen selection.
     */
    public BooleanProperty DatabaseSelectedSelectedProperty() {
        return databaseSelected;
    }

    /**
     * Runnable to be executed on login.
     * It updates the screen selection properties accordingly.
     */
    Runnable logIn = () -> {
        loginSelected.setValue(false);
        databaseSelected.setValue(true);
    };

    /**
     * Runnable to be executed on logout.
     * It updates the screen selection properties and login status accordingly.
     */
    Runnable logOut = () -> {
        databaseSelected.setValue(false);
        loginSelected.setValue(true);
        isLoggedIn.setValue(false);
    };
}