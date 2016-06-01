package bdd;

import bdd.AUn;
import bdd.BureauDeVote;
import bdd.Candidat;
import bdd.Electeur;
import bdd.Votepour;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-28T20:09:39")
@StaticMetamodel(Election.class)
public class Election_ { 

    public static volatile CollectionAttribute<Election, Votepour> votepourCollection;
    public static volatile CollectionAttribute<Election, AUn> aUnCollection;
    public static volatile CollectionAttribute<Election, Candidat> candidatCollection;
    public static volatile SingularAttribute<Election, Integer> idElection;
    public static volatile SingularAttribute<Election, String> type;
    public static volatile SingularAttribute<Election, String> nom;
    public static volatile SingularAttribute<Election, BureauDeVote> numBureau;
    public static volatile CollectionAttribute<Election, Electeur> electeurCollection;
    public static volatile CollectionAttribute<Election, BureauDeVote> bureauVoteCollection;
    public static volatile SingularAttribute<Election, Date> dateElection;

}