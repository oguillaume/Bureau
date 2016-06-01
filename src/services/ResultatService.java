/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bdd.Base;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adm
 */
public class ResultatService implements IResultatService{
     private final Base base= new Base();
    @Override
    public List<List<String>> recupererResultatsElection(Connection conn) {
        String requete_resultats_candidats="SELECT nom,prenom,nbVoix FROM"
                +" Candidat as c,Personne as p,Resultat as r,A_Un as a"
                +" WHERE c.idpersonne=p.idpersonne AND a.idpersonne=c.idpersonne"
                +" AND a.idresultat=r.idresultat  ORDER BY nbvoix DESC";
        ResultSet resultat=null;
        List<List<String>> resultatsElection = new ArrayList<List<String>>();
        try{
            
            resultat=base.executerRequeteQuery(requete_resultats_candidats, conn);
            int i=1;
            while(resultat.next()){
                List<String> resultatI = new ArrayList<String>();
                resultatI.add(String.valueOf(i));
                resultatI.add(resultat.getString("nom")+" "+resultat.getString("prenom"));
                resultatI.add(String.valueOf(resultat.getInt("nbVoix")));
                resultatsElection.add(resultatI);
                i=i+1;
            }
          //  base.deconnexion(conn);
        } catch (SQLException ex) {
             Logger.getLogger(ResultatService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultatsElection;
    }

    @Override
    public int nombreVotants(Connection conn) {
       String requete_inscrits="SELECT COUNT(*) as count FROM Votepour WHERE signatures=TRUE";
        ResultSet resultat=null;
        int nbvotants=0;
        try{
            resultat=base.executerRequeteQuery(requete_inscrits, conn);
            resultat.next();
            nbvotants=resultat.getInt("count");
         //   base.deconnexion(conn);
        }    catch (SQLException ex) {
             Logger.getLogger(ResultatService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nbvotants;
    }

    @Override
    public int nombreInscrits(Connection conn) { //,int idBureau){
        String requete_inscrits="SELECT COUNT(*) as nbre FROM electeur";
        //String requete_inscrits_bureau="SELECT COUNT(*) as nbre FROM electeur where num_bureau=?";
        ResultSet resultat=null;
        int nbinscrits=0;
        try{
            resultat=base.executerRequeteQuery(requete_inscrits, conn); //,idBureau);
            resultat.next();
            nbinscrits=resultat.getInt("nbre");
         //   base.deconnexion(conn);
        }    catch (SQLException ex) {
             Logger.getLogger(ResultatService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nbinscrits;
    }
}
