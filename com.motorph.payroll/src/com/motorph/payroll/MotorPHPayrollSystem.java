
package com.motorph.payroll;

import com.motorph.payroll.data.EmployeeDataManager;
import com.motorph.payroll.models.Employee;
import com.motorph.payroll.ui.DashboardFrame;

public class MotorPHPayrollSystem {
    public static void main(String[] args) {

        EmployeeDataManager manager = new EmployeeDataManager();

        System.out.println("📌 List of Employees:");
        for (Employee emp : manager.getAllEmployees()) {
            System.out.println(emp.getFirstName() + " " + emp.getLastName() + " - " + emp.getEmployeeId());
        }

        String testEmployeeId = "1001"; // Change this to an actual Employee ID
        Employee testEmployee = manager.getEmployeeById(testEmployeeId);

        if (testEmployee != null) {
            System.out.println("\n✅ Employee Found: " + testEmployee.getFirstName() + " " + testEmployee.getLastName());


            DashboardFrame dashboard = new DashboardFrame(testEmployeeId);
            dashboard.setVisible(true);
        } else {
            System.out.println("\n❌ Error: Employee Not Found!");
        }
    }
}
