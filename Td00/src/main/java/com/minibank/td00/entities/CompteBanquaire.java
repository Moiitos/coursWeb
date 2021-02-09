package com.minibank.td00.entities;

import com.minibank.td00.entities.enumeration.TypeCompte;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CompteBanquaire")
public class CompteBanquaire implements Serializable {

    //Attribues
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "numero")
    private int Numero;

    @Enumerated(EnumType.STRING)
    @NonNull
    private TypeCompte Type;

    @Column(name = "soldeInitial")
    private float SoldeInitial;

    @Column(name = "soldeActuel")
    private float SoldeActuel;

    @OneToOne(cascade = CascadeType.ALL)
    private Client Client;


    //private List<String> Historique = new ArrayList<>();
    //List<String> Historique = new ArrayList<>();

    //Modification solde
    public void AjoutArgent(float montant){
        this.SoldeActuel += montant;
        //Historique.add("+ " + montant);
    }

    public void RetirerArgent(float montant){
        this.SoldeActuel -= montant;
       // Historique.add("- " + montant);
    }

    // Getter
//    public List<String> getHistorique() {
//        return Historique;
//    }

    public float getSoldeActuel() {
        return SoldeActuel;
    }

    public int getNumero() {
        return Numero;
    }

    //Constructeur
    public CompteBanquaire(TypeCompte type, float soldeInitial, float soldeActuel, Client client) {
        Numero = id.intValue();
        Type = type;
        SoldeInitial = soldeInitial;
        SoldeActuel = soldeActuel;
        Client = client;
        //Historique.add("+ " + soldeInitial);
    }

    public CompteBanquaire(){}

    //ToString
    @Override
    public String toString() {
        return "MiniBank.CompteBanquaire{" +
                "Numero=" + Numero +
                ", TypeCompte=" + Type +
                ", SoldeInitial=" + SoldeInitial +
                ", SoldeActuel=" + SoldeActuel +
                ", MiniBank.Client=" + Client +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public TypeCompte getType() {
        return Type;
    }

    public void setType(TypeCompte type) {
        Type = type;
    }

    public float getSoldeInitial() {
        return SoldeInitial;
    }

    public void setSoldeInitial(float soldeInitial) {
        SoldeInitial = soldeInitial;
    }

    public void setSoldeActuel(float soldeActuel) {
        SoldeActuel = soldeActuel;
    }

    public com.minibank.td00.entities.Client getClient() {
        return Client;
    }

    public void setClient(com.minibank.td00.entities.Client client) {
        Client = client;
    }

    //public void setHistorique(List<String> historique) {
//        Historique = historique;
//    }
}
