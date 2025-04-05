package integration;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelDatabase;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FrontendAPITest {
    @Test
    void testApiLoadsPackages() throws IOException {
        TravelDatabase db = new TravelDatabase("test_travel_packages.xml"); // use test file
        db.savePackages(new TravelPackageList());
        assertDoesNotThrow(() -> {
            TravelPackageList list = db.loadPackages();
            assertNotNull(list.getPackages());
        });
        new File("test_travel_packages.xml").delete(); // clean up
    }
}
