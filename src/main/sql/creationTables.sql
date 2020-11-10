CREATE TABLE `eleve` (
  `eleve_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`eleve_id`)
);

CREATE TABLE `tache` (
  `tache_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `release_date` date NOT NULL,
  `eleve_id` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `director` varchar(45) NOT NULL,
  `summary` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`film_id`),
  KEY `genre_id_fk` (`genre_id`),
  CONSTRAINT `genre_id_fk` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`genre_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `identifiant` (

);

