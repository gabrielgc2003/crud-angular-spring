package com.gabriel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gabriel.model.Cursos;
import com.gabriel.repository.CursoRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(CursoRepository cursoRepository){
		return args -> {
			cursoRepository.deleteAll();

			Cursos c = new Cursos();
			c.setName("Angular com Spring");
			c.setCategory("front-end");

			cursoRepository.save(c);
		};
	}

}
