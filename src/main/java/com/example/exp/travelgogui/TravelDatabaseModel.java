package com.example.exp.travelgogui;

import com.example.exp.travelgogui.backend.TravelPackage;
import javafx.beans.property.*;
import javafx.collections.ObservableList;

public class TravelDatabaseModel {

    private final ListProperty<TravelPackage> travelPackageList = new SimpleListProperty<TravelPackage>();

    public ObservableList<TravelPackage> getTravelPackageList(){
        return travelPackageList.get();
    }

    public final void setTravelPackageList(ObservableList<TravelPackage> value){travelPackageList.set(value);}

    public ListProperty<TravelPackage> travelPackageListProperty(){
        return travelPackageList;
    }

    private final IntegerProperty selectedItem = new SimpleIntegerProperty();

    public IntegerProperty getSelectedItemProperty(){
        return selectedItem;
    }

    public final void setSelectedItemProperty(Integer value){selectedItem.set(value);}

    public final StringProperty nameProperty = new SimpleStringProperty();
    public final StringProperty descriptionProperty = new SimpleStringProperty();
    public final IntegerProperty stockProperty = new SimpleIntegerProperty();
    public final DoubleProperty priceProperty = new SimpleDoubleProperty();
}
