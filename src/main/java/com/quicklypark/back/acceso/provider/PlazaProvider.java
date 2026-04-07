package com.quicklypark.back.acceso.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.quicklypark.back.acceso.dto.ParkingDto;
import com.quicklypark.back.acceso.entity.PlazaEntity;
import com.quicklypark.back.acceso.entity.RegistroEntity;
import com.quicklypark.back.acceso.exception.PlazaLibreException;
import com.quicklypark.back.acceso.exception.PlazaOcupadaException;
import com.quicklypark.back.acceso.exception.RecursoNoEncontradoException;
import com.quicklypark.back.acceso.repository.PlazaRepository;
import com.quicklypark.back.acceso.repository.RegistroRepository;
import com.quicklypark.back.acceso.repository.TipoVehiculoRepository;
import com.quicklypark.back.util.Cadenas;
import com.quicklypark.back.util.TiempoUtil;

@Component
public class PlazaProvider {

	Logger logger = LoggerFactory.getLogger(PlazaProvider.class);

	@Autowired
	private PlazaRepository plazaRepository;

	@Autowired
	private RegistroRepository registroRepository;

	@Autowired
	private ParkingProvider parkingProvider;

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	private TipoVehiculoRepository tipoVehiculoRepository;

	public void ocupar(long idPlaza, String matricula, long idTipoVehiculo)
			throws RecursoNoEncontradoException, PlazaOcupadaException {
		tipoVehiculoRepository.findById(idTipoVehiculo)
				.orElseThrow(() -> new RecursoNoEncontradoException(Cadenas.TIPO_VEHICULO_NO_ENCONTRADO));

		PlazaEntity plazaEntity = obtenerPlaza(idPlaza);

		if (!plazaEntity.isLibre()) {
			throw new PlazaOcupadaException();
		}

		plazaEntity.setLibre(false);
		plazaRepository.save(plazaEntity);

		RegistroEntity registroEntity = new RegistroEntity(matricula, idTipoVehiculo, idPlaza);
		registroRepository.save(registroEntity);

		enviarNuevoParking(plazaEntity.getIdParking());
	}

	public void liberar(long idPlaza) throws RecursoNoEncontradoException, PlazaLibreException {
		PlazaEntity plazaEntity = obtenerPlaza(idPlaza);

		if (plazaEntity.isLibre()) {
			throw new PlazaLibreException();
		}

		plazaEntity.setLibre(true);
		plazaRepository.save(plazaEntity);

		RegistroEntity registroEntity = registroRepository.findLatestByIdPlaza(idPlaza)
				.orElse(new RegistroEntity("Error de registro", null, idPlaza));

		registroEntity.setMarcaTiempoSalida(TiempoUtil.ahora());
		registroRepository.save(registroEntity);

		enviarNuevoParking(plazaEntity.getIdParking());
	}

	private PlazaEntity obtenerPlaza(long idPlaza) throws RecursoNoEncontradoException {
		return plazaRepository.findById(idPlaza)
				.orElseThrow(() -> new RecursoNoEncontradoException(Cadenas.PLAZA_NO_ENCONTRADA));
	}

	private void enviarNuevoParking(long idParking) {
		ParkingDto parking = parkingProvider.obtener(idParking);
		simpMessagingTemplate.convertAndSend("/topic/parking/" + idParking, parking);
	}

}
