package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class AppEmployee {
    public static void main(String[] args) {
        Employee[] employees = readEmployees();

        for (Employee employee: employees) {
            System.out.println(employee);
        }

//        try {
//            // create a FileWriter
//            FileWriter fileWriter = new FileWriter("payroll.csv", true);
//            // create a BufferedWriter
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            // write to the file
//            bufferedWriter.write("line 1 is here \n");
//            bufferedWriter.write("line 2 is here \n");
//            bufferedWriter.write("line 3 is here \n");
//
//            // close the writer
//            bufferedWriter.close();
//        } catch (IOException e) {
//            System.out.println("ERROR: An unexpected error occurred");
//            e.getStackTrace();
//        }





    }

    private static Employee[] readEmployees() {
        Employee[] employees = new Employee[8];

        try {
            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader("employees.csv");
            // create a BufferedReader to manage input stream
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            //skip header line
            bufferedReader.readLine();

            int index = 0;
            // read until there is no more data
            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
                String[] parts = line.split(Pattern.quote("|"));


                Employee employee = new Employee();

                String employeeIdAsString = parts[0];
                int employeeId = Integer.parseInt(employeeIdAsString);
                employee.setEmployeeId(employeeId);
//                OR
//                  employee.setEmployeeId(Integer.parseInt(parts[0]));

                String name = parts[1];
                employee.setName(name);
//                OR
//                employee.setName(parts[1]);


                String hoursWorkedAsString = parts[2];
                double hoursWorked = Double.parseDouble(hoursWorkedAsString);
                employee.setHoursWorked(hoursWorked);
//                OR
//                employee.setHoursWorked(Double.parseDouble(parts[2]));


                String payRateAsString = parts[3];
                double payRate = Double.parseDouble(payRateAsString);
                employee.setPayRate(payRate);
//                OR
//                employee.setPayRate(Double.parseDouble(parts[3]));

                employees[index] = employee;
//                System.out.println(employee);
                index = index + 1; //index++
            }
            // close the stream and release the resources
            bufferedReader.close();
        } catch (IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }

        return employees;


    }
}
