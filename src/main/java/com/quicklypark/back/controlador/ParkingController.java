package com.quicklypark.back.controlador;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.quicklypark.back.acceso.dto.ParkingDto;
import com.quicklypark.back.acceso.exception.AutenticacionException;
import com.quicklypark.back.acceso.provider.ParkingProvider;
import com.quicklypark.back.util.Cadenas;
import com.quicklypark.back.util.SeguridadUtil;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/parking")
public class ParkingController {

	Logger logger = LoggerFactory.getLogger(ParkingController.class);

	@Autowired
	private SeguridadUtil seguridadUtil;

	@Autowired
	private ParkingProvider parkingProvider;

	@GetMapping
	@Operation(summary = "Listar todos los parkings")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(parkingProvider.listar());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Obtener parking por id")
	public ResponseEntity<?> obtener(@PathVariable long id) {
		ParkingDto parking = null;
		try {
			parking = parkingProvider.obtener(id);
		} catch (Exception e) {
			logger.error(Cadenas.ERROR_OBTENER_PARKING);
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Cadenas.ERROR_OBTENER_PARKING);
		}
		return ResponseEntity.ok(parking);
	}

	@PostMapping(consumes = "multipart/form-data")
	@Operation(summary = "Crear un nuevo parking")
	public ResponseEntity<String> nuevo(@RequestParam String email, @RequestParam String clave,
			@RequestParam String direccion, @RequestParam String horario, @RequestPart MultipartFile fichero) {
		try {
			seguridadUtil.validarCredenciales(email, clave);
			parkingProvider.crear(direccion, horario, fichero);
		} catch (AutenticacionException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} catch (IOException e) {
			logger.error(Cadenas.ERROR_LEER_PARKING);
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Cadenas.ERROR_LEER_PARKING);
		}
		return ResponseEntity.ok(Cadenas.EXITO_NUEVO_PARKING);
	}

	@PostMapping(path = "/preview", consumes = "multipart/form-data")
	@Operation(summary = "Previsualizar un nuevo parking")
	public ResponseEntity<?> previsualizar(@RequestParam String email, @RequestParam String clave,
			@RequestParam String direccion, @RequestParam String horario, @RequestPart MultipartFile fichero) {
		ParkingDto parking = null;
		try {
			seguridadUtil.validarCredenciales(email, clave);
			parking = parkingProvider.previsualizar(direccion, horario, fichero);
		} catch (AutenticacionException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} catch (IOException e) {
			logger.error(Cadenas.ERROR_LEER_PARKING);
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Cadenas.ERROR_LEER_PARKING);
		}
		return ResponseEntity.ok(parking);
	}
}
