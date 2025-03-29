package com.motorph.payroll.models;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String employeeId, String firstName, String lastName, String address, String phoneNumber, double salary) {
        super(employeeId, firstName, lastName, address, phoneNumber, "Part-Time", salary);
    }

    @Override
    public double getDeductions() {
        return getSalary() * 0.05; 
    }

    @Override
    public String generatePayslip() {
        return "Payslip for " + getFirstName() + " " + getLastName() +
                "\nNet Pay: ₱" + (getSalary() - getDeductions());
    }
    
    public PartTimeEmployee(String id, String firstName, String lastName, String birthDate,
                        String address, String phoneNumber, double salary) {
    super(id, firstName, lastName, birthDate, address, phoneNumber, salary);
}
}
