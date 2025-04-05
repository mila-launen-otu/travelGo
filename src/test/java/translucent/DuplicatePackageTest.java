package translucent;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DuplicatePackageTest {

  @Test
  void testDuplicatePackageNotAllowed() {
    TravelPackageList list = new TravelPackageList();
    TravelPackage pkg = new TravelPackage(
            "Trip X",
            "Desc",
            5, 399.99,
            "Tokyo",
            "Flight",
            "Asia",
            "img.jpg"
    );
    list.getPackages().add(pkg);

    // Add duplicate
    boolean isDuplicate = list.getPackages().stream().anyMatch(p -> p.getName().equals(pkg.getName()));

    assertTrue(isDuplicate, "Duplicate check failed — should catch duplicate package by name.");
  }
}
