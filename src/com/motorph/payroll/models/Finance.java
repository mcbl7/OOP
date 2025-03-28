package com.motorph.payroll.models;

public class Finance extends Employee {
    public Finance(String employeeId, String firstName, String lastName,
                   String address, String phoneNumber, double salary) {
        super(employeeId, firstName, lastName, address, phoneNumber, "Finance", salary);
    }

    @Override
    public double getDeductions() {
        return getSalary() * 0.08; // Example: Finance employees have 8% deductions
    }

    @Override
    public String generatePayslip() {
        return "Payslip for " + getFirstName() + " " + getLastName() +
                "\nNet Pay: ₱" + (getSalary() - getDeductions());
    }
}
