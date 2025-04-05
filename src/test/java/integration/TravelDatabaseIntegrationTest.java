package integration;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelDatabase;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TravelDatabaseIntegrationTest {
  @Test
  void testLoadPackagesDoesNotThrow() throws IOException {
    TravelDatabase db = new TravelDatabase("test_travel_packages.xml");
    db.savePackages(new TravelPackageList());
    assertDoesNotThrow(() -> db.loadPackages());
    new File("test_travel_packages.xml").delete(); // clean up
  }
}