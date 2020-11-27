DELETE FROM tea;
DELETE FROM eleve;
DELETE FROM identifiant;
DELETE FROM nn;

INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (1,'Desclodures','Eliott',4,'ITI');
INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (2,'Fauchet','Corentin',4,'ITI');
INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (3,'De Foresta','Martin',4,'ITI');
INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (4,'Paturel','Ronan',4,'ITI');

INSERT INTO `identifiant`(`nomUtil`,`Mdp`,`Admin`,`eleve_id`) VALUES ('Ronan' , 'Paturel', true,4);
INSERT INTO `identifiant`(`nomUtil`,`Mdp`,`Admin`,`eleve_id`) VALUES ('Eliott' , 'Desclodures', false,1);

INSERT INTO `tea`(`tea_id`,`title`,`release_date`,`duration`,`valide`) VALUES (1,'Forum HEI' ,'2019-10-10' ,2,true);
INSERT INTO `tea`(`tea_id`,`title`,`release_date`,`duration`,`valide`) VALUES (2,'Salon Marseille' ,'2020-10-12' ,4,false);
INSERT INTO `tea`(`tea_id`,`title`,`release_date`,`duration`,`valide`) VALUES (3,'Aide une asso avec un moyen de locomotion' ,'2020-10-06',3,true);

INSERT INTO `nn`(`tea_id`,`eleve_id`)VALUES (1,1);
INSERT INTO `nn`(`tea_id`,`eleve_id`)VALUES (3,1);
