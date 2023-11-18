drop database empresa;
create database empresa; 
use empresa;

create table clientes (
id int auto_increment primary key,
nif int, 
nombre varchar(50),
edad int
);

insert into clientes (id, nif, nombre, edad) values
(1, 001, 'daniel', 25),
(2, 002, 'javi', 20),
(3, 003, 'juan', 42);