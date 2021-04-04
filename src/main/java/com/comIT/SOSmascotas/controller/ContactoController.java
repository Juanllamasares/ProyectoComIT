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

import com.comIT.SOSmascotas.entidades.Contacto;
import com.comIT.SOSmascotas.repositories.ContactoRepository;

@Controller
@RequestMapping("/contactos")
public class ContactoController {
	
	@Autowired
	private ContactoRepository repo;
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

    //devuelve un listado de contactos
	@RequestMapping("/listado")
	public String list(Model model) {
		model.addAttribute("contactos", repo.findAll());
		return "listado";
	}
    //guarda un contacto
	@RequestMapping(value = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT })
	public String guardarMascota(@RequestParam(value = "nombre") String nombre, @RequestParam(value = "telefono") int telefono,@RequestParam(value = "whatsApp")int whatsApp,
			Model model) throws ParseException {

		Contacto contacto = new Contacto();
		contacto.setNombre(nombre);
		contacto.setTelefono(telefono);
		contacto.setWhatsApp(whatsApp);
		repo.save(contacto);
		model.addAttribute("contacto", contacto);
		return "redirect:/listado";
	}
    //borra un contacto por id
    @PostMapping(value = "/borrar/{id}")
	public String contactoBorrado(@PathVariable(value = "id") long id, Model model) {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			model.addAttribute("error", "No se pudo eliminar el contacto");
			return "error";
		}
		return "contacto borrado";
	}

	@GetMapping(value = "/error")
	public String error() {
		return "error";
	}

}
