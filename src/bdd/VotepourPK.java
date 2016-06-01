/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author adm
 */
@Embeddable
public class VotepourPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idpersonne")
    private int idpersonne;
    @Basic(optional = false)
    @Column(name = "id_election")
    private int idElection;
    @Basic(optional = false)
    @Column(name = "idpersonne_1")
    private int idpersonne1;

    public VotepourPK() {
    }

    public VotepourPK(int idpersonne, int idElection, int idpersonne1) {
        this.idpersonne = idpersonne;
        this.idElection = idElection;
        this.idpersonne1 = idpersonne1;
    }

    public int getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(int idpersonne) {
        this.idpersonne = idpersonne;
    }

    public int getIdElection() {
        return idElection;
    }

    public void setIdElection(int idElection) {
        this.idElection = idElection;
    }

    public int getIdpersonne1() {
        return idpersonne1;
    }

    public void setIdpersonne1(int idpersonne1) {
        this.idpersonne1 = idpersonne1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpersonne;
        hash += (int) idElection;
        hash += (int) idpersonne1;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VotepourPK)) {
            return false;
        }
        VotepourPK other = (VotepourPK) object;
        if (this.idpersonne != other.idpersonne) {
            return false;
        }
        if (this.idElection != other.idElection) {
            return false;
        }
        if (this.idpersonne1 != other.idpersonne1) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.VotepourPK[ idpersonne=" + idpersonne + ", idElection=" + idElection + ", idpersonne1=" + idpersonne1 + " ]";
    }
    
}
