
package com.motorph.payroll.models;

public class FullTimeEmployee extends Employee {
    
    // Constructor for FullTimeEmployee
    public FullTimeEmployee(String employeeId, String firstName, String lastName, 
                            String address, String phoneNumber, double salary) {
        super(employeeId, firstName, lastName, address, phoneNumber, "Full-Time", salary);
    }

    // Corrected getDeductions method (Overrides Employee)
    @Override
    public double getDeductions() {
        return getSalary() * 0.10; // 10% deduction for full-time employees
    }

    // Generate a payslip for the employee
    @Override
    public String generatePayslip() {
        return "Payslip for " + getFirstName() + " " + getLastName() +
               "\nNet Pay: ₱" + (getSalary() - getDeductions());
    }
}
