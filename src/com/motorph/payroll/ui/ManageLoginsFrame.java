/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.motorph.payroll.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import com.motorph.payroll.util.LogWriter;

public class ManageLoginsFrame extends javax.swing.JFrame {

    private static final String FILE_PATH = "/Users/samleonor/Desktop/com.motorph.payroll/Accounts.csv";

    // Manually declared variables
    private JTable tblAccounts;
    private DefaultTableModel tableModel;
    private String itName;


    public ManageLoginsFrame(String itName) {
        this.itName = itName;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Manage Login Credentials");

        tableModel = (DefaultTableModel) jTable1.getModel();
        tblAccounts = jTable1;

        loadAccountsFromFile();
        addListeners();
    }

    private void addListeners() {
        btnAdd.addActionListener(e -> addLogin());
        btnEdit.addActionListener(e -> editPassword());
        btnDeleteSelected.addActionListener(e -> deleteSelected());
    }

    private void loadAccountsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            tableModel.setRowCount(0);
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 2) {
                    tableModel.addRow(new Object[]{data[0].trim(), data[1].trim()});
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to load accounts.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveAccountsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("EmployeeID,Password\n");
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String id = tableModel.getValueAt(i, 0).toString();
                String pass = tableModel.getValueAt(i, 1).toString();
                writer.write(id + "," + pass + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to save accounts.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addLogin() {
    String id = txtEmpID.getText().trim();
    String pass = new String(txtPassword.getPassword()).trim();

    if (id.isEmpty() || pass.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter both ID and Password.", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    for (int i = 0; i < tableModel.getRowCount(); i++) {
        if (tableModel.getValueAt(i, 0).toString().equalsIgnoreCase(id)) {
            JOptionPane.showMessageDialog(this, "Employee ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    tableModel.addRow(new Object[]{id, pass});
    saveAccountsToFile();
    LogWriter.log("➕ Added login for Employee ID: " + id);
    txtEmpID.setText("");
    txtPassword.setText("");
}

    private void editPassword() {
        int selectedRow = tblAccounts.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to edit.", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }
    String newPass = new String(txtPassword.getPassword()).trim();
    if (newPass.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter new password.", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }
    String empId = tableModel.getValueAt(selectedRow, 0).toString();
    tableModel.setValueAt(newPass, selectedRow, 1);
    saveAccountsToFile();
    LogWriter.log("✏️ Edited password for Employee ID: " + empId);
    txtPassword.setText("");
}

    private void deleteSelected() {
        int selectedRow = tblAccounts.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Select a row to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }
    String deletedId = tableModel.getValueAt(selectedRow, 0).toString();
    tableModel.removeRow(selectedRow);
    saveAccountsToFile();
    LogWriter.log("❌ Deleted login for Employee ID: " + deletedId);
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblEmpID = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtEmpID = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDeleteSelected = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setText("Manage Login Credentials");

        lblEmpID.setText("Employee ID:");

        lblPassword.setText("Password:");

        txtEmpID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpIDActionPerformed(evt);
            }
        });

        btnAdd.setText("Add Login");

        btnEdit.setText("Password");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Employee ID", "Password"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        scrollPane1.add(jScrollPane1);

        btnDeleteSelected.setText("Delete Selected");

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle)
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 154, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEmpID)
                                .addGap(144, 144, 144)
                                .addComponent(lblPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPassword)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(142, 142, 142))))
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(btnDeleteSelected)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpID)
                    .addComponent(lblPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btnDeleteSelected)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             new ITDashboardFrame(itName).setVisible(true);
             this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtEmpIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpIDActionPerformed

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManageLoginsFrame("IT").setVisible(true));
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDeleteSelected;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblEmpID;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTextField txtEmpID;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
