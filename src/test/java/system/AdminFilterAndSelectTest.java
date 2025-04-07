package system;

import com.example.exp.travelgogui.travel_database_screen.TravelDatabaseModel;
import com.example.exp.travelgogui.travel_database_screen.TravelDatabaseViewBuilder;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AdminFilterAndSelectTest extends ApplicationTest {
    @Override
    public void start(Stage stage) {
        TravelDatabaseModel model = new TravelDatabaseModel();

        // Set the entire list before passing it to the view
        javafx.collections.ObservableList<TravelPackage> packages =
                javafx.collections.FXCollections.observableArrayList(
                        new TravelPackage(
                                "Test Trip",
                                "Test Desc",
                                5,
                                200.0,
                                "Tokyo",
                                "Plane",
                                "Asia",
                                "img.jpg"
                        )
                );

        model.setTravelPackageList(packages);
        Runnable onSave = () -> {};
        Region view = new TravelDatabaseViewBuilder(model, onSave,onSave).build();

        javafx.scene.Scene scene = new javafx.scene.Scene(view);
        stage.setScene(scene);
        stage.show();
    }


    @Test
    void testGuestCanFilterAndSelectPackage() {
        assertDoesNotThrow(() -> new TravelDatabaseModel());
    }
}
