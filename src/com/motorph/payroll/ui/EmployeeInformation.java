/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.motorph.payroll.ui;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.JOptionPane;

public class EmployeeInformation extends javax.swing.JFrame {
    
    private HRDashboardFrame parentDashboard;


    public EmployeeInformation(HRDashboardFrame dashboard) {
        this.parentDashboard = dashboard;
        initComponents();
        loadEmployeeData();
}
    public void loadEmployeeData() {
        String filePath = "/Users/samleonor/Desktop/com.motorph.payroll/Employee Data.csv";
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();

        model.setRowCount(0); // Clear existing data

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                model.addRow(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployeeFromCSV(String empNum) {
    String filePath = "/Users/samleonor/Desktop/Group2-PayrollSystem-master/src/MainPackage/Employee Data.csv";
    File inputFile = new File(filePath);
    File tempFile = new File("/Users/samleonor/Desktop/Group2-PayrollSystem-master/src/MainPackage/temp.csv");

    if (!inputFile.exists()) {
        JOptionPane.showMessageDialog(null, "Error: Employee data file not found!", "File Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean deleted = false;

    try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
         BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");

            if (values.length == 0 || values[0].trim().isEmpty()) {
                continue;
            }

            if (!values[0].equals(empNum)) {
                bw.write(line + "\n");
            } else {
                deleted = true;
            }
        }

        bw.close();

    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error reading file.", "File Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!deleted) {
        JOptionPane.showMessageDialog(null, "Error: Employee not found in file!", "Delete Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!inputFile.delete()) {
        JOptionPane.showMessageDialog(null, "Error: Unable to delete original file.", "File Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!tempFile.renameTo(inputFile)) {
        JOptionPane.showMessageDialog(null, "Error: Unable to rename temp file.", "File Error", JOptionPane.ERROR_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Employee deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        jLabelTitle = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Emp. Number", "Last Name", "First Name", "Position"
            }
        ));
        jScrollPane2.setViewportView(employeeTable);

        jLabelTitle.setText("Employee Information");

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabelTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(editButton)
                        .addGap(57, 57, 57)
                        .addComponent(deleteButton)
                        .addGap(38, 38, 38)
                        .addComponent(refreshButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTitle)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(refreshButton))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        loadEmployeeData();// TODO add your handling code here:
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select an employee to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    Object value = employeeTable.getValueAt(selectedRow, 0);
    if (value == null) {
        JOptionPane.showMessageDialog(this, "Error: Employee number is missing.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String empNum = (String) employeeTable.getValueAt(selectedRow, 0); // Employee Number

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete Employee #" + empNum + "?",
            "Confirm Deletion", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        deleteEmployeeFromCSV(empNum); // Remove from CSV
        ((DefaultTableModel) employeeTable.getModel()).removeRow(selectedRow); // Remove from JTable
        JOptionPane.showMessageDialog(this, "Employee deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an employee to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String empNum = (String) employeeTable.getValueAt(selectedRow, 0);
        String lastName = (String) employeeTable.getValueAt(selectedRow, 1);
        String firstName = (String) employeeTable.getValueAt(selectedRow, 2);
        String position = (String) employeeTable.getValueAt(selectedRow, 3);

        EditEmployee editEmployeeWindow = new EditEmployee(parentDashboard, empNum, lastName, firstName, position);
        editEmployeeWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            this.dispose(); // Close the EmployeeInformation frame
        if (parentDashboard != null) {
            parentDashboard.setVisible(true); // Show the HR Dashboard again
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
    javax.swing.SwingUtilities.invokeLater(() -> {
        HRDashboardFrame dashboard = new HRDashboardFrame("HR"); 
        EmployeeInformation empInfo = new EmployeeInformation(dashboard);
        empInfo.setVisible(true);
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTable employeeTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables
}
