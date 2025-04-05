package integration;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelDatabase;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseQueryTest {
    @Test
    void testDatabaseQueryReturnsList() throws IOException {
        TravelDatabase db = new TravelDatabase("test_travel_packages.xml");

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

        db.savePackages(sampleList);
        TravelPackageList list = db.loadPackages();

        assertNotNull(list);
        assertFalse(list.getPackages().isEmpty());
        new File("test_travel_packages.xml").delete(); // clean up
    }

}
