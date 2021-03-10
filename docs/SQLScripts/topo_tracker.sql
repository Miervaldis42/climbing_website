SET NAMES utf8;

CREATE TABLE `climbing_website_db`.`topos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `owner_id` INT NOT NULL,
  `site_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT '1',
  `publishedDate` DATETIME NOT NULL,
  `borrower_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  
  INDEX `topoUser_id_idx` (`owner_id` ASC) VISIBLE,
  INDEX `topoSite_id_idx` (`site_id` ASC) VISIBLE,
  INDEX `topoBorrower_id_idx` (`borrower_id` ASC) VISIBLE,

  CONSTRAINT `topoOwner_id`
    FOREIGN KEY (`owner_id`)
    REFERENCES `climbing_website_db`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `topoSite_id`
    FOREIGN KEY (`site_id`)
    REFERENCES `climbing_website_db`.`sites` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `topoBorrower_id`
    FOREIGN KEY (`borrower_id`)
    REFERENCES `climbing_website_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1;


--
-- Dumping data for table `topos`
--

LOCK TABLES `climbing_website_db`.`topos` WRITE;

INSERT INTO `climbing_website_db`.`topos` VALUES 
	(1, 1, 1, "Topo n°1", "1001 façons de traverser les Alpes ! (Topo pour débutants)", 0, '2020-01-01 10:10:10', null),
  (2, 1, 2, "Topo n°2", "1001 façons de traverser les Vosges ! (Topo pour débutants)", 1, '2020-02-01 10:40:10', null),
  (3, 1, 2, "Topo n°3", "1001 façons de traverser les Vosges ! (Topo pour experts)", 2, '2020-03-01 12:10:10', 2),
  (4, 1, 4, "Astuces de grimpe", "Attention, ce topo est renouvelé tous les ans !", 3, '2020-04-11 06:10:10', 3);

UNLOCK TABLES;