-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema CustomerDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CustomerDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CustomerDB` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema ShopDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ShopDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ShopDB` ;
USE `CustomerDB` ;

-- -----------------------------------------------------
-- Table `CustomerDB`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CustomerDB`.`customer` (
  `customerID` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `phone` VARCHAR(10) NOT NULL,
  `cnp` VARCHAR(13) NOT NULL,
  UNIQUE INDEX `cnp_UNIQUE` (`cnp` ASC),
  PRIMARY KEY (`customerID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShopDB`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ShopDB`.`product` (
  `productID` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `price` FLOAT NULL,
  `description` VARCHAR(100) NULL,
  `in_stock` INT NULL,
  PRIMARY KEY (`productID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CustomerDB`.`history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CustomerDB`.`history` (
  `historyID` INT NOT NULL,
  `customerID` INT NOT NULL,
  `productID` INT NOT NULL,
  PRIMARY KEY (`historyID`),
  INDEX `productID_idx` (`productID` ASC),
  INDEX `customerID_index` (`customerID` ASC),
  CONSTRAINT `customerID`
    FOREIGN KEY (`customerID`)
    REFERENCES `CustomerDB`.`customer` (`customerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `productID`
    FOREIGN KEY (`productID`)
    REFERENCES `ShopDB`.`product` (`productID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `ShopDB` ;

-- -----------------------------------------------------
-- Table `ShopDB`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ShopDB`.`review` (
  `reviewID` INT NOT NULL,
  `productID` INT NOT NULL,
  `text` VARCHAR(100) NULL,
  PRIMARY KEY (`reviewID`),
  INDEX `productID_index` (`productID` ASC),
  CONSTRAINT `productID`
    FOREIGN KEY (`productID`)
    REFERENCES `ShopDB`.`product` (`productID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShopDB`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ShopDB`.`cart` (
  `cartID` INT NOT NULL,
  `customerID` INT NOT NULL,
  PRIMARY KEY (`cartID`),
  UNIQUE INDEX `cartID_UNIQUE` (`cartID` ASC),
  INDEX `customerID_idx` (`customerID` ASC),
  CONSTRAINT `customerID`
    FOREIGN KEY (`customerID`)
    REFERENCES `CustomerDB`.`customer` (`customerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShopDB`.`cart_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ShopDB`.`cart_detail` (
  `cart_detailID` INT NOT NULL,
  `cartID` INT NOT NULL,
  `productID` INT NOT NULL,
  `number_of_products` INT NOT NULL,
  PRIMARY KEY (`cart_detailID`),
  INDEX `cartID_indx` (`cartID` ASC),
  INDEX `productID_indx` (`productID` ASC),
  CONSTRAINT `cartID_c`
    FOREIGN KEY (`cartID`)
    REFERENCES `ShopDB`.`cart` (`cartID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `productID_c`
    FOREIGN KEY (`productID`)
    REFERENCES `ShopDB`.`product` (`productID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
