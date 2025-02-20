package tests_examen_sgbd;

import java.util.regex.Pattern;

public class Customer {
    private int clientID;
    private String name;
    private String surname;
    private String phone;
    private String email;

    // Getters
    public int getClientID() { return clientID; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    // Setters
    public void setClientID(int clientID) { this.clientID = clientID; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }


    // Methods
    public boolean emailValidation(String mailToCheck) {
        return mailToCheck != null && !mailToCheck.isBlank() && 
               Pattern.matches("^[a-z0-9._%+-]{1,64}@[a-z0-9-]{1,63}\\.[a-z]{2,10}$", mailToCheck);
    }

    public boolean phoneValidation(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.isBlank() && 
               Pattern.matches("^(?:\\+32|0032|0)4\\d{2}[\\s./]?\\d{2}[\\s./]?\\d{2}[\\s./]?\\d{2}$", phoneNumber);
    }

    public boolean nameValidation(String name) {
        return name != null && !name.isBlank() && 
               Pattern.matches("^[A-Za-zÀ-ÖØ-öø-ÿ]+(?:[-' ][A-Za-zÀ-ÖØ-öø-ÿ]+)*$", name);
    }

    public boolean surnameValidation(String surname) {
        return surname != null && !surname.isBlank() && 
               Pattern.matches("^[A-Za-zÀ-ÖØ-öø-ÿ]+(?:[-' ][A-Za-zÀ-ÖØ-öø-ÿ]+)*$", surname);
    }
}
