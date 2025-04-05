package translucent;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MemoryManagementTest {
  @Test
  void testBulkLoadMemorySafe() {
    long before = Runtime.getRuntime().freeMemory();
    List<TravelPackage> packages = new ArrayList<>();

    for (int i = 0; i < 100000; i++) {
      packages.add(new TravelPackage(
              "Trip " + i,
              "Desc",
              10,
              100 + i,
              "City",
              "Type",
              "Continent",
              "img.jpg"
      ));
    }

    long timeAfter = Runtime.getRuntime().freeMemory();
    long memoryUsed = before - timeAfter;
    System.out.println("Memory Used: " + memoryUsed / 1024 + " KB");

    // Arbitrary limit – adjust based on your system's capacity
    assertTrue(memoryUsed < 500 * 1024 * 1024, "Memory usage is too high!");
  }
}