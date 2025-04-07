package com.example.exp.travelgogui.travel_database_screen;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelDatabase;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class TravelDatabaseInteractor {
    private final TravelDatabaseModel model;
    private final TravelDatabase database = new TravelDatabase();

    /**
     * Constructor to initialize the TravelDatabaseInteractor with the given model.
     *
     * @param model The TravelDatabaseModel to be used by the interactor.
     */
    public TravelDatabaseInteractor(TravelDatabaseModel model) {
        this.model = model;
        loadTravelPackagesFromDB();
    }

    /**
     * Method to load travel packages from the database and update the model.
     */
    public void loadTravelPackagesFromDB() {
        ObservableList<TravelPackage> list1;
        try {
            list1 = FXCollections.observableArrayList(database.loadPackages().getPackages());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.setTravelPackageList(list1);
    }

    /**
     * Method to save travel packages from the model to the database.
     */
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
