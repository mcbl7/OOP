/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.motorph.payroll.ui;

import com.motorph.payroll.payroll.Payroll;
import com.motorph.payroll.payroll.PayrollProcessor; 
import javax.swing.*;
import com.motorph.payroll.models.Employee;
import com.motorph.payroll.models.FullTimeEmployee;




public class PayrollFrame extends javax.swing.JFrame {

 
    public PayrollFrame() {
        initComponents();
    }
    
    private void calculatePayroll() {
        try {
            double basicSalary = Double.parseDouble(salaryField.getText());
        double overtimeHours = Double.parseDouble(overtimeField.getText());
        double hourlyRate = Double.parseDouble(hourlyRateField.getText());

        // ✅ Create an Employee object (Example: FullTimeEmployee)
        Employee employee = new FullTimeEmployee("E001", "John", "Doe", "123 Main St", "555-1234", basicSalary);

        // ✅ Pass Employee, NOT Payroll
        PayrollProcessor processor = new PayrollProcessor((Employee) employee); // ✅ FIXED

        // ✅ Set results in JLabels
        grossPayLabel.setText("₱" + processor.calculateGrossSalary());
        deductionsAmountLabel.setText("₱" + employee.getDeductions());
        netPayAmountLabel.setText("₱" + processor.calculateNetSalary());

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
        jLabel1 = new javax.swing.JLabel();
        grossPayLabel = new javax.swing.JLabel();
        salaryLabel = new javax.swing.JLabel();
        deductionsAmountLabel = new javax.swing.JLabel();
        overtimeLabel = new javax.swing.JLabel();
        netPayAmountLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hourlyRateLabel.setText("Hourly Rate:");

        grossLabel.setText("Gross Pay:");

        deductionsLabel.setText("Deductions:");

        netPayLabel.setText("Net Pay:");

        calculateButton.setText("Calculate Payroll");

        salaryField.setText("jTextField1");

        overtimeField.setText("jTextField2");

        hourlyRateField.setText("jTextField3");

        jLabel1.setText("Payroll Calculator");

        grossPayLabel.setText("jLabel2");

        salaryLabel.setText("Basic Salary:");

        deductionsAmountLabel.setText("jLabel3");

        overtimeLabel.setText("Overtime Hours:");

        netPayAmountLabel.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(214, 214, 214))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(netPayLabel)
                            .addComponent(deductionsLabel)
                            .addComponent(grossLabel)
                            .addComponent(hourlyRateLabel)
                            .addComponent(overtimeLabel)
                            .addComponent(salaryLabel))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(overtimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hourlyRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(grossPayLabel)
                            .addComponent(deductionsAmountLabel)
                            .addComponent(netPayAmountLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(calculateButton)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
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
                .addGap(30, 30, 30)
                .addComponent(calculateButton)
                .addGap(24, 24, 24)
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
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PayrollFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayrollFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayrollFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayrollFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayrollFrame().setVisible(true);
            }
        });
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
    private javax.swing.JTextField salaryField;
    private javax.swing.JLabel salaryLabel;
    // End of variables declaration//GEN-END:variables
}
