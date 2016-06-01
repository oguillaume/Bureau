/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.Codage;


/**
 *
 * @author HP-G61
 */
public class Base {
    
    public ParametresBase parametres;
    public Base() {
    }
    /*
    *   Fonction connexion()
    *   Arguments : aucun
    *   Retour : la connexion créée
    *   Exception : Fichier de proprietes non localisé
    */
    
    public Connection connexion() throws FileNotFoundException{
        parametres=new ParametresBase();
        parametres.chargerParametres();
        String Driver=parametres.getDriver();
        String ip=parametres.getIp();
        String base=parametres.getBase();
        String gestion=parametres.getGestio();
        String port=parametres.getPort();
        String user=parametres.getUtilisateur();
        String pass=parametres.getMot_passe();
        
        String url="jdbc:"+gestion+"://"+ip+":"+port+"/"+base;
        System.out.println("url="+url);
        Connection conn=null;
        
        try {
            Class.forName(Driver);
            
        } catch (ClassNotFoundException cflex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, cflex);
            System.out.println(cflex.getMessage());
        }
        try{
            System.out.println("Driver="+Driver);
            String pass_hache= Codage.encryptPassword(pass, "MD5");
            conn=DriverManager.getConnection(url,user,pass);
            System.out.println("Base connectée ...");
            return conn;
        }catch(SQLException sqlex){
              Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, sqlex);
              System.out.println(sqlex.getMessage());
        }
        return conn;
    }
	/*
    *   Fonction deconnexion()
    *   Arguments :la connexion créée
    *   Retour : aucun
    */
    
    public void deconnexion(Connection conn){
        try{
            conn.close();
            System.out.println("Base déconnectée...");
        }catch(SQLException sqlex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }
    /*
    *   Fonction executerRequeteQuery (fonction de type SELECT)
    *   Arguments : requete (une requete sql )
    *               connexion (une connexion à la base)
    *               objets (les données de sélection)
    *   Retour :    Un tableau de données
    */
    public ResultSet executerRequeteQuery(String requete,Connection conn,Object... objet)throws SQLException{
        PreparedStatement etat=conn.prepareStatement(requete);
        for(int i=0;i<objet.length;i++){
            etat.setObject((i+1), objet[i]);
        }
        ResultSet rs=etat.executeQuery();
        //PreparedStatement etat=initialisationRequetePreparee( conn, requete, false, objet );
        
        return rs;
        
    }
    /*
    *   Fonction executerRequeteUpdate (fonction de type UPDATE,DELETE,INSERT..)
    *   Arguments : requete (une requete sql )
    *               connexion (une connexion à la base)
    *               objets (les données à modifier)                
    *   Retour :    Rien
    */
    public  int  executerRequeteUpdate(String requete,Connection conn,boolean clretour,Object... objets){
        PreparedStatement etat=null;
        ResultSet rs=null;         
        int cleretour=0;
        try{
            etat=initialisationRequetePreparee( conn, requete,clretour, objets );
            
            int statut =   etat.executeUpdate();
            if (statut==0){
                throw new BDDException("Echec de la mise à jour /création de l'objet");
            }
            if(clretour){
            rs=etat.getGeneratedKeys();
            while(rs.next()){
            cleretour= rs.getInt(1);}
           }
         
        }catch(SQLException sqlex){
            System.out.println(sqlex.getMessage());
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE,null,sqlex);
        }finally{
            fermetureSilencieuse(etat);
        }
        return cleretour;
    }
    /*
    * méthode qui initialise la requête préparée basée sur la connexion en
    * argument avec la requête SQL et les objets donnés
    */
    public static PreparedStatement initialisationRequetePreparee( Connection connexion,
            String sql, boolean returnGenerateKeys, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement( sql, returnGenerateKeys ?
                Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }
    public static void fermetureSilencieuse( ResultSet resultSet ) {
        if ( resultSet != null ) {
            try {
                resultSet.close();
            } catch ( SQLException e ) {
                System.out.println( "Echec de la fermeture du ResultSet : " + e.getMessage() );
            }
        }
    }

    public static void fermetureSilencieuse( Statement statement ) {
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                System.out.println( "Echec de la fermeture du Statement : " + e.getMessage() );
            }
        }
    }

    public static void fermetureSilencieuse( Connection connexion ) {
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException e ) {
                System.out.println( "Echec de la fermeture de la connexion : " + e.getMessage() );
            }
        }
    }

    public static void fermetureSilencieuse( Statement statement, Connection connexion ) {
        fermetureSilencieuse( statement );
        fermetureSilencieuse( connexion );
    }

    public static void fermetureSilencieuse( ResultSet resultSet, Statement statement, Connection connexion ) {
        fermetureSilencieuse( resultSet );
        fermetureSilencieuse( statement );
        fermetureSilencieuse( connexion );
    }
    
}
