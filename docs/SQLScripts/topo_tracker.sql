CREATE TABLE `climbing_website_db`.`topos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `owner_id` INT NOT NULL,
  `site_id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `status` VARCHAR(255) NOT NULL DEFAULT '1',
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
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `topoBorrower_id`
    FOREIGN KEY (`borrower_id`)
    REFERENCES `climbing_website_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

COMMENT = 'Table for \'Topos\'';