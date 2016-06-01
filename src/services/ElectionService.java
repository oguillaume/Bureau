/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bdd.BDDException;
import bdd.Base;
import bdd.Election;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adm
 */
public class ElectionService implements IElectionService{
    private final Base base= new Base();
    @Override
    public Election chargerElection(Connection conn, int idElection) {
        Election election=null;
        ResultSet resultat = null;
        String requete_select_election="SELECT * FROM Election where id_election =?";
        try{
            election=new Election();
            resultat=base.executerRequeteQuery(requete_select_election, conn, idElection);
            while (resultat.next()){
                election.setNom(resultat.getString("nom"));
                election.setType(resultat.getString("type"));
                election.setDateElection(resultat.getDate("date_election"));
            }
        }catch(SQLException sqlex){
                throw new BDDException(sqlex);    
        }
        return election;
    }

    @Override
    public int creerElection(Connection conn, String nom, String type, Date date){
        String requete_creer_election="INSERT INTO Election(nom,type,date_election)"+
                " VALUES(?,?,?)";
        int idElection=base.executerRequeteUpdate(requete_creer_election, conn, true, nom,type,date);
        return idElection;     
    }

    @Override
    public void retirerElection(Connection conn, int id) {
       String requete_retirer_election="DELETE * FROM Election WHERE id_election=?";
       base.executerRequeteUpdate(requete_retirer_election, conn, false, id);
    }

    @Override
    public List<Election> listeElection(Connection conn) {
        List<Election> listElections= new ArrayList<Election>();
        Election election = null;
        ResultSet resultat = null;
        String requete_select_all_elections="SELECT * FROM Election";
        try {  
           
            resultat=base.executerRequeteQuery(requete_select_all_elections, conn);
            while (resultat.next()){
                 election = new Election();
                election.setIdElection(resultat.getInt("id_election"));
                election.setNom(resultat.getString("nom"));
                election.setType(resultat.getString("type"));
                election.setDateElection(resultat.getDate("date_election"));
                listElections.add(election);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listElections;
    }

    @Override
    public Election modifierElection(Connection conn, int id, String nom, String type, Date date) {
      String requete_modifier_election="UPDATE Election SET nom=?, type=?,date_election=?"
              +" WHERE id_election=?";
      base.executerRequeteUpdate(requete_modifier_election, conn, false, nom,type,date,id);
      Election election=chargerElection(conn,id);
      return election;
    }
    
    
}
