import java.util.*;

public class App {
    static Scanner userInput; // To prevent userInput.close() from closing System.in
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to metric converter! Please select one of the following:\n\n KilometersToMiles \n\n GramsToOunces \n\n KilogramsToPounds \n\n SquareFeetToAcres \n");
        System.out.println("Type \"exit\" to leave the program");
        while (true){
            userInput = new Scanner(System.in);
            String conversionSelected = "";
            System.out.print(">");
            conversionSelected = userInput.nextLine();
            if (conversionSelected.equals("exit")) {
                System.exit(0);
            }
            String convType = "";
            convType = conversionSelect(conversionSelected); 
            if (!convType.equals("")) {
                double quantity = 0;
                System.out.println("What is the amount?");
                while (quantity == 0) {
                    try {
                        quantity = 0;
                        System.out.print(">");
                        userInput = new Scanner(System.in);
                        quantity = userInput.nextDouble();
                        conversion(convType, quantity);
                    } catch(InputMismatchException e) {
                        System.out.println("Please enter a number that is an element of the reals");
                    }
                }
            
            }
        }
    }

    public static void conversion(String convType, double quantity){
        double convertedValue = 0;
        String unitSuffix = "";
        switch (convType) {
            case "KilogramsToPounds":
                convertedValue = quantity * 2.20462;
                unitSuffix = " lbs";
                break;
            case "KilometersToMiles":
                convertedValue = quantity * 2.2046;
                unitSuffix = " mi";
                break;
            case "GramsToOunces":
                convertedValue = quantity * 0.035274;
                unitSuffix = " oz";
                break;
            case "SquareFeetToAcres":
                convertedValue = quantity * 0.0000229568;
                unitSuffix = " Acres";
                break;
        }
        System.out.println("The converted value is " + convertedValue + unitSuffix);
        System.out.println("Input another conversion or type \"exit\" to leave");


    }

    public static String conversionSelect(String conversionSelected) {
        String convType = "";
        switch (conversionSelected) {
            case "KilogramsToPounds":
                convType = "KilogramsToPounds";
                break;
            case "KilometersToMiles":
                convType = "KilometersToMiles";
                break;
            case "GramsToOunces":
                convType = "GramsToOunces";
                break;
            case "SquareFeetToAcres":
                convType = "SquareFeetToAcres";
                break;
            default:
                System.out.println("Please enter one of the choices");
        }
        
        return convType;

    }
}

