/*copier une table ordonnée vers un fichier*/

COPY (SELECT * FROM electeur ORDER BY identifiant) TO 'C:/PPE/EssaiCopyTable.txt';

/*copier une table depuis un fichier */

COPY personne FROM 'C:/PPE/ClientLourd/src/fichier/ListeElectoraleEssai.txt';

