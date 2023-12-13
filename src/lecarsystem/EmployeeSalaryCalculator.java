/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lecarsystem;

/**
 *
 * @author LOW EN DONG
 */
import java.util.Scanner;

public class EmployeeSalaryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee type (sales or management): ");
        String employeeType = scanner.nextLine().toLowerCase();

        if ("sales".equals(employeeType)) {
            calculateSalesEmployeeSalary();
        } else if ("management".equals(employeeType)) {
            calculateManagementEmployeeSalary();
        } else {
            System.out.println("Invalid employee type entered.");
        }

        scanner.close();
    }

    private static void calculateSalesEmployeeSalary() {
        double basicSalary = 1200;
        double allowanceCap = 250;

        System.out.println("Enter car sales price: ");
        double salesPrice = getValidDoubleInput();

        double commission = 0.01 * salesPrice;
        double allowance = Math.min(allowanceCap, commission);

        double totalSalary = basicSalary + allowance + commission;

        System.out.println("Total Salary for Sales employee: RM" + totalSalary);
    }

    private static void calculateManagementEmployeeSalary() {
        double basicSalary = 2200;
        double allowanceCap = 350;

        System.out.println("Enter car sales price: ");
        double salesPrice = getValidDoubleInput();

        double commission = 0.01 * salesPrice;
        double allowance = Math.min(allowanceCap, commission);

        double totalSalary = basicSalary + allowance + commission;

        System.out.println("Total Salary for Management employee: RM" + totalSalary);
    }

    private static double getValidDoubleInput() {
        Scanner scanner = new Scanner(System.in);
        double input = 0;

        while (true) {
            try {
                input = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return input;
    }
}
