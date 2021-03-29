package com.comIT.SOSmascotas.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comIT.SOSmascotas.entidades.Mascota;
@Transactional
@Repository
public interface MascotaRepository extends CrudRepository<Mascota, Long> {

}
