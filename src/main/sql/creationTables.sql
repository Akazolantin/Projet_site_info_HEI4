CREATE TABLE `eleve` (
  `eleve_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `year` int(3) NOT NULL,
  `domaine` varchar(30) NOT NULL,
  PRIMARY KEY (`eleve_id`)
);

CREATE TABLE `TEA` (
  `tea_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `release_date` date NOT NULL,
  `eleve_id` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  PRIMARY KEY (`tea_id`),
  KEY `elve_id_fk` (`eleve_id`),
  CONSTRAINT `eleve_id_fk` FOREIGN KEY (`eleve_id`) REFERENCES `eleve` (`eleve_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `identifiant` (
	`nomUtil` varchar(30) NOT NULL,
	`Mdp` varchar(30) NOT NULL,
	`Admin` boolean NOT NULL,
    `eleve_id` int(11) NOT NULL,
	KEY `elve_id_fkk` (`eleve_id`),
	CONSTRAINT `eleve_id_fkk` FOREIGN KEY (`eleve_id`) REFERENCES `eleve` (`eleve_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
	PRIMARY KEY (`nomUtil`)
);

