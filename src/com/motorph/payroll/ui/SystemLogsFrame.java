/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.motorph.payroll.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
 *
 * @author samleonor
 */
public class SystemLogsFrame extends JFrame {
    
    private ITDashboardFrame itDashboard;
    private static final String LOGS_FILE_PATH = "/Users/samleonor/Desktop/com.motorph.payroll/SystemLogs.txt";

    public SystemLogsFrame(ITDashboardFrame dashboard) {
        this.itDashboard = dashboard;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("System Logs");

        jLabel1.setFont(new Font("Arial", Font.BOLD, 18));
        txtLogs.setEditable(false);

        btnRefresh.addActionListener(e -> loadLogs());
        btnClose.addActionListener(e -> {
            this.dispose();
            if (itDashboard != null) {
                itDashboard.setVisible(true);
            }
        });

        loadLogs();
    }

    private void loadLogs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOGS_FILE_PATH))) {
            txtLogs.setText("");
            String line;
            while ((line = reader.readLine()) != null) {
                txtLogs.append(line + "\n");
            }
        } catch (IOException e) {
            txtLogs.setText("⚠ Unable to load logs.\n" + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scrollPaneLogs = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLogs = new javax.swing.JTextArea();
        btnRefresh = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("System Activity Logs");

        txtLogs.setColumns(20);
        txtLogs.setRows(5);
        jScrollPane1.setViewportView(txtLogs);

        scrollPaneLogs.setViewportView(jScrollPane1);

        btnRefresh.setText("Refresh");

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneLogs)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(172, 172, 172))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(scrollPaneLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnClose))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        ITDashboardFrame dummyDashboard = new ITDashboardFrame("IT Tester");
        new SystemLogsFrame(dummyDashboard).setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrollPaneLogs;
    private javax.swing.JTextArea txtLogs;
    // End of variables declaration//GEN-END:variables
}
