package com.motorph.payroll.ui;

import com.motorph.payroll.models.Employee;
import com.motorph.payroll.models.FullTimeEmployee;
import com.motorph.payroll.models.PartTimeEmployee;
import com.motorph.payroll.payroll.PayrollProcessor;
import com.motorph.payroll.attendance.AttendanceManager;
import com.motorph.payroll.attendance.AttendanceRepository;
import com.motorph.payroll.data.EmployeeRepository;
import com.motorph.payroll.util.LogWriter;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;



public class DashboardFrame extends javax.swing.JFrame {
    
    private String employeeName;
    private Employee user;
    private PayrollProcessor payrollProcessor;
    private static final String FILE_PATH = "/Users/samleonor/Desktop/com.motorph.payroll/Employee Data.csv";

    
    public DashboardFrame(String employeeId) {
        this.user = loadEmployeeData(employeeId);
        if (this.user == null) {
            JOptionPane.showMessageDialog(this, "Error: Employee not found!", "Login Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0); // Exit if user not found
        }
        
        initComponents(); 
        setSize(800, 600); // Set uniform size
        setLocationRelativeTo(null); // Center the frame
        welcomeLabel.setText("Welcome, " + user.getFirstName() + " " + user.getLastName());
    }

    private Employee loadEmployeeData(String employeeId) {
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
        String line;
        br.readLine(); // Skip header
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            System.out.println("ROW DEBUG: " + Arrays.toString(values));
            if (values.length < 14) continue;

            String id = values[0].trim();
            if (id.equals(employeeId.trim())) {
                String firstName = values[2].trim();
                String lastName = values[1].trim();
                String birthDate = values[3].trim();
                String address = values[4].trim();
                String phoneNumber = values[5].trim();
                String status = values[10].trim();
                String position = values[11].trim();

                System.out.println("Employee Status: " + status);

                String rawSalary = values[13].trim().replace("\"", "").replace(",", "");
                double salary = rawSalary.equalsIgnoreCase("N/A") ? 0.0 : Double.parseDouble(rawSalary);

                Employee emp;
                if (status.equalsIgnoreCase("Regular")) {
                    emp = new FullTimeEmployee(id, firstName, lastName, birthDate, address, phoneNumber, salary);
                    emp.setPosition(position);
                    return emp;
                } else if (status.equalsIgnoreCase("Probationary")) {
                    emp = new PartTimeEmployee(id, firstName, lastName, birthDate, address, phoneNumber, salary);
                    emp.setPosition(position);
                    return emp;
                } else {
                    System.out.println("⚠️ Unrecognized status: " + status);
                    return null;
                }
            }
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }
    return null;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutButton = new javax.swing.JButton();
        openPayrollButton = new javax.swing.JButton();
        viewPayslipButton = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        openPayrollButton.setText("Process Payroll");
        openPayrollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openPayrollButtonActionPerformed(evt);
            }
        });

        viewPayslipButton.setText("View Payslip");
        viewPayslipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPayslipButtonActionPerformed(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("ITF Devanagari", 0, 24)); // NOI18N
        welcomeLabel.setText("Welcome, [Employee Name]");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(viewPayslipButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(openPayrollButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(310, 310, 310))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(welcomeLabel)
                .addGap(61, 61, 61)
                .addComponent(viewPayslipButton)
                .addGap(18, 18, 18)
                .addComponent(openPayrollButton)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewPayslipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPayslipButtonActionPerformed
        LogWriter.log("👀 Payslip viewed by: " + user.getFirstName() + " " + user.getLastName());
        new PayslipFrame(user).setVisible(true);
    }//GEN-LAST:event_viewPayslipButtonActionPerformed

    private void openPayrollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openPayrollButtonActionPerformed
        List<Employee> employees = EmployeeRepository.loadAll();
        AttendanceManager attendanceManager = new AttendanceManager();

        AttendanceRepository.loadAttendanceRecords(attendanceManager);

        new ProcessPayrollFrame(employees, attendanceManager, user, this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_openPayrollButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
    int confirm = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to logout?",
        "Logout Confirmation",
        JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        String fullName = user.getFirstName() + " " + user.getLastName();
        LogWriter.log("🚪 Logout | Role: Employee | Name: " + fullName);
        this.dispose(); 
        new LoginFrame().setVisible(true); 
    }
    }//GEN-LAST:event_logoutButtonActionPerformed

public static void main(String[] args) {
        String testEmployeeId = "10001";
        SwingUtilities.invokeLater(() -> {
            DashboardFrame dashboard = new DashboardFrame(testEmployeeId);
            dashboard.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton openPayrollButton;
    private java.awt.Panel panel1;
    private javax.swing.JButton viewPayslipButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
