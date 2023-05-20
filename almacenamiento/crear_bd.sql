create database if not exists clinica CHARACTER SET utf8 COLLATE utf8_general_ci;
use clinica;




CREATE TABLE `paciente` (
	`dni` VARCHAR(9) NOT NULL,
	`nombre` VARCHAR(100) NULL DEFAULT NULL,
	`edad` INT(11) NULL DEFAULT NULL,
	`sexo` CHAR(1) NULL DEFAULT NULL,
	`calle` VARCHAR(100) NULL DEFAULT NULL,
	`localidad` VARCHAR(100) NULL DEFAULT NULL,
	`cod_postal` VARCHAR(10) NULL DEFAULT NULL,
	`peso` DOUBLE NULL DEFAULT NULL,
	`altura` DOUBLE NULL DEFAULT NULL,
	PRIMARY KEY (`dni`)
)

CREATE TABLE `profesionales_medicos` (
	`dni` VARCHAR(9) NOT NULL,
	`nombre` VARCHAR(50) NULL DEFAULT NULL,
	`apellidos` VARCHAR(50) NULL DEFAULT NULL,
	`localidad` VARCHAR(50) NULL DEFAULT NULL,
	`telefono` VARCHAR(20) NULL DEFAULT NULL,
	`especialidad` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`dni`)
)

CREATE TABLE `visitas` (
	`dni` VARCHAR(9) NOT NULL,
	`dniProfesional` VARCHAR(9) NOT NULL,
	`fecha` DATE NOT NULL,
	`hora` TIME NOT NULL,
	`peso` DECIMAL(5,2) NULL DEFAULT NULL,
	`altura` DECIMAL(5,2) NULL DEFAULT NULL,
	`unidadaltura` VARCHAR(10) NULL DEFAULT NULL,
	`resulimc` VARCHAR(20) NULL DEFAULT NULL,
	PRIMARY KEY (`dni`, `fecha`, `hora`),
	INDEX `idx_dniProfesional` (`dniProfesional`),
	INDEX `idx_dni` (`dni`),
	CONSTRAINT `FK_visitas_paciente` FOREIGN KEY (`dni`) REFERENCES `paciente` (`dni`) ON UPDATE CASCADE,
   CONSTRAINT `FK_visitas_profesional` FOREIGN KEY (`dniProfesional`) REFERENCES `profesionales_medicos` (`dni`) ON UPDATE CASCADE
 

);