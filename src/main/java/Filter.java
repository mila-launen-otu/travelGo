import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.List;
//class that filters stock
public class Filter {
    //filter stock, returns travel PackagePackageList
    public static TravelPackageList filterStock(int min, int max, TravelPackageList initalList) {
        List<TravelPackage> modList = new ArrayList<TravelPackage>();
        for(int i = 0; i < initalList.getPackages().size(); i ++){
            if(initalList.getPackage(i).getStock() < max && initalList.getPackage(i).getStock() >= min){
                modList.add(initalList.getPackage(i));
            }
        }
        return new TravelPackageList(modList);
    }
    public static TravelPackageList filterPrice(float min, float max, TravelPackageList initalList) {
        List<TravelPackage> modList = new ArrayList<TravelPackage>();
        for(int i = 0; i < initalList.getPackages().size(); i ++){
            if(initalList.getPackage(i).getStock() < max && initalList.getPackage(i).getStock() >= min){
                modList.add(initalList.getPackage(i));
            }
        }
        return new TravelPackageList(modList);
    }
    public static TravelPackageList filterContinent(Continent continent, TravelPackageList initalList) {
        List<TravelPackage> modList = new ArrayList<TravelPackage>();
        for(int i = 0; i < initalList.getPackages().size(); i ++){
            if(initalList.getPackage(i).getContinent() == continent){
                modList.add(initalList.getPackage(i));
            }
        }
        return new TravelPackageList(modList);
    }
    public static TravelPackageList filterTravelType(String Type, TravelPackageList initalList) {
        List<TravelPackage> modList = new ArrayList<TravelPackage>();
        for(int i = 0; i < initalList.getPackages().size(); i ++){
            if(initalList.getTravelType().equals("Travel")){
                modList.add(initalList.getPackage(i));
            }
        }
        return new TravelPackageList(modList);
    }
}

