/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bdd.BDDException;
import bdd.Base;
import bdd.BureauDeVote;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adm
 */
public class BureauService implements IBureauService{
    private final Base base = new Base();
    @Override
    public BureauDeVote chargerBureau(Connection conn, Integer idBureau) {
       String requete_select_bureau="SELECT * FROM bureau_de_vote WHERE num_bureau=?";
      
       BureauDeVote bureau = new BureauDeVote();
       ResultSet resultat=null;
       try{
           resultat=base.executerRequeteQuery(requete_select_bureau, conn, idBureau);
            while (resultat.next()){ 
                bureau.setNumBureau(resultat.getInt("num_bureau"));
                bureau.setVille(resultat.getString("ville"));
                bureau.setLibelle(resultat.getString("libelle"));
            }
       }catch(SQLException sqlex){
            throw new BDDException(sqlex);
       }
       return bureau;
    }

    @Override
    public void creerBureau(Connection conn, String libelle, String ville) {
        String requete_insert_bureau="INSERT INTO bureau_de_vote(libelle,ville)"+
                "VALUES(?,?)";   
        base.executerRequeteUpdate(requete_insert_bureau,conn,false,libelle,ville);
    }

    @Override
    public List<BureauDeVote> listeBureau(Connection conn) {
       String requete_all_bureaux="SELECT * FROM bureau_de_vote";
        List<BureauDeVote> listeBureaux = new ArrayList<BureauDeVote>();
        BureauDeVote bureau = null;
        ResultSet resultat=null;
        try{
            resultat=base.executerRequeteQuery(requete_all_bureaux, conn);
            while (resultat.next()){ 
                bureau= new BureauDeVote();
                bureau.setNumBureau(resultat.getInt("num_bureau"));
                bureau.setVille(resultat.getString("ville"));
                bureau.setLibelle(resultat.getString("libelle"));
                listeBureaux.add(bureau);
            }
        }catch(SQLException sqlex){
            throw new BDDException(sqlex);
        }
        return listeBureaux;
    }  
    public void modifierBureau(Connection conn, String nom, String adresse, Integer numBureau){
         String requete_modification = "UPDATE bureau_de_vote SET nom=?, adresse=? WHERE num_bureau=?";
         base.executerRequeteUpdate(requete_modification,conn,false,nom,adresse,numBureau);
    }
    
    public void retirerBureau(Connection conn,Integer numBureau){
        String requete_retrait="DELETE FROM bureau_de_vote WHERE num_bureau=?";
        base.executerRequeteUpdate(requete_retrait, conn, false, numBureau);
    }
}
