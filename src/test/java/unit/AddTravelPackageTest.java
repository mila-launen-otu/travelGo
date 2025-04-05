package unit;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTravelPackageTest {
    @Test
    void testAddTravelPackage() {
        TravelPackageList list = new TravelPackageList();
        TravelPackage pkg = new TravelPackage(
                "Beach Trip",
                "Relax by the shore",
                10,
                499.99,
                "Bali",
                "Cruise",
                "Asia",
                "beach.jpg"
        );

        list.getPackages().add(pkg);
        assertTrue(list.getPackages().contains(pkg));
    }
}
