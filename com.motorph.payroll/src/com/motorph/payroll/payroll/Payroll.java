/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.payroll;


public class Payroll {
    private double basicSalary;
    private double overtimeHours;
    private double hourlyRate;
    private double deductions;

    // Constructor
    public Payroll(double basicSalary, double overtimeHours, double hourlyRate, double deductions) {
        this.basicSalary = basicSalary;
        this.overtimeHours = overtimeHours;
        this.hourlyRate = hourlyRate;
        this.deductions = deductions;
    }
    
public double getBasicSalary() {
        return basicSalary;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getDeductions() {
        return deductions;
    }
}




    
