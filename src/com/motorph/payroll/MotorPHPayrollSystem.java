package com.motorph.payroll;

import com.motorph.payroll.ui.DashboardFrame;
import javax.swing.SwingUtilities;

public class MotorPHPayrollSystem {
    public static void main(String[] args) {
        
        String testEmployeeId = "10001";

        SwingUtilities.invokeLater(() -> {
            DashboardFrame dashboard = new DashboardFrame(testEmployeeId);
            dashboard.setVisible(true);
        });
    }
}
