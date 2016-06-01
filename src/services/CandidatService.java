 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bdd.BDDException;
import bdd.Base;
import static bdd.Base.fermetureSilencieuse;
import bdd.Candidat;
import bdd.Election;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP-G61
 */
public class CandidatService implements ICandidatService{
    
    private static final String requete_insert_resultat="INSERT INTO Resultat(nbvoix) VALUES (0)";
    
    private final Base base=new Base();
    
    @Override
    public List<Candidat> listeCandidat(Connection conn) {
        Candidat candidat = null;
        List<Candidat> listeCandidat = new ArrayList<Candidat>();
        ResultSet resultat=null;
        PersonneService persCandidat = null;
        String requete_select_candidat_all="SELECT * FROM Candidat";
        try{
            resultat=base.executerRequeteQuery(requete_select_candidat_all, conn);
        while (resultat.next()){   
            candidat= new Candidat();
            persCandidat= new PersonneService();
            candidat.setIdCandidat(resultat.getInt("id_candidat"));
            candidat.setIdpersonne(resultat.getInt("idpersonne"));
            candidat.setPersonne(persCandidat.chargerPersonne(conn, candidat.getIdpersonne()));
            candidat.setProgramme(resultat.getString("programme"));
            candidat.setPhoto(resultat.getString("photo"));
            listeCandidat.add(candidat);
        }
        }catch(SQLException sqlex){
            throw new BDDException(sqlex);
        }finally{
            fermetureSilencieuse(resultat);
        }
        return listeCandidat;
    }

    @Override
    public void creerCandidat(Connection conn, String nom, String prenom, String adresse, 
            String accroche,String photo, Election election) {
        String requete_insert_cand1="INSERT INTO Personne(nom,prenom,adresse)"+
            " VALUES(?,?,?)";
        String requete_insert_cand2 = "INSERT INTO Candidat(programme"
                + ",photo,idpersonne) VALUES(?,?,?)";
        String requete_insert_cand_aun="INSERT INTO AUN(id_election,idpersonne,idresultat)"
            + " VALUES(?,?,?)";
        int idPersonne=base.executerRequeteUpdate(requete_insert_cand1, conn,true,nom,prenom,adresse);
        int idCandidat=base.executerRequeteUpdate(requete_insert_cand2,conn,true,accroche,photo,idPersonne);
        int idResultat=idCandidat*election.getIdElection();
        base.executerRequeteUpdate(requete_insert_cand_aun, conn, false, election.getIdElection(),idPersonne,idCandidat);    
    }

    @Override
    public void retirerCandidat(Connection conn, int idCandidat) {
       String requete_delete_candidat="DELETE FROM Candidat WHERE id_candidat=?";
       String requete_delete_personne="DELETE FROM Personne WHERE idPersonne=?";
       int idPersonne =base.executerRequeteUpdate(requete_delete_candidat, conn, true, idCandidat);
       base.executerRequeteUpdate(requete_delete_personne, conn, false, idPersonne);
    }

    @Override
    public Candidat chargerCandidat(Connection conn,Integer idCandidat) {
        Candidat candidat = new Candidat();
        PersonneService persCandidat = new PersonneService(); 
        String requete_select_1_candidat="SELECT * FROM Candidat WHERE id_candidat=?";
        try{
            ResultSet resultat=base.executerRequeteQuery(requete_select_1_candidat, conn,idCandidat);
            while (resultat.next()){
                candidat.setIdpersonne(resultat.getInt("idpersonne"));
                candidat.setPersonne(persCandidat.chargerPersonne(conn, candidat.getIdpersonne()));
                candidat.setProgramme(resultat.getString("programme"));
                candidat.setPhoto(resultat.getString("photo"));
            }
        }catch(SQLException sqlex){
            throw new BDDException(sqlex);
        }
        return candidat;
    }

    @Override
    public void modifierCandidat(Connection conn,int id, String nom, String prenom, String adresse, 
            String accroche, String photo, Election election) {
        String requete_modifier_personne="UPDATE Personne SET nom=?,prenom=?,adresse=?"
                 +" WHERE idpersonne in(SELECT idpersonne FROM Candidat WHERE id_candidat=?)";
        String requete_modifier_candidat="UPDATE Candidat SET programme=?,photo=? WHERE id_candidat=?";
        String requete_modifer_cand_aun="UPDATE AUN SET id_election";
        base.executerRequeteUpdate(requete_modifier_personne, conn, false, nom,prenom,adresse,id);
        base.executerRequeteUpdate(requete_modifier_candidat, conn, true,accroche,photo,id);
    } 
}
