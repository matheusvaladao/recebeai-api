-- init.sql

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE DATABASE IF NOT EXISTS gestaoentregasdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE gestaoentregasdb;

-- -----------------------------------------------------
-- Table `gestaoentregasdb`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestaoentregasdb`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `gestaoentregasdb`.`usuarios` (
  `idusuarios` BIGINT AUTO_INCREMENT NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  `senha` VARCHAR(256) NOT NULL,
  `nome` VARCHAR(256) NOT NULL,
  `cpf` VARCHAR(11) NULL,
  `cep` VARCHAR(8) NOT NULL,
  `endereco` VARCHAR(256) NOT NULL,
  `latitude` DECIMAL(10,8) NOT NULL,
  `longitude` DECIMAL(10,8) NOT NULL,
  PRIMARY KEY (`idusuarios`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestaoentregasdb`.`receptores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestaoentregasdb`.`receptores` ;

CREATE TABLE IF NOT EXISTS `gestaoentregasdb`.`receptores` (
  `idreceptores` BIGINT AUTO_INCREMENT NOT NULL,
  `capacidade` INT NULL,
  `dias_recebimento` VARCHAR(50) NOT NULL,
  `usuarios_idusuarios` BIGINT NOT NULL,
  PRIMARY KEY (`idreceptores`),
  INDEX `fk_receptores_usuarios_idx` (`usuarios_idusuarios` ASC) VISIBLE,
  CONSTRAINT `fk_receptores_usuarios`
    FOREIGN KEY (`usuarios_idusuarios`)
    REFERENCES `gestaoentregasdb`.`usuarios` (`idusuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestaoentregasdb`.`categorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestaoentregasdb`.`categorias` ;

CREATE TABLE IF NOT EXISTS `gestaoentregasdb`.`categorias` (
  `idcategorias` BIGINT AUTO_INCREMENT NOT NULL,
  `descricao` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idcategorias`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestaoentregasdb`.`marcas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestaoentregasdb`.`marcas` ;

CREATE TABLE IF NOT EXISTS `gestaoentregasdb`.`marcas` (
  `idmarcas` BIGINT AUTO_INCREMENT NOT NULL,
  `descricao` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idmarcas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestaoentregasdb`.`produtos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestaoentregasdb`.`produtos` ;

CREATE TABLE IF NOT EXISTS `gestaoentregasdb`.`produtos` (
  `idprodutos` BIGINT AUTO_INCREMENT NOT NULL,
  `descricao` VARCHAR(50) NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `marcas_idmarcas` BIGINT NOT NULL,
  `categorias_idcategorias` BIGINT NOT NULL,
  PRIMARY KEY (`idprodutos`),
  INDEX `fk_produtos_marcas1_idx` (`marcas_idmarcas` ASC) VISIBLE,
  INDEX `fk_produtos_categorias1_idx` (`categorias_idcategorias` ASC) VISIBLE,
  CONSTRAINT `fk_produtos_marcas1`
    FOREIGN KEY (`marcas_idmarcas`)
    REFERENCES `gestaoentregasdb`.`marcas` (`idmarcas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtos_categorias1`
    FOREIGN KEY (`categorias_idcategorias`)
    REFERENCES `gestaoentregasdb`.`categorias` (`idcategorias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestaoentregasdb`.`formas_pagamentos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestaoentregasdb`.`formas_pagamentos` ;

CREATE TABLE IF NOT EXISTS `gestaoentregasdb`.`formas_pagamentos` (
  `idformas_pagamentos` BIGINT AUTO_INCREMENT NOT NULL,
  `descricao` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idformas_pagamentos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestaoentregasdb`.`entregas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gestaoentregasdb`.`entregas` ;

CREATE TABLE IF NOT EXISTS `gestaoentregasdb`.`entregas` (
  `identregas` BIGINT AUTO_INCREMENT NOT NULL,
  `data_inicio` DATE NOT NULL,
  `data_fim` DATE NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `produtos_idprodutos` BIGINT NOT NULL,
  `receptores_idreceptores` BIGINT NOT NULL,
  `usuarios_idusuarios` BIGINT NOT NULL,
  `formas_pagamentos_idformas_pagamentos` BIGINT NOT NULL,
  PRIMARY KEY (`identregas`),
  INDEX `fk_entregas_produtos1_idx` (`produtos_idprodutos` ASC) VISIBLE,
  INDEX `fk_entregas_receptores1_idx` (`receptores_idreceptores` ASC) VISIBLE,
  INDEX `fk_entregas_usuarios1_idx` (`usuarios_idusuarios` ASC) VISIBLE,
  INDEX `fk_entregas_formas_pagamentos1_idx` (`formas_pagamentos_idformas_pagamentos` ASC) VISIBLE,
  CONSTRAINT `fk_entregas_produtos1`
    FOREIGN KEY (`produtos_idprodutos`)
    REFERENCES `gestaoentregasdb`.`produtos` (`idprodutos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_entregas_receptores1`
    FOREIGN KEY (`receptores_idreceptores`)
    REFERENCES `gestaoentregasdb`.`receptores` (`idreceptores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_entregas_usuarios1`
    FOREIGN KEY (`usuarios_idusuarios`)
    REFERENCES `gestaoentregasdb`.`usuarios` (`idusuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_entregas_formas_pagamentos1`
    FOREIGN KEY (`formas_pagamentos_idformas_pagamentos`)
    REFERENCES `gestaoentregasdb`.`formas_pagamentos` (`idformas_pagamentos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;