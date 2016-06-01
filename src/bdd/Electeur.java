/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "electeur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Electeur.findAll", query = "SELECT e FROM Electeur e"),
    @NamedQuery(name = "Electeur.findByIdElecteur", query = "SELECT e FROM Electeur e WHERE e.electeurPK.idElecteur = :idElecteur"),
    @NamedQuery(name = "Electeur.findByIdentifiant", query = "SELECT e FROM Electeur e WHERE e.identifiant = :identifiant"),
    @NamedQuery(name = "Electeur.findByMotDePasse", query = "SELECT e FROM Electeur e WHERE e.motDePasse = :motDePasse"),
    @NamedQuery(name = "Electeur.findByDatedenaissance", query = "SELECT e FROM Electeur e WHERE e.datedenaissance = :datedenaissance"),
    @NamedQuery(name = "Electeur.findByIdpersonne", query = "SELECT e FROM Electeur e WHERE e.electeurPK.idpersonne = :idpersonne"),
    @NamedQuery(name = "Electeur.findBySignatures", query = "SELECT e FROM Electeur e WHERE e.signatures = :signatures")})
public class Electeur implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_electeur")
    private int idElecteur;
    @Id
    @Basic(optional = false)
    @Column(name = "idpersonne")
    private Integer idpersonne;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ElecteurPK electeurPK;
    @Column(name = "identifiant")
    private String identifiant;
    @Column(name = "mot_de_passe")
    private String motDePasse;
    @Column(name = "datedenaissance")
    @Temporal(TemporalType.DATE)
    private Date datedenaissance;
    @Column(name = "signatures")
    private Boolean signatures;
    @JoinColumn(name = "num_bureau", referencedColumnName = "num_bureau")
    @ManyToOne
    private BureauDeVote numBureau;
    @JoinColumn(name = "id_election", referencedColumnName = "id_election")
    @ManyToOne
    private Election idElection;
    @JoinColumn(name = "idpersonne", referencedColumnName = "idpersonne", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personne personne;

    public Electeur() {
    }

    public Electeur(ElecteurPK electeurPK) {
        this.electeurPK = electeurPK;
    }

    public Electeur(int idElecteur, int idpersonne) {
        this.electeurPK = new ElecteurPK(idElecteur, idpersonne);
    }

    public ElecteurPK getElecteurPK() {
        return electeurPK;
    }

    public void setElecteurPK(ElecteurPK electeurPK) {
        this.electeurPK = electeurPK;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Date getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(Date datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public Boolean getSignatures() {
        return signatures;
    }

    public void setSignatures(Boolean signatures) {
        this.signatures = signatures;
    }

    public BureauDeVote getNumBureau() {
        return numBureau;
    }

    public void setNumBureau(BureauDeVote numBureau) {
        this.numBureau = numBureau;
    }

    public Election getIdElection() {
        return idElection;
    }

    public void setIdElection(Election idElection) {
        this.idElection = idElection;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Electeur(Integer idpersonne) {
        this.idpersonne = idpersonne;
    }

    public Electeur(Integer idpersonne, int idElecteur) {
        this.idpersonne = idpersonne;
        this.idElecteur = idElecteur;
    }

    public int getIdElecteur() {
        return idElecteur;
    }

    public void setIdElecteur(int idElecteur) {
        this.idElecteur = idElecteur;
    }

    public Integer getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(Integer idpersonne) {
        this.idpersonne = idpersonne;
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
        if (!(object instanceof Electeur)) {
            return false;
        }
        Electeur other = (Electeur) object;
        if ((this.idpersonne == null && other.idpersonne != null) || (this.idpersonne != null && !this.idpersonne.equals(other.idpersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.Electeur[ idpersonne=" + idpersonne + " ]";
    }
    
}
