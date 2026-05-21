package com.quicklypark.back.acceso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.quicklypark.back.acceso.entity.RegistroVehiculosVistaEntity;

public interface RegistroVehiculosVistaRepository extends CrudRepository<RegistroVehiculosVistaEntity, Long> {

	@Query("FROM RegistroVehiculosVistaEntity r " + "WHERE r.idParking = :idParking")
	public List<RegistroVehiculosVistaEntity> obtenerPorIdParking(@Param("idParking") long idParking);
}
