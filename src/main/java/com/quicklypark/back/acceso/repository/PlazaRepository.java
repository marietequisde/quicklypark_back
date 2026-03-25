package com.quicklypark.back.acceso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.quicklypark.back.acceso.entity.PlazaEntity;

public interface PlazaRepository extends CrudRepository<PlazaEntity, Integer> {

	@Query("FROM PlazaEntity p WHERE p.idParking = :idParking")
	public List<PlazaEntity> findByIdParking(@Param("idParking") long idParking);
}
