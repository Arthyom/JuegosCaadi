-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Usuario_Clase` VARCHAR(20) NOT NULL,
  `Usuario_Nombre` VARCHAR(30) NOT NULL,
  `Usuario_Apellidos` VARCHAR(50) NOT NULL,
  `Usuario_Grado` VARCHAR(45) NULL,
  `Usuario_Password` VARCHAR(45) NOT NULL,
  `Usuario_Activo` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC),
  UNIQUE INDEX `Usuario_Nombre_UNIQUE` (`Usuario_Nombre` ASC),
  UNIQUE INDEX `Usuario_Password_UNIQUE` (`Usuario_Password` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Estudiante` (
  `idEstudiante` INT NOT NULL AUTO_INCREMENT,
  `Estudiante_Nombre` VARCHAR(45) NOT NULL,
  `Estudiante_Apellidos` VARCHAR(50) NULL,
  `Estudiante_Semestre` TINYINT NOT NULL,
  `Estudiante_NivelIngles` TINYINT NOT NULL,
  `Estudiante_Carrera` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idEstudiante`),
  UNIQUE INDEX `idEstudiante_UNIQUE` (`idEstudiante` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Materia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Materia` (
  `idMateria` INT NOT NULL AUTO_INCREMENT,
  `Materia_Nombre` VARCHAR(45) NOT NULL,
  `Materia_Creditos` TINYINT NOT NULL,
  `Materia_Siguiente` VARCHAR(45) NOT NULL,
  `Materia_PreRequisitos` VARCHAR(45) NOT NULL,
  `Estudiante_idEstudiante` INT NOT NULL,
  PRIMARY KEY (`idMateria`),
  UNIQUE INDEX `idMateria_UNIQUE` (`idMateria` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sesion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Sesion` (
  `idSesion` INT NOT NULL AUTO_INCREMENT,
  `Sesion_Inicio` DATE NOT NULL,
  `Sesion_Termino` DATE NOT NULL,
  `Sesion_Duracion` DATE NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idSesion`),
  UNIQUE INDEX `idSesion_UNIQUE` (`idSesion` ASC),
  INDEX `fk_Sesion_Usuario1_idx` (`Usuario_idUsuario` ASC),
  CONSTRAINT `fk_Sesion_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `mydb`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Material` (
  `idMaterial` INT NOT NULL AUTO_INCREMENT,
  `Material_Nombre` VARCHAR(45) NOT NULL,
  `Material_Clase` VARCHAR(15) NOT NULL,
  `Material_Existencia` TINYINT NOT NULL,
  `Material_Disponible` TINYINT NOT NULL,
  `Material_Habilidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMaterial`),
  UNIQUE INDEX `idMaterial_UNIQUE` (`idMaterial` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Juego`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Juego` (
  `Juego_Idioma` VARCHAR(20) NOT NULL,
  `Juego_EnlaceDigital` VARCHAR(45) NULL,
  `Juego_InstruccionesUso` MEDIUMTEXT NOT NULL,
  `Juego_Descripcion` TINYTEXT NOT NULL,
  `Juego_MaterialAdicional` VARCHAR(45) NULL,
  `Juego_NumeroParticipantes` TINYINT NOT NULL,
  `Juego_TiempoSugerido` VARCHAR(10) NOT NULL,
  `Juego_EtiquetaTemas` VARCHAR(20) NOT NULL,
  `Juego_EtiquetasVocabulario` VARCHAR(20) NOT NULL,
  `Material_idMaterial` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_Juego_Material1_idx` (`Material_idMaterial` ASC),
  UNIQUE INDEX `Material_idMaterial_UNIQUE` (`Material_idMaterial` ASC),
  CONSTRAINT `fk_Juego_Material1`
    FOREIGN KEY (`Material_idMaterial`)
    REFERENCES `mydb`.`Material` (`idMaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Administrador` (
  `Administrador_NivelIngles` TINYINT NOT NULL,
  `Usuario_idUsuario` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_Administrador_Usuario1_idx` (`Usuario_idUsuario` ASC),
  PRIMARY KEY (`Usuario_idUsuario`),
  UNIQUE INDEX `Usuario_idUsuario_UNIQUE` (`Usuario_idUsuario` ASC),
  CONSTRAINT `fk_Administrador_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `mydb`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EstudianteLei`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EstudianteLei` (
  `EstudianteLei_Semestre` INT NOT NULL,
  `EstudianteLei_Nivelngles` TINYINT NOT NULL,
  `Estudiante_Calificacion` VARCHAR(45) NOT NULL,
  `Usuario_idUsuario` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_EstudianteLei_Usuario1_idx` (`Usuario_idUsuario` ASC),
  PRIMARY KEY (`Usuario_idUsuario`),
  UNIQUE INDEX `Usuario_idUsuario_UNIQUE` (`Usuario_idUsuario` ASC),
  CONSTRAINT `fk_EstudianteLei_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `mydb`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Profesor` (
  `Profesor_TipoContrato` VARCHAR(20) NOT NULL,
  `Usuario_idUsuario` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_Profesor_Usuario1_idx` (`Usuario_idUsuario` ASC),
  PRIMARY KEY (`Usuario_idUsuario`),
  UNIQUE INDEX `Usuario_idUsuario_UNIQUE` (`Usuario_idUsuario` ASC),
  CONSTRAINT `fk_Profesor_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `mydb`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Material_has_Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Material_has_Material` (
  `Material_idMaterial` INT NOT NULL,
  `Material_idMaterial1` INT NOT NULL,
  PRIMARY KEY (`Material_idMaterial`, `Material_idMaterial1`),
  INDEX `fk_Material_has_Material_Material2_idx` (`Material_idMaterial1` ASC),
  INDEX `fk_Material_has_Material_Material1_idx` (`Material_idMaterial` ASC),
  CONSTRAINT `fk_Material_has_Material_Material1`
    FOREIGN KEY (`Material_idMaterial`)
    REFERENCES `mydb`.`Material` (`idMaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Material_has_Material_Material2`
    FOREIGN KEY (`Material_idMaterial1`)
    REFERENCES `mydb`.`Material` (`idMaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Administrador_Administra_Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Administrador_Administra_Material` (
  `Administrador_Usuario_idUsuario` INT NOT NULL,
  `Material_idMaterial` INT NOT NULL,
  PRIMARY KEY (`Administrador_Usuario_idUsuario`, `Material_idMaterial`),
  INDEX `fk_Administrador_has_Material_Material1_idx` (`Material_idMaterial` ASC),
  INDEX `fk_Administrador_has_Material_Administrador1_idx` (`Administrador_Usuario_idUsuario` ASC),
  CONSTRAINT `fk_Administrador_has_Material_Administrador1`
    FOREIGN KEY (`Administrador_Usuario_idUsuario`)
    REFERENCES `mydb`.`Administrador` (`Usuario_idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Administrador_has_Material_Material1`
    FOREIGN KEY (`Material_idMaterial`)
    REFERENCES `mydb`.`Material` (`idMaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EstudianteLei_Crea_Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EstudianteLei_Crea_Material` (
  `EstudianteLei_Usuario_idUsuario` INT NOT NULL,
  `Material_idMaterial` INT NOT NULL,
  PRIMARY KEY (`EstudianteLei_Usuario_idUsuario`, `Material_idMaterial`),
  INDEX `fk_EstudianteLei_has_Material_Material1_idx` (`Material_idMaterial` ASC),
  INDEX `fk_EstudianteLei_has_Material_EstudianteLei1_idx` (`EstudianteLei_Usuario_idUsuario` ASC),
  CONSTRAINT `fk_EstudianteLei_has_Material_EstudianteLei1`
    FOREIGN KEY (`EstudianteLei_Usuario_idUsuario`)
    REFERENCES `mydb`.`EstudianteLei` (`Usuario_idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EstudianteLei_has_Material_Material1`
    FOREIGN KEY (`Material_idMaterial`)
    REFERENCES `mydb`.`Material` (`idMaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Profesor_Solicita_Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Profesor_Solicita_Material` (
  `Profesor_Usuario_idUsuario` INT NOT NULL,
  `Material_idMaterial` INT NOT NULL,
  `IdMateria` VARCHAR(45) NULL,
  `Materia` VARCHAR(45) NULL,
  PRIMARY KEY (`Profesor_Usuario_idUsuario`, `Material_idMaterial`),
  INDEX `fk_Profesor_has_Material_Material1_idx` (`Material_idMaterial` ASC),
  INDEX `fk_Profesor_has_Material_Profesor1_idx` (`Profesor_Usuario_idUsuario` ASC),
  CONSTRAINT `fk_Profesor_has_Material_Profesor1`
    FOREIGN KEY (`Profesor_Usuario_idUsuario`)
    REFERENCES `mydb`.`Profesor` (`Usuario_idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Profesor_has_Material_Material1`
    FOREIGN KEY (`Material_idMaterial`)
    REFERENCES `mydb`.`Material` (`idMaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Profesor_Imparte_Materia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Profesor_Imparte_Materia` (
  `Profesor_Usuario_idUsuario` INT NOT NULL,
  `Materia_idMateria` INT NOT NULL,
  `Materia_Estudiante_idEstudiante` INT NOT NULL,
  `DiasMateria` VARCHAR(45) NULL,
  `NumeroAlumnos` INT NULL,
  `Horario` VARCHAR(45) NULL,
  `MaterialDisponible` VARCHAR(45) NULL,
  PRIMARY KEY (`Profesor_Usuario_idUsuario`, `Materia_idMateria`, `Materia_Estudiante_idEstudiante`),
  INDEX `fk_Profesor_has_Materia_Materia1_idx` (`Materia_idMateria` ASC, `Materia_Estudiante_idEstudiante` ASC),
  INDEX `fk_Profesor_has_Materia_Profesor1_idx` (`Profesor_Usuario_idUsuario` ASC),
  CONSTRAINT `fk_Profesor_has_Materia_Profesor1`
    FOREIGN KEY (`Profesor_Usuario_idUsuario`)
    REFERENCES `mydb`.`Profesor` (`Usuario_idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Profesor_has_Materia_Materia1`
    FOREIGN KEY (`Materia_idMateria` , `Materia_Estudiante_idEstudiante`)
    REFERENCES `mydb`.`Materia` (`idMateria` , `Estudiante_idEstudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EstudianteLei_Cursan_Materia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EstudianteLei_Cursan_Materia` (
  `EstudianteLei_Usuario_idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Materia_idMateria` INT NOT NULL,
  `Materia_Estudiante_idEstudiante` INT NOT NULL,
  PRIMARY KEY (`EstudianteLei_Usuario_idUsuario`, `Materia_idMateria`, `Materia_Estudiante_idEstudiante`),
  INDEX `fk_EstudianteLei_has_Materia_Materia1_idx` (`Materia_idMateria` ASC, `Materia_Estudiante_idEstudiante` ASC),
  INDEX `fk_EstudianteLei_has_Materia_EstudianteLei1_idx` (`EstudianteLei_Usuario_idUsuario` ASC),
  UNIQUE INDEX `EstudianteLei_Usuario_idUsuario_UNIQUE` (`EstudianteLei_Usuario_idUsuario` ASC),
  CONSTRAINT `fk_EstudianteLei_has_Materia_EstudianteLei1`
    FOREIGN KEY (`EstudianteLei_Usuario_idUsuario`)
    REFERENCES `mydb`.`EstudianteLei` (`Usuario_idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EstudianteLei_has_Materia_Materia1`
    FOREIGN KEY (`Materia_idMateria` , `Materia_Estudiante_idEstudiante`)
    REFERENCES `mydb`.`Materia` (`idMateria` , `Estudiante_idEstudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Estudiante_Cursa_Materia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Estudiante_Cursa_Materia` (
  `Estudiante_idEstudiante` INT NOT NULL,
  `Materia_idMateria` INT NOT NULL,
  `Materia_Estudiante_idEstudiante` INT NOT NULL,
  PRIMARY KEY (`Estudiante_idEstudiante`, `Materia_idMateria`, `Materia_Estudiante_idEstudiante`),
  INDEX `fk_Estudiante_has_Materia_Materia1_idx` (`Materia_idMateria` ASC, `Materia_Estudiante_idEstudiante` ASC),
  INDEX `fk_Estudiante_has_Materia_Estudiante1_idx` (`Estudiante_idEstudiante` ASC),
  CONSTRAINT `fk_Estudiante_has_Materia_Estudiante1`
    FOREIGN KEY (`Estudiante_idEstudiante`)
    REFERENCES `mydb`.`Estudiante` (`idEstudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estudiante_has_Materia_Materia1`
    FOREIGN KEY (`Materia_idMateria` , `Materia_Estudiante_idEstudiante`)
    REFERENCES `mydb`.`Materia` (`idMateria` , `Estudiante_idEstudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
