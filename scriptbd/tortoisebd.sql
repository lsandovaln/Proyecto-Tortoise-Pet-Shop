-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tortoise
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tortoise
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tortoise` DEFAULT CHARACTER SET utf8 ;
USE `tortoise` ;

-- -----------------------------------------------------
-- Table `tortoise`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tortoise`.`categoria` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tortoise`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tortoise`.`producto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `stock` INT(11) NOT NULL,
  `precio` DECIMAL(8,2) NOT NULL,
  `idcategoria` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_producto` (`idcategoria` ASC),
  CONSTRAINT `FK_producto`
    FOREIGN KEY (`idcategoria`)
    REFERENCES `tortoise`.`categoria` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
