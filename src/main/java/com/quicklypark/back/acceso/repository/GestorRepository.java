package com.quicklypark.back.acceso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.quicklypark.back.acceso.entity.GestorEntity;

public interface GestorRepository extends CrudRepository<GestorEntity, Integer> {

	@Query("FROM GestorEntity g WHERE g.email = :email AND g.clave = :clave")
	public Optional<GestorEntity> obtenerPorEmailYClave(@Param("email") String email, @Param("clave") String clave);
}
