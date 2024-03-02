package com.uce.edu.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.ec.repository.modelo.Estudiante;
import com.uce.edu.ec.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	@GetMapping("/nuevoEstudiante")
	public String nuevoEstudiante(Estudiante estudiante) {
		return "vistaNuevoEstudiante";
	}

	@PostMapping("/guardar")
	public String guardar(Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		return "redirect:/estudiantes/nuevoEstudiante";
	}
}
