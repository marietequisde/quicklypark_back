INSERT INTO registro (matricula, id_tipo_vehiculo, marca_tiempo_entrada, marca_tiempo_salida, id_plaza)
WITH RECURSIVE semanas_atras AS (
    -- Caso base: Hace exactamente 14 días
    SELECT CURDATE() - INTERVAL 14 DAY AS fecha
    UNION ALL
    -- Caso recursivo: Añadir un día secuencialmente hasta llegar a hoy
    SELECT fecha + INTERVAL 1 DAY 
    FROM semanas_atras 
    WHERE fecha < CURDATE()
)
SELECT 
    -- Genera una matrícula realista semi-aleatoria (Ej: 4721BCA) basada en la plaza y el día
    CONCAT(
        FLOOR(1000 + (MOD(p.id * DAY(s.fecha) * 13, 8999))),
        CHAR(65 + MOD(p.id + DAY(s.fecha), 26)),
        CHAR(65 + MOD(p.id + 2, 26)),
        CHAR(65 + MOD(DAY(s.fecha), 26))
    ) AS matricula,
    
    -- Asigna el tipo de vehículo de forma cíclica (1, 2 o 3)
    (MOD(p.id + DAY(s.fecha), 3) + 1) AS id_tipo_vehiculo,
    
    -- Hora de entrada dinámica: Entre las 06:00 y las 17:00 según la plaza y el día
    TIMESTAMP(s.fecha) 
      + INTERVAL (6 + MOD(p.id + DAY(s.fecha), 12)) HOUR 
      + INTERVAL (MOD(p.id * 7, 60)) MINUTE AS marca_tiempo_entrada,
      
    -- Hora de salida dinámica: Entre 1 y 5 horas después de la entrada
    TIMESTAMP(s.fecha) 
      + INTERVAL (6 + MOD(p.id + DAY(s.fecha), 12)) HOUR 
      + INTERVAL (MOD(p.id * 7, 60)) MINUTE 
      + INTERVAL (1 + MOD(p.id * 3, 5)) HOUR 
      + INTERVAL (MOD(p.id * 11, 60)) MINUTE AS marca_tiempo_salida,
      
    p.id AS id_plaza
FROM semanas_atras s
CROSS JOIN plaza p
-- Filtro para que no se llenen absolutamente todas las plazas todos los días (simula ocupación del ~50%)
WHERE MOD(p.id + DAY(s.fecha), 2) = 0;