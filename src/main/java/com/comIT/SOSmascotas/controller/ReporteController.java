package com.comIT.SOSmascotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comIT.SOSmascotas.entidades.Reporte;
import com.comIT.SOSmascotas.repositories.ReporteRepository;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {
	@Autowired
	private ReporteRepository reporteRepo;
	@GetMapping(value = "/")
	public ResponseEntity<Reporte> nuevoReporte(){
		Reporte reporte = new Reporte();
		reporteRepo.save(reporte);
		return ResponseEntity.ok(reporte);
	}
}
