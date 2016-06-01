package services;

import bdd.BDDException;
import bdd.Base;
import static bdd.Base.fermetureSilencieuse;
import bdd.BureauDeVote;
import bdd.Electeur;
import bdd.ElecteurPK;
import bdd.Election;
import bdd.Personne;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Formatter;
import java.util.List;

/**
 *
 * @author Olivier Guillaume
 */
public class ElecteurService implements IElecteurService { 
    private final Base base = new Base();
 
    @Override
    public List<Electeur> findAll(Connection conn) {
        String requete_select_elec1="SELECT * FROM Electeur";
        List<Electeur> listeElecteur = new ArrayList<Electeur>();
        Electeur electeur = null; 
        ElecteurPK cleElecteur = null;
        Personne persElecteur=null;
        PersonneService servicePersonne = null; 
        BureauDeVote bureau = null;
        ResultSet resultat=null;   
        try{
        resultat=base.executerRequeteQuery(requete_select_elec1, conn);
        while (resultat.next()){ 
            electeur=new Electeur();
            cleElecteur=new ElecteurPK();
            servicePersonne =new PersonneService();
            bureau= new BureauDeVote();
            cleElecteur.setIdElecteur(resultat.getInt("id_electeur"));
            cleElecteur.setIdpersonne(resultat.getInt("idpersonne"));
            electeur.setElecteurPK(cleElecteur);            
            persElecteur=servicePersonne.chargerPersonne(conn, cleElecteur.getIdpersonne());
            electeur.setPersonne(persElecteur);
            electeur.setIdElecteur(cleElecteur.getIdElecteur());
            electeur.setIdentifiant(resultat.getString("identifiant"));
            electeur.setMotDePasse(resultat.getString("mot_de_passe"));
            electeur.setDatedenaissance(resultat.getDate("datedenaissance"));
            bureau.setNumBureau(resultat.getInt("num_bureau"));
            electeur.setNumBureau(bureau);
            listeElecteur.add(electeur);
        }
        }catch(SQLException sqlex){
            throw new BDDException(sqlex);
        }finally{
            fermetureSilencieuse(resultat);
        }
    return listeElecteur;
    }

    @Override
    public void creerElecteur(Connection conn, String nom,String prenom, String adresse, String motDePasse
            ,Integer numBureau,String identifiant,Date date) { 
        String requete_insert_elec1="INSERT INTO Personne(nom,prenom,adresse)"+
            " VALUES(?,?,?)";
        String requete_insert_elec2 = "INSERT INTO Electeur(mot_de_passe"
                + ",identifiant,datedenaissance,num_bureau,idpersonne) VALUES(?,?,?,?,?)";
        int idPersonne=base.executerRequeteUpdate(requete_insert_elec1, conn,true,nom,prenom,adresse);
        String pass_hache=encryptPassword(motDePasse); 
        //String pass_hache=Codage.encryptPassword(motDePasse,"SHA-1");
        base.executerRequeteUpdate(requete_insert_elec2,conn,false,pass_hache,identifiant,date,numBureau,idPersonne);  
    }

    @Override
    public void retirerElecteur(Connection conn, int idElecteur) {
        String requete_retirer_electeur1="DELETE FROM Electeur WHERE id_electeur=?";
        String requete_retirer_electeur2="DELETE FROM Personne WHERE idpersonne=?";
        int idPersonne =base.executerRequeteUpdate(requete_retirer_electeur1, conn, true, idElecteur);
        base.executerRequeteUpdate(requete_retirer_electeur2, conn, false, idPersonne);   
    }

