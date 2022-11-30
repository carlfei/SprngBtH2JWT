package com.example.controller;

import com.example.model.Libros;
import com.example.repository.Biblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controlador {
    @Autowired
    Biblioteca biblioteca;



    List<Libros> libros = new ArrayList<>();

    @GetMapping("/list/{id}")
    public List<Libros> listar(@PathVariable(value = "id") Long id){

        return (biblioteca.findById(id)).stream().collect(Collectors.toList());

    }
    @GetMapping("/listAdd/{id}/{titulo}/{autor}")
    public List<Libros> anyadir(@PathVariable(value = "id") Long id,
                               @PathVariable(value = "titulo") String titulo,
                               @PathVariable(value = "autor") String autor){
                             libros.add(new Libros(id,titulo,autor));
                             biblioteca.saveAll(libros);


        return libros
                .stream()
                .collect(Collectors.toList());

    }



}
