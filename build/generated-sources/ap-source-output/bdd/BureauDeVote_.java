package bdd;

import bdd.Electeur;
import bdd.Election;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-17T14:07:54")
@StaticMetamodel(BureauDeVote.class)
public class BureauDeVote_ { 

    public static volatile SingularAttribute<BureauDeVote, String> ville;
    public static volatile SingularAttribute<BureauDeVote, String> libelle;
    public static volatile CollectionAttribute<BureauDeVote, Election> electionCollection;
    public static volatile SingularAttribute<BureauDeVote, Election> idElection;
    public static volatile SingularAttribute<BureauDeVote, Integer> numBureau;
    public static volatile CollectionAttribute<BureauDeVote, Electeur> electeurCollection;

}