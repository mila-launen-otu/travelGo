package unit;

import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackageList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterContinentTest {
    @Test
    void testFilterByContinent() {
        TravelPackageList travelPackages = new TravelPackageList();
        travelPackages.getPackages().add(new TravelPackage(
                "Paris",
                "",
                5,
                500.0,
                "",
                "",
                "Europe",
                ""
        ));
        travelPackages.getPackages().add(new TravelPackage(
                "Bangkok",
                "",
                5,
                600.0,
                "",
                "",
                "Asia",
                ""
        ));
        travelPackages.getPackages().add(new TravelPackage(
                "London",
                "",
                5,
                700.0,
                "",
                "",
                "Europe",
                ""
        ));

        List<TravelPackage> filteredPackages = travelPackages.getPackages().stream()
                .filter(pkg -> "Europe".equalsIgnoreCase(pkg.getContinent()))
                .toList();

        assertEquals(2, filteredPackages.size());
    }
}
