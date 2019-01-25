/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vince
 */
import java.util.*;

public class distanceConverter 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int option = 0;
        
        while (option != 4)
        {
            menu();
            option = input.nextInt();

            while (option < 1 || option > 4)
            {           
                System.out.println("Invalid option. Choose again.");
                option = input.nextInt();
            }
            
            if (option == 1)
                showKilometers();
            if (option == 2)
                showInches();
            if (option == 3)
                showFeet();           
        }        
    }
    
    public static void showKilometers()
    {
        Scanner input = new Scanner(System.in);
        double meters;
        double conversion;
        System.out.println("Enter distance in meters: ");
        meters = input.nextDouble();
        conversion = meters * .0001;
        System.out.println("Your distance in kilometers: " + conversion + "\n");       
    }
    
    public static void showInches()
    {
        Scanner input = new Scanner(System.in);
        double meters;
        double conversion;
        System.out.println("Enter distance in meters: ");
        meters = input.nextDouble();
        conversion = meters * 39.37;
        System.out.println("Your distance in inches: " + conversion + "\n");       
    }
    
    public static void showFeet()
    {
        Scanner input = new Scanner(System.in);
        double meters;
        double conversion;
        System.out.println("Enter distance in meters: ");
        meters = input.nextDouble();
        conversion = meters * 3.281;
        System.out.println("Your distance in feet: " + conversion + "\n");       
    }
    
    public static void menu()
    {
        System.out.println("Choose an option (1-4): ");
        System.out.println("(1) Convert to Kilometers");
        System.out.println("(2) Convert to inches");
        System.out.println("(3) Convert to feet");
        System.out.println("(4) Quit the program");
    }
    
    
}
