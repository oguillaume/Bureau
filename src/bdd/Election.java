/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "election")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Election.findAll", query = "SELECT e FROM Election e"),
    @NamedQuery(name = "Election.findByIdElection", query = "SELECT e FROM Election e WHERE e.idElection = :idElection"),
    @NamedQuery(name = "Election.findByNom", query = "SELECT e FROM Election e WHERE e.nom = :nom"),
    @NamedQuery(name = "Election.findByType", query = "SELECT e FROM Election e WHERE e.type = :type"),
    @NamedQuery(name = "Election.findByDateElection", query = "SELECT e FROM Election e WHERE e.dateElection = :dateElection")})
public class Election implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "a_lieu_dans", joinColumns = {
        @JoinColumn(name = "id_election", referencedColumnName = "id_election")}, inverseJoinColumns = {
        @JoinColumn(name = "num_bureau", referencedColumnName = "num_bureau")})
    
    private Collection<BureauDeVote> bureauVoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "election")
    private Collection<Votepour> votepourCollection;
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_election")
    private Integer idElection;
    @Column(name = "nom")
    private String nom;
    @Column(name = "type")
    private String type;
    @Column(name = "date_election")
    @Temporal(TemporalType.DATE)
    private Date dateElection;
    @JoinColumn(name = "num_bureau", referencedColumnName = "num_bureau")
    @ManyToOne
    private BureauDeVote numBureau;
    @OneToMany(mappedBy = "idElection")
    private Collection<Electeur> electeurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "election")
    private Collection<AUn> aUnCollection;
    @OneToMany(mappedBy = "idElection")
    private Collection<Candidat> candidatCollection;

    public Election() {
    }

    public Election(Integer idElection) {
        this.idElection = idElection;
    }

    public Integer getIdElection() {
        return idElection;
    }

    public void setIdElection(Integer idElection) {
        Integer oldIdElection = this.idElection;
        this.idElection = idElection;
        changeSupport.firePropertyChange("idElection", oldIdElection, idElection);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        changeSupport.firePropertyChange("nom", oldNom, nom);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    public Date getDateElection() {
        return dateElection;
    }

    public void setDateElection(Date dateElection) {
        Date oldDateElection = this.dateElection;
        this.dateElection = dateElection;
        changeSupport.firePropertyChange("dateElection", oldDateElection, dateElection);
    }

    public BureauDeVote getNumBureau() {
        return numBureau;
    }

    public void setNumBureau(BureauDeVote numBureau) {
        BureauDeVote oldNumBureau = this.numBureau;
        this.numBureau = numBureau;
        changeSupport.firePropertyChange("numBureau", oldNumBureau, numBureau);
    }

    @XmlTransient
    public Collection<Electeur> getElecteurCollection() {
        return electeurCollection;
    }

    public void setElecteurCollection(Collection<Electeur> electeurCollection) {
        this.electeurCollection = electeurCollection;
    }

    @XmlTransient
    public Collection<AUn> getAUnCollection() {
        return aUnCollection;
    }

    public void setAUnCollection(Collection<AUn> aUnCollection) {
        this.aUnCollection = aUnCollection;
    }

    @XmlTransient
    public Collection<Candidat> getCandidatCollection() {
        return candidatCollection;
    }

    public void setCandidatCollection(Collection<Candidat> candidatCollection) {
        this.candidatCollection = candidatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idElection != null ? idElection.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Election)) {
            return false;
        }
        Election other = (Election) object;
        if ((this.idElection == null && other.idElection != null) || (this.idElection != null && !this.idElection.equals(other.idElection))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.Election[ idElection=" + idElection + " ]";
    }

    @XmlTransient
    public Collection<BureauDeVote> getBureauVoteCollection() {
        return bureauVoteCollection;
    }

    public void setBureauVoteCollection(Collection<BureauDeVote> bureauVoteCollection) {
        this.bureauVoteCollection = bureauVoteCollection;
    }

   

    @XmlTransient
    public Collection<Votepour> getVotepourCollection() {
        return votepourCollection;
    }

    public void setVotepourCollection(Collection<Votepour> votepourCollection) {
        this.votepourCollection = votepourCollection;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
