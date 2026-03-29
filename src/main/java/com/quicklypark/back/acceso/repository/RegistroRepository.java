package com.quicklypark.back.acceso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.quicklypark.back.acceso.entity.RegistroEntity;

public interface RegistroRepository extends CrudRepository<RegistroEntity, Long>{

	@Query("FROM RegistroEntity r WHERE r.idPlaza = :idPlaza ORDER BY marcaTiempoEntrada DESC LIMIT 1")
	public Optional<RegistroEntity> findLatestByIdPlaza(@Param("idPlaza") long idPlaza);
}
