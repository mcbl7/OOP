
package com.motorph.payroll.attendance;

import java.util.ArrayList;
import java.util.List;

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

    public String generateAttendanceReport(String employeeId) {
        return "Attendance Report for " + employeeId;
    }
}
