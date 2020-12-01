DELETE FROM nn;
DELETE FROM tea;
DELETE FROM identifiant;
DELETE FROM eleve;

INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (1,'Desclodures','Eliott',4,'ITI');
INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (2,'Fauchet','Corentin',4,'ITI');
INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (3,'De Foresta','Martin',4,'ITI');
INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (4,'Paturel','Ronan',4,'ITI');

INSERT INTO `identifiant`(`nomUtil`,`Mdp`,`Admin`,`eleve_id`) VALUES ('Ronan' , '$argon2i$v=19$m=65536,t=22,p=1$+0I+XAJBRoSGkKczm/wzqA$mZv9qrL0Cm0rZ4BisBo6yArTa8hUstdWy06SLTV11SY', true,4);
INSERT INTO `identifiant`(`nomUtil`,`Mdp`,`Admin`,`eleve_id`) VALUES ('Eliott' , '$argon2i$v=19$m=65536,t=22,p=1$H6/5yIic9u0DhxZlbEMbvw$p13QMcOaAShOoS9ly6vJMSkNKRYUMnuct7fzHtQGaOI', false,1);

INSERT INTO `tea`(`tea_id`,`title`,`release_date`,`duration`,`valide`) VALUES (1,'Forum HEI' ,'2019-10-10' ,2,true);
INSERT INTO `tea`(`tea_id`,`title`,`release_date`,`duration`,`valide`) VALUES (2,'Salon Marseille' ,'2020-10-12' ,4,false);
INSERT INTO `tea`(`tea_id`,`title`,`release_date`,`duration`,`valide`) VALUES (3,'Aide une asso avec un moyen de locomotion' ,'2020-10-06',3,true);

INSERT INTO `nn`(`tea_id`,`eleve_id`)VALUES (1,1);
INSERT INTO `nn`(`tea_id`,`eleve_id`)VALUES (3,1);