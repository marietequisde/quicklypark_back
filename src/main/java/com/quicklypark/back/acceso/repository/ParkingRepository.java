package com.quicklypark.back.acceso.repository;

import org.springframework.data.repository.CrudRepository;
import com.quicklypark.back.acceso.entity.ParkingEntity;

public interface ParkingRepository extends CrudRepository<ParkingEntity, Long> {

}
