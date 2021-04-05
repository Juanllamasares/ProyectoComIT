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

import com.comIT.SOSmascotas.entidades.Administrador;
import com.comIT.SOSmascotas.repositories.AdministradorRepository;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	
	@Autowired
	private AdministradorRepository repo;
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

    //devuelve un listado de administradores
	@RequestMapping("/listado")
	public String list(Model model) {
		model.addAttribute("admins", repo.findAll());
		return "listado";
	}
	
	//crea un administrador
			@RequestMapping("/crear")
			public String crear(Model model) {
				Administrador admin = new Administrador();
				admin.setCorreo(new String());
				admin.setContraseña(new String());
				model.addAttribute("administrador", admin);

				return "crear";
			}
    //guarda un administrador
	@RequestMapping(value = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT })
	public String guardarAdmin(@RequestParam(value = "correo") String correo, @RequestParam(value = "contraseña") String contraseña,Model model) throws ParseException {

		Administrador admin = new Administrador();
		admin.setCorreo(correo);
		admin.setContraseña(contraseña);
		repo.save(admin);
		model.addAttribute("administrador", admin);
		return "redirect:/listado";
	}
    //borra un administrador por id
    @PostMapping(value = "/borrar/{id}")
	public String adminBorrado(@PathVariable(value = "id") long id, Model model) {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			model.addAttribute("error", "No se pudo eliminar el administrador");
			return "error";
		}
		return "administrador borrado";
	}

	@GetMapping(value = "/error")
	public String error() {
		return "error";
	}


}
