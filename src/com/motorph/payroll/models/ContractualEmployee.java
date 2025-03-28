/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.models;

public class ContractualEmployee extends Employee {

    public ContractualEmployee(String id, String firstName, String lastName, String address, String phone, double salary) {
        super(id, firstName, lastName, address, phone, "Contractual", salary);
    }

    @Override
    public String generatePayslip() {
        return "Payslip for Contractual Employee: " + getFirstName() + " " + getLastName();
    }

    @Override
    public double getDeductions() {
        return 0; // You can update this logic later if needed
    }
}
