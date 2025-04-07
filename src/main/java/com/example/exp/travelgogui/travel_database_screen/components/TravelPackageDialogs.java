package com.example.exp.travelgogui.travel_database_screen.components;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import java.io.File;

public class TravelPackageDialogs {
    static public Dialog<TravelPackage> AddTravelPackageDialog() {
        // Initialize properties for the travel package fields
        StringProperty nameProperty = new SimpleStringProperty("");
        StringProperty descriptionProperty = new SimpleStringProperty("");
        IntegerProperty stockProperty = new SimpleIntegerProperty();
        DoubleProperty priceProperty = new SimpleDoubleProperty();
        StringProperty locationProperty = new SimpleStringProperty("");
        StringProperty imageURLProperty = new SimpleStringProperty("");

        // Properties for Combo Boxes
        ObjectProperty<String> continentProperty = new SimpleObjectProperty<>();
        ObservableList<String> continentObservableList = FXCollections.observableArrayList(
            "Africa", "Antarctica", "Asia", "Europe", "North America", "Oceania", "South America"
        );
        ListProperty<String> continentList = new SimpleListProperty<>(continentObservableList);

        ObjectProperty<String> travelTypeProperty = new SimpleObjectProperty<>();
        ObservableList<String> travelTypeObservableList = FXCollections.observableArrayList(
            "Cruise", "Plane", "Train", "Bus", "Ferry"
        );
        ListProperty<String> travelTypeList = new SimpleListProperty<>(travelTypeObservableList);

        // Create the dialog
        Dialog<TravelPackage> dialog = new Dialog<>();
        dialog.setTitle("Add Travel Package");
        DialogPane dialogPane = new DialogPane();

        // Create the form with fields
        Form form = Form.of(
                Group.of(
                        Field.ofStringType(nameProperty)
                                .label("Name")
                                .required("This field can’t be empty"),
                        Field.ofStringType(descriptionProperty)
                                .label("Description")
                                .required("This field can’t be empty"),
                        Field.ofIntegerType(stockProperty)
                                .label("Stock")
                                .required("This field can’t be empty"),
                        Field.ofDoubleType(priceProperty)
                                .label("Price")
                                .required("This field can’t be empty"),
                        Field.ofStringType(locationProperty).label("Location")
                                .required("This field can't be empty!"),
                        Field.ofSingleSelectionType(travelTypeList, travelTypeProperty)
                                .label("Travel Type")
                                .required("Must Select Travel Type"),
                        Field.ofSingleSelectionType(continentList, continentProperty)
                                .label("Continent ")
                                .required("Must Select Travel Type")
                )
        ).title("Login");

        // Create image selection components
        Label imageLabel = new Label("No file selected");
        Button imageButton = new Button("Choose Image");
        imageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose Image");

            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
            );

            fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") + "/src/main/resources/images"));
            File selectedFile = fileChooser.showOpenDialog(null);

