DELETE FROM tache;
DELETE FROM eleve;
DELETE FROM identifiant;

INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (1,'Desclodures','Eliott',4,'ITI');
INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (2,'Fauchet','Corentin',4,'ITI');
INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (3,'De Foresta','Martin',4,'ITI');
INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (4,'Paturel','Ronan',4,'ITI');

INSERT INTO `identifiant`(`nomUtil`,`Mdp`,`Admin`) VALUES ('Ronan' , 'Paturel', true);
INSERT INTO `identifiant`(`nomUtil`,`Mdp`,`Admin`) VALUES ('Eliott' , 'Desclodures', false);

INSERT INTO `TEA`(`tea_id`,`title`,`release_date`,`eleve_id`,`duration`) VALUES (1,'Forum HEI' ,'2019-10-10' ,2,120);
INSERT INTO `TEA`(`tea_id`,`title`,`release_date`,`eleve_id`,`duration`) VALUES (2,'Salon Marseille' ,'2020-10-12' ,3,240);
INSERT INTO `TEA`(`tea_id`,`title`,`release_date`,`eleve_id`,`duration`) VALUES (3,'Aide une asso avec un moyen de locomotion' ,'2020-10-06',1,75);

