package com.motorph.payroll.auth;

import com.motorph.payroll.models.Employee;
import com.motorph.payroll.models.HR;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, Employee> employeeRecords = new HashMap<>();

    static {
        users.put("admin01", "password123"); // Example users
        users.put("hr01", "hrpass");

        employeeRecords.put("admin01", new HR("10001", "Alice", "Johnson", "123 Main St", "555-1234", 50000.0));
    }

    public Employee authenticate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return employeeRecords.get(username);
        }
        return null;
    }
}
