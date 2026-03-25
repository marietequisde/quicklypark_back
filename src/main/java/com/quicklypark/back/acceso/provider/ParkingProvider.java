package com.quicklypark.back.acceso.provider;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.quicklypark.back.acceso.entity.ParkingEntity;
import com.quicklypark.back.acceso.entity.PlazaEntity;
import com.quicklypark.back.acceso.repository.ParkingRepository;
import com.quicklypark.back.acceso.repository.PlazaRepository;
import com.quicklypark.back.util.FicheroParkingUtil;

@Component
public class ParkingProvider {

	Logger logger = LoggerFactory.getLogger(ParkingProvider.class);

	@Autowired
	private ParkingRepository parkingRepository;

	@Autowired
	private PlazaRepository plazaRepository;

	public Long crear(String direccion, String horario, MultipartFile fichero) throws IOException {
		ParkingEntity parking = new ParkingEntity(direccion, horario);
		Long idParking = parkingRepository.save(parking).getId();

		List<PlazaEntity> plazas = FicheroParkingUtil.leerPlazas(fichero, idParking);
		for (int i = 0; i < plazas.size(); i++) {
			plazaRepository.save(plazas.get(i));
		}

		return idParking;
	}

}
