package com.comIT.SOSmascotas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comIT.SOSmascotas.entidades.Reporte;
import com.comIT.SOSmascotas.repositories.ReporteRepository;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");

	@Autowired
	private ReporteRepository reporteRepo;

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	// devuelve un listado de reportes
	@RequestMapping("/listado")
	public String list(Model model) {
		model.addAttribute("reportes", reporteRepo.findAll());
		return "listado";
	}

	// crea un reporte
	@RequestMapping("/crear")
	public String crear(Model model) {
		Reporte reporte = new Reporte();
		reporte.setFechaCreacion(new Date());
		model.addAttribute("reporte", reporte);

		return "crear";
	}

	// guarda un reporte
	@PostMapping(value = "/guardarReporte")
	public String guardarReporte(@ModelAttribute Reporte rep, @RequestParam(value = "telefono") String telefono,
			Model model) {

		Date fecha = new Date();
//		try {
//			fecha = SIMPLE_DATE_FORMAT.parse(rep.getFechaCreacion());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		rep.setFechaCreacion(fecha);
		reporteRepo.save(rep);

		model.addAttribute("reportes", reporteRepo.findAll());
		return "listado";
	}

	// borra un reporte por id
	@PostMapping(value = "/borrar/{id}")
	public String reporteBorrado(@PathVariable(value = "id") long id, Model model) {
		try {
			reporteRepo.deleteById(id);
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
