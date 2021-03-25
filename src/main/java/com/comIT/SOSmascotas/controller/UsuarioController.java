package com.comIT.SOSmascotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.comIT.SOSmascotas.entidades.Usuario;
import com.comIT.SOSmascotas.repositories.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioController {
	
	@Autowired
    UsuarioRepository usuarioRepo;
	@GetMapping(value = "/")
	public ResponseEntity <Usuario> nuevoUsuario(){
		Usuario usuario = new Usuario();
		usuarioRepo.save(usuario);
		return ResponseEntity.ok(usuario);
	}
	
	public class Wrapper{
		public String status;
		public Object object;
	}
	
	//trae todos los usuarios
	@GetMapping(value = "/")
	public ResponseEntity<List<Usuario>> getUsuarios(){
		return new ResponseEntity<List<Usuario>>((List<Usuario>) usuarioRepo.findAll(), HttpStatus.OK);
	}
	

}
