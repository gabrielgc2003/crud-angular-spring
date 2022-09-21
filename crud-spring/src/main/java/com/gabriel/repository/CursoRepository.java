package com.gabriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.model.Cursos;

@Repository
public interface CursoRepository extends JpaRepository <Cursos /* Model banco de dados */, Long /* Tipo chave primaria */>{
    
}
