
package com.motorph.payroll.data;

import com.motorph.payroll.models.Employee;
import com.motorph.payroll.models.FullTimeEmployee;
import com.motorph.payroll.models.PartTimeEmployee;

import java.io.*;
import java.util.*;

/**
 * Manages employee data by loading from a CSV file.
 */
public class EmployeeDataManager {
    private static final String FILE_PATH = "/Users/samleonor/Desktop/com.motorph.payroll/src/com/motorph/payroll/data/Employee Data.csv"; // Change this to the actual path
    private List<Employee> employees;

    public EmployeeDataManager() {
        employees = new ArrayList<>();
        loadEmployees();
    }

    /**
     * Loads employee data from a CSV file into memory.
     */
    private void loadEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // Skip header row
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                if (data.length < 6) {
                    System.err.println("Skipping invalid row: " + line);
                    continue;
                }

                String id = data[0].trim();
                String firstName = data[1].trim();
                String lastName = data[2].trim();
                String address = data[3].trim();
                String phone = data[4].trim();
                double salary = Double.parseDouble(data[5].trim());

                Employee employee;
                if (data.length > 6 && data[6].trim().equalsIgnoreCase("FullTime")) {
                    employee = new FullTimeEmployee(id, firstName, lastName, address, phone, salary);
                } else {
                    employee = new PartTimeEmployee(id, firstName, lastName, address, phone, salary);
                }

                employees.add(employee);
            }
            System.out.println("✅ Employees loaded successfully! Total: " + employees.size());

        } catch (IOException | NumberFormatException e) {
            System.err.println("❌ Error loading employee data: " + e.getMessage());
        }
    }

    /**
     * Returns all employees.
     */
    public List<Employee> getAllEmployees() {
        return employees;
    }

    /**
     * Finds an employee by ID.
     */
    public Employee getEmployeeById(String employeeId) {
        return employees.stream()
                .filter(emp -> emp.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElse(null);
    }
    
 public static void main(String[] args) {
        EmployeeDataManager manager = new EmployeeDataManager();
        
        // Print loaded employees
        System.out.println("\nLoaded Employees:");
        for (Employee emp : manager.getAllEmployees()) {
            System.out.println(emp.getFirstName() + " " + emp.getLastName() + " - ID: " + emp.getEmployeeId());
        }
 }
    
    
}
