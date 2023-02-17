-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema theatrebooking
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema theatrebooking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `theatrebooking` DEFAULT CHARACTER SET utf8mb4 ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
USE `theatrebooking` ;

-- -----------------------------------------------------
-- Table `theatrebooking`.`showProduction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`showProduction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `showName` VARCHAR(45) NULL,
  `showDescription` MEDIUMTEXT NULL,
  `duration` INT NULL,
  `language` ENUM('English', 'Spanish', 'Italian') NULL,
  `typeID` ENUM('Musical', 'Opera', 'Theatre', 'Concert') NOT NULL,
  `liveAccompaniment` TINYINT NULL,
  `circlePrice` DOUBLE NOT NULL,
  `stallPrice` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO showProduction (showName, showDescription, duration, language, typeID, liveAccompaniment, circlePrice, stallPrice) VALUES ('Queen', 'Queen are here to rock your socks off!', '120', 'English', 'Concert', '1', '10.00', '20.00');

INSERT INTO showProduction (showName, showDescription, duration, language, typeID, liveAccompaniment, circlePrice, stallPrice) VALUES ('Le Figaro', 'Mozarts back with a brand new track!', '180', 'Italian', 'Opera', '1',  '6.00', '12.00');

INSERT INTO showProduction (showName, showDescription, duration, language, typeID, liveAccompaniment, circlePrice, stallPrice) VALUES ('Les Miserable', 'The French are back with a revolution. King Louis is a bit worried', '120', 'English', 'Musical', '0', '9.00', '14.00');

INSERT INTO showProduction (showName, showDescription, duration, language, typeID, liveAccompaniment, circlePrice, stallPrice) VALUES ('Shakespeare: To be, or not be', 'A new take on the Shakespeare play Hamlet', '90', 'English', 'Theatre', '0', '5.00', '10.00');

INSERT INTO showProduction (showName, showDescription, duration, language, typeID, liveAccompaniment, circlePrice, stallPrice) VALUES ('Bugsy Malone', 'The kids are back with swing', '150', 'English', 'Musical', '1', '10.00', '7.00');

INSERT INTO showProduction (showName, showDescription, duration, language, typeID, liveAccompaniment, circlePrice, stallPrice) VALUES ('Adele', 'Latest hits from the album 104', '120', 'English', 'Concert', '1', '20.00', '30.00');

-- -----------------------------------------------------
-- Table `theatrebooking`.`performance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`performance` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `showDate` DATE NULL,
  `showStartTime` TIME NULL,
  `totalAvailibilityStalls` INT NULL,
  `totalAvailibilityCircle` INT NULL,
  `showProductionID` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `showProductionID_idx` (`showProductionID` ASC) VISIBLE,
  CONSTRAINT `showProductionID`
    FOREIGN KEY (`showProductionID`)
    REFERENCES `theatrebooking`.`showProduction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-10-10', '19:30:00', '120', '80', '1');

INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-10-12', '14:00:00', '120', '80', '2');

INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-10-12', '19:30:00', '120', '80', '2');

INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-10-18', '19:30:00', '120', '80', '3');

INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-10-19', '19:30:00', '120', '80', '3');

INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-10-20', '19:30:00', '120', '80', '3');

INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-11-06', '17:30:00', '120', '80', '4');

INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-12-04', '17:30:00', '120', '80', '4');

INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-12-10', '18:00:00', '120', '80', '5');

INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-12-14', '20:00:00', '120', '80', '6');


-- -----------------------------------------------------
-- Table `theatrebooking`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `addressLine1` VARCHAR(45) NULL,
  `addressLine2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `postcode` VARCHAR(9) NULL,
  `creditCard` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theatrebooking`.`musicPerformer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`musicPerformer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `showProductionID` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `showProduction1_idx` (`showProductionID` ASC) VISIBLE,
  CONSTRAINT `showProductionID3`
    FOREIGN KEY (`showProductionID`)
    REFERENCES `theatrebooking`.`showProduction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO musicPerformer (name, showProductionID) VALUES ('Freddie Mercury', '1');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Brian May', '1');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('John Deacon', '1');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Roger Taylor', '1');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Wolfgang Amadeus Mozart', '2');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Julia Steiner', '2');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('New York Philharmonic Orchestra', '3');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Esa Pekka Salonen', '3');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('James Gall', '5');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Ed Sheeran', '5');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Adele', '6');


-- -----------------------------------------------------
-- Table `theatrebooking`.`regularPerformer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`regularPerformer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `showProductionID` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `performance2ID_idx` (`showProductionID` ASC) VISIBLE,
  CONSTRAINT `showProductionID2`
    FOREIGN KEY (`showProductionID`)
    REFERENCES `theatrebooking`.`showProduction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO regularPerformer (name, showProductionID) VALUES ('Ryan Gosling', '3');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Emma Stone', '3');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Harry Styles', '3');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Vanessa Hudgens', '3');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Danny DeVito', '4');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Benedict Cumberbatch', '4');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Emma Thompson', '4');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Joanna Lum', '5');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Dara OBrian', '5');


-- -----------------------------------------------------
-- Table `theatrebooking`.`concessionID`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`concessionID` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` ENUM('Regular', 'Student', 'Under 16', 'Other') NULL,
  `discount` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theatrebooking`.`transactionID`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`transactionID` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `timestamp` DATETIME NULL,
  `customerID` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `customerID_idx` (`customerID` ASC) VISIBLE,
  CONSTRAINT `customerID`
    FOREIGN KEY (`customerID`)
    REFERENCES `theatrebooking`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theatrebooking`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theatrebooking`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `transactionID` INT NULL,
  `performanceID` INT NULL,
  `concessionID` INT NULL,
  `collectionID` ENUM('Posted', 'BoxOffice', 'PrintAtHome') NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
