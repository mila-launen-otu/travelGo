package com.example.exp.travelgogui;

import com.example.exp.travelgogui.backend.TravelDatabase;
import com.example.exp.travelgogui.backend.TravelPackage;
import com.example.exp.travelgogui.backend.TravelPackageList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class TravelDatabaseInteractor {
    private TravelDatabaseModel model;
    private final TravelDatabase database = new TravelDatabase();
    public TravelDatabaseInteractor(TravelDatabaseModel model) {
        this.model = model;
        loadTravelPackagesFromDB();
    }
    public void loadTravelPackagesFromDB() {
        ObservableList<TravelPackage> list1 = null;
        try {
            list1 = FXCollections.observableArrayList(database.loadPackages().getPackages());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.setTravelPackageList(list1);
    }
    public void writeTravelPackagesToDB(){
        TravelPackageList travelPackageList = new TravelPackageList();
        travelPackageList.setPackages(model.getTravelPackageList());
        try {
            database.savePackages(travelPackageList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
