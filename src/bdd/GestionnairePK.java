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
public class GestionnairePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_gestionnaire")
    private int idGestionnaire;
    @Basic(optional = false)
    @Column(name = "idpersonne")
    private int idpersonne;

    public GestionnairePK() {
    }

    public GestionnairePK(int idGestionnaire, int idpersonne) {
        this.idGestionnaire = idGestionnaire;
        this.idpersonne = idpersonne;
    }

    public int getIdGestionnaire() {
        return idGestionnaire;
    }

    public void setIdGestionnaire(int idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public int getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(int idpersonne) {
        this.idpersonne = idpersonne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idGestionnaire;
        hash += (int) idpersonne;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestionnairePK)) {
            return false;
        }
        GestionnairePK other = (GestionnairePK) object;
        if (this.idGestionnaire != other.idGestionnaire) {
            return false;
        }
        if (this.idpersonne != other.idpersonne) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.GestionnairePK[ idGestionnaire=" + idGestionnaire + ", idpersonne=" + idpersonne + " ]";
    }
    
}
