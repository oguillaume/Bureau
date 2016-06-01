package services;

import bdd.Personne;
import java.sql.Connection;

/**
 *
 * @author adm
 */
public interface IPersonneService {
    public abstract Personne chargerPersonne(Connection conn,Integer idpersonne);
    
}
