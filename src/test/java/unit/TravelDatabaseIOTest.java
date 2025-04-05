package unit;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelDatabase;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class TravelDatabaseIOTest {
  @Test
  void testLoadThrowsIOExceptionOnCorruptFile() {
    String testFile = "test_corrupt_travel_packages.xml";
    File file = new File(testFile);

    try {
      // Write invalid content to simulate a corrupted XML
      java.nio.file.Files.write(file.toPath(), "not xml".getBytes());

      // Use the test-specific file for the database
      TravelDatabase db = new TravelDatabase(testFile);

      // Should throw IOException when parsing corrupted XML
      assertThrows(IOException.class, db::loadPackages);

    } catch (IOException e) {
      fail("Unexpected exception during test setup: " + e.getMessage());

    } finally {
      // Ensure cleanup happens even if test fails
      if (file.exists() && !file.delete()) {
        System.err.println("WARNING: failed to delete test file: " + testFile);
      }
    }
  }
}