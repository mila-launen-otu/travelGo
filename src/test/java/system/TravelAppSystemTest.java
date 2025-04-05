package system;

import com.example.exp.travelgogui.travel_database_screen.TravelDatabaseModel;
import com.example.exp.travelgogui.travel_database_screen.TravelDatabaseViewBuilder;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

class TravelAppSystemTest extends ApplicationTest {
  @Override
  public void start(Stage stage) {
    TravelDatabaseModel testModel = new TravelDatabaseModel();

    // Dummy data to prevent NPE
    javafx.collections.ObservableList<com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage> list =
            javafx.collections.FXCollections.observableArrayList(
                    new com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage(
                            "Sample Package",
                            "Test Desc",
                            5,
                            999.0,
                            "Paris",
                            "Plane",
                            "Europe",
                            "img.jpg"
                    )
            );
    testModel.setTravelPackageList(list);
    Runnable testOnSave = () -> {};

    javafx.scene.Scene scene = new javafx.scene.Scene(new TravelDatabaseViewBuilder(testModel, testOnSave).build());
    stage.setScene(scene);
    stage.show();
  }

  @Test
  void testApplicationLaunches() {
    // Basic GUI launch test – pass if no crash
  }
}