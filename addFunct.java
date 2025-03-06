import java.util.Scanner;

public class addFunct {
    public static boolean isValid(String s){
        if(s.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    public static String[] add(){
        boolean input = true;
        boolean input2 = true;
        String name;
        String desc;

        while(input){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter the name:");
            name = myObj.nextLine();

            if(isValid(name)){
                System.out.println("The valid name you chose was:" + name);
                System.out.println("you can now write a description.");
                input = false;
            }
            else{
                System.out.println("ERROR: your name is not valid");
            }
        }

        while(input2){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter the description:");
            desc = myObj.nextLine();

            if(isValid(desc)){
                System.out.println("The valid description you chose was:" + desc);
                System.out.println("you can now exit adding a name + description.");
                input2 = false;
            }
            else{
                System.out.println("ERROR: your description is not valid");
            }
        }

        String[] val = new String[2];
//        val[0] = name;
//        val[1] = desc;
        return val;

    }
}
