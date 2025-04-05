package integration;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelDatabase;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseQueryTest {
    @Test
    void testDatabaseQueryReturnsList() throws IOException {
        TravelDatabase db = new TravelDatabase();

        // Add a dummy package to ensure list is not empty
        TravelPackageList sampleList = new TravelPackageList();
        sampleList.getPackages().add(new TravelPackage(
                "Test Trip",
                "Description",
                3,
                299.99,
                "Toronto",
                "Bus",
                "North America",
                "sample.jpg"
        ));

        db.savePackages(sampleList); // Save a non-empty list

        TravelPackageList list = db.loadPackages();

        assertNotNull(list);
        assertFalse(list.getPackages().isEmpty(), "Database should not return an empty list in normal cases.");
    }
}
