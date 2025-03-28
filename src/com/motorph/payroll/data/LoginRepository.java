/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class LoginRepository {
    private static final String FILE_PATH = "/Users/samleonor/Desktop/com.motorph.payroll/Accounts.csv";
    private static final String ROLES_PATH = "/Users/samleonor/Desktop/com.motorph.payroll/ListOfAdmins.csv";

    // Loads Employee ID and Password from Accounts.csv
    public static Map<String, String> loadCredentials() {
        Map<String, String> credentials = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    String employeeId = values[0].trim();
                    String password = values[1].trim();
                    credentials.put(employeeId, password);
                }
            }
        } catch (Exception e) {
            System.err.println("⚠️ Error loading credentials from Accounts.csv:");
            e.printStackTrace();
        }
        return credentials;
    }

    public static Map<String, String> loadRoles() {
        Map<String, String> roles = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ROLES_PATH))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String empId = parts[0].trim();
                    String role = parts[2].trim(); // Role is in 3rd column
                    roles.put(empId, role);
                }
            }
        } catch (Exception e) {
            System.err.println("⚠️ Error loading roles from ListOfAdmins.csv:");
            e.printStackTrace();
        }
        return roles;
    }

    public static Map<String, String[]> loadUserDetails() {
        Map<String, String[]> userDetailsMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ROLES_PATH))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip header
                }

                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String empId = parts[0].trim();
                    String name = parts[1].trim();
                    String role = parts[2].trim().toLowerCase();
                    userDetailsMap.put(empId, new String[]{name, role});
                }
            }
        } catch (Exception e) {
            System.err.println("⚠️ Error loading user details from ListOfAdmins.csv:");
            e.printStackTrace();
        }
        return userDetailsMap;
    }
}

