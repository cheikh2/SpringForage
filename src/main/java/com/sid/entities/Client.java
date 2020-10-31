package com.sid.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    @Column(name="prenom")
    private String prenom;
    @Column(name="nom")
    private String nom;
    @Column(name="adress")
    private String adress;
    @Column(name="telephone")
    private String telephone;
    @ManyToOne
    private Village village;

    public Client() {
    }

    public Client(String prenom, String nom, String adress, String telephone) {
        this.prenom = prenom;
        this.nom = nom;
        this.adress = adress;
        this.telephone = telephone;
        this.village = village;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }
}
