start transaction;
insert into personne(nom,prenom)
	values('Dupont','Marc');
select @Id:=id_personne from personne 
	where prenom='Marc';
insert into electeur(id_personne,identifiant,mot_de_passe)
	values(@Id,'mdupont',sha1('essai'));
commit;

start transaction;
insert into personne(nom,prenom)
	values('Dupont','Marie');
insert into electeur(identifiant,mot_de_passe,id_personne)
values('medupont',sha1('essai'),
     select id_personne from personne 
			where prenom='Marie' );
commit;
           