package com.example.exp.travelgogui.travel_database_screen;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import java.util.Comparator;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.Builder;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.web.WebView;

import static com.example.exp.travelgogui.travel_database_screen.components.TravelPackageDialogs.*;

public class TravelDatabaseViewBuilder implements Builder<Region> {
    private final TravelDatabaseModel model;
    private final Runnable onSave;
    private final Runnable logOut;
    private final ListView<TravelPackage> listView = new ListView<>();

    /**
     * Constructor to initialize the TravelDatabaseViewBuilder with the given parameters.
     *
     * @param model The TravelDatabaseModel to be used by the view builder.
     * @param onSave A Runnable to handle saving travel packages.
     * @param logOut A Runnable to handle logging out of the travel database.
     */
    public TravelDatabaseViewBuilder(TravelDatabaseModel model,Runnable onSave,Runnable logOut) {
        this.model = model;
        this.onSave = onSave;
        this.logOut = logOut;
        setInitalFilter();
    }

    /**
     * Sets the initial filter for the travel packages.
     */
    private void setInitalFilter(){
        applyFilter("All", "All","None",true);
    }

    /**
     * Builds the main view for the travel database.
     *
     * @return The built Region view.
     */
    @Override
    public Region build() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(1280,720);
        Node adminBar = adminBar();
        adminBar.visibleProperty().bind(model.isLoggedIn);
        adminBar.managedProperty().bind(model.isLoggedIn);
        borderPane.setTop(new VBox(adminBar,createFilterBar()));
        borderPane.setCenter(travelPackagesBox());
        return borderPane;
    }

    /**
     * Creates the admin bar with buttons for managing travel packages.
     *
     * @return The admin bar Node.
     */
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

        // Help button
        Button helpButton = new Button("Help");
        helpButton.setOnAction(e -> showHelpWindow());

        HBox hBox = new HBox(
                addButton,
                removeButton,
                updateButton,
                saveButton,
                helpButton
        );
        hBox.setPadding(new Insets(5));
        hBox.setSpacing(25);
        return hBox;
    }

    /**
     * Creates the travel packages box with a ListView.
     *
     * @return The travel packages box Node.
     */
    private Node travelPackagesBox() {
        // Set the cell factory for the ListView to use custom cells
        listView.setCellFactory(travelPackage -> createCell());

        // Bind the items property of the ListView to the filtered travel package list
        listView.itemsProperty().bind(model.filteredTravelPackageList());

        // Add a listener to update the selected item property in the model when the selection changes
        listView.getSelectionModel().getSelectedIndices().addListener(
                (ListChangeListener<? super Integer>) change -> {
                    if (!change.getList().isEmpty()) {
                        model.setSelectedItemProperty(change.getList().get(0));
                    }
                }
        );

        return listView;
    }

    /**
     * Creates a custom ListCell for TravelPackages.
     *
     * @return The custom ListCell.
     */
    // Custom ListCell for TravelPackages
    private ListCell<TravelPackage> createCell() {
        ListCell<TravelPackage> cell = new ListCell<>() {
            @Override
            protected void updateItem(TravelPackage item, boolean empty) {
                super.updateItem(item, empty);

                if (item != null && !isEmpty()) {
                    // Create a label for the package name with bold and larger font
                    Label packageName = new Label(item.getName());
                    packageName.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");

                    // Create a VBox to hold the package details
                    VBox content = new VBox(
                            packageName,
                            new Label(item.getDescription()),
                            new Label("Stock: " + item.getStock()),
                            new Label("Price: $" + item.getPrice()),
                            new Label("Location: " + item.getLocation()),
                            new Label("Travel Type: " + item.getTravelType()),
                            new Label("Continent: " + item.getContinent())
                    );

                    // Set the VBox as the graphic for the cell
                    setGraphic(content);
                } else {
                    // Clear the graphic and text if the item is null or empty
                    setGraphic(null);
                    setText(null);
                }
            }
        };

        // Add a mouse click listener to open the detail view on double-click
        cell.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && !cell.isEmpty()) {
                TravelPackage clicked = cell.getItem();
                TravelPackageDetailView.newView(cell.getItem());
            }
        });

        return cell;
    }

    /**
     * Creates the filter bar with dropdowns and buttons for filtering travel packages.
     *
     * @return The filter bar Node.
     */
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
        Button logOutButton = new Button("Log Out");
        logOutButton.setOnAction(event -> logOut.run());
        // Add components to the filter bar
        filterNavigation.getChildren().addAll(
                new Label("Continent: "), continentDropdown,
                new Label("Travel Type: "), travelTypeDropdown,
                new Label("Sort by: "), sortOptions,
                new Label("Order: "), toggleSort,
                filterButton,
                new Separator(Orientation.VERTICAL),
                logOutButton
        );

        return filterNavigation;
    }

    /**
     * Applies the filter to the travel packages based on the selected criteria.
     *
     * @param continent The selected continent.
     * @param travelType The selected travel type.
     * @param sortingType The selected sorting type.
     * @param isAscending Whether the sorting is in ascending order.
     */
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

    /**
     * Helper method to show the help window.
     */
    // Helper method to show the help window
    private void showHelpWindow() {
        // Create a new stage for the help window
        Stage helpStage = new Stage();
        helpStage.setTitle("Help & Documentation");

        // Create a WebView to display the help content
        WebView webView = new WebView();
        String htmlContent = """
            <html>
            <head>
                <style>
                    body { font-family: sans-serif; padding: 20px; }
                    h1, h2 { color: #2e6da4; }
                    ul { margin-left: 20px; }
                </style>
            </head>
            <body>
                <h1>User Guide for Travel Package Management Application</h1>
                <h2>Introduction</h2>
                <p>Welcome to the Travel Package Management Application! This guide will walk you through the steps of using the application effectively, whether you are an Admin or a Normal User.</p>
        
                <h2>Getting Started</h2>
                <ul>
                    <li><b>Log In:</b> Upon launching the application, you will be prompted to log in.</li>
                    <li><b>Select User Type:</b><br>
                        <ul>
                            <li><b>Admin:</b> Full permissions to edit, add, delete, and filter travel packages.</li>
                            <li><b>Normal User:</b> Can filter available travel packages based on specific criteria.</li>
                        </ul>
                    </li>
                </ul>
        
                <h2>Admin Features</h2>
                <ul>
                    <li><b>Editing a Travel Package:</b>
                        <ol>
                            <li>Click “Update Travel Package”.</li>
                            <li>Select the package to edit.</li>
                            <li>Edit the attributes and save changes.</li>
                        </ol>
                    </li>
                    <li><b>Adding a Travel Package:</b>
                        <ol>
                            <li>Click “Add Travel Package”.</li>
                            <li>Fill in details and click Save.</li>
                        </ol>
                    </li>
                    <li><b>Deleting a Travel Package:</b>
                        <ol>
                            <li>Select a travel package.</li>
                            <li>Click “Remove Selected Travel Package”.</li>
                        </ol>
                    </li>
                </ul>
        
                <h2>Normal User & Developer Features</h2>
                <p>Filter available travel packages:</p>
                <ul>
                    <li>Go to the filtering section (second header).</li>
                    <li>Select:
                        <ul>
                            <li><b>Region</b></li>
                            <li><b>Travel Type</b></li>
                            <li><b>Price Range</b></li>
                            <li><b>Stock Availability</b></li>
                        </ul>
                    </li>
                    <li>Click <b>Filter</b> to see results.</li>
                </ul>
        
                <h2>Conclusion</h2>
                <p>This app helps Admins manage and Users find travel packages with ease. If you get stuck, come back to this guide. Happy browsing!</p>
            </body>
            </html>
            """;

        // Load the HTML content into the WebView
        webView.getEngine().loadContent(htmlContent);

        // Create a layout for the WebView
        VBox layout = new VBox(webView);
        VBox.setVgrow(webView, Priority.ALWAYS);

        // Create a scene for the help window
        Scene helpScene = new Scene(layout, 600, 500);
        helpStage.setScene(helpScene);

        // Set the modality of the help window to block input events to other windows
        helpStage.initModality(Modality.APPLICATION_MODAL);

        // Show the help window and wait for it to be closed before returning to the caller
        helpStage.showAndWait();
    }
}
