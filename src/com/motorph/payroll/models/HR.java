package com.motorph.payroll.models;

public class HR extends Employee {
    public HR(String employeeId, String firstName, String lastName,
              String address, String phoneNumber, double salary) {
        super(employeeId, firstName, lastName, address, phoneNumber, "HR", salary);
    }

    @Override
    public double getDeductions() {
        return getSalary() * 0.10; 
    }

    @Override
    public String generatePayslip() {
        return "Payslip for " + getFirstName() + " " + getLastName() +
                "\nNet Pay: ₱" + (getSalary() - getDeductions());
    }
}
