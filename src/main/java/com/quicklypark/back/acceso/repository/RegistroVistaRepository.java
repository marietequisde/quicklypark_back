package com.quicklypark.back.acceso.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.quicklypark.back.acceso.entity.RegistroVistaEntity;

public interface RegistroVistaRepository extends CrudRepository<RegistroVistaEntity, Long> {

	@Query("FROM RegistroVistaEntity r " + "WHERE r.idParking = :idParking AND "
			+ "r.marcaTiempoEntrada BETWEEN :desde AND :hasta")
	public List<RegistroVistaEntity> obtenerPorIdParkingYFechas(@Param("idParking") long idParking,
			@Param("desde") Timestamp desde, @Param("hasta") Timestamp hasta);
}
