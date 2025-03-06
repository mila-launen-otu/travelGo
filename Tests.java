import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tests {
    private static final Scanner scanner = new Scanner(System.in); // ✅ Use one Scanner

    public static void main(String[] args) throws FileNotFoundException {
        testCsvToHash(); // Test reading from CSV
        testAddFunction(); // Test adding a package
        testEditFunction(); // Test editing a package
        testDeleteFunction(); // Test deleting a package
        testViewFunction(); // Test viewing all packages
    }

    public static void testCsvToHash() throws FileNotFoundException {
        System.out.println("=== TESTING CsvToHash ===");
        CsvToHash.main(new String[0]); // Run CsvToHash to load data
        System.out.println("CsvToHash executed. Check if it properly reads the CSV.");
    }

    public static void testAddFunction() {
        System.out.println("\n=== TESTING AddFunct.add() ===");
        String[] result = addFunct.add();
        if (result.length == 2) {
            System.out.println("Add function returned: Name = " + result[0] + ", Description = " + result[1]);
        } else {
            System.out.println("ERROR: Add function did not return expected results.");
        }
    }

    public static void testEditFunction() {
        System.out.println("\n=== TESTING AddFunct.editPackage() ===");
        System.out.print("Enter a package name to edit: ");
        String packageName = scanner.nextLine();
        //addFunct.editPackage();
        System.out.println("Check if the package was edited correctly.");
    }

    public static void testDeleteFunction() {
        System.out.println("\n=== TESTING AddFunct.deletePackage() ===");
        System.out.print("Enter a package name to delete: ");
        String packageName = scanner.nextLine();
        //addFunct.deletePackage();
        System.out.println("Check if the package was deleted correctly.");
    }

    public static void testViewFunction() {
        System.out.println("\n=== TESTING AddFunct.viewPackages() ===");
       // addFunct.viewPackages();
        System.out.println("Check if all packages are displayed correctly.");
    }
}
