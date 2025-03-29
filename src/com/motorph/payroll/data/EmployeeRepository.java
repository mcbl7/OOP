/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.data;

import com.motorph.payroll.models.Employee;
import com.motorph.payroll.models.FullTimeEmployee;
import com.motorph.payroll.models.PartTimeEmployee;
import com.motorph.payroll.util.LogWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private static final String FILE_PATH = "/Users/samleonor/Desktop/com.motorph.payroll/Employee Data.csv";

    public static List<Employee> loadAll() {
        List<Employee> employees = new ArrayList<>();
        LogWriter.log("📥 Starting to load employee data from Employee Data.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip header
                }

                String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (tokens.length < 14) continue;

                String id = tokens[0].trim();
                String lastName = tokens[1].trim();
                String firstName = tokens[2].trim();
                String birthDate = tokens[3].trim();
                String address = tokens[4].trim();
                String phone = tokens[5].trim();
                String type = tokens[10].trim();
                String role = tokens[11].trim();

                String salaryStr = tokens[13].trim().replace("\"", "").replace(",", "");
                double salary = salaryStr.equalsIgnoreCase("N/A") ? 0.0 : Double.parseDouble(salaryStr);

                Employee emp;
                if (type.equalsIgnoreCase("Regular")) {
                    emp = new FullTimeEmployee(id, firstName, lastName, birthDate, address, phone, salary);
                } else {
                    emp = new PartTimeEmployee(id, firstName, lastName, birthDate, address, phone, salary);
                }

                emp.setPosition(role);
                employees.add(emp);

                LogWriter.log("✅ Loaded employee: " + firstName + " " + lastName + " (" + id + ")");
            }

            LogWriter.log("✅ Finished loading " + employees.size() + " employee(s)");

        } catch (Exception e) {
            LogWriter.log("⛔ Error loading employees: " + e.getMessage());
            e.printStackTrace();
        }

        return employees;
    }
}
    
