package integration;

import com.example.exp.travelgogui.travel_database_screen.TravelDatabaseModel;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FrontendListDisplayTest {
    @Test
    void testModelPopulatesCorrectly() {
        TravelDatabaseModel model = new TravelDatabaseModel();
        ObservableList<TravelPackage> list = FXCollections.observableArrayList();
        TravelPackage sample = new TravelPackage("UI Test", "", 5, 250.0, "", "", "", "");
        list.add(sample);
        model.setTravelPackageList(list);

        assertNotNull(model.getTravelPackageList());
        assertEquals("UI Test", model.getTravelPackageList().get(0).getName());
    }
}