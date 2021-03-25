package com.comIT.SOSmascotas.repositories;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.comIT.SOSmascotas.entidades.Administrador;
@Transactional
@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Long> {
	

}
