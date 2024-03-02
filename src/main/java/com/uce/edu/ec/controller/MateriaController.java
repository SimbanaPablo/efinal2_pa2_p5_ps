package com.uce.edu.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.ec.repository.modelo.Materia;
import com.uce.edu.ec.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	private IMateriaService materiaService;

	@GetMapping("/nuevaMateria")
	public String nuevaMateria(Materia materia) {
		return "vistaNuevaMateria";
	}

	@PostMapping("/guardar")
	public String guardar(Materia materia) {
		this.materiaService.guardar(materia);
		return "redirect:/materias/nuevaMateria";
	}
}
