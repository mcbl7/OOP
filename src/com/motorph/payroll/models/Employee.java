package com.motorph.payroll.models;

public abstract class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String position;
    private double salary;

    public Employee(String employeeId, String firstName, String lastName, String address,
                    String phoneNumber, String position, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    public void setAddress(String address) { this.address = address; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setPosition(String position) { this.position = position; }

    // ✅ Must be implemented by subclasses
    public abstract double getDeductions();
    public abstract String generatePayslip();
}
