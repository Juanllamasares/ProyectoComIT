package com.comIT.SOSmascotas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.comIT.SOSmascotas.entidades.Usuario;
import com.comIT.SOSmascotas.repositories.UsuarioRepository;

@SpringBootApplication
public class SoSmascotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoSmascotasApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner loadData(UsuarioRepository repository) {
		return (args)->{
			Usuario usuario=new Usuario();
			usuario.setCorreo("juanllama160@gmail.com");
			usuario.setContraseña("123456");
			usuario.setAdministrador(null);;
			repository.save(usuario);
			
		};
	}
}


