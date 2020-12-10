DELETE FROM nn;
DELETE FROM tea;
DELETE FROM identifiant;
DELETE FROM eleve;

INSERT INTO `eleve`(`eleve_id`,`nom`,`prenom`,`year`,`domaine`) VALUES (4,'Paturel','Ronan',4,'ITI');

INSERT INTO `identifiant`(`nomUtil`,`Mdp`,`Admin`,`eleve_id`) VALUES ('Ronan' , '$argon2i$v=19$m=65536,t=22,p=1$+0I+XAJBRoSGkKczm/wzqA$mZv9qrL0Cm0rZ4BisBo6yArTa8hUstdWy06SLTV11SY', true,4);

INSERT INTO `tea`(`title`,`release_date`,`duration`,`valide`,`nbrDispo`) VALUES ('Forum HEI' ,'2021-10-10' ,2,false,5);
INSERT INTO `tea`(`title`,`release_date`,`duration`,`valide`,`nbrDispo`) VALUES ('Salon Marseille' ,'2020-10-12' ,4,false,10);
INSERT INTO `tea`(`title`,`release_date`,`duration`,`valide`,`nbrDispo`) VALUES ('Aide une asso avec un moyen de locomotion' ,'2020-10-06',3,false,6);
INSERT INTO `tea`(`title`,`release_date`,`duration`,`valide`,`nbrDispo`) VALUES ('Aide une ammsso avec un moyen de locomotion' ,'2020-10-06',3,false,6);



