package com.example.exp.travelgogui.travel_database_screen;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import javafx.beans.property.*;
import javafx.collections.ObservableList;

public class TravelDatabaseModel {
    // All Travel Packages Property
    private final ListProperty<TravelPackage> travelPackageList = new SimpleListProperty<>();

    /**
     * Gets the list of all travel packages.
     *
     * @return The list of all travel packages.
     */
    public ObservableList<TravelPackage> getTravelPackageList() {
        return travelPackageList.get();
    }

    /**
     * Sets the list of all travel packages.
     *
     * @param value The list of all travel packages to set.
     */
    public final void setTravelPackageList(ObservableList<TravelPackage> value) {
        travelPackageList.set(value);
    }

    /**
     * Gets the property of the list of all travel packages.
     *
     * @return The property of the list of all travel packages.
     */
    public ListProperty<TravelPackage> travelPackageListProperty() {
        return travelPackageList;
    }

    // Filtered Travel Packages Property
    private final ListProperty<TravelPackage> filteredTravelPackageList = new SimpleListProperty<>();

    /**
     * Gets the list of filtered travel packages.
     *
     * @return The list of filtered travel packages.
     */
    public ObservableList<TravelPackage> getFilteredTravelPackageList() {
        return filteredTravelPackageList.get();
    }

    /**
     * Sets the list of filtered travel packages.
     *
     * @param value The list of filtered travel packages to set.
     */
    public final void setFilteredTravelPackageList(ObservableList<TravelPackage> value) {
        filteredTravelPackageList.set(value);
    }

    /**
     * Gets the property of the list of filtered travel packages.
     *
     * @return The property of the list of filtered travel packages.
     */
    public ListProperty<TravelPackage> filteredTravelPackageList() {
        return filteredTravelPackageList;
    }

    // Selected Item Property
    private final IntegerProperty selectedItem = new SimpleIntegerProperty();

    /**
     * Gets the property of the selected item.
     *
     * @return The property of the selected item.
     */
    public IntegerProperty getSelectedItemProperty() {
        return selectedItem;
    }

    /**
     * Sets the property of the selected item.
     *
     * @param value The value of the selected item to set.
     */
    public final void setSelectedItemProperty(Integer value) {
        selectedItem.set(value);
    }

    // Login Status Property
    public final BooleanProperty isLoggedIn = new SimpleBooleanProperty(false);
}