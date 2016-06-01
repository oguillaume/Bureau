/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "candidat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidat.findAll", query = "SELECT c FROM Candidat c"),
    @NamedQuery(name = "Candidat.findByProgramme", query = "SELECT c FROM Candidat c WHERE c.programme = :programme"),
    @NamedQuery(name = "Candidat.findByPhoto", query = "SELECT c FROM Candidat c WHERE c.photo = :photo"),
    @NamedQuery(name = "Candidat.findByIdpersonne", query = "SELECT c FROM Candidat c WHERE c.idpersonne = :idpersonne")})
public class Candidat implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_candidat")
    private int idCandidat;
    private static final long serialVersionUID = 1L;
    @Column(name = "programme")
    private String programme;
    @Column(name = "photo")
    private String photo;
    @Id
    @Basic(optional = false)
    @Column(name = "idpersonne")
    private Integer idpersonne;
    @JoinColumn(name = "id_election", referencedColumnName = "id_election")
    @ManyToOne
    private Election idElection;
    @JoinColumn(name = "idpersonne", referencedColumnName = "idpersonne", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;

    public Candidat() {
    }

    public Candidat(Integer idpersonne) {
        this.idpersonne = idpersonne;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(Integer idpersonne) {
        this.idpersonne = idpersonne;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersonne != null ? idpersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidat)) {
            return false;
        }
        Candidat other = (Candidat) object;
        if ((this.idpersonne == null && other.idpersonne != null) || (this.idpersonne != null && !this.idpersonne.equals(other.idpersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdd.Candidat[ idpersonne=" + idpersonne + " ]";
    }

    public Integer getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(Integer idCandidat) {
        this.idCandidat = idCandidat;
    }

    
    
}
