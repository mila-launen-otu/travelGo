package system;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AdminDeletePackageTest {
    @Test
    void testDeleteTravelPackage() {
        TravelPackageList list = new TravelPackageList();
        TravelPackage pkg = new TravelPackage(
                "To Delete",
                "Remove me",
                4, 300.0,
                "Lisbon",
                "Bus",
                "Europe",
                "img.jpg"
        );

        list.getPackages().add(pkg);
        list.getPackages().remove(pkg);

        assertFalse(list.getPackages().contains(pkg));
    }
}
