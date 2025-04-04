package com.example.exp.travelgogui.login_screen;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
                        Field.ofStringType(model.userNameProperty)
                                .label("Username"),
                        Field.ofStringType(model.passwordProperty)
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
            adminLogin.execute(model.userNameProperty.get(),model.passwordProperty.get());
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
