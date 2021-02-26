SET NAMES utf8;
USE `climbing_website_db`;

--
-- Table structure for table `sites`
--

DROP TABLE IF EXISTS `sites`;

CREATE TABLE `sites` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `location` varchar(45) NOT NULL,
  `tag` boolean NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;


--
-- Dumping data for table `sites`
--

LOCK TABLES `sites` WRITE;

INSERT INTO `sites` VALUES 
	(1, "Les Alpes", "Magnifique chaîne de montagnes avec ces nombreux parcours d'escalade pour débutants.", "France", 1),
	(2, "Les Vosges", "Débutants & experts peuvent venir défier les mystères de la nature.", "France", 0),
	(3, "Le Jura", "Grandeur Nature", "France", 0),
	(4, "Le Massif Central", "Parfait terrain de jeu pour les grimpeurs en été comme en hiver !", "France", 1),
	(5, "Les Pyrénées", "Jusqu'au 30 décembre, certains secteurs seront réouverts !", "France", 0);

UNLOCK TABLES;