package com.sid.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;;
import java.util.List;

@Entity
public class Village implements Serializable
{
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    @Column(name="libelle")
    private String libelle;
    @OneToMany(mappedBy = "village", fetch = FetchType.LAZY)
    List<Client> clients = new ArrayList<>();

    public Village() {
        super();
    }

    public Village(String libelle) {
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
