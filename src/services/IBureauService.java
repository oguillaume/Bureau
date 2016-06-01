/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bdd.BureauDeVote;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author adm
 */
public interface IBureauService {
    public abstract BureauDeVote chargerBureau(Connection conn, Integer idBureau);
    
    public abstract void creerBureau(Connection conn,String libelle, String ville);
    
  //  public abstract void retirerCandidat(Connection conn, Candidat candidat);
    
    public abstract List<BureauDeVote> listeBureau(Connection conn);
}
