/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bdd.Gestionnaire;
import bdd.Personne;
import java.sql.Connection;

/**
 *
 * @author adm
 */
public interface IAdminService {
     public abstract Gestionnaire chargerAdmin(Connection conn,String identifiant);
    
    public abstract void creerAdmin(Connection conn,String nom, String prenom
        ,String adresse,String motDePasse,String identifiant);
    
    public abstract void retirerAdmin(Connection conn, Gestionnaire admin);
    
    public abstract boolean verifierAdmin(Connection conn, String identifiant, String mot_de_passe);
    
}
