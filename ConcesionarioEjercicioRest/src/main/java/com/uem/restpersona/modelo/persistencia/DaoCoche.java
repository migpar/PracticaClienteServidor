package com.uem.restpersona.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uem.restpersona.modelo.entidad.Coche;

@Repository
public interface DaoCoche extends JpaRepository<Coche, Integer>{

}
