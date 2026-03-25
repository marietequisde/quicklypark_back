-- PARKING
INSERT INTO parking (id, direccion, horario) VALUES
(1, 'Calle Mayor 10, Zaragoza', '24h'),
(2, 'Av. Cataluña 45, Zaragoza', '08:00-22:00'),
(3, 'Paseo Independencia 100, Zaragoza', '24h');

-- PLAZAS
-- Parking 1 (2 plantas, 3x3)
INSERT INTO plaza (planta, fila, columna, id_parking, libre) VALUES
(0,0,0,1,TRUE),
(0,0,1,1,FALSE),
(0,0,2,1,TRUE),
(0,1,0,1,FALSE),
(0,1,1,1,TRUE),
(0,1,2,1,TRUE),
(1,0,0,1,TRUE),
(1,0,1,1,FALSE),
(1,0,2,1,TRUE);

-- Parking 2 (1 planta, 2x3)
INSERT INTO plaza (planta, fila, columna, id_parking, libre) VALUES
(0,0,0,2,TRUE),
(0,0,1,2,FALSE),
(0,0,2,2,TRUE),
(0,1,0,2,TRUE),
(0,1,1,2,TRUE),
(0,1,2,2,FALSE);

-- Parking 3 (1 planta, 2x2)
INSERT INTO plaza (planta, fila, columna, id_parking, libre) VALUES
(0,0,0,3,TRUE),
(0,0,1,3,FALSE),
(0,1,0,3,TRUE),
(0,1,1,3,TRUE);

-- REGISTROS (algunas plazas ocupadas/libres)
INSERT INTO registro (matricula, marca_tiempo_entrada, marca_tiempo_salida, id_plaza) VALUES
('1234ABC', '2026-03-18 08:00:00', NULL, 2),
('5678DEF', '2026-03-18 07:30:00', '2026-03-18 10:00:00', 4),
('9012GHI', '2026-03-17 22:00:00', NULL, 8),
('3456JKL', '2026-03-18 09:15:00', NULL, 11),
('7890MNO', '2026-03-18 06:00:00', '2026-03-18 08:00:00', 6);

-- GESTORES
INSERT INTO gestor (email, clave, nombre, apellidos) VALUES
('admin1@parking.com', 'pass1234', 'Carlos', 'Gomez Ruiz'),
('admin2@parking.com', 'clave5678', 'Laura', 'Martinez Lopez'),
('admin3@parking.com', 'admin9999', 'Javier', 'Sanchez Perez');