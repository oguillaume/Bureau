/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bdd.BDDException;
import bdd.Base;
import bdd.Gestionnaire;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

/**
 *
 * @author adm
 */
public class AdminService implements IAdminService{
     private final Base base= new Base();
     
    @Override
    public Gestionnaire chargerAdmin(Connection conn, String identifiant) {
        Gestionnaire admin;
        String requete_select_admin="SELECT * FROM Gestionnaire where identifiant =?";
        ResultSet resultat;
        try{
            admin=new Gestionnaire();
            resultat=base.executerRequeteQuery(requete_select_admin, conn, identifiant);
            while (resultat.next()){
                admin.setIdentifiant(resultat.getString("identifiant"));
                admin.setPasseadmin(resultat.getString("passeadmin"));
            }
        }catch(SQLException sqlex){
                throw new BDDException(sqlex);    
        }
        return admin;
    }

    @Override
    public void retirerAdmin(Connection conn, Gestionnaire admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void creerAdmin(Connection conn, String nom, String prenom, String adresse, String motDePasse, String identifiant) {
        String requete_insert_admin1="INSERT INTO Personne(nom,prenom,adresse)"+
            " VALUES(?,?,?)";
        String requete_insert_admin2 = "INSERT INTO Gestionnaire(identifiant,passeadmin"+
            ",idPersonne)VALUES(?,?,?)";
        int idPersonne=base.executerRequeteUpdate(requete_insert_admin1, conn,true,nom,prenom,adresse);
        String pass_hache=encryptPassword(motDePasse);
        //String pass_hache=Codage.encryptPassword(motDePasse, "SHA-1");
        base.executerRequeteUpdate(requete_insert_admin2,conn,false,identifiant,pass_hache,idPersonne);
         }

    @Override
    public boolean verifierAdmin(Connection conn, String identifiant, String mot_de_passe) {
       Gestionnaire admin = chargerAdmin(conn, identifiant);
       if (admin.getIdentifiant()==null) 
        {
            return false;      
        } else{
       String passehache = encryptPassword(mot_de_passe);
       if(admin.getPasseadmin().equals(passehache)){
           return true;
       }
       else return false;       
     }}
    private static String encryptPassword(String password)
    { // cryptage du mot de passe
    String sha1 = "";
    try
    {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(password.getBytes("UTF-8"));
        sha1 = byteToHex(crypt.digest());
    }
    catch(NoSuchAlgorithmException e)
    {
        e.printStackTrace();
    }
    catch(UnsupportedEncodingException e)
    {
        e.printStackTrace();
    }
    return sha1;
}

private static String byteToHex(final byte[] hash)
{
    Formatter formatter = new Formatter();
    for (byte b : hash)
    {
        formatter.format("%02x", b);
    }
    String result = formatter.toString();
    formatter.close();
    return result;
}
    
}
