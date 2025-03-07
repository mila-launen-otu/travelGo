import com.sun.tools.javac.Main;

import java.util.HashMap;
import java.util.Scanner;

public class filter {
    public static void filterFunct(){
        Scanner input = new Scanner(System.in);
        float[] range;

        while (true) {
            System.out.println("Enter Your minimum Price Range, or press e to exit:");
            String minID = input.nextLine(); // Get user input

            System.out.println("Enter Your Maximum Price Range, or press e to exit:");
            String maxID = input.nextLine(); // Get user input

            if (minID.equalsIgnoreCase("exit") || maxID.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break; // Exit the program
            }
            float min = 0;
            float max = 10000;
            try {
                min = Float.parseFloat(minID);
            }
            catch (NumberFormatException e) {
                min = 0;
            }

            try {
                max = Float.parseFloat(maxID);
            }
            catch (NumberFormatException e) {
                max = 100000;
            }


            // Check if the ID exists in the HashMap
            for(String id : MainProg.travelPackages.keySet()){
                float tripPrice = MainProg.travelPackages.get(id).getPrice();
                if(tripPrice <= max && tripPrice >= min){
                    System.out.println(MainProg.travelPackages.get(id).toString());
                }
            }
        }
        input.close();
    }
}
