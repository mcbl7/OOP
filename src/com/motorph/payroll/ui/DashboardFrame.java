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

        openPayrollButton.setText("Process Payroll");
        openPayrollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openPayrollButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addGap(169, 169, 169))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addGap(217, 217, 217))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openPayrollButton)
                            .addComponent(viewPayslipButton))
                        .addGap(185, 185, 185))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(welcomeLabel)
                .addGap(54, 54, 54)
                .addComponent(viewPayslipButton)
                .addGap(18, 18, 18)
                .addComponent(openPayrollButton)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addContainerGap(133, Short.MAX_VALUE))
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
        new PayslipFrame(user).setVisible(true);
    }//GEN-LAST:event_viewPayslipButtonActionPerformed

    private void openPayrollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openPayrollButtonActionPerformed
        List<Employee> employees = EmployeeRepository.loadAll();
        AttendanceManager attendanceManager = new AttendanceManager();

        // ✅ Load records from Attendance.csv
        AttendanceRepository.loadAttendanceRecords(attendanceManager);

        // ✅ Open the real payroll processor
        new ProcessPayrollFrame(employees, attendanceManager).setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton openPayrollButton;
    private javax.swing.JButton viewPayslipButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
