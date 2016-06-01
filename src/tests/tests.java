/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import bdd.BDDException;
import bdd.Base;
import bdd.BureauDeVote;
import bdd.Candidat;
import bdd.Electeur;
import bdd.Election;
import bdd.Personne;
import bdd.Votepour;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import services.AdminService;
import services.BureauService;
import services.CandidatService;
import services.ElecteurService;
import services.ElectionService;
import services.PersonneService;
import services.RelationEBVService;

/**
 *
 * @author HP-G61
 * classe de test pour le client lourd
 */
public class tests {
    
    public static void main(String[] args) throws FileNotFoundException {
        Base database = new Base();
        Connection conn=database.connexion();
         /* creation d'un administrateur */
        AdminService  serviceGestio =new AdminService();
   //     serviceGestio.creerAdmin(conn, "Marie", "Marc", "Le puits", "essai", "maire");
        /* creation du bureau */
    
        BureauService serviceBureau = new BureauService();
    //   serviceBureau.creerBureau(conn, "salle des fetes", "MaVille");
    //    serviceBureau.creerBureau(conn,"mairie","MaVille");
       /* creation d'un electeur */
        List<Electeur> listeElecteurs ;
        List<Candidat> listeCandidat;
        List<Personne> listePersonne,listePersonnes;
        PersonneService servicePersonne = new PersonneService();
        ElecteurService serviceElecteur = new ElecteurService();
  //      serviceElecteur.creerElecteur(conn, "SARKOZY","NICOLAS1","Neubourg","merde",1,"nsarkozy");
  //      serviceElecteur.creerElecteur(conn, "JEANMAIRE", "JEAN", "Le BOURG", "truc", 1,"jjeanmaire");
  //       serviceElecteur.creerElecteur(conn, "Dubois", "JEAN", "Le BOURG", "essai", 2,"jdubois");
        /* creation d'un candidat */
        CandidatService serviceCandidat = new CandidatService();
  //      serviceCandidat.creerCandidat(conn,"Romain","FRANCOIS","Neubourg", "des sous!", null);
        /* creation d'une election */
        ElectionService serviceElection=new ElectionService();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date=null;
        try{
            date=df.parse("23-06-2016");
     //       serviceElection.creerElection(conn, "le meilleur patissier", "locale", date);

        }catch(ParseException pe){
            pe.printStackTrace();
        }
    //    serviceElection.creerElection(conn, "le meilleur patissier", "locale", date);
        
        Election election = serviceElection.chargerElection(conn, 1);
        System.out.println("Election :"+election.getNom()+" "+election.getType()+" le"+election.getDateElection().toString());
    //    Electeur electeure = serviceElecteur.chargerElecteur(conn, "SARKOZY", "NICOLAS1", "Neubourg");
    //    System.out.println("Electeur MDP :"+electeure.getMotDePasse());
        System.out.println("liste des électeurs");
        listeElecteurs=serviceElecteur.findAll(conn);
       
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
        String requete="SELECT * FROM Votepour";
     
        Votepour votes = new Votepour();
        
        try{
            ResultSet resultat=database.executerRequeteQuery(requete, conn);
            while(resultat.next()){
                int idElection = resultat.getInt("id_election");
                System.out.println("idElection ="+idElection);
            }   
        }catch(SQLException sqlex){
            throw new BDDException(sqlex);
        }
        
    
        database.deconnexion(conn);
        
        
    }
    
}