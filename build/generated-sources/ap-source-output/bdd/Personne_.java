package bdd;

import bdd.AUn;
import bdd.Candidat;
import bdd.Electeur;
import bdd.Gestionnaire;
import bdd.Votepour;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-28T20:09:39")
@StaticMetamodel(Personne.class)
public class Personne_ { 

    public static volatile CollectionAttribute<Personne, Votepour> votepourCollection;
    public static volatile CollectionAttribute<Personne, Votepour> votepourCollection1;
    public static volatile SingularAttribute<Personne, Integer> idpersonne;
    public static volatile SingularAttribute<Personne, Gestionnaire> gestionnaire;
    public static volatile CollectionAttribute<Personne, AUn> aUnCollection;
    public static volatile SingularAttribute<Personne, String> adresse;
    public static volatile SingularAttribute<Personne, Electeur> electeur;
    public static volatile SingularAttribute<Personne, Candidat> candidat;
    public static volatile CollectionAttribute<Personne, Gestionnaire> gestionnaireCollection;
    public static volatile SingularAttribute<Personne, String> nom;
    public static volatile SingularAttribute<Personne, String> prenom;
    public static volatile CollectionAttribute<Personne, Electeur> electeurCollection;

}