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
public class AUnPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idresultat")
    private int idresultat;
    @Basic(optional = false)
    @Column(name = "idpersonne")
    private int idpersonne;
    @Basic(optional = false)
    @Column(name = "id_election")
    private int idElection;

    public AUnPK() {
    }

    public AUnPK(int idresultat, int idpersonne, int idElection) {
        this.idresultat = idresultat;
        this.idpersonne = idpersonne;
        this.idElection = idElection;
    }

    public int getIdresultat() {
        return idresultat;
    }

    public void setIdresultat(int idresultat) {
        this.idresultat = idresultat;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idresultat;
        hash += (int) idpersonne;
        hash += (int) idElection;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AUnPK)) {
            return false;
        }
        AUnPK other = (AUnPK) object;
        if (this.idresultat != other.idresultat) {
            return false;
        }
        if (this.idpersonne != other.idpersonne) {
            return false;
        }
        if (this.idElection != other.idElection) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.AUnPK[ idresultat=" + idresultat + ", idpersonne=" + idpersonne + ", idElection=" + idElection + " ]";
    }
    
}
