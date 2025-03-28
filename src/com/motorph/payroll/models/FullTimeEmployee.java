package com.motorph.payroll.models;

public class FullTimeEmployee extends Employee {
    
    // Updated constructor now accepts actual position from CSV
    public FullTimeEmployee(String employeeId, String firstName, String lastName, 
                            String address, String phoneNumber, String position, double salary) {
        super(employeeId, firstName, lastName, address, phoneNumber, position, salary);
    }

    @Override
    public double getDeductions() {
        return getSalary() * 0.10; // 10% deduction for full-time employees
    }

    @Override
    public String generatePayslip() {
        return "Payslip for " + getFirstName() + " " + getLastName() +
               "\nPosition: " + getPosition() +
               "\nNet Pay: ₱" + (getSalary() - getDeductions());
    }
}
