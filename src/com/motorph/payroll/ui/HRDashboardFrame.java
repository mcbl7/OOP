/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.motorph.payroll.ui;

import javax.swing.*;
import com.motorph.payroll.util.LogWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.SwingUtilities;


public class HRDashboardFrame extends javax.swing.JFrame {

    private String hrName;

    public HRDashboardFrame(String hrName) {
        this.hrName = hrName;
        initComponents();
        setLocationRelativeTo(null);
        lblHRName.setText(hrName); // Show HR name
        setSize(800, 600);
    }
    
    private void openEmployeeInformation() {
        EmployeeInformation empInfo = new EmployeeInformation(this); // pass HRDashboardFrame reference
        empInfo.setVisible(true);
        this.setVisible(false);
    }

    
    public void updateEmployeeInCSV(String oldEmpNum, String newEmpNum, String lastName, String firstName, String position) {
    String filePath = "/Users/samleonor/Desktop/Group2-PayrollSystem-master/src/MainPackage/Employee Data.csv";
    File inputFile = new File(filePath);
    File tempFile = new File("/Users/samleonor/Desktop/Group2-PayrollSystem-master/src/MainPackage/temp.csv");

    if (!inputFile.exists()) {
        JOptionPane.showMessageDialog(null, "Error: Employee data file not found!", "File Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean updated = false;

    try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
         BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");

            if (values[0].equals(oldEmpNum)) {
                bw.write(newEmpNum + "," + lastName + "," + firstName + "," + position + "\n");
                updated = true;
            } else {
                bw.write(line + "\n");
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    if (!inputFile.delete()) {
        System.out.println("ERROR: Unable to delete original file.");
    }
    if (!tempFile.renameTo(inputFile)) {
        System.out.println("ERROR: Unable to rename temp file.");
    } else {
        System.out.println("Employee updated successfully in CSV.");
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblHRName = new javax.swing.JLabel();
        btnAddEmployee = new javax.swing.JButton();
        btnViewEmployees = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Welcome,");

        lblHRName.setText("HR");

        btnAddEmployee.setText("Add New Employee");
        btnAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmployeeActionPerformed(evt);
            }
        });

        btnViewEmployees.setText("Edit Employee");
        btnViewEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEmployeesActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(0, 51, 153));

        jLabel1.setFont(new java.awt.Font("Charter", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MotorPH HR Dashboard");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(340, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewEmployees, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddEmployee, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHRName)))
                .addGap(314, 314, 314))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblHRName))
                .addGap(37, 37, 37)
                .addComponent(btnAddEmployee)
                .addGap(18, 18, 18)
                .addComponent(btnViewEmployees)
                .addGap(18, 18, 18)
                .addComponent(btnLogout)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
    int confirm = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to logout?",
        "Logout Confirmation",
        JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        LogWriter.log("🚪 Logout | Role: HR | Name: " + hrName);
        this.dispose();
        new LoginFrame().setVisible(true);
    }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmployeeActionPerformed
        new AddEmployee(this).setVisible(true); // Pass the current dashboard
        this.setVisible(false);
    }//GEN-LAST:event_btnAddEmployeeActionPerformed

    private void btnViewEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewEmployeesActionPerformed
        EmployeeInformation employeeInfo = new EmployeeInformation(this);
        employeeInfo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnViewEmployeesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new HRDashboardFrame("Sample HR").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmployee;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnViewEmployees;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblHRName;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
