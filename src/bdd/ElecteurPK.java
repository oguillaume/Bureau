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
public class ElecteurPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_electeur")
    private int idElecteur;
    @Basic(optional = false)
    @Column(name = "idpersonne")
    private int idpersonne;

    public ElecteurPK() {
    }

    public ElecteurPK(int idElecteur, int idpersonne) {
        this.idElecteur = idElecteur;
        this.idpersonne = idpersonne;
    }

    public int getIdElecteur() {
        return idElecteur;
    }

    public void setIdElecteur(int idElecteur) {
        this.idElecteur = idElecteur;
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
        hash += (int) idElecteur;
        hash += (int) idpersonne;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElecteurPK)) {
            return false;
        }
        ElecteurPK other = (ElecteurPK) object;
        if (this.idElecteur != other.idElecteur) {
            return false;
        }
        if (this.idpersonne != other.idpersonne) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.ElecteurPK[ idElecteur=" + idElecteur + ", idpersonne=" + idpersonne + " ]";
    }
    
}
