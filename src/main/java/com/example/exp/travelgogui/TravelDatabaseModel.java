package com.example.exp.travelgogui;

import com.example.exp.travelgogui.backend.TravelPackage;
import javafx.beans.property.*;
import javafx.collections.ObservableList;

public class TravelDatabaseModel {
    //All Travel Packages Property
    private final ListProperty<TravelPackage> travelPackageList = new SimpleListProperty<>();

    public ObservableList<TravelPackage> getTravelPackageList(){
        return travelPackageList.get();
    }

    public final void setTravelPackageList(ObservableList<TravelPackage> value){travelPackageList.set(value);}

    public ListProperty<TravelPackage> travelPackageListProperty(){
        return travelPackageList;
    }
    //Filtered Travel Packages Property

    private final ListProperty<TravelPackage> filteredTravelPackageList = new SimpleListProperty<>();

    public ObservableList<TravelPackage> getFilteredTravelPackageList(){
        return filteredTravelPackageList.get();
    }

    public final void setFilteredTravelPackageList(ObservableList<TravelPackage> value) {
        filteredTravelPackageList.set(value);
    }

    public ListProperty<TravelPackage> filteredTravelPackageList(){
        return filteredTravelPackageList;
    }

    private final IntegerProperty selectedItem = new SimpleIntegerProperty();

    public IntegerProperty getSelectedItemProperty(){
        return selectedItem;
    }

    public final void setSelectedItemProperty(Integer value){selectedItem.set(value);}
}
