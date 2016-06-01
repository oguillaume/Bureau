/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bdd.Candidat;
import bdd.Election;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author HP-G61
 */
public interface ICandidatService {
    
    public abstract Candidat chargerCandidat(Connection conn,Integer idCandidat);
    
    public abstract void creerCandidat(Connection conn,String nom, String prenom,
            String adresse, String accroche,String photo, Election election);
    
    public abstract void retirerCandidat(Connection conn, int id);
    
    public abstract List<Candidat> listeCandidat(Connection conn);
    
    public abstract void modifierCandidat(Connection conn,int id,String nom, String prenom,
            String adresse, String accroche,String photo, Election election);
}
