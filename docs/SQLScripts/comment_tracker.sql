SET NAMES utf8;

CREATE TABLE `climbing_website_db`.`comments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `site_id` INT NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `createdAt` DATETIME NOT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `modifiedLastBy` INT NULL DEFAULT NULL,

  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `site_id_idx` (`site_id` ASC) VISIBLE,
  INDEX `modifiedLastBy_idx` (`modifiedLastBy` ASC) VISIBLE,

  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `climbing_website_db`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `siteId`
    FOREIGN KEY (`site_id`)
    REFERENCES `climbing_website_db`.`sites` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `modifiedLastBy`
    FOREIGN KEY (`modifiedLastBy`)
    REFERENCES `climbing_website_db`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE

) ENGINE=InnoDB AUTO_INCREMENT=1;



--
-- Dumping data for table `comments`
--

LOCK TABLES `climbing_website_db`.`comments` WRITE;

INSERT INTO `climbing_website_db`.`comments` VALUES 
	(1, 3, 1, "J'ai visité ce site l'année dernière, c'était cool ! :D", '2020-01-01 10:10:10', '2020-01-02 22:22:22', 1),
  (2, 2, 2, "Ce site est de nouveau en ligne !", '2020-02-01 10:10:10', null, null);

UNLOCK TABLES;