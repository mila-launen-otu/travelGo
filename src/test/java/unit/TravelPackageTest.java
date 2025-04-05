package unit;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelPackageTest {
  @Test
  void testConstructorSetsValues() {
    TravelPackage p = new TravelPackage("Test", "Desc", 5, 199.99, "Paris", "Train", "Europe", "image.jpg");
    assertEquals("Test", p.getName());
    assertEquals(5, p.getStock());
  }
}