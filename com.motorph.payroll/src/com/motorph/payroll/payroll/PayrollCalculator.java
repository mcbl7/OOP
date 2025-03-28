
package com.motorph.payroll.payroll;

public interface PayrollCalculator {
    double calculateGrossSalary();
    double calculateDeductions();
    double calculateNetSalary();
    double calculateOvertimePay();
}
