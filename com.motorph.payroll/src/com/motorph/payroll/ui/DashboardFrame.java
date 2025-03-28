
package com.motorph.payroll.ui;

import com.motorph.payroll.models.Employee;
import com.motorph.payroll.models.FullTimeEmployee;
import com.motorph.payroll.models.PartTimeEmployee;
import com.motorph.payroll.payroll.PayrollProcessor;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class DashboardFrame extends javax.swing.JFrame {
    private Employee user;
    private PayrollProcessor payrollProcessor;

    private static final String FILE_PATH = "/Users/samleonor/Desktop/com.motorph.payroll/src/com/motorph/payroll/data/Employee Data.csv"; 
    private static final String PAYROLL_FILE = "/Users/samleonor/Desktop/com.motorph.payroll/src/com/motorph/payroll/data/Payroll.csv"; 

    public DashboardFrame(String employeeId) {
        System.out.println("Loading Employee Data... Searching for: " + employeeId);
        this.user = loadEmployeeData(employeeId);

        if (this.user == null) {
            JOptionPane.showMessageDialog(this, "❌ Error: Employee not found!", "Login Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0); // Exit if user not found
        }

        this.payrollProcessor = new PayrollProcessor(user);
        initComponents();

        welcomeLabel.setText("Welcome, " + user.getFirstName() + " " + user.getLastName());

        payrollProcessor.testPayrollCalculations();
    }

    private Employee loadEmployeeData(String employeeId) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean headerSkipped = false;

            while ((line = br.readLine()) != null) {
                if (!headerSkipped) { // Skip header row
                    headerSkipped = true;
                    continue;
                }

                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (values.length < 15) continue; // Ensure valid data format

                String id = values[0].trim();
                System.out.println("Read ID: '" + id + "' Comparing with: '" + employeeId + "'");

                if (id.equalsIgnoreCase(employeeId.trim())) { 
                    String firstName = values[2].trim();
                    String lastName = values[1].trim();
                    String address = values[3].trim();
                    String phoneNumber = values[4].trim();

                    String salaryString = values[14].trim().replace("\"", "").replace(",", "");
                    double salary = Double.parseDouble(salaryString);

                    System.out.println("✅ Employee Found: " + firstName + " " + lastName);

                    // Check employment type
                    String employmentType = values[10].trim();
                    if (employmentType.equalsIgnoreCase("Regular")) {
                        return new FullTimeEmployee(id, firstName, lastName, address, phoneNumber, salary);
                    } else {
                        return new PartTimeEmployee(id, firstName, lastName, address, phoneNumber, salary);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("❌ ERROR: Employee with ID " + employeeId + " not found.");
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        viewPayslipButton = new javax.swing.JButton();
        openPayrollButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setText("Welcome, [Employee Name]");

        viewPayslipButton.setText("View Payslip");
        viewPayslipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPayslipButtonActionPerformed(evt);
            }
        });

        openPayrollButton.setText("Open Payroll Calculator");

        logoutButton.setText("Logout");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(viewPayslipButton)
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(openPayrollButton)
                            .addComponent(welcomeLabel))
                        .addGap(169, 169, 169))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addGap(217, 217, 217))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(welcomeLabel)
                .addGap(54, 54, 54)
                .addComponent(viewPayslipButton)
                .addGap(18, 18, 18)
                .addComponent(openPayrollButton)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewPayslipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPayslipButtonActionPerformed
                                                  
    if (user != null) {
            new PayslipFrame(user).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No employee data loaded!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_viewPayslipButtonActionPerformed

   private void processPayrollButtonActionPerformed(java.awt.event.ActionEvent evt) {
        double netPay = payrollProcessor.calculateNetSalary();
        String payrollEntry = user.getEmployeeId() + "," + user.getFirstName() + " " + user.getLastName() +
                              ",₱" + user.getSalary() + ",₱" + payrollProcessor.calculateOvertimePay() + 
                              ",₱" + payrollProcessor.calculateDeductions() + ",₱" + netPay;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PAYROLL_FILE, true))) {
            writer.write(payrollEntry);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "✅ Payroll processed and saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "❌ Error saving payroll!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String testEmployeeId = "10001"; 

        SwingUtilities.invokeLater(() -> {
            DashboardFrame dashboard = new DashboardFrame(testEmployeeId);
            dashboard.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton openPayrollButton;
    private javax.swing.JButton viewPayslipButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
