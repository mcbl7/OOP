/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.motorph.payroll.ui;

import com.motorph.payroll.attendance.AttendanceManager;
import com.motorph.payroll.attendance.AttendanceRecord;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 *
 * @author samleonor
 */
public class AttendanceFrame extends javax.swing.JFrame {
    
    private AttendanceManager attendanceManager;

    public AttendanceFrame() {
        attendanceManager = new AttendanceManager();

        loadAttendanceFromCSV("/Users/samleonor/Desktop/com.motorph.payroll/Attendance.csv");

        initComponents();
        setLocationRelativeTo(null);
        setSize(800, 600);
    }
    
    private void loadAttendanceFromCSV(String filePath) { 
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        int loadedCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Skip lines that are clearly headers
                if (line.toLowerCase().contains("employee") || line.toLowerCase().contains("date")) {
                    continue;
                }

                String[] values = line.split(",");
                if (values.length == 4) {
                    try {
                        String employeeId = values[0].trim();
                        Date date = sdf.parse(values[1].trim());
                        String timeIn = values[2].trim();
                        String timeOut = values[3].trim();

                        attendanceManager.addRecord(new AttendanceRecord(employeeId, date, timeIn, timeOut));
                        loadedCount++;
                    } catch (Exception parseError) {
                        // Show which line is bad
                        JOptionPane.showMessageDialog(this,
                                "❌ Parse error at line: " + line + "\n" + parseError.getMessage(),
                                "Parse Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        JOptionPane.showMessageDialog(this, "✅ Loaded " + loadedCount + " records from CSV!", "CSV Load Success", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "❌ Error loading CSV:\n" + e.getMessage(), "CSV Load Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel2 = new javax.swing.JLabel();
        txtEmployeeId = new javax.swing.JTextField();
        btnLoadAttendance = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendanceTable = new javax.swing.JTable();
        panel2 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();

        panel1.setBackground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Employee ID:");

        btnLoadAttendance.setText("Load Attendance");
        btnLoadAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadAttendanceActionPerformed(evt);
            }
        });

        attendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Time In", "Time Out"
            }
        ));
        jScrollPane1.setViewportView(attendanceTable);

        panel2.setBackground(new java.awt.Color(0, 51, 153));

        jLabel1.setFont(new java.awt.Font("Charter", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Attendance Management");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLoadAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(309, 309, 309))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(288, 288, 288))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnLoadAttendance)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadAttendanceActionPerformed
        String employeeId = txtEmployeeId.getText().trim();
        if (employeeId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an Employee ID!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<AttendanceRecord> records = attendanceManager.getRecordsByEmployee(employeeId);

        DefaultTableModel model = (DefaultTableModel) attendanceTable.getModel();
        model.setRowCount(0);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (records.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No attendance records found for Employee ID: " + employeeId, "No Records", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (AttendanceRecord record : records) {
                model.addRow(new Object[]{
                    sdf.format(record.getDate()),
                    record.getTimeIn(),
                    record.getTimeOut()
                });
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new AttendanceFrame().setVisible(true));
    }//GEN-LAST:event_btnLoadAttendanceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendanceTable;
    private javax.swing.JButton btnLoadAttendance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JTextField txtEmployeeId;
    // End of variables declaration//GEN-END:variables
}
