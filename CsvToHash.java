import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.header;

public class CsvToHash {
    public static void search(HashMap<String, MainProg.TravelPackage> map){
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
                System.out.println(map.get(id).toString()); // Print the value associated with the ID
            } else {
                System.out.println("ID not found: " + id);
                System.out.println("Please input a valid ID number to search (or type 'exit' to quit):");
            }
        }
        input.close();
    }

    public static void addToCSV(String filePath, MainProg.TravelPackage travelPackage) {
        String pckg = travelPackage.toCsv();

        try (FileWriter writer = new FileWriter(filePath, true)) { // 'true' enables append mode
            writer.append("\n");  // Ensure it's on a new line
            writer.append(pckg);  // Convert array to CSV format
            System.out.println("Data appended successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }
    public static void updateHashMap(String filePath) throws FileNotFoundException{
        // Specify the path to the CSV fil
        // Create a HashMap to store key-value pairs from the CSV
        // Initialize a Scanner to read the file
        Scanner scanner = new Scanner(new File(filePath));
        HashMap<String, MainProg.TravelPackage> updatedHashMap = new HashMap<>();
        // Read each line of the CSV file

        while (scanner.hasNextLine()) {
            // Split the line into two parts at the first comma
            String[] parts = scanner.nextLine().split(",", 2);

            // Check if the line contains at least two parts (key and value)

            if (parts.length >= 2) {
                // add the key-value pair to the HashMap
                String[] infoVal = parts[1].split(",",4);
                MainProg.TravelPackage newpck = new MainProg.TravelPackage(infoVal[0], infoVal[3], Integer.parseInt(infoVal[2]), Float.parseFloat(infoVal[1]));
                updatedHashMap.put(parts[0], newpck);
            }
        }
        // Close the Scanner to release resources
        scanner.close();
        MainProg.travelPackages = updatedHashMap;
    }
    public static void overwriteCsvFile(HashMap<String, MainProg.TravelPackage> map, String filePath){
        try (FileWriter writer = new FileWriter(filePath, false)) {
            // Write the header
            writer.write("");
            for(String id: map.keySet()){
                addToCSV(filePath, map.get(id));
            }
            System.out.println("CSV file overwritten successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }



