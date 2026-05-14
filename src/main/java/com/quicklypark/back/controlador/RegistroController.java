package com.quicklypark.back.controlador;

import java.sql.Timestamp;
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

import com.quicklypark.back.acceso.entity.RegistroVistaEntity;
import com.quicklypark.back.acceso.exception.AutenticacionException;
import com.quicklypark.back.acceso.repository.RegistroVistaRepository;
import com.quicklypark.back.util.SeguridadUtil;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/registro")
public class RegistroController {

	Logger logger = LoggerFactory.getLogger(RegistroController.class);

	@Autowired
	private SeguridadUtil seguridadUtil;

	@Autowired
	private RegistroVistaRepository registroVistaRepository;

	@GetMapping("/{id}")
	@Operation(summary = "Obtener los datos de uso de un parking")
	public ResponseEntity<?> obtenerPorIdParking(@RequestParam String email, @RequestParam String clave,
			@PathVariable long id, @RequestParam Timestamp desde, @RequestParam Timestamp hasta) {
		List<RegistroVistaEntity> registros = null;
		try {
			seguridadUtil.validarCredenciales(email, clave);
			registros = registroVistaRepository.obtenerPorIdParkingYFechas(id, desde, hasta);
		} catch (AutenticacionException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
		return ResponseEntity.ok(registros);
	}
}
