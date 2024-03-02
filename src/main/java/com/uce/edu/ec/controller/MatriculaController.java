package com.uce.edu.ec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.ec.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.ec.service.IMatriculaService;
import com.uce.edu.ec.service.to.MatriculaTO;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private IMatriculaService matriculaService;

	@GetMapping("/reporte")
	public String reporte(MatriculaDTO matriculaDTO, Model model) {
		List<MatriculaDTO> matriculas = this.matriculaService.reporteMatriculas();
		model.addAttribute("matriculas", matriculas);
		return "vistaReportes";
	}

	@GetMapping("/nuevaMatricula")
	public String nuevaMatricula(MatriculaTO matriculaTO) {
		return "vistaNuevaMatricula";
	}

	@PostMapping("/matricular")
	public String matricular(MatriculaTO matriculaTO) {
		this.matriculaService.matriculaMultiple(matriculaTO);
		return "redirect:/matriculas/nuevaMatricula";
	}

}
