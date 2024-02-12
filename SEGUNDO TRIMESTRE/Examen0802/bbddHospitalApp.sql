-- Crear la base de datos
drop database HospitalApp;
CREATE DATABASE HospitalApp;
USE HospitalApp;

-- Crear tabla pacientes
CREATE TABLE pacientes (
    IDPaciente INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50),
    Apellidos VARCHAR(50),
    Ciudad VARCHAR(50),
    Direccion VARCHAR(50),
    Edad VARCHAR(50),
    Historial varchar(50)
);

-- Crear tabla medicos
CREATE TABLE medicos (
    IDMedico INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50),
    Apellidos VARCHAR(50),
    Especialidad VARCHAR(50)
);

-- Crear tabla citas
CREATE TABLE citas (
    IDCitas INT PRIMARY KEY AUTO_INCREMENT,
    Fecha DATE,
	Hora VARCHAR(30),
    IDPaciente INT,
    IDMedico INT,
    FOREIGN KEY (IDPaciente) REFERENCES pacientes(IDPaciente),
    FOREIGN KEY (IDMedico) REFERENCES medicos(IDMedico)
);