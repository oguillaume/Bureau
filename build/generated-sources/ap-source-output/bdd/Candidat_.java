package bdd;

import bdd.Election;
import bdd.Personne;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-17T14:07:54")
@StaticMetamodel(Candidat.class)
public class Candidat_ { 

    public static volatile SingularAttribute<Candidat, Integer> idCandidat;
    public static volatile SingularAttribute<Candidat, Integer> idpersonne;
    public static volatile SingularAttribute<Candidat, Personne> personne;
    public static volatile SingularAttribute<Candidat, String> photo;
    public static volatile SingularAttribute<Candidat, Election> idElection;
    public static volatile SingularAttribute<Candidat, String> programme;

}