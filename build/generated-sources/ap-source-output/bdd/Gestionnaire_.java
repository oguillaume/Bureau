package bdd;

import bdd.GestionnairePK;
import bdd.Personne;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-17T14:07:54")
@StaticMetamodel(Gestionnaire.class)
public class Gestionnaire_ { 

    public static volatile SingularAttribute<Gestionnaire, GestionnairePK> gestionnairePK;
    public static volatile SingularAttribute<Gestionnaire, Personne> personne;
    public static volatile SingularAttribute<Gestionnaire, String> identifiant;
    public static volatile SingularAttribute<Gestionnaire, String> passeadmin;

}