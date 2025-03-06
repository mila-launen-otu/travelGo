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
    public static boolean isValidFloat(String f){
        try {
            Float.parseFloat(f); // Try converting to float
            return true; // It's a float
        } catch (NumberFormatException e) {
            return false; // Not a float
        }
    }
    public static boolean isValidInt(String f){
        try {
            Integer.parseInt(f); // Try converting to float
            return true; // It's a float
        } catch (NumberFormatException e) {
            return false; // Not a float
        }
    }

    public static MainProg.TravelPackage add(){
        //{0:Title 1:price 2:stock 3:description}
        MainProg.TravelPackage newPackage = new MainProg.TravelPackage();
        Scanner myObj = new Scanner(System.in);
        for(int i = 0; i < 4; i ++){
            if(i == 1){
                //scans for floats
                System.out.println("Enter Price:");
                String price =myObj.nextLine();
                if(!isValid(price) || !isValidFloat(price)){
                    System.out.println("Empty:" + isValid(price) + "Valid Float: " + isValidFloat(price));
                    System.out.println(Float.parseFloat(price));
                    System.out.println("Enter valid price");
                    i --;
                }
                else{
                    newPackage.price = Float.parseFloat(price);
                }
            }
            else if(i == 2){
                System.out.println("Enter Stock:");
                String stock = myObj.nextLine();
                if(!isValidInt(stock) || !isValid(stock)){
                    System.out.println("Enter valid stock");
                    i--;
                }
                else{
                    newPackage.stock = Integer.parseInt(stock);
                }
            }
            else if(i == 3){
                System.out.println("Enter Desc:");
                String desc = myObj.nextLine();
                newPackage.description = desc;
            }
            else{
                System.out.println("Enter Title:");
                String title = myObj.nextLine();
                newPackage.name = title;
            }

        }
        System.out.println(newPackage.toString());
        return newPackage;

    }
}
