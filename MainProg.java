import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class MainProg {
    public static HashMap<String, TravelPackage> travelPackages = new HashMap<>();

    // Class to store package details
    static class TravelPackage {
        String id;
        String name;
        String description;
        int stock;
        float price;

        public TravelPackage(String name, String description, int stock, float price) {
            this.id = String.valueOf(1000 + (int)(Math.random() * ((9999 - 1000) + 1)));
            this.name = name;
            this.description = description;
            this.stock = stock;
            this.price = price;
        }

        public TravelPackage() {
            this.id = String.valueOf(1000 + (int)(Math.random() * ((9999 - 1000) + 1)));
           this.name = "";
           this.description = "";
           this.stock = 0;
           this.price = 0;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Description: " + description + ", Stock: " + stock + ", Price: $" + price;
        }

        public void changeStock(int stockChange){
            this.stock += stock;
        }

    }

    public static boolean isValid(String s) {
        return !s.isEmpty();
    }

    public static int getValidStock(Scanner scanner) {
        int stock = -1;
        while (stock < 0) {
            System.out.println("Enter stock quantity (must be 0 or higher):");
            String input = scanner.nextLine();
            try {
                stock = Integer.parseInt(input);
                if (stock < 0) {
                    System.out.println("ERROR: Stock number cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Please enter a valid number.");
            }
        }
        return stock;
    }

    public static double getValidPrice(Scanner scanner) {
        double price = -1;
        while (price < 0) {
            System.out.println("Enter price (must be 0 or higher):");
            String input = scanner.nextLine();
            try {
                price = Double.parseDouble(input);
                if (price < 0) {
                    System.out.println("ERROR: Price cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Please enter a valid price.");
            }
        }
        return price;
    }


    public static void editPackage() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the name of the package you want to edit:");
        String name = myObj.nextLine();

        if (travelPackages.containsKey(name)) {
            TravelPackage pkg = travelPackages.get(name);
            System.out.println("Current Package Details: " + pkg);

            System.out.println("What would you like to edit?");
            System.out.println("1. Name");
            System.out.println("2. Description");
            System.out.println("3. Stock");
            System.out.println("4. Price");
            System.out.println("5. All");
            System.out.print("Enter your choice (1-5): ");
            String choice = myObj.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Enter new name:");
                    String newName = myObj.nextLine();
                    while (!isValid(newName)) {
                        System.out.println("ERROR: Name cannot be empty. Enter again:");
                        newName = myObj.nextLine();
                    }
                    travelPackages.remove(name);
                    pkg.name = newName;
                    travelPackages.put(newName, pkg);
                    System.out.println("Package name updated successfully!");
                    break;

                case "2":
                    System.out.println("Enter new description:");
                    String newDesc = myObj.nextLine();
                    while (!isValid(newDesc)) {
                        System.out.println("ERROR: Description cannot be empty. Enter again:");
                        newDesc = myObj.nextLine();
                    }
                    pkg.description = newDesc;
                    System.out.println("Package description updated successfully!");
                    break;

                case "3":
                    int newStock = getValidStock(myObj);
                    pkg.stock = newStock;
                    System.out.println("Package stock updated successfully!");
                    break;

                case "4":
                    float newPrice = (float) getValidPrice(myObj);
                    pkg.price = newPrice;
                    System.out.println("Package price updated successfully!");
                    break;

                case "5":
                    System.out.println("Enter new name:");
                    String newFullName = myObj.nextLine();
                    while (!isValid(newFullName)) {
                        System.out.println("ERROR: Name cannot be empty. Enter again:");
                        newFullName = myObj.nextLine();
                    }

                    System.out.println("Enter new description:");
                    String newFullDesc = myObj.nextLine();
                    while (!isValid(newFullDesc)) {
                        System.out.println("ERROR: Description cannot be empty. Enter again:");
                        newFullDesc = myObj.nextLine();
                    }

                    int newFullStock = getValidStock(myObj);
                    float newFullPrice = (float) getValidPrice(myObj);

                    travelPackages.remove(name);
                    travelPackages.put(newFullName, new TravelPackage(newFullName, newFullDesc, newFullStock, newFullPrice));
                    System.out.println("Package updated successfully!");
                    break;

                default:
                    System.out.println("Invalid option! No changes made.");
            }
        } else {
            System.out.println("Package not found!");
        }
    }

    public static void deletePackage() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the name of the package you want to delete:");
        String name = myObj.nextLine();

        if (travelPackages.containsKey(name)) {
            travelPackages.remove(name);
            System.out.println("Package deleted successfully!");
        } else {
            System.out.println("Package not found!");
        }
    }

    public static void viewPackages() {
        if (travelPackages.isEmpty()) {
            System.out.println("No travel packages available.");
        } else {
            System.out.println("Travel Packages:");
            for (TravelPackage pkg : travelPackages.values()) {
                System.out.println(pkg);
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String filepth = "database.csv";
        CsvToHash.addToCSV(filepth);
        CsvToHash.addToCSV(filepth);
        CsvToHash.addToCSV(filepth);
        CsvToHash.updateHashMap();
        viewPackages();

    }


}




