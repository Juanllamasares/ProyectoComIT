package com.comIT.SOSmascotas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.comIT.SOSmascotas.entidades.Reporte;
import com.comIT.SOSmascotas.repositories.ReporteRepository;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
	
	@Autowired
	private ReporteRepository repo;
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

    //devuelve un listado de reportes
	@RequestMapping("/listado")
	public String list(Model model) {
		model.addAttribute("reportes", repo.findAll());
		return "listado";
	}
    //guarda un reporte
	@RequestMapping(value = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT })
	public String guardarReporte(@RequestParam(value = "fechaCreacion") String fechaCreacion,Model model) throws ParseException {

		Date fecha = new SimpleDateFormat("yyyy-mm-dd").parse(fechaCreacion);
		
		Reporte reporte = new Reporte();
		reporte.setFechaCreacion(fecha);
		repo.save(reporte);
		model.addAttribute("reporte", reporte);
		return "redirect:/listado";
	}
    //borra una mascota por id
    @PostMapping(value = "/borrar/{id}")
	public String reporteBorrado(@PathVariable(value = "id") long id, Model model) {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			model.addAttribute("error", "No se pudo eliminar el reporte");
			return "error";
		}
		return "reporte borrado";
	}

	@GetMapping(value = "/error")
	public String error() {
		return "error";
	}

}
