import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    TravelPackageManager manager = new TravelPackageManager();

    List<TravelPackage> packageList = Arrays.asList(
            new TravelPackage("Jamaica All Inclusive", "An Amazing island getaway!", 5, 499.99),
            new TravelPackage("Japan Cherry Blossoms", "Explore Japan in cherry blossom season!", 10, 1500.99)
    );

    TravelPackageList travelPackageList = new TravelPackageList(packageList);

    try {
      // Save packages
      manager.savePackages(travelPackageList);
      System.out.println("Packages saved to XML.");

      // Load packages
      TravelPackageList loadedPackages = manager.loadPackages();
      System.out.println("Loaded Packages: " + loadedPackages.getPackages().size());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}