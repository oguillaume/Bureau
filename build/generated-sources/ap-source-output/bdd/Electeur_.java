package bdd;

import bdd.BureauDeVote;
import bdd.ElecteurPK;
import bdd.Election;
import bdd.Personne;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-28T20:09:39")
@StaticMetamodel(Electeur.class)
public class Electeur_ { 

    public static volatile SingularAttribute<Electeur, Integer> idElecteur;
    public static volatile SingularAttribute<Electeur, String> motDePasse;
    public static volatile SingularAttribute<Electeur, Integer> idpersonne;
    public static volatile SingularAttribute<Electeur, Personne> personne;
    public static volatile SingularAttribute<Electeur, String> identifiant;
    public static volatile SingularAttribute<Electeur, Election> idElection;
    public static volatile SingularAttribute<Electeur, Date> datedenaissance;
    public static volatile SingularAttribute<Electeur, ElecteurPK> electeurPK;
    public static volatile SingularAttribute<Electeur, Boolean> signatures;
    public static volatile SingularAttribute<Electeur, BureauDeVote> numBureau;

}