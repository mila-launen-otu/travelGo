// Test: TravelDatabaseIOTest.java
package unit;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelDatabase;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class TravelDatabaseIOTest {
  @Test
  void testLoadThrowsIOExceptionOnCorruptFile() {
    File file = new File("travel_packages.xml");
    try {
      if (!file.exists()) file.createNewFile();
      java.nio.file.Files.write(file.toPath(), "not xml".getBytes());
    } catch (IOException e) {
      fail("Failed to create corrupt file");
    }

    TravelDatabase db = new TravelDatabase();
    assertThrows(IOException.class, db::loadPackages);
  }
}