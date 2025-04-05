package translucent;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileCleanupTest {
  private static final String TEST_FILE = "test_travel_packages.xml";
  private final XmlMapper xmlMapper = new XmlMapper();

  @Test
  void testDeleteRemovesFromFile() throws IOException {
    // Step 1: Save a package
    TravelPackageList list = new TravelPackageList();
    TravelPackage pkg = new TravelPackage(
            "Temp",
            "Desc",
            2,
            150.0,
            "Rome",
            "Flight",
            "Europe",
            "img.jpg"
    );
    list.getPackages().add(pkg);
    xmlMapper.writeValue(new File(TEST_FILE), list);

    // Step 2: Remove it and save again
    list.getPackages().remove(pkg);
    xmlMapper.writeValue(new File(TEST_FILE), list);

    // Step 3: Reload from file and check
    TravelPackageList reloaded = xmlMapper.readValue(new File(TEST_FILE), TravelPackageList.class);
    assertTrue(reloaded.getPackages().isEmpty(), "Expected empty list after deletion.");
  }

  @AfterEach
  void cleanup() {
    File file = new File(TEST_FILE);
    if (!file.delete()) {
      System.err.println("WARNING: Test file not deleted.");
    }
  }
}