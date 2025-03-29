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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblHRName = new javax.swing.JLabel();
        btnAddEmployee = new javax.swing.JButton();
        btnEditEmployee = new javax.swing.JButton();
        btnViewEmployees = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MotorPH HR Dashboard");

        jLabel2.setText("Welcome,");

        lblHRName.setText("jLabel3");

        btnAddEmployee.setText("Add New Employee");
        btnAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmployeeActionPerformed(evt);
            }
        });

        btnEditEmployee.setText("Edit Employee Info");
        btnEditEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditEmployeeActionPerformed(evt);
            }
        });

        btnViewEmployees.setText("View Employee List");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHRName))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewEmployees))
                .addGap(199, 199, 199))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblHRName))
                .addGap(44, 44, 44)
                .addComponent(btnAddEmployee)
                .addGap(18, 18, 18)
                .addComponent(btnEditEmployee)
                .addGap(18, 18, 18)
                .addComponent(btnViewEmployees)
                .addGap(18, 18, 18)
                .addComponent(btnLogout)
                .addContainerGap(88, Short.MAX_VALUE))
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

    private void btnEditEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditEmployeeActionPerformed
        EmployeeInformation parentFrame = new EmployeeInformation(this); // ✅ pass current HRDashboardFrame
        String empId = "10001";
        String lastName = "Dela Cruz";
        String firstName = "Juan";
        String position = "Developer";

        EditEmployee editFrame = new EditEmployee(this, empId, lastName, firstName, position);
        editFrame.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnEditEmployeeActionPerformed

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
    private javax.swing.JButton btnEditEmployee;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnViewEmployees;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblHRName;
    // End of variables declaration//GEN-END:variables
}
