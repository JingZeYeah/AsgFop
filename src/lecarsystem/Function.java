/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecarsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author ASUS
 */
public class Function {
    //Storing CVS file in ArrayList that will be used later for checking
    public List<String[]> readCsvFile(String fileName) throws IOException {
        
        List<String[]> records = new ArrayList<>();

        try (FileReader reader = new FileReader(fileName);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            for (CSVRecord csvRecord : csvParser) {
                String[] record = new String[csvRecord.size()];
                for (int i = 0; i < csvRecord.size(); i++) {
                    record[i] = csvRecord.get(i);
                }
                records.add(record);
            }
        }

        return records;
    }
    
    public void importfunction(int path){
        try{
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                BufferedReader reader = new BufferedReader(new FileReader("path.txt"));
                String line = reader.readLine();
                String [] filepath = line.split(",");
                
                PrintWriter writer = new PrintWriter(new FileWriter("path.txt"));
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                
                switch (path){
                    case 0:
                        writer.print(file);
                        writer.print(",");
                        writer.print(filepath[1]);
                        writer.print(",");
                        writer.print(filepath[2]);
                        writer.print(",");
                        writer.print(filepath[3]);
                        writer.close();
                        break;
                    case 1:
                        writer.print(filepath[0]);
                        writer.print(",");
                        writer.print(file);
                        writer.print(",");
                        writer.print(filepath[2]);
                        writer.print(",");
                        writer.print(filepath[3]);
                        writer.close();
                        break;
                    case 2:
                        writer.print(filepath[0]);
                        writer.print(",");
                        writer.print(filepath[1]);
                        writer.print(",");
                        writer.print(file);
                        writer.print(",");
                        writer.print(filepath[3]);
                        writer.close();
                        break;
                    case 3:
                        writer.print(filepath[0]);
                        writer.print(",");
                        writer.print(filepath[1]);
                        writer.print(",");
                        writer.print(filepath[2]);
                        writer.print(",");
                        writer.print(file);
                        writer.close();
                        break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
}
