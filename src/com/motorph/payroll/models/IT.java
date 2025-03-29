package com.motorph.payroll.models;

public class IT extends Employee {
    public IT(String employeeId, String firstName, String lastName,
              String address, String phoneNumber, double salary) {
        super(employeeId, firstName, lastName, address, phoneNumber, "IT", salary);
    }

    @Override
    public double getDeductions() {
        return getSalary() * 0.07; 
    }

    @Override
    public String generatePayslip() {
        return "Payslip for " + getFirstName() + " " + getLastName() +
                "\nNet Pay: ₱" + (getSalary() - getDeductions());
    }
}
