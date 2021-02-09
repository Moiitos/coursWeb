package com.minibank.td00.entities;

import javax.persistence.*;

@Entity
@Table(name = "adresse")
public class Adresse {

    //Attribues
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "numCivique")
    private int Numcivique;

    @Column(name = "rue")
    private String Rue;

    @Column(name = "ville")
    private String Ville;

    @Column(name = "codePostal")
    private String CodePostal;

    //Constructeur
    public Adresse(int numcivique, String rue, String ville, String codePostal) {
        Numcivique = numcivique;
        Rue = rue;
        Ville = ville;
        CodePostal = codePostal;
    }

    public Adresse(){}

    //ToString
    @Override
    public String toString() {
        return "MiniBank.Adresse{" +
                "Numcivique=" + Numcivique +
                ", Rue='" + Rue + '\'' +
                ", Ville='" + Ville + '\'' +
                ", CodePostal='" + CodePostal + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumcivique() {
        return Numcivique;
    }

    public void setNumcivique(int numcivique) {
        Numcivique = numcivique;
    }

    public String getRue() {
        return Rue;
    }

    public void setRue(String rue) {
        Rue = rue;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public String getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(String codePostal) {
        CodePostal = codePostal;
    }
}
