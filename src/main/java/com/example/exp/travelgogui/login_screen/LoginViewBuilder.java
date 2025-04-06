package com.example.exp.travelgogui.login_screen;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class LoginViewBuilder implements Builder<Region> {
    private final LoginModel model;
    private final Runnable guestLogin;
    private final functionalInterface adminLogin;
    public LoginViewBuilder(LoginModel model, Runnable runExample,functionalInterface functionalInterface) {
        this.model = model;
        guestLogin = runExample;
        this.adminLogin=functionalInterface;
    }
    @Override
    public Region build() {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(adminLoginScreen());
        borderPane.setPrefSize(550,300);
        return borderPane;
    }
    private Node adminLoginScreen(){
        Form loginForm = Form.of(
                Group.of(
                        Field.ofStringType(model.userName)
                                .label("Username"),
                        Field.ofStringType(model.password)
                                .label("Password")
                                .required("This field can’t be empty")
                )
        ).title("Login");
        Button adminButton = new Button("Login as Admin");
        Button guestButton = new Button("Continue as Guest");
        guestButton.setOnAction(evt->{
            guestLogin.run();
        });
        adminButton.setOnAction(evt->{
            loginForm.persist();
            adminLogin.execute(
                () -> {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Login Error");
                    alert.setHeaderText("Incorrect Username or Password");
                    alert.setContentText("Please check your username and password and try again.");
                    alert.showAndWait();
                },model.userName.get(), model.password.get());
        });
        adminButton.setMaxWidth(500);
        guestButton.setMaxWidth(500);
        VBox vbox = new VBox(
                new Label("Login"),
                new FormRenderer(loginForm),
                adminButton,
                guestButton
        );
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);
        return vbox;
    }
}
