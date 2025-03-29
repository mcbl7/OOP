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
        setSize(800, 600);
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

        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        panel1 = new java.awt.Panel();
        jLabelTitle = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Employee Number", "Last Name", "First Name", "Position"
            }
        ));
        jScrollPane2.setViewportView(employeeTable);

        panel1.setBackground(new java.awt.Color(0, 51, 153));

        jLabelTitle.setFont(new java.awt.Font("Charter", 1, 18)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("Employee Information");

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(276, 276, 276)
                .addComponent(jLabelTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(297, Short.MAX_VALUE)
                .addComponent(editButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton)
                .addGap(272, 272, 272))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(refreshButton))
                .addGap(50, 50, 50))
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

        String empId = (String) employeeTable.getValueAt(selectedRow, 0);
        String lastName = (String) employeeTable.getValueAt(selectedRow, 1);
        String firstName = (String) employeeTable.getValueAt(selectedRow, 2);
        String position = (String) employeeTable.getValueAt(selectedRow, 3);

        EditEmployee editFrame = new EditEmployee(parentDashboard, empId, lastName, firstName, position);
        editFrame.setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Panel panel1;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables
}
