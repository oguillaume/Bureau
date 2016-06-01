/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP-G61
 */
public class ParametresBase {
    private static final String fichier = "src/proprietes/base-ovh.properties";
    private String ip;   
    private String base;   
    private String port;  
    private String driver;   
    private String utilisateur;
    private String gestio;
    private String mot_passe;

    public ParametresBase() {
    }

    public ParametresBase(String ip, String gestio, String base, String port, 
            String driver, String utilisateur, String mot_passe) {
        this.ip = ip;
        this.base = base;
        this.port = port;
        this.driver = driver;
        this.utilisateur = utilisateur;
        this.mot_passe = mot_passe;
        this.gestio=gestio;
    }
    
    public void chargerParametres() throws FileNotFoundException{
        Properties prop = new Properties();
        FileInputStream in;
        try{
            in = new FileInputStream(fichier);
            prop.load(in);
            this.ip=prop.getProperty("ip");
            this.base=prop.getProperty("base");
            this.driver=prop.getProperty("driver");
            this.gestio=prop.getProperty("gestionnaire");
            this.utilisateur=prop.getProperty("utilisateur");
            this.mot_passe=prop.getProperty("password");
            this.port=prop.getProperty("port");
            in.close();
        }catch(FileNotFoundException ex){
            Logger.getLogger(ParametresBase.class.getName()).log(Level.SEVERE,null,ex);
        }catch(IOException ex){
            Logger.getLogger(ParametresBase.class.getName()).log(Level.SEVERE,null,ex);
        }
             
    }
     public void ecrireParametres(){
         Properties prop = new Properties();
         OutputStream out = null;
         try{
             out=new FileOutputStream(fichier);
            prop.setProperty("ip",ip);
            prop.setProperty("base",base);
            prop.setProperty("driver",driver);
            prop.setProperty("gestio",gestio);
            prop.getProperty("utilisateur",utilisateur);
            prop.getProperty("password",mot_passe);
            prop.getProperty("port",port);
         }catch(IOException ioex){
             ioex.printStackTrace();
         }finally{
             if(out!=null){
                 try{
                     out.close();
                 }catch(IOException io){
                     io.printStackTrace();
 
                 }
             }
         }
     }
     public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getGestio() {
        return gestio;
    }

    public void setGestio(String gestio) {
        this.gestio = gestio;
    }

    public String getMot_passe() {
        return mot_passe;
    }

    public void setMot_passe(String mot_passe) {
        this.mot_passe = mot_passe;
    }

   


}
