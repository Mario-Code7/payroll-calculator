package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class AppEmployee {
    public static void main(String[] args) {
        try {
// create a FileReader object connected to the File
            FileReader fileReader = new FileReader("employees.csv");
// create a BufferedReader to manage input stream
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            //skip header line
            bufferedReader.readLine();
// read until there is no more data
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] parts = line.split(Pattern.quote("|"));


                Employee employee = new Employee();

//                String employeeIdAsString = parts[0];
//                int employeeId = Integer.parseInt(employeeIdAsString);
//                employee.setEmployeeId(employeeId);
//              OR
//                employee.setEmployeeId(Integer.parseInt(parts[0]));
                String employeeId = parts[0];
                employee.setEmployeeId(Integer.parseInt(employeeId));

                String name = parts[1];
                employee.setName(name);

//                String hoursWorkedAsString = parts[2];
//                double hoursWorked = Double.parseDouble(hoursWorkedAsString);
//                employee.setHoursWorked(hoursWorked);

                String hoursWorked = parts[2];
                employee.setHoursWorked(Double.parseDouble(hoursWorked));

//                String payRateAsString = parts[3];
//                double payRate = Double.parseDouble(payRateAsString);
//                employee.setPayRate(payRate);

                String payRate = parts[3];
                employee. setPayRate(Double.parseDouble(payRate));




                System.out.println(employee);


            }
// close the stream and release the resources
            bufferedReader.close();
        } catch (IOException e) {
// display stack trace if there was an error
            e.printStackTrace();
        }
    }
}
