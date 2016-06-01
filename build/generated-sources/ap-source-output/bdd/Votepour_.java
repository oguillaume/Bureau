package bdd;

import bdd.Election;
import bdd.Personne;
import bdd.VotepourPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-28T20:09:39")
@StaticMetamodel(Votepour.class)
public class Votepour_ { 

    public static volatile SingularAttribute<Votepour, Election> election;
    public static volatile SingularAttribute<Votepour, VotepourPK> votepourPK;
    public static volatile SingularAttribute<Votepour, Personne> personne;
    public static volatile SingularAttribute<Votepour, Boolean> signatures;
    public static volatile SingularAttribute<Votepour, Personne> personne1;

}