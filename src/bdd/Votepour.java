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
@Table(name = "votepour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Votepour.findAll", query = "SELECT v FROM Votepour v"),
    @NamedQuery(name = "Votepour.findBySignatures", query = "SELECT v FROM Votepour v WHERE v.signatures = :signatures"),
    @NamedQuery(name = "Votepour.findByIdpersonne", query = "SELECT v FROM Votepour v WHERE v.votepourPK.idpersonne = :idpersonne"),
    @NamedQuery(name = "Votepour.findByIdElection", query = "SELECT v FROM Votepour v WHERE v.votepourPK.idElection = :idElection"),
    @NamedQuery(name = "Votepour.findByIdpersonne1", query = "SELECT v FROM Votepour v WHERE v.votepourPK.idpersonne1 = :idpersonne1")})
public class Votepour implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VotepourPK votepourPK;
    @Column(name = "signatures")
    private Boolean signatures;
    @JoinColumn(name = "id_election", referencedColumnName = "id_election", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Election election;
    @JoinColumn(name = "idpersonne", referencedColumnName = "idpersonne", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personne personne;
    @JoinColumn(name = "idpersonne_1", referencedColumnName = "idpersonne", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personne personne1;

    public Votepour() {
    }

    public Votepour(VotepourPK votepourPK) {
        this.votepourPK = votepourPK;
    }

    public Votepour(int idpersonne, int idElection, int idpersonne1) {
        this.votepourPK = new VotepourPK(idpersonne, idElection, idpersonne1);
    }

    public VotepourPK getVotepourPK() {
        return votepourPK;
    }

    public void setVotepourPK(VotepourPK votepourPK) {
        this.votepourPK = votepourPK;
    }

    public Boolean getSignatures() {
        return signatures;
    }

    public void setSignatures(Boolean signatures) {
        this.signatures = signatures;
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

    public Personne getPersonne1() {
        return personne1;
    }

    public void setPersonne1(Personne personne1) {
        this.personne1 = personne1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (votepourPK != null ? votepourPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Votepour)) {
            return false;
        }
        Votepour other = (Votepour) object;
        if ((this.votepourPK == null && other.votepourPK != null) || (this.votepourPK != null && !this.votepourPK.equals(other.votepourPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.Votepour[ votepourPK=" + votepourPK + " ]";
    }
    
}
