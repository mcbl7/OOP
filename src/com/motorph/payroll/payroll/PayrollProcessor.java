package com.motorph.payroll.payroll;

import com.motorph.payroll.attendance.AttendanceManager;
import com.motorph.payroll.models.Employee;

import java.util.Date;

public class PayrollProcessor {
    private Employee employee;
    private AttendanceManager attendanceManager;
    private double hourlyRate;

    public PayrollProcessor(Employee employee, AttendanceManager attendanceManager) {
        this.employee = employee;
        this.attendanceManager = attendanceManager;

        // Assume monthly salary divided by 160 working hours for hourly rate
        this.hourlyRate = employee.getSalary() / 160.0;
    }

    public double calculateTotalHours(Date start, Date end) {
        return attendanceManager.getTotalHours(employee.getEmployeeId(), start, end);
    }

    public double calculateOvertimeHours(Date start, Date end) {
        return attendanceManager.getOvertimeHours(employee.getEmployeeId(), start, end);
    }

    public double calculateGrossSalary(Date start, Date end) {
        double totalHours = calculateTotalHours(start, end);
        return totalHours * hourlyRate;
    }

    public double calculateNetSalary(Date start, Date end) {
        return calculateGrossSalary(start, end) - employee.getDeductions();
    }
    
    public double getHourlyRate() {
        return hourlyRate;
    }
    
    public String getEmployeeId() {
        return employee.getEmployeeId();
    }

    public String getEmployeeName() {
        return employee.getFirstName() + " " + employee.getLastName();
    }

    public double getDeductions() {
        return employee.getDeductions();
    }
}