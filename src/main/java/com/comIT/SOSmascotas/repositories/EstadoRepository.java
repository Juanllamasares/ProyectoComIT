package com.comIT.SOSmascotas.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comIT.SOSmascotas.entidades.Estado;
@Repository
@Transactional
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
