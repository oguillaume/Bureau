/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "gestionnaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestionnaire.findAll", query = "SELECT g FROM Gestionnaire g"),
    @NamedQuery(name = "Gestionnaire.findByIdGestionnaire", query = "SELECT g FROM Gestionnaire g WHERE g.gestionnairePK.idGestionnaire = :idGestionnaire"),
    @NamedQuery(name = "Gestionnaire.findByPasseadmin", query = "SELECT g FROM Gestionnaire g WHERE g.passeadmin = :passeadmin"),
    @NamedQuery(name = "Gestionnaire.findByIdentifiant", query = "SELECT g FROM Gestionnaire g WHERE g.identifiant = :identifiant"),
    @NamedQuery(name = "Gestionnaire.findByIdpersonne", query = "SELECT g FROM Gestionnaire g WHERE g.gestionnairePK.idpersonne = :idpersonne")})
public class Gestionnaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GestionnairePK gestionnairePK;
    @Column(name = "passeadmin")
    private String passeadmin;
    @Column(name = "identifiant")
    private String identifiant;
    @JoinColumn(name = "idpersonne", referencedColumnName = "idpersonne", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personne personne;

    public Gestionnaire() {
    }

    public Gestionnaire(GestionnairePK gestionnairePK) {
        this.gestionnairePK = gestionnairePK;
    }

    public Gestionnaire(int idGestionnaire, int idpersonne) {
        this.gestionnairePK = new GestionnairePK(idGestionnaire, idpersonne);
    }

    public GestionnairePK getGestionnairePK() {
        return gestionnairePK;
    }

    public void setGestionnairePK(GestionnairePK gestionnairePK) {
        this.gestionnairePK = gestionnairePK;
    }

    public String getPasseadmin() {
        return passeadmin;
    }

    public void setPasseadmin(String passeadmin) {
        this.passeadmin = passeadmin;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gestionnairePK != null ? gestionnairePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestionnaire)) {
            return false;
        }
        Gestionnaire other = (Gestionnaire) object;
        if ((this.gestionnairePK == null && other.gestionnairePK != null) || (this.gestionnairePK != null && !this.gestionnairePK.equals(other.gestionnairePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.Gestionnaire[ gestionnairePK=" + gestionnairePK + " ]";
    }
    
}
