package com.examplemateuscurso.cursoremedios.repositories;

import com.examplemateuscurso.cursoremedios.entities.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface RemedioRepositorio extends JpaRepository<Remedio, Long> {
    List<Remedio> findAllByAtivoTrue();
}
