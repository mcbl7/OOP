/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.motorph.payroll.ui;

import com.motorph.payroll.attendance.AttendanceManager;
import com.motorph.payroll.models.Employee;
import com.motorph.payroll.models.FullTimeEmployee;
import com.motorph.payroll.payroll.PayrollProcessor;
import javax.swing.*;
import java.util.Date;




public class PayrollFrame extends javax.swing.JFrame {

 
    public PayrollFrame() {
        setSize(800, 600);
        initComponents();
    }
    
    private void calculatePayroll() {
        try {
            double basicSalary = Double.parseDouble(salaryField.getText());
            double overtimeHours = Double.parseDouble(overtimeField.getText());
            double hourlyRate = Double.parseDouble(hourlyRateField.getText());

            Employee employee = new FullTimeEmployee("E001", "John", "Doe", "01/01/1990", "123 Main St", "555-1234", basicSalary);
            AttendanceManager dummyAttendance = new AttendanceManager();
            PayrollProcessor processor = new PayrollProcessor(employee, dummyAttendance);

            Date start = new Date();
            Date end = new Date();

            grossPayLabel.setText("₱" + processor.calculateGrossSalary(start, end));
            deductionsAmountLabel.setText("₱" + employee.getDeductions());
            netPayAmountLabel.setText("₱" + processor.calculateNetSalary(start, end));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hourlyRateLabel = new javax.swing.JLabel();
        grossLabel = new javax.swing.JLabel();
        deductionsLabel = new javax.swing.JLabel();
        netPayLabel = new javax.swing.JLabel();
        calculateButton = new javax.swing.JButton();
        salaryField = new javax.swing.JTextField();
        overtimeField = new javax.swing.JTextField();
        hourlyRateField = new javax.swing.JTextField();
        grossPayLabel = new javax.swing.JLabel();
        salaryLabel = new javax.swing.JLabel();
        deductionsAmountLabel = new javax.swing.JLabel();
        overtimeLabel = new javax.swing.JLabel();
        netPayAmountLabel = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hourlyRateLabel.setText("Hourly Rate:");

        grossLabel.setText("Gross Pay:");

        deductionsLabel.setText("Deductions:");

        netPayLabel.setText("Net Pay:");

        calculateButton.setText("Calculate Payroll");

        grossPayLabel.setText("jLabel2");

        salaryLabel.setText("Basic Salary:");

        deductionsAmountLabel.setText("jLabel3");

        overtimeLabel.setText("Overtime Hours:");

        netPayAmountLabel.setText("jLabel4");

        panel1.setBackground(new java.awt.Color(0, 51, 153));

        jLabel1.setFont(new java.awt.Font("Charter", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Payroll Calculator");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(netPayLabel)
                            .addComponent(deductionsLabel)
                            .addComponent(grossLabel)
                            .addComponent(hourlyRateLabel)
                            .addComponent(overtimeLabel)
                            .addComponent(salaryLabel))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(salaryField)
                                .addComponent(overtimeField)
                                .addComponent(hourlyRateField, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(grossPayLabel)
                            .addComponent(deductionsAmountLabel)
                            .addComponent(netPayAmountLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(calculateButton)))
                .addContainerGap(277, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryLabel)
                    .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(overtimeLabel)
                    .addComponent(overtimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hourlyRateLabel)
                    .addComponent(hourlyRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(calculateButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grossLabel)
                    .addComponent(grossPayLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deductionsLabel)
                    .addComponent(deductionsAmountLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(netPayLabel)
                    .addComponent(netPayAmountLabel))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new PayrollFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calculateButton;
    private javax.swing.JLabel deductionsAmountLabel;
    private javax.swing.JLabel deductionsLabel;
    private javax.swing.JLabel grossLabel;
    private javax.swing.JLabel grossPayLabel;
    private javax.swing.JTextField hourlyRateField;
    private javax.swing.JLabel hourlyRateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel netPayAmountLabel;
    private javax.swing.JLabel netPayLabel;
    private javax.swing.JTextField overtimeField;
    private javax.swing.JLabel overtimeLabel;
    private java.awt.Panel panel1;
    private javax.swing.JTextField salaryField;
    private javax.swing.JLabel salaryLabel;
    // End of variables declaration//GEN-END:variables
}
