package com.example.exp.travelgogui;

import com.example.exp.travelgogui.backend.TravelPackage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;

public class TravelPackageDetailView {
  public static void newView(TravelPackage travelPackage) {
    Stage stage = new Stage();
    stage.setTitle(travelPackage.getName());

    // Left Side: Information about the travel package
    VBox infoBox = new VBox(10);
    infoBox.setPadding(new Insets(10));
    infoBox.getChildren().addAll(
            labeledValue("Package Name: ", travelPackage.getName()),
            labeledValue("Stock: ", String.valueOf(travelPackage.getStock())),
            labeledValue("Price: ", "$" + travelPackage.getPrice()),
            labeledValue("Location: ", travelPackage.getLocation()),
            labeledValue("Travel Type: ", travelPackage.getTravelType()),
            labeledValue("Continent: ", travelPackage.getContinent())
    );

    // Description (Bottom Left Side)
    Label descriptionLabel = new Label("Description:");
    descriptionLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");

    Label descriptionValue = new Label(travelPackage.getDescription());
    descriptionValue.setWrapText(true);
    descriptionValue.setStyle("-fx-font-size: 14;");

    descriptionLabel.setMaxWidth(400);
    VBox descriptionSection = new VBox(5, descriptionLabel, descriptionValue);
    VBox leftPane = new VBox(infoBox, descriptionSection);
    VBox.setVgrow(descriptionLabel, Priority.ALWAYS);
    leftPane.setPadding(new Insets(10));
    leftPane.setSpacing(15);
    leftPane.setPrefWidth(450);

    // Right Side: Image of the travel package
    Image image;

    try {
      // Try to load the image from the specified URL
      File imageFile = new File(System.getProperty("user.dir"), travelPackage.getImageUrl());
      if (imageFile.exists()) {
        image = new Image(imageFile.toURI().toString());
      } else {
        throw new Exception();
      }
    } catch (Exception e) {
      // Fallback to a default image if the specified image is not found
      URL fallbackURL = TravelPackageDetailView.class.getResource("/images/default.jpg");

      if (fallbackURL != null) {
        image = new Image(fallbackURL.toExternalForm());
      } else {
        System.out.println("Default Image not found");
        image = new Image("https://via.placeholder.com/400");
      }
    }

    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(400);
    imageView.setPreserveRatio(true);
    StackPane imagePane = new StackPane(imageView);
    imagePane.setPadding(new Insets(10));
    imagePane.setAlignment(Pos.CENTER);

    // Main Layout: Combine left and right sides
    HBox root = new HBox(leftPane, imagePane);
    Scene scene = new Scene(root, 900, 500);
    stage.setScene(scene);
    stage.show();
  }

  // Helper method to create a labeled value pair
  private static HBox labeledValue(String labelText, String valueText) {
    Label label = new Label(labelText);
    label.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");

    Label value = new Label(valueText);
    value.setStyle("-fx-font: 14;");

    HBox box = new HBox(5, label, value);

    return box;
  }
}