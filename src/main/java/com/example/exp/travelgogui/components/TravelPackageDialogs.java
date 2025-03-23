package com.example.exp.travelgogui.components;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import com.example.exp.travelgogui.backend.TravelPackage;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;

public class TravelPackageDialogs {
    static public Dialog<TravelPackage> AddTravelPackageDialog(){
        StringProperty nameProperty = new SimpleStringProperty("");
        StringProperty descriptionProperty = new SimpleStringProperty("");
        IntegerProperty stockProperty = new SimpleIntegerProperty();
        DoubleProperty priceProperty = new SimpleDoubleProperty();
        StringProperty locationProperty = new SimpleStringProperty("");
        //Properties for Combo Boxes
        ObjectProperty<String> continentProperty = new SimpleObjectProperty<>();
        ObservableList<String> continentObservableList = FXCollections.observableArrayList(
                "Africa", "Antarctica", "Asia", "Europe", "North America", "Oceania", "South America"
        );
        // Creating a ListProperty and binding it to the observable list
        ListProperty<String> continentList = new SimpleListProperty<>(continentObservableList);
        //
        ObjectProperty<String> travelTypeProperty = new SimpleObjectProperty<>();
        ObservableList<String> travelTypeObservableList = FXCollections.observableArrayList(
                "Cruise","Plane","Train","Bus","Ferry"
        );
        // Creating a ListProperty and binding it to the observable list
        ListProperty<String> travelTypeList = new SimpleListProperty<>(travelTypeObservableList);
        Dialog<TravelPackage> dialog = new Dialog<>();
        dialog.setTitle("Add Travel Package");
        DialogPane dialogPane = new DialogPane();
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
                        Field.ofSingleSelectionType(travelTypeList,travelTypeProperty)
                                .label("Travel Type")
                                .required("Must Select Travel Type"),
                        Field.ofSingleSelectionType(continentList,continentProperty)
                                .label("Continent ")
                                .required("Must Select Travel Type")
                )
        ).title("Login");
        dialogPane.setContent(new FormRenderer(form));
        dialogPane.getButtonTypes().addAll(ButtonType.OK,ButtonType.CLOSE);
        dialogPane.setPrefSize(600,400);
        dialog.setResultConverter(
                buttonType -> {
                    if (buttonType == ButtonType.OK) {
                        form.persist();
                        return new TravelPackage(nameProperty.get(),
                                descriptionProperty.get(),
                                stockProperty.get(),
                                priceProperty.get(),
                                locationProperty.get(),
                                travelTypeProperty.get(),
                                continentProperty.get());
                    }
                    else {
                        return null;
                    }
                }
        );
        dialog.setDialogPane(dialogPane);
        return dialog;
    }
    static public Dialog<TravelPackage> UpdateTravelPackageDialog(TravelPackage travelPackage){
        Dialog<TravelPackage> dialog = new Dialog<>();
        dialog.setTitle("Update Travel Package");
        DialogPane dialogPane = new DialogPane();
        StringProperty nameProperty = new SimpleStringProperty(travelPackage.getName());
        StringProperty descriptionProperty = new SimpleStringProperty(travelPackage.getDescription());
        IntegerProperty stockProperty = new SimpleIntegerProperty(travelPackage.getStock());
        DoubleProperty priceProperty = new SimpleDoubleProperty(travelPackage.getPrice());
        StringProperty locationProperty = new SimpleStringProperty(travelPackage.getLocation());
        //Properties for Combo Boxes
        ObjectProperty<String> continentProperty = new SimpleObjectProperty<>(travelPackage.getContinent());
        ObservableList<String> continentObservableList = FXCollections.observableArrayList(
                "Africa", "Antarctica", "Asia", "Europe", "North America", "Oceania", "South America"
        );
        // Creating a ListProperty and binding it to the observable list
        ListProperty<String> continentList = new SimpleListProperty<>(continentObservableList);
        //
        ObjectProperty<String> travelTypeProperty = new SimpleObjectProperty<>(travelPackage.getTravelType());
        ObservableList<String> travelTypeObservableList = FXCollections.observableArrayList(
                "Cruise","Flight","Train","Bus","Ferry"
        );
        // Creating a ListProperty and binding it to the observable list
        ListProperty<String> travelTypeList = new SimpleListProperty<>(travelTypeObservableList);
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
                        Field.ofSingleSelectionType(travelTypeList,travelTypeProperty)
                                .label("Travel Type")
                                .required("Must Select Travel Type"),
                        Field.ofSingleSelectionType(continentList,continentProperty)
                                .label("Continent ")
                                .required("Must Select Travel Type")

                )
        ).title("Edit Travel Package");
        dialogPane.setContent(new FormRenderer(form));
        dialogPane.getButtonTypes().addAll(ButtonType.OK,ButtonType.CLOSE);
        dialogPane.setPrefSize(600,400);
        dialog.setDialogPane(dialogPane);
        dialog.setResultConverter(
                buttonType -> {
                    if (buttonType == ButtonType.OK) {
                        form.persist();
                        return new TravelPackage(nameProperty.get(),
                                descriptionProperty.get(),
                                stockProperty.get(),
                                priceProperty.get(),
                                locationProperty.get(),
                                travelTypeProperty.get(),
                                continentProperty.get());
                    }
                    else {
                        return null;
                    }
                }
        );
        return dialog;
    }

}
