package com.quicklypark.back.acceso.provider;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.quicklypark.back.acceso.dto.ParkingDto;
import com.quicklypark.back.acceso.dto.PlazaDto;
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

	public ParkingDto obtener(long idParking) {
		ParkingDto parkingDto = null;
		Optional<ParkingEntity> parkingEntity = parkingRepository.findById(idParking);

		if (parkingEntity.isPresent()) {

			List<PlazaEntity> plazasEntity = plazaRepository.findByIdParking(idParking);
			PlazaDto[][] plazasDto = new PlazaDto[obtenerMaxFila(plazasEntity) + 1]
													[obtenerMaxColumna(plazasEntity) + 1];

			for (int i = 0; i < plazasEntity.size(); i++) {
				PlazaEntity plazaEntity = plazasEntity.get(i);
				plazasDto[plazaEntity.getFila()][plazaEntity.getColumna()] = new PlazaDto(plazaEntity.isLibre());
			}

			parkingDto = new ParkingDto();
			parkingDto.setDireccion(parkingEntity.get().getDireccion());
			parkingDto.setHorario(parkingEntity.get().getHorario());
			parkingDto.setPlazas(plazasDto);
		}

		return parkingDto;
	}

	public Long crear(String direccion, String horario, MultipartFile fichero) throws IOException {
		ParkingEntity parking = new ParkingEntity(direccion, horario);
		Long idParking = parkingRepository.save(parking).getId();

		List<PlazaEntity> plazas = FicheroParkingUtil.leerPlazas(fichero, idParking);
		for (int i = 0; i < plazas.size(); i++) {
			plazaRepository.save(plazas.get(i));
		}

		return idParking;
	}

	private static int obtenerMaxFila(List<PlazaEntity> plazas) {
		int max = 0;
		for (int i = 0; i < plazas.size(); i++) {
			int fila = plazas.get(i).getFila();
			if (fila > max) {
				max = fila;
			}
		}
		return max;
	}

	private static int obtenerMaxColumna(List<PlazaEntity> plazas) {
		int max = 0;
		for (int i = 0; i < plazas.size(); i++) {
			int columna = plazas.get(i).getColumna();
			if (columna > max) {
				max = columna;
			}
		}
		return max;
	}
}
