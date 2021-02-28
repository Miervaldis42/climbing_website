SET NAMES utf8;

CREATE TABLE `climbing_website_db`.`routes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sector_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `quotation` VARCHAR(10) NOT NULL,

  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `sector_id_idx` (`sector_id` ASC) VISIBLE,

  CONSTRAINT `sector_id`
    FOREIGN KEY (`sector_id`)
    REFERENCES `climbing_website_db`.`sectors` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--
-- Dumping data for table `routes`
--
LOCK TABLES `climbing_website_db`.`routes` WRITE;

INSERT INTO `climbing_website_db`.`routes` VALUES 
	(1, 1, "Route 66", "3"),
	(2, 1, "Route 7", "3+");

UNLOCK TABLES;