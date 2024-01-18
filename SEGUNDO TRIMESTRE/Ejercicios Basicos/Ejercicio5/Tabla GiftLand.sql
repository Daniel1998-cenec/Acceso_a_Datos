drop database GiftLand;
CREATE DATABASE IF NOT EXISTS GiftLand ;
USE GiftLand ;

CREATE TABLE IF NOT EXISTS Productos (
  id int AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  descripcion TEXT,
  precio DECIMAL(10, 2),
  fabricante VARCHAR(50),
  unidades INT
);

INSERT INTO Productos (nombre, descripcion, precio, fabricante, unidades) VALUES
	('Asterix y Obelix en Hispania', 'Un emocionante libro para los amantes de la lectura', 29.99, 'Editorial ABC', 50),
	('Dune', 'El mejor libro de Ciencia Ficción', 15.50, 'Editorial Marvel', 100),
	('Illiada', 'Un clásico para regalar', 50, 'Editorial Homero', 30),
	('Juego la batalla del Abismo de Helm', 'Juego de estrategia para divertirse en familia', 39.99, 'Juegos Divertidos S.L.', 20)

