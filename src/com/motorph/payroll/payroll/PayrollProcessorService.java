/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.payroll;

import com.motorph.payroll.attendance.AttendanceManager;
import com.motorph.payroll.models.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author samleonor
 */
public class PayrollProcessorService {
    
    private AttendanceManager attendanceManager;

    public PayrollProcessorService(AttendanceManager attendanceManager) {
        this.attendanceManager = attendanceManager;
    }
    
    public List<PayrollResult> processAllEmployees(List<Employee> employees, Date start, Date end) {
        List<PayrollResult> results = new ArrayList<>();

        for (Employee employee : employees) {
            PayrollProcessor processor = new PayrollProcessor(employee, attendanceManager);

            double totalHours = processor.calculateTotalHours(start, end);
            double gross = processor.calculateGrossSalary(start, end);
            double deductions = processor.getDeductions();
            double net = processor.calculateNetSalary(start, end);

            PayrollResult result = new PayrollResult(
                    employee.getEmployeeId(),
                    processor.getEmployeeName(),
                    totalHours,
                    gross,
                    deductions,
                    net
            );

            results.add(result);
        }
        
        return results;
        
    }
}
