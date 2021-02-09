package com.minibank.td00.entities;

import com.minibank.td00.entities.enumeration.Sexe;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personne")
public class Personne implements Serializable {

    //Attribues
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String Nom;

    @Column(name = "prenom")
    private String Prenom;

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse Adresse;

    @Column(name = "telephone")
    private String NumTelephone;

    @Column(name = "email")
    private String Email;

    @Enumerated(EnumType.STRING)
    @NonNull
    private Sexe Sexe;

    //Constructeur
    public Personne(String nom, String prenom, Adresse adresse, String numTelephone, String email, Sexe sexe) {
        Nom = nom;
        Prenom = prenom;
        Adresse = adresse;
        NumTelephone = numTelephone;
        Email = email;
        Sexe = sexe;
    }

    public Personne(){}

    //ToString
    @Override
    public String toString() {
        return "MiniBank.Personne{" +
                "Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", MiniBank.Adresse=" + Adresse +
                ", NumTelephone='" + NumTelephone + '\'' +
                ", Email='" + Email + '\'' +
                ", Sexe=" + Sexe +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public com.minibank.td00.entities.Adresse getAdresse() {
        return Adresse;
    }

    public void setAdresse(com.minibank.td00.entities.Adresse adresse) {
        Adresse = adresse;
    }

    public String getNumTelephone() {
        return NumTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        NumTelephone = numTelephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Sexe getSexe() {
        return Sexe;
    }

    public void setSexe(Sexe sexe) {
        Sexe = sexe;
    }
}
