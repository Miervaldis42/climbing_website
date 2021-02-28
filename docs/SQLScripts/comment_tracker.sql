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

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;