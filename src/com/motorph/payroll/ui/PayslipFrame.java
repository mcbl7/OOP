/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.motorph.payroll.ui;

import com.motorph.payroll.attendance.AttendanceManager;
import com.motorph.payroll.models.Employee;
import com.motorph.payroll.models.FullTimeEmployee;
import com.motorph.payroll.models.PartTimeEmployee;
import com.motorph.payroll.payroll.PayrollProcessor;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.print.PrinterException;
import com.motorph.payroll.util.LogWriter;



public class PayslipFrame extends javax.swing.JFrame {
    private Employee employee;
    private PayrollProcessor payrollProcessor;
    private AttendanceManager attendanceManager;

    public PayslipFrame(Employee employee) {
        this.employee = employee;
        this.attendanceManager = new AttendanceManager();
        this.payrollProcessor = new PayrollProcessor(employee, attendanceManager);

        setTitle("Employee Payslip");
        setSize(450, 400);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents();
        setSize(800, 600);

        startDateSpinner.setModel(new javax.swing.SpinnerDateModel());
        endDateSpinner.setModel(new javax.swing.SpinnerDateModel());

        startDateSpinner.setEditor(new javax.swing.JSpinner.DateEditor(startDateSpinner, "MM/dd/yyyy"));
        endDateSpinner.setEditor(new javax.swing.JSpinner.DateEditor(endDateSpinner, "MM/dd/yyyy"));

        loadPayslipDetails();
    }

    
    private void loadPayslipDetails() {
        Date start = new Date();
        Date end = new Date();
        double hourlyRate = employee.getSalary() / 160.0;
        double overtimeHours = attendanceManager.getOvertimeHours(employee.getEmployeeId(), start, end);
        double overtimePay = overtimeHours * hourlyRate;

        lblNameLabel.setText(employee.getFirstName() + " " + employee.getLastName());
        lblEmployeeIDLabel.setText(employee.getEmployeeId());
        lblPositionLabel.setText(employee instanceof FullTimeEmployee ? "Full-Time" : "Part-Time");
        lblBasicSalaryLabel.setText("₱" + String.format("%,.2f", employee.getSalary()));
        lblOvertimePayLabel.setText("₱" + String.format("%,.2f", overtimePay));
        lblAllowancesLabel.setText("₱2,000");
        lblDeductionsLabel.setText("₱" + String.format("%,.2f", employee.getDeductions()));
        lblNetPayLabel.setText("₱" + String.format("%,.2f", payrollProcessor.calculateNetSalary(start, end)));
    }

