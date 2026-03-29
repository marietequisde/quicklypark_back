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
import com.quicklypark.back.acceso.provider.ParkingProvider;
import com.quicklypark.back.util.Cadenas;

@RestController
@RequestMapping(path = "/parking")
public class ParkingController {

	Logger logger = LoggerFactory.getLogger(ParkingController.class);

	@Autowired
	private ParkingProvider parkingProvider;

	@GetMapping("/{id}")
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

	@PostMapping
	public ResponseEntity<String> nuevo(@RequestParam String direccion, @RequestParam String horario,
			@RequestPart MultipartFile fichero) {
		try {
			parkingProvider.crear(direccion, horario, fichero);
		} catch (IOException e) {
			logger.error(Cadenas.ERROR_LEER_PARKING);
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Cadenas.ERROR_LEER_PARKING);
		}
		return ResponseEntity.ok(Cadenas.EXITO_NUEVO_PARKING);
	}
}
