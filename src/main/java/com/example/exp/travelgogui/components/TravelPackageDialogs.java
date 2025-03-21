package com.example.exp.travelgogui.components;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import com.example.exp.travelgogui.backend.TravelPackage;
import javafx.beans.property.*;
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
        StringProperty travelTypeProperty = new SimpleStringProperty("");
        StringProperty continentProperty = new SimpleStringProperty("");
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
                        Field.ofStringType(travelTypeProperty).label("Travel Type")
                                .required("This field can't be empty!"),
                        Field.ofStringType(continentProperty).label("Continent")
                                .required("This field can't be empty!")
                )
        ).title("Login");
        dialogPane.setContent(new FormRenderer(form));
        dialogPane.getButtonTypes().addAll(ButtonType.OK,ButtonType.CLOSE);
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
        StringProperty travelTypeProperty = new SimpleStringProperty(travelPackage.getTravelType());
        StringProperty continentProperty = new SimpleStringProperty(travelPackage.getContinent());

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
                                .required("This field can’t be empty")
                )
        ).title("Login");
        dialogPane.setContent(new FormRenderer(form));
        dialogPane.getButtonTypes().addAll(ButtonType.OK,ButtonType.CLOSE);
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
