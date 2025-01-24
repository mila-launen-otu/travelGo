import java.io.*;
import java.util.*;

public class CsvToHash {
    public static void main(String[] args) throws FileNotFoundException {
        // Specify the path to the CSV file
        String filePath = "C:\\Users\\kendr\\SysDesLab02\\database.csv";

        // Create a HashMap to store key-value pairs from the CSV
        HashMap<String, String> map = new HashMap<>();

        // Initialize a Scanner to read the file
        Scanner scanner = new Scanner(new File(filePath));

        // Read each line of the CSV file
        while (scanner.hasNextLine()) {
            // Split the line into two parts at the first comma
            String[] parts = scanner.nextLine().split(",", 2);

            // Check if the line contains at least two parts (key and value)
            if (parts.length >= 2) {
                // add the key-value pair to the HashMap
                map.put(parts[0], parts[1]);
            }
        }
        // Close the Scanner to release resources
        scanner.close();

        // Allow user to access data by ID
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an ID number to search (or type 'exit' to quit):");
        while (true) {
            String id = input.nextLine(); // Get user input
            if (id.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break; // Exit the program
            }

            // Check if the ID exists in the HashMap
            if (map.containsKey(id)) {
                System.out.println("ID: " + id + " => " + map.get(id)); // Print the value associated with the ID
            } else {
                System.out.println("ID not found: " + id);
                System.out.println("Please input a valid ID number to search (or type 'exit' to quit):");
            }
        }
        input.close();
    }
}


