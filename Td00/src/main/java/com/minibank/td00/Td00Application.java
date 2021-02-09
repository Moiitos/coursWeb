package com.minibank.td00;

import com.minibank.td00.entities.*;
import com.minibank.td00.entities.enumeration.Sexe;
import com.minibank.td00.entities.services.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Td00Application {

    private final Logger log = LoggerFactory.getLogger(Td00Application.class);

    private AdresseServiceImpl adresseService;
    private ClientServiceImpl clientService;
    private CompteBanquaireServiceImpl compteBanquaireService;
    private GestionnaireServiceImpl gestionnaireService;
    private PersonneServiceImpl personneService;

    public static void main(String[] args) {
        SpringApplication.run(Td00Application.class, args);
    }

    @Bean
    void crud() {
        //Initialisation
        //  gestionnaire
        Gestionnaire gestionnaire = new Gestionnaire("Sodoke", "Komi",
                new Adresse(123, "Gino", "BlainVille", "J2K1A8"),
                "450-254-3152", "Komi.Sodoke@gmail.ca", Sexe.Homme, 232, "gino", "123");

        //  client
        //String nom, String prenom, MiniBank.Adresse adresse, String numTelephone,
        //                               String email, String sexe, int numClient, int salaire, String statMatrimonial,
        //                               int anneeNaissance, int code
        List<Client> clients = new ArrayList<>();
        clients.add(gestionnaire.AjoutClient("Dubois", "Anthony",
                new Adresse(241, "Feuillue", "BoucherVille", "P9D4G2"),
                "450-824-9264", "Anthony.Dubois@gmail.ca", "Homme",
                1, 50000, "Marie", 2000, 8243));
        clients.add(gestionnaire.AjoutClient("Masse", "Pierre",
                new Adresse(634, "Rocheux", "BlueMontagne", "H6F4U3"),
                "450-234-2836", "Pierre.Masse@gmail.ca", "Homme",
                2, 75000, "Marie", 1986, 1923));
        clients.add(gestionnaire.AjoutClient("Duplessie", "Virginie",
                new Adresse(285, "Montaigneux", "Rigaud", "K8N5G2"),
                "450-102-1732", "Virginie.Duplessie@gmail.ca", "Femme",
                3, 47000, "Divorce", 1992, 1029));
        clients.add(gestionnaire.AjoutClient("Rochefort", "Eliane",
                new Adresse(863, "Havre", "Valleyfield", "J6S1V7"),
                "450-299-6666", "Eliane.Rochefort@gmail.ca", "Femme",
                4, 120000, "Marie", 2000, 8243));
        clients.add(gestionnaire.AjoutClient("Nolin", "William",
                new Adresse(274, "Riviere", "RiviereVille", "J8G5T6"),
                "450-274-3344", "William.Nolin@gmail.ca", "Homme",
                5, 130000, "Marie", 2000, 8243));
    }

//    public static void mainV2(String[] args) {
//        SpringApplication.run(Td00Application.class, args);
//
//        //Initialisation
//        //  gestionnaire
//        Gestionnaire gestionnaire = new Gestionnaire("Sodoke", "Komi",
//                new Adresse(123, "Gino", "BlainVille", "J2K1A8"),
//                "450-254-3152", "Komi.Sodoke@gmail.ca", Sexe.Homme, 232, "gino", "123");
//
//        //  client
//        //String nom, String prenom, MiniBank.Adresse adresse, String numTelephone,
//        //                               String email, String sexe, int numClient, int salaire, String statMatrimonial,
//        //                               int anneeNaissance, int code
//        List<Client> clients = new ArrayList<>();
//        clients.add(gestionnaire.AjoutClient("Dubois", "Anthony",
//                new Adresse(241, "Feuillue", "BoucherVille", "P9D4G2"),
//                "450-824-9264", "Anthony.Dubois@gmail.ca", "Homme",
//                1, 50000, "Marie", 2000, 8243));
//        clients.add(gestionnaire.AjoutClient("Masse", "Pierre",
//                new Adresse(634, "Rocheux", "BlueMontagne", "H6F4U3"),
//                "450-234-2836", "Pierre.Masse@gmail.ca", "Homme",
//                2, 75000, "Marie", 1986, 1923));
//        clients.add(gestionnaire.AjoutClient("Duplessie", "Virginie",
//                new Adresse(285, "Montaigneux", "Rigaud", "K8N5G2"),
//                "450-102-1732", "Virginie.Duplessie@gmail.ca", "Femme",
//                3, 47000, "Divorce", 1992, 1029));
//        clients.add(gestionnaire.AjoutClient("Rochefort", "Eliane",
//                new Adresse(863, "Havre", "Valleyfield", "J6S1V7"),
//                "450-299-6666", "Eliane.Rochefort@gmail.ca", "Femme",
//                4, 120000, "Marie", 2000, 8243));
//        clients.add(gestionnaire.AjoutClient("Nolin", "William",
//                new Adresse(274, "Riviere", "RiviereVille", "J8G5T6"),
//                "450-274-3344", "William.Nolin@gmail.ca", "Homme",
//                5, 130000, "Marie", 2000, 8243));
//
//        //Application
//        Scanner sc = new Scanner(System.in);
//        int choix = 0;
//
//        do {
////            System.out.println("Entrer votre identifiant");
////            var username = sc.nextLine();
////            System.out.println("Entrer votre mot de passe");
////            var password = sc.nextLine();
////            if (gestionnaire.VerifierInformation(username, password)) {
//            System.out.println("Bienvenue dans Mini-Banque INC.");
//            System.out.println("Choisir une action : ");
//            System.out.println("----------------------------------------\n" +
//                    "1 - Ajouter un client\n" +
//                    "2 - Consulter le solde d'un client\n" +
//                    "3 - Lister les clients\n" +
//                    "4 - Ouvrir un compte client\n" +
//                    "5 - Effectuer une operation\n" +
//                    "6 - Demande de credit\n" +
//                    "----------------------------------------");
//            System.out.println("Enter une action de 1 a 5... ");
//            choix = sc.nextInt();
//
//            switch (choix) {
//                case 1:
//                    System.out.println("Ajouter un nouveau client");
//                    System.out.println("Entrer le nom");
//                    var nom = sc.nextLine();
//                    System.out.println("Entrer le prenom");
//                    var prenom = sc.nextLine();
//                    System.out.println("Entrer le numero civique");
//                    var numCivique = sc.nextInt();
//                    System.out.println("Entrer le de rue");
//                    var rue = sc.nextLine();
//                    System.out.println("Entrer la ville");
//                    var ville = sc.nextLine();
//                    System.out.println("Entrer le code postal");
//                    var codePostal = sc.nextLine();
//                    System.out.println("Entrer le numero de telephone");
//                    var numTelephone = sc.nextLine();
//                    System.out.println("Entrer le email");
//                    var email = sc.nextLine();
//                    System.out.println("Entrer le sexe");
//                    var sexe = sc.nextLine();
//                    System.out.println("Entrer le numero client");
//                    var numClient = sc.nextInt();
//                    System.out.println("Entrer le salaire");
//                    var salaire = sc.nextInt();
//                    System.out.println("Entrer le statut matrimonial");
//                    var statMatrimonial = sc.nextLine();
//                    System.out.println("Entrer l'annee de naissance");
//                    var anneeNaissance = sc.nextInt();
//                    System.out.println("Entrer le code");
//                    var code = sc.nextInt();
//
//                    clients.add(gestionnaire.AjoutClient(nom, prenom,
//                            new Adresse(numCivique, rue, ville, codePostal),
//                            numTelephone, email, sexe, numClient, salaire, statMatrimonial, anneeNaissance, code));
//
//                    System.out.println("MiniBank.Client bien ajouter!");
//                    break;
//                case 2:
//                    System.out.println("Choisir un client :");
//                    for (var c : gestionnaire.ListerClient())
//                        System.out.println(c);
//                    choix = sc.nextInt();
//                    System.out.println(gestionnaire.ConsulterSoldeClient(clients.get(choix - 1)));
//                    break;
//                case 3:
//                    for (var c : gestionnaire.ListerClient())
//                        System.out.println(c);
//                    break;
//                case 4:
//                    System.out.println("Choisir un client :");
//                    // Choix du client
//                    for (var c : gestionnaire.ListerClient())
//                        System.out.println(c);
//                    choix = sc.nextInt();
//                    sc.nextLine();
//                    //TypeCompte compte
//                    System.out.println("Quel sorte de compte ? (cheque, epargne)");
//                    String type = sc.nextLine();
//                    sc.nextLine();
//                    //Montant initial
//                    System.out.println("Quel montant voulez vous mettre initialement?");
//                    float montant = sc.nextFloat();
//                    sc.nextLine();
//                    //Creation
//                    gestionnaire.OuvrirCompteClient(clients.get(choix - 1), type, montant);
//                    break;
//                case 5:
//                    // Choix du client
//                    for (var c : gestionnaire.ListerClient())
//                        System.out.println(c);
//                    choix = sc.nextInt();
//                    Client actuel_client = clients.get(choix - 1);
//                    System.out.println("Quel compte voulez-vous modifier?");
//                    for (var c : actuel_client.getComptes())
//                        System.out.println(c);
//                    choix = sc.nextInt();
//                    CompteBanquaire actual_compte = actuel_client.getComptes().get(choix - 1);
//                    System.out.println("Voulez-vous faire un 1 - ajout ou 2 - un retrait?");
//                    choix = sc.nextInt();
//                    if (choix == 1) {
//                        System.out.println("Quel montant voulez-vous deposer?");
//                        montant = sc.nextFloat();
//                        gestionnaire.EffectuerOperation(actuel_client, actual_compte, "Ajout", montant);
//                    } else {
//                        System.out.println("Quel montant voulez-vous retirer?");
//                        montant = sc.nextFloat();
//                        gestionnaire.EffectuerOperation(actuel_client, actual_compte, "Retirer", montant);
//                    }
//                    break;
//                case 6 :
//                    System.out.println("Entrer le montant de credit");
//                    var credit = sc.nextFloat();
//                    System.out.println("Entrer le taux interet");
//                    var interet = sc.nextFloat();
//                    System.out.println("Entrer le payement par mois");
//                    var payement = sc.nextFloat();
//                    System.out.println(gestionnaire.informationInteretCredit(credit,interet,payement));
//                    break;
//                default:
//                    System.out.println("Le choix entrer n'est pas entre 1 - 6");
//
//            }
////            } else {
////                System.out.println("Les informations rentrees sont mauvaise, n'essayer pas de nous voler!");
////            }
//        } while (choix != -1);
//    }
}
