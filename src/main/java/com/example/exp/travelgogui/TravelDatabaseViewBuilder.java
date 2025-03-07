package com.example.exp.travelgogui;

import com.example.exp.travelgogui.backend.TravelPackage;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.Builder;
import static com.example.exp.travelgogui.components.TravelPackageDialogs.*;

public class TravelDatabaseViewBuilder implements Builder<Region> {
    private final TravelDatabaseModel model;
    private Runnable onSave;
    public TravelDatabaseViewBuilder(TravelDatabaseModel model,Runnable onSave) {
        this.model = model;
        this.onSave = onSave;
    }

    @Override
    public Region build() {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(createTop());
        borderPane.setCenter(createCentre());
        return borderPane;
    }
    private Node createTop(){
        Button removeButton = new Button("Remove Selected Travel Package");
        removeButton.setOnAction(_ ->
                model.travelPackageListProperty().remove(model.getSelectedItemProperty().get())
        );
        Button addButton = new Button("Add Travel Package");
        addButton.setOnAction(
                _ ->
                        AddTravelPackageDialog().showAndWait().ifPresent(
                                travelPackage -> {
                                    model.travelPackageListProperty().add(travelPackage);
                                }
                        )
        );
        Button updateButton = new Button("Update Travel Package");
        updateButton.setOnAction(
                _ ->{
                    int selectedPackage = model.getSelectedItemProperty().get();
                    UpdateTravelPackageDialog(model.travelPackageListProperty()
                            .get(selectedPackage)).showAndWait().ifPresent(
                            travelPackage -> {
                                model.travelPackageListProperty().set(selectedPackage,travelPackage);
                            }
                    );
                }
        );
        Button saveButton = new Button("Save Travel Packages");
        saveButton.setOnAction(
                _-> onSave.run()
        );
        return new HBox(
                new Label("Travel Packages"),
                addButton,
                removeButton,
                updateButton,
                saveButton
        );
    }

    private Node createCentre() {
        return travelPackagesBox();
    }

    private Node travelPackagesBox(){
        ListView<TravelPackage> list = new ListView<>();
        //list.setCellFactory(travelPackage -> createCell());
        list.itemsProperty().bind(model.travelPackageListProperty());
        list.getSelectionModel().getSelectedIndices().addListener((ListChangeListener<Integer>) change -> model.setSelectedItemProperty(change.getList().getFirst()));
        return list;
    }
    //Custom ListCell for TravelPackages For Later
//    private ListCell<TravelPackage> createCell() {
//        return new ListCell<TravelPackage>() {
//            private Region layout;
//            @Override
//            public void updateItem(TravelPackage item, boolean isEmpty) {
//                super.updateItem(item, isEmpty);
//                if (!isEmpty && (item != null)) {
//                    item.name = "";
//                    setText(item.toString());
//                } else {
//                    setGraphic(null);
//                    setText(null);
//                }
//            }
//        };
//    }
}
