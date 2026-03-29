package com.quicklypark.back.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quicklypark.back.acceso.exception.PlazaLibreException;
import com.quicklypark.back.acceso.exception.PlazaOcupadaException;
import com.quicklypark.back.acceso.exception.RecursoNoEncontradoException;
import com.quicklypark.back.acceso.provider.PlazaProvider;
import com.quicklypark.back.util.Cadenas;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/plaza")
public class PlazaController {

	Logger logger = LoggerFactory.getLogger(PlazaController.class);

	@Autowired
	private PlazaProvider plazaProvider;

	@PatchMapping("/ocupar/{id}")
	@Operation(summary = "Ocupar una plaza por id")
	public ResponseEntity<String> ocupar(@PathVariable long id, @RequestParam String matricula) {
		try {
			plazaProvider.ocupar(id, matricula);
		} catch (RecursoNoEncontradoException | PlazaOcupadaException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

		return ResponseEntity.ok(Cadenas.EXITO_PLAZA_OCUPADA);
	}

	@PatchMapping("/liberar/{id}")
	@Operation(summary = "Liberar una plaza por id")
	public ResponseEntity<String> liberar(@PathVariable long id) {
		try {
			plazaProvider.liberar(id);
		} catch (RecursoNoEncontradoException | PlazaLibreException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

		return ResponseEntity.ok(Cadenas.EXITO_PLAZA_LIBRE);
	}

}
