package com.quicklypark.back.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quicklypark.back.acceso.entity.TipoVehiculoEntity;
import com.quicklypark.back.acceso.repository.TipoVehiculoRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/tipo-vehiculo")

public class TipoVehiculoController {

	@Autowired
	private TipoVehiculoRepository tipoVehiculoRepository;

	@GetMapping
	@Operation(summary = "Devuelve el listado de tipos de vehículo")
	public @ResponseBody List<TipoVehiculoEntity> listar() {
		return tipoVehiculoRepository.findAll();
	}
}
