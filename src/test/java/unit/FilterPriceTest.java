package unit;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterPriceTest {
    @Test
    void testFilterByPrice() {
        TravelPackageList travelPackages = new TravelPackageList();
        travelPackages.getPackages().add(new TravelPackage("Low", "", 3, 150.0, "", "", "", ""));
        travelPackages.getPackages().add(new TravelPackage("Mid", "", 5, 450.0, "", "", "", ""));
        travelPackages.getPackages().add(new TravelPackage("High", "", 6, 900.0, "", "", "", ""));

        List<TravelPackage> filteredPackages = travelPackages.getPackages().stream()
                .filter(pkg -> pkg.getPrice() >= 200 && pkg.getPrice() <= 700)
                .toList();

        assertEquals(1, filteredPackages.size());
        assertEquals("Mid", filteredPackages.get(0).getName());
    }
}
