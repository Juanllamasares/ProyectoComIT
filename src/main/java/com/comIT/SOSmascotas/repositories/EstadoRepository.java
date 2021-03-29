package com.comIT.SOSmascotas.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comIT.SOSmascotas.entidades.Estado;
@Transactional
@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {

}