    @Override
    public Electeur chargerElecteur(Connection conn, String nom, String prenom, String adresse) {
        Electeur electeur = new Electeur();
        Personne persElecteur = new Personne();
        BureauDeVote bureau = new BureauDeVote();
        String requete_electeur="SELECT * FROM electeur AS e, personne AS p where " +
                "e.idpersonne=p.idpersonne AND "+
            "p.nom=? and p.prenom=? and p.adresse=?";
        try{
            ResultSet resultat=base.executerRequeteQuery(requete_electeur, conn,nom,prenom,adresse);
            while(resultat.next()){
            persElecteur.setNom(nom);
            persElecteur.setPrenom(prenom);
            persElecteur.setAdresse(adresse);
            electeur.setMotDePasse(resultat.getString("mot_de_passe"));
            electeur.setPersonne(persElecteur);
            bureau.setNumBureau(resultat.getInt("num_bureau"));
            electeur.setDatedenaissance(resultat.getDate("datedenaissance"));
            electeur.setNumBureau(bureau);
            }
        }catch(SQLException sqlex){
            throw new BDDException(sqlex);
        }
        return electeur;
    }
    @Override
    public void inscrireElecteurElection(Connection conn, Electeur electeur, Election election) {
        String requete_votepour="INSERT INTO VotePour(idpersonne,id_election,signatures) VALUES(?,?,FALSE)";   
        base.executerRequeteUpdate(requete_votepour, conn, false, electeur.getIdpersonne(),election.getIdElection());
    }
    /* fonction pour charger une liste d'un fichier CSV */
    public void chargerListe( String file, Connection conn ) {
        /* syntaxe mysql à adapter */
        String sqlinfile = "LOAD DATA LOCAL INFILE '" + file + "' REPLACE INTO TABLE personne";
        sqlinfile += "FIELDS TERMINATED BY ';'  LINES TERMINATED BY '\n'";
        sqlinfile += "(nom,prenom,date_naissance)";
        /* syntaxe PostGresSql */
        String copyfile="COPY myTable FROM '/path/to/file/on/server' ( FORMAT CSV, DELIMITER('|') )"; 
        base.executerRequeteUpdate(sqlinfile, conn,false,null); 
    }
    private static String encryptPassword(String password) //cryptage du mot de passe
    {
        String sha1 = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        }catch(NoSuchAlgorithmException | UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return sha1;
    }
    private static String byteToHex(final byte[] hash) // conversion octet-hexa
    {
        Formatter formatter = new Formatter();
        for (byte b : hash){
        formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
    //identifiant
    public String creerIdentifiant(String nom,String prenom,String date){
        //date au format jj/mm/aaaa
        String annee = date.split("/")[2].substring(2,4);
        return (prenom.substring(0, 1)+nom+annee).toLowerCase();
    }
    // mot de passe aléatoire
    public String creerMotDePasse(Integer nb_car){
        String mot_de_passe="";
        Character car=null;
        for(Integer i=0;i<nb_car;i++){
            car=choixCaractere();
            while (car==null){
                car=choixCaractere();
            }
            mot_de_passe+=car;
        }
        return mot_de_passe;
    }
    public Character choixCaractere(){ //choix du caractère selon un nombre aléatoire
         Integer c=(int)Math.floor(Math.random()*122);
         Character car=null;
         switch (c){
             // les chiffres
                 case 48: car='0'; break;
                 case 49: car='1';break;
                 case 50: car='2';break;  
                 case 51: car='3';break; 
                 case 52: car='4';break; 
                 case 53: car='5';break; 
                 case 54: car='6';break;  
                 case 55: car='7';break;  
                 case 56: car='8';break;  
                 case 57: car='9';break; 
             // les lettres capitales    
                 case 65: car='A';break;
                 case 66: car='B';break;
                 case 67: car='C';break;
                 case 68: car='D';break;
                 case 69: car='E';break;
                 case 70: car='F';break;
                 case 71: car='G';break;                    
                 case 72: car='H';break;
                 case 73: car='I';break;
                 case 74: car='J';break;
                 case 75: car='K';break;
                 case 76: car='L';break;
                 case 77: car='M';break;
                 case 78: car='N';break;
                 case 79: car='O';break;
                 case 80: car='P';break;
                 case 81: car='Q';break;
                 case 82: car='R';break;
                 case 83: car='S';break;
                 case 84: car='T';break;
                 case 85: car='U';break;
                 case 86: car='V';break;
                 case 87: car='W';break;
                 case 88: car='X';break;
                 case 89: car='Y';break;
                 case 90: car='Z';break;
                 // lettres minuscules
                 case 97: car='a';break;
                 case 98: car='b';break;
                 case 99: car='c';break;
                 case 100: car='d';break;
                 case 101: car='e';break;
                 case 102: car='f';break;
                 case 103: car='g';break;
                 case 104: car='h';break;
                 case 105: car='i';break;
                 case 106: car='j';break;
                 case 107: car='k';break;
                 case 108: car='l';break;
                 case 109: car='m';break;
                 case 110: car='n';break;
                 case 111: car='o';break;
                 case 112: car='p';break;
                 case 113: car='q';break;
                 case 114: car='r';break;
                 case 115: car='s';break;
                 case 116: car='t';break;
                 case 117: car='u';break;
                 case 118: car='v';break;
                 case 119: car='w';break;
                 case 120: car='x';break;
                 case 121: car='y';break;
                 case 122: car='z';break;               
         }       
         return car;            
    }
    
    @Override
    public void modifierElecteur(Connection conn, int id, String nom, String prenom, String adresse, 
        int numbureau, String identifiant, Date date) {
        String requete_modifier_personne="UPDATE Personne SET nom=?,prenom=?,adresse=? "
                +"WHERE idpersonne in(SELECT idpersonne FROM Electeur WHERE id_electeur=?)";
        String requete_modifier_electeur="UPDATE Electeur SET "
                + "identifiant=?,datedenaissance=?,num_bureau=?"+
                " WHERE id_electeur=?";
        base.executerRequeteUpdate(requete_modifier_personne, conn, false, 
                nom,prenom,adresse,id);
        base.executerRequeteUpdate(requete_modifier_electeur, conn, false, 
                identifiant,date,numbureau,id);
    }   
}
