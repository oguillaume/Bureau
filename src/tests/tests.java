/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import bdd.Base;
import bdd.Candidat;
import bdd.Electeur;
import bdd.Election;
import bdd.Personne;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import services.AdminService;
import services.BureauService;
import services.CandidatService;
import services.ElecteurService;
import services.ElectionService;
import services.ListesService;
import services.PersonneService;

/**
 *
 * @author HP-G61 classe de test pour le client lourd
 */
public class tests {

    

    public static void main(String[] args) throws FileNotFoundException {
        Base database = new Base();
        Connection conn = database.connexion();
        /* creation d'un administrateur */
        AdminService serviceGestio = new AdminService();
        //     serviceGestio.creerAdmin(conn, "Marie", "Marc", "Le puits", "essai", "maire");
        /* creation du bureau */

        BureauService serviceBureau = new BureauService();
        //   serviceBureau.creerBureau(conn, "salle des fetes", "MaVille");
        //    serviceBureau.creerBureau(conn,"mairie","MaVille");
       /* creation d'un electeur */
        List<Electeur> listeElecteurs;
        List<Candidat> listeCandidat;
        List<Personne> listePersonne, listePersonnes;
        PersonneService servicePersonne = new PersonneService();
        ElecteurService serviceElecteur = new ElecteurService();
        //      serviceElecteur.creerElecteur(conn, "SARKOZY","NICOLAS1","Neubourg","merde",1,"nsarkozy");
        //      serviceElecteur.creerElecteur(conn, "JEANMAIRE", "JEAN", "Le BOURG", "truc", 1,"jjeanmaire");
        //       serviceElecteur.creerElecteur(conn, "Dubois", "JEAN", "Le BOURG", "essai", 2,"jdubois");
        /* creation d'un candidat */
        CandidatService serviceCandidat = new CandidatService();
        //      serviceCandidat.creerCandidat(conn,"Romain","FRANCOIS","Neubourg", "des sous!", null);
        /* creation d'une election */
        ElectionService serviceElection = new ElectionService();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = df.parse("23-06-2016");
            //       serviceElection.creerElection(conn, "le meilleur patissier", "locale", date);

        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        //    serviceElection.creerElection(conn, "le meilleur patissier", "locale", date);

        Election election = serviceElection.chargerElection(conn, 1);
        //    System.out.println("Election :"+election.getNom()+" "+election.getType()+" le"+election.getDateElection().toString());
        //    Electeur electeure = serviceElecteur.chargerElecteur(conn, "SARKOZY", "NICOLAS1", "Neubourg");
        //    System.out.println("Electeur MDP :"+electeure.getMotDePasse());
        System.out.println("liste des électeurs");
        listeElecteurs = serviceElecteur.findAll(conn);

        /*    for(Electeur electeur : listeElecteurs){   
         System.out.println("Electeur n°"+electeur.getElecteurPK().getIdElecteur()+" : "+
         electeur.getPersonne().getNom()+
         " "+electeur.getPersonne().getPrenom()+", idPersonne="+
         electeur.getElecteurPK().getIdpersonne());
         }
         System.out.println("liste des personnes");
       
      
         System.out.println("liste des candidats");
         listeCandidat=serviceCandidat.listeCandidat(conn);
         for(Candidat candidat : listeCandidat){
         System.out.println("Candidat n°"+candidat.getIdCandidat()+" : "+candidat.getPersonne().getNom()+" "+candidat.getPersonne().
         getPrenom()+" "+candidat.getProgramme());
         }*/
     //   RelationEBVService relation = new RelationEBVService();
        //   relation.ajouterBureauAElection(1, 3);
   /*     String requete = "COPY public.electeur TO STDOUT"; // (SELECT * FROM electeur ORDER BY identifiant)
         String requete_2="COPY (select * FROM public.personne ORDER BY nom, prenom) TO STDOUT";
         String fichier = "C:/PPE/EssaiCopyTablePersonne.csv";
         FileWriter lecteur = null;
         try {
         CopyManager copyFichier = new CopyManager((BaseConnection) conn);
         lecteur = new FileWriter(fichier);
         copyFichier.copyOut(requete_2, lecteur);
         System.out.println("table transférée");
         } catch (SQLException | IOException ex) {
         Logger.getLogger(tests.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
         try {
         if (lecteur != null) {
         lecteur.close();
         }
         } catch (IOException ex) {
         Logger.getLogger(tests.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
        

        
         */
   //     ecrireListeElecteurs(conn);
         database.deconnexion (conn);
    }

    
    private static void ecrireListeElecteurs(Connection conn) {
        ListesService serviceListes = new ListesService();
        File file = serviceListes.getResource("EssaiCopyTablePersonne2.csv");
        ElecteurService serviceElecteur = new ElecteurService();
        List<String[]> data = serviceListes.chargementTables(file);
        for (String[] oneData : data) {
            String nom = oneData[0];
            String prenom = oneData[1];
            String adresse = oneData[2];
            java.sql.Date dateNaissance = java.sql.Date.valueOf(oneData[3]);
            Integer num_bureau = Integer.parseInt(oneData[4]);
            serviceElecteur.creerElecteur(conn, nom, prenom, adresse, adresse, num_bureau, prenom, dateNaissance);
        }
    }

   

}