    private void exportPayslip() {
        if (employee == null) {
            JOptionPane.showMessageDialog(this, "No employee data available to export!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (lblNetPayLabel.getText().equals("jLabel17")) {
            JOptionPane.showMessageDialog(this, "⚠️ Please generate a payslip first.", "Notice", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String filename = employee.getEmployeeId() + "_Payslip.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Payslip for " + employee.getFirstName() + " " + employee.getLastName() + "\n");
            writer.write("===================================\n");
            writer.write("Employee ID: " + employee.getEmployeeId() + "\n");
            writer.write("Position: " + lblPositionLabel.getText() + "\n");
            writer.write("Basic Salary: " + lblBasicSalaryLabel.getText() + "\n");
            writer.write("Overtime Pay: " + lblOvertimePayLabel.getText() + "\n");
            writer.write("Allowances: " + lblAllowancesLabel.getText() + "\n");
            writer.write("Deductions: " + lblDeductionsLabel.getText() + "\n");
            writer.write("Net Pay: " + lblNetPayLabel.getText() + "\n");
            writer.write("===================================\n");

            JOptionPane.showMessageDialog(this, "✅ Payslip exported successfully! Saved as: " + filename, "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "❌ Error exporting payslip!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void printPayslip() {
        if (lblNetPayLabel.getText().equals("jLabel17")) {
            JOptionPane.showMessageDialog(this, "\u26A0\uFE0F Please generate a payslip first.", "Notice", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        StringBuilder payslip = new StringBuilder();
        payslip.append("Payslip for ").append(employee.getFirstName()).append(" ").append(employee.getLastName()).append("\n");
        payslip.append("===================================\n");
        payslip.append("Employee ID: ").append(employee.getEmployeeId()).append("\n");
        payslip.append("Position: ").append(lblPositionLabel.getText()).append("\n");
        payslip.append("Payslip Period: ").append(lblPeriodLabel.getText().replace("Payslip Period: ", "")).append("\n");
        payslip.append("Basic Salary: ").append(lblBasicSalaryLabel.getText()).append("\n");
        payslip.append("Overtime Pay: ").append(lblOvertimePayLabel.getText()).append("\n");
        payslip.append("Allowances: ").append(lblAllowancesLabel.getText()).append("\n");
        payslip.append("Deductions: ").append(lblDeductionsLabel.getText()).append("\n");
        payslip.append("Net Pay: ").append(lblNetPayLabel.getText()).append("\n");
        payslip.append("===================================\n");

        JTextArea textArea = new JTextArea(payslip.toString());
        try {
            boolean printed = textArea.print();
            if (printed) {
                JOptionPane.showMessageDialog(this, "\uD83D\uDDA8 Payslip sent to printer!", "Print", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "\u274C Print cancelled.", "Print", JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(this, "\u274C Printing failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FullTimeEmployee testEmployee = new FullTimeEmployee(
    "10001",
    "Manuel III",
    "Garcia",
    "10/11/1983",
    "Makati City",
    "966-860-270",
    90000
);

                new PayslipFrame(testEmployee).setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        jLabel4 = new javax.swing.JLabel();
        lblEmployeeName = new javax.swing.JLabel();
        lblEmployeeID = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        lblBasicSalary = new javax.swing.JLabel();
        lblOvertimePay = new javax.swing.JLabel();
        lblAllowances = new javax.swing.JLabel();
        lblDeductions = new javax.swing.JLabel();
        lblNetPay = new javax.swing.JLabel();
        lblNameLabel = new javax.swing.JLabel();
        lblEmployeeIDLabel = new javax.swing.JLabel();
        lblPositionLabel = new javax.swing.JLabel();
        lblBasicSalaryLabel = new javax.swing.JLabel();
        lblOvertimePayLabel = new javax.swing.JLabel();
        lblAllowancesLabel = new javax.swing.JLabel();
        lblDeductionsLabel = new javax.swing.JLabel();
        lblNetPayLabel = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        btnExportPayslip = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGeneratePayslip = new javax.swing.JButton();
        startDateSpinner = new javax.swing.JSpinner();
        endDateSpinner = new javax.swing.JSpinner();
        lblPeriodLabel = new javax.swing.JLabel();
        panel3 = new java.awt.Panel();

        panel1.setBackground(new java.awt.Color(0, 51, 153));

        jLabel3.setFont(new java.awt.Font("Charter", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Payroll Calculator");

        panel2.setBackground(new java.awt.Color(0, 51, 153));

        jLabel4.setFont(new java.awt.Font("Charter", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Payroll Calculator");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEmployeeName.setText("Name:");

        lblEmployeeID.setText("Employee ID:");

        lblPosition.setText("Position:");

        lblBasicSalary.setText("Basic Salary:");

        lblOvertimePay.setText("Overtime Pay:");

        lblAllowances.setText("Allowances:");

        lblDeductions.setText("Deductions:");

        lblNetPay.setText("Net Pay:");

        lblNameLabel.setText("jLabel10");

        lblEmployeeIDLabel.setText("jLabel11");

        lblPositionLabel.setText("jLabel12");

        lblBasicSalaryLabel.setText("jLabel13");

        lblOvertimePayLabel.setText("jLabel14");

        lblAllowancesLabel.setText("jLabel15");

        lblDeductionsLabel.setText("jLabel16");

        lblNetPayLabel.setText("jLabel17");

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnExportPayslip.setText("Export Payslip");
        btnExportPayslip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPayslipActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setText("Start Date:");

        jLabel2.setText("End Date:");

        btnGeneratePayslip.setText("Generate Payslip");
        btnGeneratePayslip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePayslipActionPerformed(evt);
            }
        });

        panel3.setBackground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(startDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(endDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnGeneratePayslip, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPeriodLabel)
                        .addGap(283, 283, 283))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExportPayslip)
                                .addGap(18, 18, 18)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblEmployeeID, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblEmployeeName, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblPosition, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblBasicSalary, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblOvertimePay, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblAllowances, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblDeductions, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblNetPay, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(159, 159, 159))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNameLabel)
                                        .addComponent(lblEmployeeIDLabel)
                                        .addComponent(lblPositionLabel)
                                        .addComponent(lblBasicSalaryLabel)
                                        .addComponent(lblOvertimePayLabel)
                                        .addComponent(lblAllowancesLabel)
                                        .addComponent(lblDeductionsLabel)
                                        .addComponent(lblNetPayLabel)))
                                .addGap(68, 68, 68)))
                        .addGap(202, 202, 202))))
            .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnGeneratePayslip)
                .addGap(18, 18, 18)
                .addComponent(lblPeriodLabel)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeeName)
                    .addComponent(lblNameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeeID)
                    .addComponent(lblEmployeeIDLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosition)
                    .addComponent(lblPositionLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBasicSalary)
                    .addComponent(lblBasicSalaryLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOvertimePay)
                    .addComponent(lblOvertimePayLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAllowances)
                    .addComponent(lblAllowancesLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeductions)
                    .addComponent(lblDeductionsLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNetPay)
                    .addComponent(lblNetPayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnExportPayslip)
                    .addComponent(btnPrint))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportPayslipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportPayslipActionPerformed
        exportPayslip();
        LogWriter.log("📤 Payslip exported for: " + employee.getFirstName() + " " + employee.getLastName());
    }//GEN-LAST:event_btnExportPayslipActionPerformed

    private void btnGeneratePayslipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePayslipActionPerformed
        Date start = (Date) startDateSpinner.getValue();
        Date end = (Date) endDateSpinner.getValue();

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMM dd, yyyy");
        String startStr = sdf.format(start);
        String endStr = sdf.format(end);

        double hourlyRate = employee.getSalary() / 160.0;
        double overtimeHours = attendanceManager.getOvertimeHours(employee.getEmployeeId(), start, end);
        double overtimePay = overtimeHours * hourlyRate;

        double baseSalary = employee.getSalary();
        double allowances = 2000.0;
        double deductions = employee.getDeductions();
        double grossPay = baseSalary + overtimePay + allowances;
        double netPay = grossPay - deductions;

        lblNameLabel.setText(employee.getFirstName() + " " + employee.getLastName());
        lblEmployeeIDLabel.setText(employee.getEmployeeId());
        lblPositionLabel.setText(employee instanceof FullTimeEmployee ? "Full-Time" : "Part-Time");
        lblBasicSalaryLabel.setText("₱" + String.format("%,.2f", baseSalary));
        lblOvertimePayLabel.setText("₱" + String.format("%,.2f", overtimePay));
        lblAllowancesLabel.setText("₱" + String.format("%,.2f", allowances));
        lblDeductionsLabel.setText("₱" + String.format("%,.2f", deductions));
        lblNetPayLabel.setText("₱" + String.format("%,.2f", netPay));

        LogWriter.log("🧾 Payslip generated for: " + employee.getFirstName() + " " + employee.getLastName() +
                      " | ID: " + employee.getEmployeeId() +
                      " | Period: " + startStr + " to " + endStr);
    }//GEN-LAST:event_btnGeneratePayslipActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        printPayslip();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        new DashboardFrame(employee.getEmployeeId()).setVisible(true); 
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnExportPayslip;
    private javax.swing.JButton btnGeneratePayslip;
    private javax.swing.JButton btnPrint;
    private javax.swing.JSpinner endDateSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblAllowances;
    private javax.swing.JLabel lblAllowancesLabel;
    private javax.swing.JLabel lblBasicSalary;
    private javax.swing.JLabel lblBasicSalaryLabel;
    private javax.swing.JLabel lblDeductions;
    private javax.swing.JLabel lblDeductionsLabel;
    private javax.swing.JLabel lblEmployeeID;
    private javax.swing.JLabel lblEmployeeIDLabel;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblNameLabel;
    private javax.swing.JLabel lblNetPay;
    private javax.swing.JLabel lblNetPayLabel;
    private javax.swing.JLabel lblOvertimePay;
    private javax.swing.JLabel lblOvertimePayLabel;
    private javax.swing.JLabel lblPeriodLabel;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblPositionLabel;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private javax.swing.JSpinner startDateSpinner;
    // End of variables declaration//GEN-END:variables
}
