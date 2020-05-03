package com.pavovera.notebook;

import java.io.Serializable;

public class User {
    private String fullName;
    private String birthDate;
    private String phoneNumber;
    private String email;
    private String descriptionUser;

    public User(String fullName, String birthDate, String phoneNumber, String email, String descriptionUser) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.descriptionUser = descriptionUser;
    }

    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    public String getBirthDate() {

        return birthDate;
    }

    public void setBirthDate(String birthDate) {

        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getDescriptionUser() {

        return descriptionUser;
    }

    public void setDescriptionUser(String descriptionUser) {

        this.descriptionUser = descriptionUser;
    }
}
