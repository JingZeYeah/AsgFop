/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment;

/**
 *
 * @author Acer
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class vehicle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer;
        List<String[]> vehicleData = new ArrayList<>();
        String fileName = "vehicletest.csv";
        
        //check if file exists or not
        boolean fileExists = new File(fileName).exists();

        while (true) {
            System.out.println("Add vehicle data? (Yes/No): ");
            answer = sc.nextLine();
            if (answer.equalsIgnoreCase("No")) {
                break;
            }
            if (answer.equalsIgnoreCase("Yes")) {
                System.out.println("Enter the car number plate: ");
                String numplate = sc.nextLine();
                System.out.println("Enter the car model: ");
                String model = sc.nextLine();
                System.out.println("Enter the acquired price: ");
                double acprice = sc.nextDouble();
                int status = 1;
                Double salesprice = null;
                

                // Check if the data already exists in the ArrayList
                boolean exists = false;
                for (String[] data : vehicleData) {
                    if (data[0].equals(numplate)) {
                        exists = true;
                        break;
                    }
                }

                if (!exists) {
                    // Add data to the ArrayList
                    String[] data = {numplate, model, String.valueOf(acprice), String.valueOf(status), String.valueOf(salesprice)};
                    vehicleData.add(data);

                    // Save data to CSV file
                    try {
                        FileWriter fw = new FileWriter(fileName, true);
                        
                        // Add header only if the file created for the first time
                        if (!fileExists) { 
                            fw.append("Car Plate,Car Model,Acquire price,Car Status,Sales Price\r\n");
                        }
                        // Append the data to the CSV file
                        for (String value : data) {
                            fw.append(value).append(",");
                        }
                        fw.append("\r\n");
                        fw.flush();
                        fw.close();
                    } catch (IOException e) {
                        System.err.println("An error occurred while creating the CSV file: " + e.getMessage());
                    }
                } else {
                    System.out.println("Data already exists for car number plate: " + numplate);
                }

                // Clear the scanner buffer
                sc.nextLine();
            }
        }
    }
}