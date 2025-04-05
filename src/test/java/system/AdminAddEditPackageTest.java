package system;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminAddEditPackageTest {
    @Test
    void testAddAndEditTravelPackage() {
        TravelPackageList list = new TravelPackageList();
        TravelPackage pkg = new TravelPackage(
                "New Trip",
                "Fun trip",
                8,
                500.0,
                "Berlin",
                "Flight",
                "Europe",
                "img.jpg"
        );

        // Add
        list.getPackages().add(pkg);
        assertTrue(list.getPackages().contains(pkg));

        // Edit
        pkg.setPrice(550.0);
        assertEquals(550.0, pkg.getPrice());
    }
}
