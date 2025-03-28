
package com.motorph.payroll.payroll;

import com.motorph.payroll.models.Employee;

/**
 * Processes payroll calculations for employees.
 * Implements PayrollCalculator interface.
 */
public class PayrollProcessor implements PayrollCalculator {
    private Employee employee;

    // Constructor
    public PayrollProcessor(Employee employee) {
        this.employee = employee;
    }

    @Override
    public double calculateGrossSalary() {
        return employee.getSalary(); // Gross Salary is the base salary
    }

    @Override
    public double calculateOvertimePay() {
        return employee.getSalary() * 0.10; // 10% overtime
    }

    @Override
    public double calculateDeductions() {
        return employee.getSalary() * 0.05; // 5% deductions
    }

    @Override
    public double calculateNetSalary() {
        return calculateGrossSalary() + calculateOvertimePay() - calculateDeductions();
    }

    // ✅ Test method to validate calculations
    public void testPayrollCalculations() {
        System.out.println("🔍 Testing Payroll Calculations for: " 
                + employee.getFirstName() + " " + employee.getLastName());
        
        System.out.println("Basic Salary: ₱" + calculateGrossSalary());
        System.out.println("Overtime Pay: ₱" + calculateOvertimePay());
        System.out.println("Deductions: ₱" + calculateDeductions());
        System.out.println("Net Pay: ₱" + calculateNetSalary());
        
        System.out.println("✅ Payroll Calculation Test Completed!\n");
    }
}
