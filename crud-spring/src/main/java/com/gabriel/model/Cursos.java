package com.gabriel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data // Getter e Setter LOMBOK
@Entity
//@Table(name = "----") => Personalizar nome da tabela banco de dados
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id") //transformar id para _id no json
    private Long id;

    @Column (nullable = false, length = 200 /* não permite que a coluna seja nula */ ) // (name = "nome")  Personalizar nome da coluna banco de dados
    private String name;

    @Column (nullable = false, length = 10)
    private String category;

}
