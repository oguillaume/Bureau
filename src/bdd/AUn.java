/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
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
@Table(name = "a_un")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AUn.findAll", query = "SELECT a FROM AUn a"),
    @NamedQuery(name = "AUn.findByIdresultat", query = "SELECT a FROM AUn a WHERE a.aUnPK.idresultat = :idresultat"),
    @NamedQuery(name = "AUn.findByIdpersonne", query = "SELECT a FROM AUn a WHERE a.aUnPK.idpersonne = :idpersonne"),
    @NamedQuery(name = "AUn.findByIdElection", query = "SELECT a FROM AUn a WHERE a.aUnPK.idElection = :idElection")})
public class AUn implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AUnPK aUnPK;
    @JoinColumn(name = "id_election", referencedColumnName = "id_election", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Election election;
    @JoinColumn(name = "idpersonne", referencedColumnName = "idpersonne", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personne personne;
    @JoinColumn(name = "idresultat", referencedColumnName = "idresultat", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resultat resultat;

    public AUn() {
    }

    public AUn(AUnPK aUnPK) {
        this.aUnPK = aUnPK;
    }

    public AUn(int idresultat, int idpersonne, int idElection) {
        this.aUnPK = new AUnPK(idresultat, idpersonne, idElection);
    }

    public AUnPK getAUnPK() {
        return aUnPK;
    }

    public void setAUnPK(AUnPK aUnPK) {
        this.aUnPK = aUnPK;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aUnPK != null ? aUnPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AUn)) {
            return false;
        }
        AUn other = (AUn) object;
        if ((this.aUnPK == null && other.aUnPK != null) || (this.aUnPK != null && !this.aUnPK.equals(other.aUnPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.AUn[ aUnPK=" + aUnPK + " ]";
    }
    
}
