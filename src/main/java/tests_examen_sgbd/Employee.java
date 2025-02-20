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

    public boolean CheckPoste(String roleToCheck) {
        return roleToCheck != null && !roleToCheck.isBlank() && 
               Pattern.matches("^[A-Za-zÀ-ÖØ-öø-ÿ_]+$", roleToCheck);
    }

    public boolean CheckPassword(String pwdToCheck) {
        return pwdToCheck != null && !pwdToCheck.isBlank() && 
               Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", pwdToCheck);
    }

    public boolean CheckNomDUtilisateur(String userName) {
        return userName != null && !userName.isBlank() && 
               Pattern.matches("^[a-z_][a-z0-9_]*$", userName);
    }
}
