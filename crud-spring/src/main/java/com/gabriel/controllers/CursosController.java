package com.gabriel.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Cursos create(@RequestBody Cursos cursos){
        return cursoRepository.save(cursos);
    }
}
