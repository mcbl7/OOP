/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.attendance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author samleonor
 */
public class AttendanceRepository {
    
    private static final String FILE_PATH = "/Users/samleonor/Desktop/com.motorph.payroll/Attendance.csv";

    public static void loadAttendanceRecords(AttendanceManager manager) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // skip header
                }

                String[] values = line.split(",");

                if (values.length >= 4) {
                    String employeeId = values[0].trim();
                    Date date = dateFormat.parse(values[1].trim());
                    String timeIn = values[2].trim();
                    String timeOut = values[3].trim();

                    AttendanceRecord record = new AttendanceRecord(employeeId, date, timeIn, timeOut);
                    manager.addRecord(record);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
