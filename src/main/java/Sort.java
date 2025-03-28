import java.util.ArrayList;

public class Sort {
    public static void SortStock(TravelPackageList initalList){
        int i, j;
        TravelPackage temp;
        boolean swapped;
        int n = initalList.getPackages().size();
        ArrayList<TravelPackage> newList = (ArrayList<TravelPackage>) initalList.getPackages();

        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (newList.get(j).getStock() > newList.get(j + 1).getStock()) {

                    // Swap arr[j] and arr[j+1]
                    temp = newList.get(j);
                    newList.set(j, newList.get(j+1));
                    newList.set(j+1, temp);
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }

    }
    public static void SortPrice(TravelPackageList initalList){
        int i, j;
        TravelPackage temp;
        boolean swapped;
        int n = initalList.getPackages().size();
        ArrayList<TravelPackage> newList = (ArrayList<TravelPackage>) initalList.getPackages();

        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (newList.get(j).getPrice() > newList.get(j + 1).getPrice()) {

                    // Swap arr[j] and arr[j+1]
                    temp = newList.get(j);
                    newList.set(j, newList.get(j+1));
                    newList.set(j+1, temp);
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }

    }
}
