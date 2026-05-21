DROP TABLE IF EXISTS gestor;
DROP TABLE IF EXISTS registro;
DROP TABLE IF EXISTS tipo_vehiculo;
DROP TABLE IF EXISTS plaza;
DROP TABLE IF EXISTS parking;

CREATE TABLE parking (
    id SERIAL PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL,
    horario VARCHAR(100)
);

CREATE TABLE plaza (
    id SERIAL PRIMARY KEY,
    planta INTEGER NOT NULL,
    fila INTEGER NOT NULL,
    columna INTEGER NOT NULL,
    id_parking INTEGER NOT NULL REFERENCES parking(id) ON DELETE CASCADE,
    libre BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (id_parking, planta, fila, columna)
);

CREATE TABLE tipo_vehiculo (
	id SERIAL PRIMARY KEY,
	tipo VARCHAR(40) UNIQUE NOT NULL
);

CREATE TABLE registro (
    id SERIAL PRIMARY KEY,
    matricula VARCHAR(20) NOT NULL,
    id_tipo_vehiculo BIGINT UNSIGNED,
    marca_tiempo_entrada TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    marca_tiempo_salida TIMESTAMP,
    id_plaza INTEGER NOT NULL REFERENCES plaza(id) ON DELETE CASCADE,
    FOREIGN KEY (id_tipo_vehiculo) REFERENCES tipo_vehiculo(id) ON DELETE CASCADE
);

CREATE TABLE gestor (
    id SERIAL PRIMARY KEY,
    email VARCHAR(64) UNIQUE NOT NULL,
    clave VARCHAR(16) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    apellidos VARCHAR(40) NOT NULL
);

CREATE OR REPLACE VIEW vista_registro AS
SELECT
r.id,
tipo AS tipo_vehiculo,
marca_tiempo_entrada,
marca_tiempo_salida,
id_parking
FROM registro r
JOIN tipo_vehiculo t ON r.id_tipo_vehiculo = t.id
JOIN plaza p ON r.id_plaza = p.id; 

CREATE OR REPLACE VIEW vista_registro_semanal AS
SELECT id_parking,
SUM(case WEEKDAY(marca_tiempo_entrada) when 0 then 1 else 0 end) AS "lunes",
SUM(case WEEKDAY(marca_tiempo_entrada) when 1 then 1 else 0 end) AS "martes",
SUM(case WEEKDAY(marca_tiempo_entrada) when 2 then 1 else 0 end) AS "miercoles",
SUM(case WEEKDAY(marca_tiempo_entrada) when 3 then 1 else 0 end) AS "jueves",
SUM(case WEEKDAY(marca_tiempo_entrada) when 4 then 1 else 0 end) AS "viernes",
SUM(case WEEKDAY(marca_tiempo_entrada) when 5 then 1 else 0 end) AS "sabado",
SUM(case WEEKDAY(marca_tiempo_entrada) when 6 then 1 else 0 end) AS "domingo"
FROM vista_registro
WHERE WEEK(CURDATE(), 1) = WEEK(marca_tiempo_entrada, 1)
GROUP BY id_parking;

CREATE OR REPLACE VIEW vista_registro_vehiculos AS
SELECT 
id_parking,
SUM(CASE WHEN tipo_vehiculo = 'Furgoneta' THEN 1 ELSE 0 END) AS furgoneta,
SUM(CASE WHEN tipo_vehiculo = 'Motocicleta' THEN 1 ELSE 0 END) AS motocicleta,
SUM(CASE WHEN tipo_vehiculo = 'Turismo' THEN 1 ELSE 0 END) AS turismo
FROM vista_registro
GROUP BY id_parking;