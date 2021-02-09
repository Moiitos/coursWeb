package com.minibank.td00.entities;

import com.minibank.td00.entities.enumeration.Sexe;
import com.minibank.td00.entities.enumeration.StatMatrimonial;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gestionnaire")
public class Gestionnaire extends Personne implements Serializable  {

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

    @Column(name = "bureau")
    private int NumBureau;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Client> Clients = new ArrayList<>();

    @Column(name = "username")
    private String Username;

    @Column(name = "password")
    private String Password;

    //Constructeur
    public Gestionnaire(String nom, String prenom, Adresse adresse, String numTelephone, String email, Sexe sexe, int numBureau, String username, String password) {
        super(nom, prenom, adresse, numTelephone, email, sexe);
        this.NumBureau = numBureau;
        this.Username = username;
        this.Password = password;
    }

    public Gestionnaire(){}

    public Client AjoutClient(String nom, String prenom, Adresse adresse, String numTelephone,
                               String email, String sexe, int numClient, int salaire, String statMatrimonial,
                               int anneeNaissance, int code)
    {
        //Nouveau client
        Client nouveau_Client;

        // Trouver sexe
        Sexe sexeOption = Sexe.Femme;
        if (sexe.equalsIgnoreCase("Homme"))
            sexeOption = Sexe.Homme;

        switch (statMatrimonial) {
            case "Celibataire":
                nouveau_Client = new Client(nom, prenom, adresse, numTelephone,
                        email, sexeOption, numClient, salaire,
                        StatMatrimonial.Celibataire, anneeNaissance, code);
            case "Marie":
                nouveau_Client = new Client(nom, prenom, adresse, numTelephone,
                        email, sexeOption, numClient, salaire,
                        StatMatrimonial.Marie, anneeNaissance, code);
            default:
                nouveau_Client = new Client(nom, prenom, adresse, numTelephone,
                        email, sexeOption, numClient, salaire,
                        StatMatrimonial.Divorce, anneeNaissance, code);
        }

        Clients.add(nouveau_Client);
        return nouveau_Client;
    }

    public List<String> ConsulterSoldeClient(Client client){return client.AfficherSoldeTotal();}

    public List<Client> ListerClient() {return Clients;}

    public void OuvrirCompteClient(Client client, String type, float soldeInitial){
        client.OuvrirCompteBanquaire(type, soldeInitial, client);
    }

    public void EffectuerOperation(Client client, CompteBanquaire compte, String operation, float montant){
        if (operation.equalsIgnoreCase("Ajout")) {
            client.AjoutArgent(compte, montant);
        } else {
            client.RetirerArgent(compte, montant);
        }
    }

    public Boolean VerifierInformation(String username, String password){
        return this.Username.equalsIgnoreCase(username) && this.Password.equalsIgnoreCase(password);
    }

    public String informationInteretCredit(float credit, float interet, float payement){
        var montantTotal = credit + (credit * (interet/100));
        float nbMois = montantTotal/payement;
        nbMois = Math.round(nbMois);
        if (nbMois > 12) {
            return "Le montant total du credit est " + montantTotal +
                    ", le tout payer en coup de " + payement + " durera " +
                    Math.round(nbMois / 12) + " annees et " + Math.round(nbMois % 12) + " mois.";
        } else {
            return "Le montant total du credit est " + montantTotal +
                    ", le tout payer en coup de " + payement + " durera " +
                     + nbMois + " mois.";
        }
    }

    //ToString
    @Override
    public String toString() {
        return "MiniBank.Gestionnaire{" +
                "NumBureau=" + NumBureau +
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

    public int getNumBureau() {
        return NumBureau;
    }

    public void setNumBureau(int numBureau) {
        NumBureau = numBureau;
    }

    public List<Client> getClients() {
        return Clients;
    }

    public void setClients(List<Client> clients) {
        Clients = clients;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
