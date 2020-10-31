package com.sid.web.dto;

public class UserRegistrationDto {
    private String prenom;
    private String nom;
    private String email;
    private String password;

    public UserRegistrationDto() {

    }

    public UserRegistrationDto(String prenom, String nom, String email, String password) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
