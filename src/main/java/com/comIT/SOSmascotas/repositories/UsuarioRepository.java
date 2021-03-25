package com.comIT.SOSmascotas.repositories;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.comIT.SOSmascotas.entidades.Usuario;
@Transactional
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {@Override
default long count() {
	// TODO Auto-generated method stub
	return 0;
}
}

