package bdd;

import bdd.AUnPK;
import bdd.Election;
import bdd.Personne;
import bdd.Resultat;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-17T14:07:54")
@StaticMetamodel(AUn.class)
public class AUn_ { 

    public static volatile SingularAttribute<AUn, Election> election;
    public static volatile SingularAttribute<AUn, Personne> personne;
    public static volatile SingularAttribute<AUn, AUnPK> aUnPK;
    public static volatile SingularAttribute<AUn, Resultat> resultat;

}