
package com.motorph.payroll.models;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String employeeId, String firstName, String lastName, String address, String phoneNumber, double salary) {
        super(employeeId, firstName, lastName, address, phoneNumber, "Part-Time", salary);
    }

    @Override
    public double getDeductions() {
        return getSalary() * 0.05; // Example: 5% deduction for part-time employees
    }

    @Override
    public String generatePayslip() {
        return "Payslip for " + getFirstName() + " " + getLastName() +
                "\nNet Pay: ₱" + (getSalary() - getDeductions());
    }
}
