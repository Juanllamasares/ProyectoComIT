package com.comIT.SOSmascotas.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comIT.SOSmascotas.entidades.Reporte;
import com.comIT.SOSmascotas.repositories.ReporteRepository;


@RestController
@RequestMapping("/api/reportes")
public class ReporteController {
	
	private ReporteRepository repo;
	
	@Autowired
	public ReporteController(ReporteRepository repo) {
		this.repo = repo;
	}

	//agrega un reporte
	
	@GetMapping(value = "/add")
	public ResponseEntity<Wrapper> getReporte(@PathParam(value = "fecha")Date fechaCreacion,@PathParam(value = "baja")Boolean baja){
		Wrapper wrapper = new Wrapper();
		Reporte reporte = new Reporte();
		reporte.setFechaCreacion(fechaCreacion);
		reporte.setBaja(baja);
		repo.save(reporte);
		wrapper.object=reporte;
		wrapper.status="El reporte fue agregado";
		return new ResponseEntity<Wrapper>(wrapper,HttpStatus.CREATED);
	}
	
	//me devuelve una lista de reportes
	
	@GetMapping(value = "/")
    public ResponseEntity<List<Reporte>> getReportes(){
		return new ResponseEntity<List<Reporte>>((List<Reporte>) repo.findAll(),HttpStatus.OK);
	}
	
	//elimino un reporte por id
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Wrapper>deleteReporte(@PathParam(value = "id")Long id){
		Wrapper wrapper = new Wrapper();
		
	    try {
		   Reporte reporte = repo.findById(id).get();
		   repo.delete(reporte);
		   wrapper.status = "El reporte "+id+" fue eliminado";
	   } catch (Exception e) {
		   wrapper.status = "El reporte no fue encontrado";
	   }
	
	   return new ResponseEntity<Wrapper>(wrapper,HttpStatus.OK);
		
	}
	
	public class Wrapper {
		public String status;
		public Object object;
		
	}

}
