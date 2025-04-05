package unit;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterStockSizeTest {
    @Test
    void testFilterStockRange() {
        TravelPackageList travelPackages = new TravelPackageList();
        travelPackages.getPackages().add(new TravelPackage("A", "", 2, 100.0, "", "", "", ""));
        travelPackages.getPackages().add(new TravelPackage("B", "", 8, 200.0, "", "", "", ""));
        travelPackages.getPackages().add(new TravelPackage("C", "", 4, 300.0, "", "", "", ""));

        List<TravelPackage> filteredPackages = travelPackages.getPackages().stream()
                .filter(pkg -> pkg.getStock() >= 0 && pkg.getStock() <= 6)
                .toList();

        assertEquals(2, filteredPackages.size());
    }
}
