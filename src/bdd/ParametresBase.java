/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author HP-G61
 */
public class ParametresBase {

    private static final String fichier = "src/proprietes/base-elec.properties";
    private String ip;
    private String base;
    private String port;
    private String driver;
    private String utilisateur;
    private String gestio;
    private String mot_passe;

    static org.jdom2.Document document;
    static Element racine;

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
        this.gestio = gestio;
    }

    public void chargerParametres() throws FileNotFoundException {
        Properties prop = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream(fichier);
            prop.load(in);
            this.ip = prop.getProperty("ip");
            this.base = prop.getProperty("base");
            this.driver = prop.getProperty("driver");
            this.gestio = prop.getProperty("gestionnaire");
            this.utilisateur = prop.getProperty("utilisateur");
            this.mot_passe = prop.getProperty("password");
            this.port = prop.getProperty("port");
            in.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Le fichier de configuration est introuvable !Veuillez le vérifier.","Erreur",JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(ParametresBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParametresBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void chargerParametres(String files, String type) {
        Properties prop = new Properties();
        FileInputStream in;
        if (type.equals(".properties")) {
            try {
                in = new FileInputStream(files);
                prop.load(in);
                this.ip = prop.getProperty("ip");
                this.base = prop.getProperty("base");
                this.driver = prop.getProperty("driver");
                this.gestio = prop.getProperty("gestionnaire");
                this.utilisateur = prop.getProperty("utilisateur");
                this.mot_passe = prop.getProperty("password");
                this.port = prop.getProperty("port");
                in.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ParametresBase.class.getName()).log(Level.SEVERE, "Le fichier est absent", ex);
            } catch (IOException ex) {
                Logger.getLogger(ParametresBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (type.equals(".xml")) {

            SAXBuilder sax = new SAXBuilder();
            try {
                /* on cree un fichier JDOM ayant pour argument le fichier XML*/
                document = sax.build(new File(files));

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Le fichier de configuration est introuvable !Veuillez le vérifier.","Erreur",JOptionPane.WARNING_MESSAGE);
                 Logger.getLogger(ParametresBase.class.getName()).log(Level.SEVERE, "Le fichier est absent", ex);
            } catch (JDOMException | IOException ex) {
                Logger.getLogger(ParametresBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            /* initialisation de l'élément racine*/
            racine = document.getRootElement();
            this.ip = racine.getChild("ip").getText();
            this.base = racine.getChildText("base");
            this.driver = racine.getChildText("driver");
            this.gestio = racine.getChildText("gestionnaire");
            this.mot_passe = racine.getChildText("password");
            this.port=racine.getChildText("port");
            this.utilisateur=racine.getChildText("utilisateur");

        }

    }

    public void ecrireParametres() {
        Properties prop = new Properties();
        OutputStream out = null;
        try {
            out = new FileOutputStream(fichier);
            prop.setProperty("ip", ip);
            prop.setProperty("base", base);
            prop.setProperty("driver", driver);
            prop.setProperty("gestio", gestio);
            prop.getProperty("utilisateur", utilisateur);
            prop.getProperty("password", mot_passe);
            prop.getProperty("port", port);
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException io) {
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
