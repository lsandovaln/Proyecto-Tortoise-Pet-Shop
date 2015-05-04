SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `tortoise` DEFAULT CHARACTER SET utf8 ;
USE `tortoise` ;

-- -----------------------------------------------------
-- Table `tortoise`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tortoise`.`categoria` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(80) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tortoise`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tortoise`.`producto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `stock` INT(11) NULL DEFAULT NULL,
  `precio` DECIMAL(8,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `idcategoria`
    FOREIGN KEY (`id`)
    REFERENCES `tortoise`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;