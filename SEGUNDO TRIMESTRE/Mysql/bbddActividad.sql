drop database actividad;
create database actividad;
use actividad;

CREATE TABLE alumno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    telefono VARCHAR(15),
    direccion VARCHAR(100),
    cp VARCHAR(10),
    email VARCHAR(100)
);