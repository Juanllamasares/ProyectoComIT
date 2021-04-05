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

import com.comIT.SOSmascotas.entidades.Usuario;
import com.comIT.SOSmascotas.repositories.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repo;
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	//crea un reporte
		@RequestMapping("/crear")
		public String crear(Model model) {
			Usuario usuario = new Usuario();
			usuario.setCorreo(new String());
			usuario.setContraseña(new String());
			model.addAttribute("usuario", usuario);

			return "crear";
		}

    //devuelve un listado de usuarios
	@RequestMapping("/listado")
	public String list(Model model) {
		model.addAttribute("usuarios", repo.findAll());
		return "listado";
	}
    //guarda un usuario
	@RequestMapping(value = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT })
	public String guardarUsuario(@RequestParam(value = "correo") String correo, @RequestParam(value = "contraseña") String contraseña,Model model) throws ParseException {

		Usuario usuario = new Usuario();
		usuario.setCorreo(correo);
		usuario.setContraseña(contraseña);
		repo.save(usuario);
		model.addAttribute("usuario", usuario);
		return "redirect:/listado";
	}
    //borra un usuario por id
    @PostMapping(value = "/borrar/{id}")
	public String usuarioBorrado(@PathVariable(value = "id") long id, Model model) {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			model.addAttribute("error", "No se pudo eliminar el usuario");
			return "error";
		}
		return "usuario borrado";
	}

	@GetMapping(value = "/error")
	public String error() {
		return "error";
	}


}
