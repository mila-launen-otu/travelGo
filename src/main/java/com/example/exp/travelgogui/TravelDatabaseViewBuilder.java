package com.example.exp.travelgogui;

import com.example.exp.travelgogui.backend.TravelPackage;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.Builder;
import static com.example.exp.travelgogui.components.TravelPackageDialogs.*;

public class TravelDatabaseViewBuilder implements Builder<Region> {
    private final TravelDatabaseModel model;
    private final Runnable onSave;
    private final ObservableList<TravelPackage> originalList = FXCollections.observableArrayList();
    private final ListView<TravelPackage> listView = new ListView<>();
    public TravelDatabaseViewBuilder(TravelDatabaseModel model,Runnable onSave) {
        this.model = model;
        this.onSave = onSave;
    }

    @Override
    public Region build() {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(createTop());

        VBox centerBox = new VBox();
        centerBox.getChildren().addAll(createFilterBar(), travelPackagesBox());
        borderPane.setCenter(centerBox);
//        borderPane.setCenter(createCentre());
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
                                travelPackage -> model.travelPackageListProperty().add(travelPackage)
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
        HBox hBox = new HBox(
                addButton,
                removeButton,
                updateButton,
                saveButton
        );
        hBox.setPadding(new Insets(5));
        hBox.setSpacing(25);
        return hBox;
    }

    private Node createCentre() {
        return travelPackagesBox();
    }

    private Node travelPackagesBox(){
//        ListView<TravelPackage> list = new ListView<>();
//        list.setCellFactory(travelPackage -> createCell());
//        list.itemsProperty().bind(model.travelPackageListProperty());
//        list.getSelectionModel().getSelectedIndices().addListener((ListChangeListener<Integer>) change -> model.setSelectedItemProperty(change.getList().getFirst()));
//        return list;

//        listView.setCellFactory(travelPackage -> createCell());
////        listView.itemsProperty().bind(model.travelPackageListProperty());
//        listView.setItems(model.getTravelPackageList());
//        listView.getSelectionModel().getSelectedIndices().addListener(
//                (ListChangeListener<Integer>) change -> model.setSelectedItemProperty(
//                        change.getList().getFirst())
//        );
//
//        return listView;

        listView.setCellFactory(travelPackage -> createCell());
        listView.setItems(model.getTravelPackageList());
        listView.getSelectionModel().getSelectedIndices().addListener(
                (ListChangeListener<Integer>) change ->
                        model.setSelectedItemProperty(change.getList().getFirst())
        );

        return listView;
    }
    //Custom ListCell for TravelPackages For Later
    private ListCell<TravelPackage> createCell() {
        return new ListCell<TravelPackage>() {
            private Region layout;
            @Override
            public void updateItem(TravelPackage item, boolean isEmpty) {
                super.updateItem(item, isEmpty);
                if (!isEmpty && (item != null)) {
                    setGraphic(new VBox(
                            new Label(item.getName()),
                            new Label(item.getDescription()),
                            new Label("Stock: "+ item.getStock()),
                            new Label("Price: "+ item.getPrice()),
                            new Label("Location:" + item.getLocation()),
                            new Label("Travel Type:" + item.getTravelType()),
                            new Label("Continent:" + item.getContinent())
                    ));
                } else {
                    setGraphic(null);
                    setText(null);
                }
            }
        };
    }

    private Node createFilterBar() {
        HBox filterNavigation = new HBox();
//        filterNavigation.setSpacing(10);
//        filterNavigation.setPadding(new Insets(10)); // Add: 5?
//
//        String[] filterButtons = {"All", "Asia", "Africa", "North America", "South America", "Antarctica", "Europe",
//                "Australia/Oceania"};
//
//        for (String button : filterButtons) {
//            Button fB = new Button(button);
//            fB.setOnAction(event -> applyFilter(button));
//            filterNavigation.getChildren().add(fB);
//        }
//
//        return filterNavigation;

        filterNavigation.setSpacing(10);
        filterNavigation.setPadding(new Insets(10));

        ComboBox<String> continentDropdown = new ComboBox<>();
        continentDropdown.getItems().addAll("All", "Asia", "Africa", "North America", "South America",
                "Antarctica", "Oceania");
        continentDropdown.setValue("All"); // Default

        Button filterButton = new Button("Filter");
        filterButton.setOnAction(event ->
                applyFilter(continentDropdown.getValue()));

        filterNavigation.getChildren().addAll(new Label("Continent: "), continentDropdown, filterButton);

        return filterNavigation;

    }

    private void applyFilter(String continent) {
//        if (originalList.isEmpty()) {
//            originalList.addAll(model.travelPackageListProperty());
//        }
//
//        if (continent.equals("All")) {
//            listView.setItems(FXCollections.observableArrayList(originalList));
//        } else {
//            ObservableList<TravelPackage> filteredList = originalList.filtered(
//                    travelPackage -> continent.equals(travelPackage.getContinent())
//            );
//            listView.setItems(filteredList);
//        }

        ObservableList<TravelPackage> fullList = model.getTravelPackageList();

        if (continent.equals("All")) {
            listView.setItems(fullList);
        } else {
            ObservableList<TravelPackage> filteredList = fullList.filtered(travelPackage ->
                    continent.equals(travelPackage.getContinent())
            );
            listView.setItems(filteredList);
        }
    }
}
