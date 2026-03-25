package com.quicklypark.back.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quicklypark.back.acceso.entity.GestorEntity;
import com.quicklypark.back.acceso.repository.GestorRepository;

@Controller
@RequestMapping(path = "/gestor")
public class GestorController {

	@Autowired
	private GestorRepository gestorRepository;

	@PostMapping
	public @ResponseBody boolean nuevoGestor(@RequestParam String email, @RequestParam String clave,
			@RequestParam String nombre, @RequestParam String apellidos) {
		GestorEntity nuevoGestor = new GestorEntity(email, clave, nombre, apellidos);
		gestorRepository.save(nuevoGestor);

		return true;
	}
}
