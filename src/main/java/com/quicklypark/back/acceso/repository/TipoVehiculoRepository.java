package com.quicklypark.back.acceso.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.quicklypark.back.acceso.entity.TipoVehiculoEntity;

public interface TipoVehiculoRepository extends CrudRepository<TipoVehiculoEntity, Long> {

	@Query("FROM TipoVehiculoEntity t")
	public List<TipoVehiculoEntity> findAll();
}
