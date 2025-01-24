import java.util.Objects;
import java.util.Scanner;

public class UserInterface {
  public static void userInterface(String[] args) {
    Scanner scn = new Scanner(System.in);
    String input = "";
    while(!Objects.equals(input, "exit")){
      System.out.println("Enter exit for exiting the program");
      System.out.println("v for viewing the list of student information");
      System.out.println("a for adding a student's information to the list");
      System.out.println("e for editing a student's information");
      input = scn.nextLine();
      switch (input){
        case "v" ->{

        }
        case "a" ->{
          System.out.println("Input the student's Name:");

          System.out.println("Input the students");
        }
        case "e" ->{

        }
        case null, default -> {
          System.out.println("Invalid option selected");
        }
      }
    }
    System.out.println("Exiting Program");
    scn.close();
  }
}
