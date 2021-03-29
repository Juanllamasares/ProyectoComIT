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

import com.comIT.SOSmascotas.entidades.Mascota;
import com.comIT.SOSmascotas.repositories.MascotaRepository;


@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

	private MascotaRepository repo;
	
	@Autowired
	public MascotaController(MascotaRepository repo) {
		this.repo = repo;
	}

	//agrega una mascota
	
	@GetMapping(value = "/add")
	public ResponseEntity<Wrapper> getMascota(@PathParam(value = "descripcion")String descripcion,@PathParam(value = "ubicacion")String ubicacion){
		Wrapper wrapper = new Wrapper();
		Mascota mascota = new Mascota();
		mascota.setDescripcion(descripcion);
		mascota.setUbicacion(ubicacion);
		repo.save(mascota);
		wrapper.object=mascota;
		wrapper.status="La mascota fue agregada";
		return new ResponseEntity<Wrapper>(wrapper,HttpStatus.CREATED);
	}
	
	//me devuelve una lista de mascotas
	
	@GetMapping(value = "/")
    public ResponseEntity<List<Mascota>> getMascotas(){
		return new ResponseEntity<List<Mascota>>((List<Mascota>) repo.findAll(),HttpStatus.OK);
	}
	
	//elimino una mascota por id
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Wrapper>deleteMascota(@PathParam(value = "id")Long id){
		Wrapper wrapper = new Wrapper();
		
	    try {
		   Mascota mascota = repo.findById(id).get();
		   repo.delete(mascota);
		   wrapper.status = "La mascota "+id+" fue eliminada";
	   } catch (Exception e) {
		   wrapper.status = "La mascota no fue encontrada";
	   }
	
	   return new ResponseEntity<Wrapper>(wrapper,HttpStatus.OK);
		
	}
	
	public class Wrapper {
		public String status;
		public Object object;
		
	}

}
