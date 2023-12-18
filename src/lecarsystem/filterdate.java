/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecarsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ASUS
 */

public class filterdate {
    
    public static void main(String[] args) {
        String testString ="2023-06-01T02:38:22Z";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        
        LocalDateTime dateTime = LocalDateTime.parse(testString, formatter);
        
        int month = dateTime.getMonthValue();
        int year = dateTime.getYear();
        
        String input = "";
        if (input == "" || input == "0") input = "0";
        
        try {
            int testmonth = Integer.parseInt(input);
            int testyear = 2024;
            if (month == testmonth || year == testyear)
            System.out.println("yesss");
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        
    }
    
}

