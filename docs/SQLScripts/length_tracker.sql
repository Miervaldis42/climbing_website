SET NAMES utf8;

CREATE TABLE `climbing_website_db`.`lengths` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `route_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `quotation` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `route_id_idx` (`route_id` ASC) VISIBLE,

  CONSTRAINT `route_id`
    FOREIGN KEY (`route_id`)
    REFERENCES `climbing_website_db`.`routes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--
-- Dumping data for table `lengths`
--
LOCK TABLES `climbing_website_db`.`lengths` WRITE;

INSERT INTO `climbing_website_db`.`lengths` VALUES 
	(1, 1, "Alpha", "3"),
	(2, 1, "Beta", "3+");

UNLOCK TABLES;