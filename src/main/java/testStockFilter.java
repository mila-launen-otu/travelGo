import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class testStockFilter {
    public TravelPackageList FakeTravelPackages(){
        List<TravelPackage> packageList = Arrays.asList(
                new TravelPackage("Jamaica All Inclusive", "An Amazing island getaway!", 5, 499.99),
                new TravelPackage("Japan Cherry Blossoms", "Explore Japan in cherry blossom season!", 10, 1000.21),
                new TravelPackage("African Lion Safari", "See beautiful Animals", 12, 1500.99)
        );
        return new TravelPackageList(packageList);
    }
    @Test
    public void filterStockSizeRed(){
        int min = 0;
        int max = 6;
        TravelPackageList listFiltered = FakeTravelPackages();
        assert listFiltered.getPackages().size() == 1;
    }

    @Test
    public void filterStockSize(){
        int min = 0;
        int max = 6;
        TravelPackageList listFiltered = Filter.filterStock(min, max, FakeTravelPackages());
        assert listFiltered.getPackages().size() == 1;

    }
    @Test
    public void filterStockData(){
        int min = 0;
        int max = 6;
        TravelPackageList testPackages = FakeTravelPackages();

        TravelPackageList listFiltered = Filter.filterStock(min, max, testPackages);
        for(int i = 0; i < listFiltered.getPackages().size(); i ++){
           assert listFiltered.getPackage(i).getStock() <= 6;
        }

    }


}
