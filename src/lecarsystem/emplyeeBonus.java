/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecarsystem;

/**
 *
 * @author Acer
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class emplyeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 0 (if sales employee) or 1 (if management employee): ");
        int input = sc.nextInt();
        double sales = 0;

        if (input == 0){
            sales = calculateSalesBonus("sales.csv", "vehicle.csv");
        } else if (input == 1){
            sales = calculateManagementCommission("sales.csv", "vehicle.csv");
        } else {
            System.out.println("Invalid input. Please try again");
            // End the program
            return;
        }
        System.out.printf("The bonus/commission received is: %.2f", sales);
    }
    
    //only for sales 
    public static double calculateSalesBonus(String salesFilename, String vehicleFilename) { 
        double bonus = 0;

        //prompt user to input id
        Scanner employScanner = new Scanner(System.in);
        System.out.println("Enter the employee id: ");
        String randemployee = employScanner.next();

        //check if the id exists in the sales.csv 
        if (employeeIdExists(randemployee, salesFilename)) {
            // Get the carPlates for the employee
            List<String> employeeCarPlates = employeeCarPlates(randemployee, salesFilename);

            //calculate total sales amount for the employee
            int totalsales = totalSales(employeeCarPlates, vehicleFilename);

            //display the number of car plates
            System.out.println("Number of car plates: " + employeeCarPlates.size());

            //display the total sales
            System.out.println("Total sales amount: " + totalsales);

            //check if condition is true
            if (totalsales > 1000000 || employeeCarPlates.size() > 15) {
                System.out.println("Eligible to get bonus");
                bonus += 500;
            } else {
                System.out.println("Not eligible to get bonus");
            }
        } else {
            System.out.println("Invalid employee ID: " + randemployee);
        }
        return bonus;
    }
    
    //only for management
    private static double calculateManagementCommission(String salesFilename, String vehicleFilename) {
        double totalCommission = 0;

        Scanner employScanner = new Scanner(System.in);
        System.out.println("Enter the employee id: ");
        String randemployee = employScanner.next();

        //check if the id exists in the sales.csv file
        if (employeeIdExists(randemployee, salesFilename)) {
            // Get the carPlates for the employee
            List<String> employeeCarPlates = employeeCarPlates(randemployee, salesFilename);

            // Calculate total sales amount for the employee
            int totalsales = totalSales(employeeCarPlates, vehicleFilename);

            // Display the total sales amount
            System.out.println("Total sales amount: " + totalsales);

            // Check if either condition is true
            double commission;
            if (totalsales <= 800000.00) {
                commission = 1.00;
            } else if (totalsales >= 800000.01 && totalsales <= 1600000.00) {
                commission = 1.15;
            } else if (totalsales >= 1600000.01 && totalsales <= 2500000.00) {
                commission = 1.25;
            } else {
                commission = 1.35;
            }

            // Update totalCommission with the calculated commission
            totalCommission += commission;
           
        }else{
            System.out.println("Invalid employee ID: " + randemployee);
        }
        return totalCommission;
    }

    private static boolean employeeIdExists(String employeeId, String salesFilename) {
        try {
            Scanner salesScanner = new Scanner(new File(salesFilename));
            salesScanner.nextLine(); // Skip header in sales file

            while (salesScanner.hasNextLine()) {
                String line = salesScanner.nextLine();
                String[] column = line.split(",");
                if (column.length >= 5) {
                    String fileEmployeeId = column[4];

                    if (employeeId.equals(fileEmployeeId)) {
                        return true;
                    }
                } else {
                    System.out.println("Invalid line in sales.csv: " + line);
                }
            }

            salesScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static List<String> employeeCarPlates(String employeeId, String salesFilename) {
        List<String> carPlates = new ArrayList<>();

        try {
            Scanner salesScanner = new Scanner(new File(salesFilename));
            salesScanner.nextLine(); // Skip header in sales file

            while (salesScanner.hasNextLine()) {
                String line = salesScanner.nextLine();
                String[] column = line.split(",");
                if (column.length >= 5) {
                    String fileEmployeeId = column[4];
                    String carPlate = column[2];

                    if (employeeId.equals(fileEmployeeId)) {
                        carPlates.add(carPlate);
                    }
                } else {
                    System.out.println("Invalid line in sales.csv: " + line);
                }
            }

            salesScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return carPlates;
    }

    private static int carPriceFromVehicle(String carPlate, String vehicleFilename) {
        try {
            Scanner vehicleScanner = new Scanner(new File(vehicleFilename));
            vehicleScanner.nextLine(); // Skip header in vehicle file

            while (vehicleScanner.hasNextLine()) {
                String line = vehicleScanner.nextLine();
                String[] vehicleColumn = line.split(",");
                if (vehicleColumn.length >= 5) {
                    String plate = vehicleColumn[0];
                    int carPrice = Integer.parseInt(vehicleColumn[4]);

                    if (carPlate.equals(plate)) {
                        return carPrice;
                    }
                } else {
                    System.out.println("Invalid line in vehicle.csv: " + line);  //will display this statement when the vehicle.csv's salesprice is null
                }
            }

            vehicleScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return -1; // Indicates invalid or not found
    }

    private static int totalSales(List<String> employeeCarPlates, String vehicleFilename) {
        int totalSalesAmount = 0;

        for (String carPlate : employeeCarPlates) {
            // Get the sales price for the carPlate from vehicle.csv
            int carPrice = carPriceFromVehicle(carPlate, vehicleFilename);

            // Check if the carPrice is valid
            if (carPrice > 0) {
                totalSalesAmount += carPrice;
            } else {
                System.out.println("Invalid carPlate in vehicle.csv: " + carPlate);
            }
        }
        return totalSalesAmount;
    }
}
