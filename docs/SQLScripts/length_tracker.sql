CREATE TABLE `climbing_website_db`.`lengths` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `site_id` INT NOT NULL,
  `route_id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `quotation` VARCHAR(10) NULL,
  PRIMARY KEY (`id`),
  INDEX `route_id_idx` (`route_id` ASC) VISIBLE,

  FOREIGN KEY (`site_id`)
    REFERENCES `climbing_website_db`.`sites` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  CONSTRAINT `route_id`
    FOREIGN KEY (`route_id`)
    REFERENCES `climbing_website_db`.`routes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);


--
-- Dumping data for table `lengths`
--
LOCK TABLES `climbing_website_db`.`lengths` WRITE;

INSERT INTO `climbing_website_db`.`lengths` VALUES 
	(1, 1, 1, "Alpha", "3"),
	(2, 1, 1, "Beta", "3+");

UNLOCK TABLES;