            if (selectedFile != null) {
                String projectDirectory = System.getProperty("user.dir");
                String relativePath = selectedFile.getAbsolutePath().replace(projectDirectory + "/", "");
                imageURLProperty.set(relativePath);
                imageLabel.setText(selectedFile.getName());
            }
        });

        // Add form and image selection to the dialog content
        VBox imageInput = new VBox(5, new Label("Image:"), imageButton, imageLabel);
        VBox dialogContent = new VBox(10, new FormRenderer(form), imageInput);
        dialogPane.setContent(dialogContent);

        // Add buttons to the dialog
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.setDialogPane(dialogPane);

        // Set the result converter to create a TravelPackage object when OK is clicked
        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                form.persist();
                return new TravelPackage(
                        nameProperty.get(),
                        descriptionProperty.get(),
                        stockProperty.get(),
                        priceProperty.get(),
                        locationProperty.get(),
                        travelTypeProperty.get(),
                        continentProperty.get(),
                        imageURLProperty.get()
                );
            } else {
                return null;
            }
        });

        return dialog;
    }

    static public Dialog<TravelPackage> UpdateTravelPackageDialog(TravelPackage travelPackage) {
        // Initialize properties with the current travel package values
        Dialog<TravelPackage> dialog = new Dialog<>();
        dialog.setTitle("Update Travel Package");
        DialogPane dialogPane = new DialogPane();
        StringProperty nameProperty = new SimpleStringProperty(travelPackage.getName());
        StringProperty descriptionProperty = new SimpleStringProperty(travelPackage.getDescription());
        IntegerProperty stockProperty = new SimpleIntegerProperty(travelPackage.getStock());
        DoubleProperty priceProperty = new SimpleDoubleProperty(travelPackage.getPrice());
        StringProperty locationProperty = new SimpleStringProperty(travelPackage.getLocation());
        StringProperty imageURLProperty = new SimpleStringProperty("");

        // Properties for Combo Boxes
        ObjectProperty<String> continentProperty = new SimpleObjectProperty<>(travelPackage.getContinent());
        ObservableList<String> continentObservableList = FXCollections.observableArrayList(
            "Africa", "Antarctica", "Asia", "Europe", "North America", "Oceania", "South America"
        );
        ListProperty<String> continentList = new SimpleListProperty<>(continentObservableList);

        ObjectProperty<String> travelTypeProperty = new SimpleObjectProperty<>(travelPackage.getTravelType());
        ObservableList<String> travelTypeObservableList = FXCollections.observableArrayList(
            "Cruise", "Plane", "Train", "Bus", "Ferry"
        );
        ListProperty<String> travelTypeList = new SimpleListProperty<>(travelTypeObservableList);

        // Create the form with fields
        Form form = Form.of(
                Group.of(
                        Field.ofStringType(nameProperty)
                                .label("Name")
                                .required("This field can’t be empty"),
                        Field.ofStringType(descriptionProperty)
                                .label("Description")
                                .required("This field can’t be empty"),
                        Field.ofIntegerType(stockProperty)
                                .label("Stock")
                                .required("This field can’t be empty"),
                        Field.ofDoubleType(priceProperty)
                                .label("Price")
                                .required("This field can’t be empty"),
                        Field.ofStringType(locationProperty).label("Location")
                                .required("This field can't be empty!"),
                        Field.ofSingleSelectionType(travelTypeList, travelTypeProperty)
                                .label("Travel Type")
                                .required("Must Select Travel Type"),
                        Field.ofSingleSelectionType(continentList, continentProperty)
                                .label("Continent ")
                                .required("Must Select Travel Type")
                )
        ).title("Edit Travel Package");

        // Create image selection components
        Label imageLabel = new Label("No file selected");
        Button imageButton = new Button("Choose Image");
        imageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose Image");

            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
            );

            fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") + "/src/main/resources/images"));
            File selectedFile = fileChooser.showOpenDialog(null);

            if (selectedFile != null) {
                String projectDirectory = System.getProperty("user.dir");
                String relativePath = selectedFile.getAbsolutePath().replace(projectDirectory + "/", "");
                imageURLProperty.set(relativePath);
                imageLabel.setText(selectedFile.getName());
            }
        });

        // Add form and image selection to the dialog content
        VBox imageInput = new VBox(5, new Label("Image:"), imageButton, imageLabel);
        VBox dialogContent = new VBox(10, new FormRenderer(form), imageInput);
        dialogPane.setContent(dialogContent);

        // Add buttons to the dialog
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.setDialogPane(dialogPane);

        // Set the result converter to update the TravelPackage object when OK is clicked
        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                form.persist();
                return new TravelPackage(
                        nameProperty.get(),
                        descriptionProperty.get(),
                        stockProperty.get(),
                        priceProperty.get(),
                        locationProperty.get(),
                        travelTypeProperty.get(),
                        continentProperty.get(),
                        imageURLProperty.get()
                );
            } else {
                return null;
            }
        });

        return dialog;
    }
}
