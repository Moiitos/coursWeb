package com.minibank.td00.entities;

import com.minibank.td00.entities.enumeration.Sexe;
import com.minibank.td00.entities.enumeration.StatMatrimonial;
import com.minibank.td00.entities.enumeration.TypeCompte;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client extends Personne implements Serializable {

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

    @Column(name = "numClient")
    private int NumClient;

    @Column(name = "salaire")
    private int Salaire;

    @Enumerated(EnumType.STRING)
    @NonNull
    private StatMatrimonial StatMatrimonial;

    @Column(name = "anneeNaissance")
    private int AnneeNaissance;

    @Column(name = "code")
    private int Code;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CompteBanquaire> Comptes = new ArrayList<>();

    //Getter
    public List<CompteBanquaire> getComptes() {
        return Comptes;
    }

    //Constructeur
    public Client(String nom, String prenom, Adresse adresse, String numTelephone,
                  String email, Sexe sexe, int numClient, int salaire,
                  StatMatrimonial statMatrimonial, int anneeNaissance, int code) {
        super(nom, prenom, adresse, numTelephone, email, sexe);
        NumClient = numClient;
        Salaire = salaire;
        StatMatrimonial = statMatrimonial;
        AnneeNaissance = anneeNaissance;
        Code = code;
    }

    public Client(){}

    public void OuvrirCompteBanquaire(String optionsCompte, float soldeInitial, Client client){
        if (optionsCompte.equalsIgnoreCase("Cheque")) {
            Comptes.add(new CompteBanquaire(TypeCompte.Cheque, soldeInitial, soldeInitial, client));
        } else {
            Comptes.add(new CompteBanquaire(TypeCompte.Epargne, soldeInitial, soldeInitial, client));
        }
    }

    public void AjoutArgent(CompteBanquaire compte, float montant){
        compte.AjoutArgent(montant);
    }

    public void RetirerArgent(CompteBanquaire compte, float montant){
        compte.RetirerArgent(montant);
    }

//    private List<String> AfficherHistorique(CompteBanquaire compte){
//        return compte.getHistorique();
//    }

    public float AfficherSolde(CompteBanquaire compte){return compte.getSoldeActuel();}

    public List<String> AfficherSoldeTotal(){
        List<String> solde = new ArrayList<>();
        float total = 0;
        for (var compte : Comptes){
            solde.add(compte.getNumero() + " : " + compte.getSoldeActuel());
            total += compte.getSoldeActuel();
        }
        solde.add("Total = " + total);
        return solde;
    }

    @Override
    public String toString() {
        return "MiniBank.Client{" +
                "NumClient=" + NumClient +
                ", Salaire=" + Salaire +
                ", StatMatrimonial=" + StatMatrimonial +
                ", AnneeNaissance=" + AnneeNaissance +
                ", Code=" + Code +
                '}';
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getNumClient() {
        return NumClient;
    }

    public void setNumClient(int numClient) {
        NumClient = numClient;
    }

    public int getSalaire() {
        return Salaire;
    }

    public void setSalaire(int salaire) {
        Salaire = salaire;
    }

    public StatMatrimonial getStatMatrimonial() {
        return StatMatrimonial;
    }

    public void setStatMatrimonial(StatMatrimonial statMatrimonial) {
        StatMatrimonial = statMatrimonial;
    }

    public int getAnneeNaissance() {
        return AnneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        AnneeNaissance = anneeNaissance;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public void setComptes(List<CompteBanquaire> comptes) {
        Comptes = comptes;
    }
}
