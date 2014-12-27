-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `project` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `project` ;

-- -----------------------------------------------------
-- Table `project`.`TransportType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`TransportType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`.`Transport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`Transport` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_id` INT NOT NULL,
  `number` INT NOT NULL,
  `source` VARCHAR(45) NOT NULL,
  `destination` VARCHAR(45) NOT NULL,
  `originTime` TIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC),
  INDEX `fk_Transport_TransportType_idx` (`type_id` ASC),
  CONSTRAINT `fk_Transport_TransportType`
    FOREIGN KEY (`type_id`)
    REFERENCES `project`.`TransportType` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`Address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `aptno` INT NOT NULL,
  `street` VARCHAR(255) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  `state` VARCHAR(255) NOT NULL,
  `pincode` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`.`RegisteredUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`RegisteredUser` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(255) NOT NULL,
  `password` VARCHAR(16) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `phoneNumber` BIGINT NOT NULL,
  `addressId` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userid_UNIQUE` (`userid` ASC),
  INDEX `fk_RegisteredUser_Address1_idx` (`addressId` ASC),
  CONSTRAINT `fk_RegisteredUser_Address1`
    FOREIGN KEY (`addressId`)
    REFERENCES `project`.`Address` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`.`Bookmark`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`Bookmark` (
  `transportId` INT NOT NULL,
  `registeredUserId` INT NOT NULL,
  PRIMARY KEY (`transportId`, `registeredUserId`),
  INDEX `fk_Transport_has_RegisteredUser_RegisteredUser1_idx` (`registeredUserId` ASC),
  INDEX `fk_Transport_has_RegisteredUser_Transport1_idx` (`transportId` ASC),
  CONSTRAINT `fk_Transport_has_RegisteredUser_Transport1`
    FOREIGN KEY (`transportId`)
    REFERENCES `project`.`Transport` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Transport_has_RegisteredUser_RegisteredUser1`
    FOREIGN KEY (`registeredUserId`)
    REFERENCES `project`.`RegisteredUser` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`.`Provider`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`Provider` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `userid` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `phoneNumber` BIGINT NOT NULL,
  `password` VARCHAR(16) NOT NULL,
  `addressId` INT NOT NULL,
  `typeId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_SystemManager_Address1_idx` (`addressId` ASC),
  INDEX `fk_Provider_TransportType1_idx` (`typeId` ASC),
  CONSTRAINT `fk_SystemManager_Address1`
    FOREIGN KEY (`addressId`)
    REFERENCES `project`.`Address` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Provider_TransportType1`
    FOREIGN KEY (`typeId`)
    REFERENCES `project`.`TransportType` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
