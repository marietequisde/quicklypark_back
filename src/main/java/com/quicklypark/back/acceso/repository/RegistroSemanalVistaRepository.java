package com.quicklypark.back.acceso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.quicklypark.back.acceso.entity.RegistroSemanalVistaEntity;

public interface RegistroSemanalVistaRepository extends CrudRepository<RegistroSemanalVistaEntity, Long> {

	@Query("FROM RegistroSemanalVistaEntity r " + "WHERE r.idParking = :idParking")
	public List<RegistroSemanalVistaEntity> obtenerPorIdParking(@Param("idParking") long idParking);
}
