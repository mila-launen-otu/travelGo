
import com.example.exp.travelgogui.TravelDatabaseApplication;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

@ExtendWith(ApplicationExtension.class)
public class Tests {
    @Start
    void onStart(Stage stage) {
        Parent sceneRoot = new TravelDatabaseApplication.ClickPane();
        Scene scene = new Scene(sceneRoot, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    void should_contain_button() {
        // expect:
        verifyThat(".button", hasText("Add Travel Package"));
    }

    @Test
    void should_click_on_button(FxRobot robot) {
        // when:
        robot.clickOn("Remove Selected Travel Package");

        // then:
        verifyThat(".button", hasText("Add Travel Package"));
    }
}
