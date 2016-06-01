package services;

import bdd.Electeur;
import bdd.Election;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author HP-G61
 */
public interface IElecteurService {
    
    public abstract Electeur chargerElecteur(Connection conn,String nom, String prenom, String adresse);

    public abstract void creerElecteur(Connection conn,String nom, String prenom
        ,String adresse,String motDePasse,Integer numBureau,String identifiant,Date date);
    
    public abstract void retirerElecteur(Connection conn, int id);
    
    public abstract List<Electeur> findAll(Connection conn);
    
    public abstract void inscrireElecteurElection(Connection conn,Electeur electeur, Election election);
    
    public abstract  void modifierElecteur(Connection conn,int id,String nom, String prenom, String adresse,
            int numbureau,String identifiant,Date date);
}