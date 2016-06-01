/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bureau_de_vote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BureauVote.findAll", query = "SELECT b FROM BureauDeVote b"),
    @NamedQuery(name = "BureauVote.findByNumBureau", query = "SELECT b FROM BureauDeVote b WHERE b.numBureau = :numBureau"),
    @NamedQuery(name = "BureauVote.findByVille", query = "SELECT b FROM BureauDeVote b WHERE b.ville = :ville")})
public class BureauDeVote implements Serializable {
    @JoinColumn(name = "id_election", referencedColumnName = "id_election")
    @ManyToOne
    private Election idElection;
    @Column(name = "libelle")
    private String libelle;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_bureau")
    private Integer numBureau;
    @Column(name = "ville")
    private String ville;
    @OneToMany(mappedBy = "numBureau")
    private Collection<Election> electionCollection;
    @OneToMany(mappedBy = "numBureau")
    private Collection<Electeur> electeurCollection;

    public BureauDeVote() {
    }

    public BureauDeVote(Integer numBureau) {
        this.numBureau = numBureau;
    }

    public Integer getNumBureau() {
        return numBureau;
    }

    public void setNumBureau(Integer numBureau) {
        this.numBureau = numBureau;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @XmlTransient
    public Collection<Election> getElectionCollection() {
        return electionCollection;
    }

    public void setElectionCollection(Collection<Election> electionCollection) {
        this.electionCollection = electionCollection;
    }

    @XmlTransient
    public Collection<Electeur> getElecteurCollection() {
        return electeurCollection;
    }

    public void setElecteurCollection(Collection<Electeur> electeurCollection) {
        this.electeurCollection = electeurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numBureau != null ? numBureau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BureauDeVote)) {
            return false;
        }
        BureauDeVote other = (BureauDeVote) object;
        if ((this.numBureau == null && other.numBureau != null) || (this.numBureau != null && !this.numBureau.equals(other.numBureau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.BureauVote[ numBureau=" + numBureau + " ]";
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Election getIdElection() {
        return idElection;
    }

    public void setIdElection(Election idElection) {
        this.idElection = idElection;
    }
    
}
