import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelPackagesTests {

    @Test
    void TravelPackageListTest(){
        List<TravelPackage> packageList = Arrays.asList(
                new TravelPackage("Jamaica All Inclusive", "An Amazing island getaway!", 5, 499.99),
                new TravelPackage("Japan Cherry Blossoms", "Explore Japan in cherry blossom season!", 10, 1500.99)
        );
        TravelPackageList travelPackageList = new TravelPackageList();
        TravelPackageList travelPackageList2 = new TravelPackageList(packageList);
        travelPackageList.setPackages(packageList);
        assertEquals(packageList,travelPackageList.getPackages());
        assertEquals(travelPackageList2.getPackages(),travelPackageList.getPackages());
    }
    @Test
    void TravelPackageSettersAndGettersTest(){
        TravelPackage travelPackage= new TravelPackage("Jamaica All Inclusive", "An Amazing island getaway!", 5, 499.99);
        assertEquals("Jamaica All Inclusive", travelPackage.getName());
        assertEquals("An Amazing island getaway!", travelPackage.getDescription());
        assertEquals(5, travelPackage.getStock());
        assertEquals(499.99, travelPackage.getPrice());
        new TravelPackage("Japan Cherry Blossoms", "Explore Japan in cherry blossom season!", 10, 1500.99);
        travelPackage.setName("Japan Cherry Blossoms");
        travelPackage.setDescription("Explore Japan in cherry blossom season!");
        travelPackage.setStock(10);
        travelPackage.setPrice(1500.99);
    }
}
