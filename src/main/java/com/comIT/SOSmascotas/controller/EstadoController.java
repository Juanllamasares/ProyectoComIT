package com.comIT.SOSmascotas.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.comIT.SOSmascotas.entidades.Estado;
import com.comIT.SOSmascotas.repositories.EstadoRepository;

@Controller
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private EstadoRepository repo;
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

    //devuelve un listado de estados 
	@RequestMapping("/listado")
	public String list(Model model) {
		model.addAttribute("estados", repo.findAll());
		return "listado";
	}
	
	//crea una estado
			@RequestMapping("/crear")
			public String crear(Model model) {
				Estado estado = new Estado();
				estado.setNombre(new String());
				model.addAttribute("estado", estado);

				return "crear";
			}
    //guarda un estado
	@RequestMapping(value = "/guardarEstado", method = { RequestMethod.POST, RequestMethod.PUT })
	public String guardarEstado(@RequestParam(value = "nombre") String nombre,Model model) throws ParseException {

		Estado estado = new Estado();
		estado.setNombre(nombre);
		repo.save(estado);
		model.addAttribute("estado", estado);
		return "redirect:/listado";
	}
    //borra un estado por id
    @PostMapping(value = "/borrar/{id}")
	public String estadoBorrado(@PathVariable(value = "id") long id, Model model) {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			model.addAttribute("error", "No se pudo eliminar el estado");
			return "error";
		}
		return "estado borrado";
	}

	@GetMapping(value = "/error")
	public String error() {
		return "error";
	}

}
