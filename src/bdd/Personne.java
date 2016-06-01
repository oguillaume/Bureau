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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "personne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findByIdpersonne", query = "SELECT p FROM Personne p WHERE p.idpersonne = :idpersonne"),
    @NamedQuery(name = "Personne.findByNom", query = "SELECT p FROM Personne p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personne.findByPrenom", query = "SELECT p FROM Personne p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Personne.findByAdresse", query = "SELECT p FROM Personne p WHERE p.adresse = :adresse")})
public class Personne implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personne")
    private Collection<Votepour> votepourCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personne1")
    private Collection<Votepour> votepourCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personne")
    private Collection<Gestionnaire> gestionnaireCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personne")
    private Collection<Electeur> electeurCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersonne")
    private Integer idpersonne;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "adresse")
    private String adresse;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personne")
    private Gestionnaire gestionnaire;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personne")
    private Electeur electeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personne")
    private Collection<AUn> aUnCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personne")
    private Candidat candidat;

    public Personne() {
    }

    public Personne(Integer idpersonne) {
        this.idpersonne = idpersonne;
    }

    public Integer getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(Integer idpersonne) {
        this.idpersonne = idpersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaire gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    public Electeur getElecteur() {
        return electeur;
    }

    public void setElecteur(Electeur electeur) {
        this.electeur = electeur;
    }

    @XmlTransient
    public Collection<AUn> getAUnCollection() {
        return aUnCollection;
    }

    public void setAUnCollection(Collection<AUn> aUnCollection) {
        this.aUnCollection = aUnCollection;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersonne != null ? idpersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.idpersonne == null && other.idpersonne != null) || (this.idpersonne != null && !this.idpersonne.equals(other.idpersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.Personne[ idpersonne=" + idpersonne + " ]";
    }

    @XmlTransient
    public Collection<Gestionnaire> getGestionnaireCollection() {
        return gestionnaireCollection;
    }

    public void setGestionnaireCollection(Collection<Gestionnaire> gestionnaireCollection) {
        this.gestionnaireCollection = gestionnaireCollection;
    }

    @XmlTransient
    public Collection<Electeur> getElecteurCollection() {
        return electeurCollection;
    }

    public void setElecteurCollection(Collection<Electeur> electeurCollection) {
        this.electeurCollection = electeurCollection;
    }

    @XmlTransient
    public Collection<Votepour> getVotepourCollection() {
        return votepourCollection;
    }

    public void setVotepourCollection(Collection<Votepour> votepourCollection) {
        this.votepourCollection = votepourCollection;
    }

    @XmlTransient
    public Collection<Votepour> getVotepourCollection1() {
        return votepourCollection1;
    }

    public void setVotepourCollection1(Collection<Votepour> votepourCollection1) {
        this.votepourCollection1 = votepourCollection1;
    }
    
}
