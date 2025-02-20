package tests_examen_sgbd;

import java.util.regex.Pattern;

public class Employee {
    private int employeeID;
    private String userName;
    private String role;
    private boolean isAvailable;
    private String passwordHash;
    private String salt;

    // Getters
    public int getEmployeeID() { return employeeID; }
    public String getUserName() { return userName; }
    public String getRole() { return role; }
    public boolean isAvailable() { return isAvailable; }
    public String getPasswordHash() { return passwordHash; }
    public String getSalt() { return salt; }

    // Setters
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setRole(String role) { this.role = role; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setSalt(String salt) { this.salt = salt; }


    // Methods

    /**
     * Check if the selected role is valid
     * Case insensitive and accepts underscores
     * No numbers allowed
     * @param roleToCheck Role to check
     * @return true if valid, otherwise false
     */
    public boolean checkRole(String roleToCheck) {
        return roleToCheck != null && !roleToCheck.isBlank() && 
               Pattern.matches("^[A-Za-zÀ-ÖØ-öø-ÿ_]+$", roleToCheck);
    }

    /**
     * Check if a password meets minimal complexity requirements:
     * - At least 8 characters
     * - At least one lowercase letter, one uppercase letter, and one number
     * @param pwdToCheck Password to check
     * @return true if valid, otherwise false
     */
    public boolean checkPassword(String pwdToCheck) {
        return pwdToCheck != null && !pwdToCheck.isBlank() && 
               Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", pwdToCheck);
    }

    /**
     * Check if a username is valid
     * - May contain or begin with an underscore
     * - Cannot begin with a number
     * - Must contain at least one character
     * @param userName Username to check
     * @return true if valid, otherwise false
     */
    public boolean checkUserName(String userName) {
        return userName != null && !userName.isBlank() && 
               Pattern.matches("^[a-z_][a-z0-9_]*$", userName);
    }
}
