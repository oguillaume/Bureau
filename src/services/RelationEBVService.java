/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bdd.Base;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adm
 */
public class RelationEBVService {
    public void ajouterBureauAElection(int idElection, int idBureau){
        String ajouterBAE="INSERT INTO a_lieu_dans(id_election,num_bureau) VALUES (?,?)";
        Base base = new Base();
        Connection conn;
        try {
            conn = base.connexion();
            base.executerRequeteUpdate(ajouterBAE, conn, true, idElection,idBureau);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelationEBVService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
