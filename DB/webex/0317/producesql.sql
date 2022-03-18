-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`user` ;

CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `userid` VARCHAR(16) NOT NULL,
  `username` VARCHAR(20) NULL,
  `grade` ENUM('a', 'b', 'c') NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`order` (
  `orderId` INT NOT NULL,
  `orderdate` TIMESTAMP NULL DEFAULT current_timestamp,
  `userId` VARCHAR(16) NULL,
  PRIMARY KEY (`orderId`),
  INDEX `order_userId_user_userId_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `order_userId_user_userId`
    FOREIGN KEY (`userId`)
    REFERENCES `mydb`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`product` ;

CREATE TABLE IF NOT EXISTS `mydb`.`product` (
  `productcode` INT NOT NULL,
  `productname` VARCHAR(45) NULL,
  `ea` INT NULL,
  `price` INT NULL,
  PRIMARY KEY (`productcode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`order_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`order_detail` ;

CREATE TABLE IF NOT EXISTS `mydb`.`order_detail` (
  `orderId` INT NOT NULL,
  `productcode` INT NOT NULL,
  `cnt` INT NULL,
  PRIMARY KEY (`orderId`, `productcode`),
  INDEX `orderdetail_productcode_product_productcode_idx` (`productcode` ASC) VISIBLE,
  CONSTRAINT `orderdetail_orderId_order_orderId`
    FOREIGN KEY (`orderId`)
    REFERENCES `mydb`.`order` (`orderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `orderdetail_productcode_product_productcode`
    FOREIGN KEY (`productcode`)
    REFERENCES `mydb`.`product` (`productcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
