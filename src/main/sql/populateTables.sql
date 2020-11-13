DELETE FROM tache;
DELETE FROM eleve;
DELETE FROM identifiant;

INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (1,'Desclodures','Eliott',4,'ITI');
INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (2,'Fauchet','Corentin',4,'ITI');
INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (3,'De Foresta','Martin',4,'ITI');
INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (4,'Paturel','Ronan',4,'ITI');

INSERT INTO `identifiant`(`nomUtil`,`Mdp`,`Admin`) VALUES ('Ronan' , 'Paturel', true);
INSERT INTO `identifiant`(`nomUtil`,`Mdp`,`Admin`) VALUES ('Eliott' , 'Desclodures', false);

