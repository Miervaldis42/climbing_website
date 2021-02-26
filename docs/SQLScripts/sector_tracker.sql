SET NAMES utf8;

CREATE TABLE `climbing_website_db`.`sectors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `site_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,

  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `site_id_idx` (`site_id` ASC) VISIBLE,

  CONSTRAINT `site_id`
    FOREIGN KEY (`site_id`)
    REFERENCES `climbing_website_db`.`sites` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--
-- Dumping data for table `sectors`
--
LOCK TABLES `climbing_website_db`.`sectors` WRITE;

INSERT INTO `climbing_website_db`.`sectors` VALUES 
	(1, 1, "Sector 7"),
	(2, 1, "District 9");

UNLOCK TABLES;