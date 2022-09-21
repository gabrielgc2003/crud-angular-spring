package com.gabriel.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.model.Cursos;
import com.gabriel.repository.CursoRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cursos")
@AllArgsConstructor //Construtor gerado por LOMBOK
public class CursosController {

    private final CursoRepository cursoRepository;

    @GetMapping
    public @ResponseBody List<Cursos> list(){
        return cursoRepository.findAll();
        
    }
}
