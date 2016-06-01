package services;

import bdd.BDDException;
import bdd.Base;
import static bdd.Base.fermetureSilencieuse;
import bdd.Personne;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adm
 */
public class PersonneService implements IPersonneService{
    private final Base base = new Base();
    
    @Override
    public Personne chargerPersonne(Connection conn,Integer idpersonne) {
        String requete_select_pers="SELECT * FROM Personne p WHERE p.idpersonne=?";
        Personne personne = new Personne();
        ResultSet resultat=null;
        try{
            resultat=base.executerRequeteQuery(requete_select_pers, conn,idpersonne);
            while(resultat.next()){
                personne.setNom(resultat.getString("nom"));
                personne.setPrenom(resultat.getString("prenom"));
                personne.setAdresse(resultat.getString("adresse"));
            }
        }catch(SQLException sqlex){
            throw new BDDException(sqlex);
        }finally{
            fermetureSilencieuse(resultat);
        }
        return personne;    
    }  
}
