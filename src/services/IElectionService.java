/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bdd.Election;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author adm
 */
public interface IElectionService {
    public abstract Election chargerElection(Connection conn,int id);

    public abstract int creerElection(Connection conn,String nom, String type, Date date);
    
    public abstract void retirerElection(Connection conn, int id);
    
    public abstract List<Election> listeElection(Connection conn);
    
     public abstract  Election modifierElection(Connection conn,int id,String nom, String type,Date date);
}
