package com.quicklypark.back.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quicklypark.back.acceso.entity.RegistroSemanalVistaEntity;
import com.quicklypark.back.acceso.entity.RegistroVehiculosVistaEntity;
import com.quicklypark.back.acceso.exception.AutenticacionException;
import com.quicklypark.back.acceso.repository.RegistroSemanalVistaRepository;
import com.quicklypark.back.acceso.repository.RegistroVehiculosVistaRepository;
import com.quicklypark.back.util.SeguridadUtil;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/registro")
public class RegistroController {

	Logger logger = LoggerFactory.getLogger(RegistroController.class);

	@Autowired
	private SeguridadUtil seguridadUtil;

	@Autowired
	private RegistroSemanalVistaRepository registroSemanalVistaRepository;

	@Autowired
	private RegistroVehiculosVistaRepository registroVehiculosVistaRepository;

	@GetMapping("/semanal/{idParking}")
	@Operation(summary = "Obtener los datos de uso de un parking en la semana actual")
	public ResponseEntity<?> obtenerPorIdParking(@RequestParam String email, @RequestParam String clave,
			@PathVariable long idParking) {
		List<RegistroSemanalVistaEntity> registros = null;
		try {
			seguridadUtil.validarCredenciales(email, clave);
			registros = registroSemanalVistaRepository.obtenerPorIdParking(idParking);
		} catch (AutenticacionException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
		return ResponseEntity.ok(registros);
	}

	@GetMapping("/vehiculos/{idParking}")
	@Operation(summary = "Obtener los datos de uso por tipo de vehículo de un parking")
	public ResponseEntity<?> obtenerDatosVehiculos(@RequestParam String email, @RequestParam String clave,
			@PathVariable long idParking) {
		List<RegistroVehiculosVistaEntity> registros = null;
		try {
			seguridadUtil.validarCredenciales(email, clave);
			registros = registroVehiculosVistaRepository.obtenerPorIdParking(idParking);
		} catch (AutenticacionException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
		return ResponseEntity.ok(registros);
	}
}
