
package com.motorph.payroll.attendance;

import java.util.Date;

public class AttendanceRecord {
    private String employeeId;
    private Date date;
    private String timeIn;
    private String timeOut;

    public AttendanceRecord(String employeeId, Date date, String timeIn, String timeOut) {
        this.employeeId = employeeId;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public String getEmployeeId() { return employeeId; }
    public Date getDate() { return date; }
    public String getTimeIn() { return timeIn; }
    public String getTimeOut() { return timeOut; }
}
