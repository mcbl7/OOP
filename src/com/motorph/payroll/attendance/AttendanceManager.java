package com.motorph.payroll.attendance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AttendanceManager {
    private List<AttendanceRecord> records = new ArrayList<>();

    public void addRecord(AttendanceRecord record) {
        records.add(record);
    }

    public List<AttendanceRecord> getRecordsByEmployee(String employeeId) {
        List<AttendanceRecord> filtered = new ArrayList<>();
        for (AttendanceRecord rec : records) {
            if (rec.getEmployeeId().equals(employeeId)) {
                filtered.add(rec);
            }
        }
        return filtered;
    }
    
    public double getTotalHours(String employeeId, Date start, Date end) {
        double totalHours = 0.0;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        for (AttendanceRecord rec : records) {
            if (rec.getEmployeeId().equals(employeeId) &&
                !rec.getDate().before(start) && !rec.getDate().after(end)) {

                try {
                    Date timeIn = sdf.parse(rec.getTimeIn());
                    Date timeOut = sdf.parse(rec.getTimeOut());
                    long millisWorked = timeOut.getTime() - timeIn.getTime();
                    double hoursWorked = millisWorked / (1000.0 * 60 * 60);
                    totalHours += hoursWorked;

                } catch (ParseException e) {
                    System.err.println("Invalid time format: " + e.getMessage());
                }
            }
        }
        
        return totalHours;
    }
    
    
    public double getOvertimeHours(String employeeId, Date start, Date end) {
        double overtime = 0.0;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        for (AttendanceRecord rec : records) {
            if (rec.getEmployeeId().equals(employeeId) &&
                !rec.getDate().before(start) && !rec.getDate().after(end)) {

                try {
                    Date timeIn = sdf.parse(rec.getTimeIn());
                    Date timeOut = sdf.parse(rec.getTimeOut());
                    double hours = (timeOut.getTime() - timeIn.getTime()) / (1000.0 * 60 * 60);
                    if (hours > 8) {
                        overtime += (hours - 8);
                    }
                } catch (ParseException e) {
                    System.err.println("Invalid time format: " + e.getMessage());
                }
            }
        }
        
        return overtime;
    }
       
    public String generateAttendanceReport(String employeeId) {
        return "Attendance Report for " + employeeId;
    }
    
    public static void main(String[] args) throws Exception {
        AttendanceManager manager = new AttendanceManager();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Sample attendance records
        manager.addRecord(new AttendanceRecord("10001", dateFormat.parse("2025-03-01"), "08:00", "17:00")); // 9 hrs
        manager.addRecord(new AttendanceRecord("10001", dateFormat.parse("2025-03-02"), "08:00", "20:00")); // 12 hrs
        manager.addRecord(new AttendanceRecord("10001", dateFormat.parse("2025-03-03"), "08:00", "16:00")); // 8 hrs

        Date start = dateFormat.parse("2025-03-01");
        Date end = dateFormat.parse("2025-03-03");

        double totalHours = manager.getTotalHours("10001", start, end);
        double overtime = manager.getOvertimeHours("10001", start, end);

        System.out.println("✅ Total Hours Worked: " + totalHours);
        System.out.println("✅ Overtime Hours: " + overtime);
    }
    
}
