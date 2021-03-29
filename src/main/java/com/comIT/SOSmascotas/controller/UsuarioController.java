package com.comIT.SOSmascotas.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comIT.SOSmascotas.entidades.Usuario;
import com.comIT.SOSmascotas.repositories.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	private UsuarioRepository repo;
	
	@Autowired
	public UsuarioController(UsuarioRepository repo) {
		this.repo = repo;
	}

	//agrega un usuario
	@GetMapping(value = "/add")
	public ResponseEntity<Wrapper> getUsuario(@PathParam(value = "correo")String correo,@PathParam(value = "contraseña")String contraseña){
		Wrapper wrapper = new Wrapper();
		Usuario usuario = new Usuario();
		usuario.setCorreo(correo);
		usuario.setContraseña(contraseña);
		repo.save(usuario);
		wrapper.object=usuario;
		wrapper.status="El usuario fue agregado";
		return new ResponseEntity<Wrapper>(wrapper,HttpStatus.CREATED);
	}
	
	//me devuelve una lista de usuarios
	
	@GetMapping(value = "/")
    public ResponseEntity<List<Usuario>> getUsuarios(){
		return new ResponseEntity<List<Usuario>>((List<Usuario>) repo.findAll(),HttpStatus.OK);
	}
	
	//elimino un usuario por id
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Wrapper>deleteUsuario(@PathParam(value = "id")Long id){
		Wrapper wrapper = new Wrapper();
		
	    try {
		   Usuario usuario = repo.findById(id).get();
		   repo.delete(usuario);
		   wrapper.status = "El usuario "+id+" fue eliminado";
	   } catch (Exception e) {
		   wrapper.status = "El usuario no fue encontrado";
	   }
	
	   return new ResponseEntity<Wrapper>(wrapper,HttpStatus.OK);
		
	}
	
	public class Wrapper {
		public String status;
		public Object object;
		
	}
	
}
