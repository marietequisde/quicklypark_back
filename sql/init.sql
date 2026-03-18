DROP TABLE IF EXISTS gestor;
DROP TABLE IF EXISTS registro;
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
    es_plaza BOOLEAN NOT NULL DEFAULT FALSE,
    libre BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (id_parking, planta, fila, columna)
);

CREATE TABLE registro (
    id SERIAL PRIMARY KEY,
    matricula VARCHAR(20) NOT NULL,
    marca_tiempo_entrada TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    marca_tiempo_salida TIMESTAMP,
    id_plaza INTEGER NOT NULL REFERENCES plaza(id) ON DELETE CASCADE
);

CREATE TABLE gestor (
    id SERIAL PRIMARY KEY,
    email VARCHAR(64) UNIQUE NOT NULL,
    clave VARCHAR(16) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    apellidos VARCHAR(40) NOT NULL
);