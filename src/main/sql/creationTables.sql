CREATE TABLE `eleve` (
  `eleve_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `year` varchar(30) NOT NULL,
  `domaine` varchar(30) NOT NULL,
  PRIMARY KEY (`eleve_id`)
);

CREATE TABLE `tache` (
  `tache_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `release_date` date NOT NULL,
  `eleve_id` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `summary` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`tache_id`),
  KEY `elve_id_fk` (`eleve_id`),
  CONSTRAINT `eleve_id_fk` FOREIGN KEY (`eleve_id`) REFERENCES `eleve` (`eleve_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `identifiant` (

);

