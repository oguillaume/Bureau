/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "resultat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultat.findAll", query = "SELECT r FROM Resultat r"),
    @NamedQuery(name = "Resultat.findByIdresultat", query = "SELECT r FROM Resultat r WHERE r.idresultat = :idresultat"),
    @NamedQuery(name = "Resultat.findByNbvoix", query = "SELECT r FROM Resultat r WHERE r.nbvoix = :nbvoix")})
public class Resultat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresultat")
    private Integer idresultat;
    @Column(name = "nbvoix")
    private Integer nbvoix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resultat")
    private Collection<AUn> aUnCollection;

    public Resultat() {
    }

    public Resultat(Integer idresultat) {
        this.idresultat = idresultat;
    }

    public Integer getIdresultat() {
        return idresultat;
    }

    public void setIdresultat(Integer idresultat) {
        this.idresultat = idresultat;
    }

    public Integer getNbvoix() {
        return nbvoix;
    }

    public void setNbvoix(Integer nbvoix) {
        this.nbvoix = nbvoix;
    }

    @XmlTransient
    public Collection<AUn> getAUnCollection() {
        return aUnCollection;
    }

    public void setAUnCollection(Collection<AUn> aUnCollection) {
        this.aUnCollection = aUnCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultat != null ? idresultat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultat)) {
            return false;
        }
        Resultat other = (Resultat) object;
        if ((this.idresultat == null && other.idresultat != null) || (this.idresultat != null && !this.idresultat.equals(other.idresultat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.Resultat[ idresultat=" + idresultat + " ]";
    }
    
}
