package com.example.exp.travelgogui;

import com.example.exp.travelgogui.backend.TravelPackage;
import java.util.Comparator;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.Builder;

import static com.example.exp.travelgogui.components.TravelPackageDialogs.*;

public class TravelDatabaseViewBuilder implements Builder<Region> {
    private final TravelDatabaseModel model;
    private final Runnable onSave;
    private final ListView<TravelPackage> listView = new ListView<>();

    public TravelDatabaseViewBuilder(TravelDatabaseModel model,Runnable onSave) {
        this.model = model;
        this.onSave = onSave;
        setInitalFilter();
    }
    private void setInitalFilter(){
        applyFilter("All", "All","None",true);
    }

    @Override
    public Region build() {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new VBox(adminBar(),createFilterBar()));
        borderPane.setCenter(travelPackagesBox());
        return borderPane;
    }
    private Node adminBar(){
        Button removeButton = new Button("Remove Selected Travel Package");
        removeButton.setOnAction(_ ->
                model.travelPackageListProperty().remove(
                    model.getFilteredTravelPackageList().get(model.getSelectedItemProperty().get())
                )
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
                    TravelPackage selectedTravelPackage = model.filteredTravelPackageList()
                        .get(selectedPackage);
                    UpdateTravelPackageDialog(selectedTravelPackage).showAndWait().ifPresent(
                            travelPackage -> {
                                model.travelPackageListProperty()
                                    .set(model.travelPackageListProperty().indexOf(selectedTravelPackage),travelPackage);
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

    private Node travelPackagesBox(){
        listView.setCellFactory(travelPackage -> createCell());
        listView.itemsProperty().bind(model.filteredTravelPackageList());
        listView.getSelectionModel().getSelectedIndices().addListener(
                (ListChangeListener<Integer>) change ->
                        model.setSelectedItemProperty(change.getList().getFirst())
        );
        return listView;
    }

    //Custom ListCell for TravelPackages For Later
    private ListCell<TravelPackage> createCell() {
        return new ListCell<TravelPackage>() {
            @Override
            public void updateItem(TravelPackage item, boolean isEmpty) {
                super.updateItem(item, isEmpty);
                if (!isEmpty && (item != null)) {
                    // Bold label for name of package
                    Label packageName = new Label(item.getName());
                    packageName.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");

                    // Set the graphic for the cell with package details
                    setGraphic(new VBox(
                            packageName,
                            new Label(item.getDescription()),
                            new Label("Stock: " + item.getStock()),
                            new Label("Price: $" + item.getPrice()),
                            new Label("Location: " + item.getLocation()),
                            new Label("Travel Type: " + item.getTravelType()),
                            new Label("Continent: " + item.getContinent())
                    ));
                } else {
                    // Clear the cell if item is empty or null
                    setGraphic(null);
                    setText(null);
                }
            }
        };
    }

    private Node createFilterBar() {
        HBox filterNavigation = new HBox();
        filterNavigation.setSpacing(10);
        filterNavigation.setPadding(new Insets(10));
        filterNavigation.setAlignment(Pos.CENTER_LEFT);

        // Dropdown for selecting continent
        ComboBox<String> continentDropdown = new ComboBox<>();
        continentDropdown.getItems().addAll("All", "Asia", "Africa", "North America", "South America",
                "Antarctica", "Oceania");
        continentDropdown.setValue("All"); // Default

        // Dropdown for selecting travel type
        ComboBox<String> travelTypeDropdown = new ComboBox<>();
        travelTypeDropdown.getItems().addAll("All", "Cruise", "Plane", "Train", "Bus", "Ferry");
        travelTypeDropdown.setValue("All"); // Default

        //Dropdown for selecting sorting Type
        ComboBox<String> sortOptions = new ComboBox<>();
        sortOptions.getItems().addAll("None","Price", "Stock");
        sortOptions.setValue("None"); // Default

        // ToggleButtons for sorting
        ToggleButton toggleSort = new ToggleButton("Ascending");

        toggleSort.setOnAction(event -> {
            boolean ascending = toggleSort.isSelected();
            if (ascending){
                toggleSort.setText("Ascending");
            }
            else {
                toggleSort.setText("Descending");
            }
        });

        // Button to apply the filter
        Button filterButton = new Button("Filter");
        filterButton.setOnAction(event ->
                applyFilter(continentDropdown.getValue(), travelTypeDropdown.getValue(),
                    sortOptions.getValue(),toggleSort.isSelected())
        );

        // Add components to the filter bar
        filterNavigation.getChildren().addAll(
                new Label("Continent: "), continentDropdown,
                new Label("Travel Type: "), travelTypeDropdown,
                new Label("Sort by: "), sortOptions,
                new Label("Order: "), toggleSort,
                filterButton
        );

        return filterNavigation;
    }

    private void applyFilter(String continent, String travelType,
        String sortingType,Boolean isAscending) {
        ObservableList<TravelPackage> fullList = model.getTravelPackageList();

        // Filter the list based on selected continent and travel type
        ObservableList<TravelPackage> filteredList = fullList.filtered(travelPackage -> {
            boolean continentFilter = continent.equals("All") || continent.equals(travelPackage.getContinent());
            boolean travelTypeFilter = travelType.equals("All") || travelType.equals(travelPackage.getTravelType());
            return continentFilter && travelTypeFilter;
        });
        SortedList<TravelPackage> sortedList = new SortedList<>(filteredList);
        //Sort List
        if (sortingType.equals("Price")) {
            sortedList.setComparator(Comparator.comparingDouble(TravelPackage::getPrice));
        } else if(sortingType.equals("Stock")) {
            sortedList.setComparator(Comparator.comparingInt(TravelPackage::getStock));
        }
        else {
            sortedList.setComparator(null);
        }
        // Apply reversed order if the list is sorted and in descending order
        if (sortedList.getComparator() != null && !isAscending) {
            sortedList.setComparator(sortedList.getComparator().reversed());
        }

        // Update the model with the filtered list
        model.setFilteredTravelPackageList(sortedList);
    }
}
