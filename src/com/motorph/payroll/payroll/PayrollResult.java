/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.payroll;

/**
 *
 * @author samleonor
 */
public class PayrollResult {
    private String employeeId;
    private String name;
    private double totalHours;
    private double grossPay;
    private double deductions;
    private double netPay;

    public PayrollResult(String employeeId, String name, double totalHours, double grossPay, double deductions, double netPay) {
        this.employeeId = employeeId;
        this.name = name;
        this.totalHours = totalHours;
        this.grossPay = grossPay;
        this.deductions = deductions;
        this.netPay = netPay;
    }
    
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getTotalHours() { return totalHours; }
    public double getGrossPay() { return grossPay; }
    public double getDeductions() { return deductions; }
    public double getNetPay() { return netPay; }
}
    
