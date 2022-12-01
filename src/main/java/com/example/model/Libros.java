package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String titulo;

    @Column
    private String autor;

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(unique = true, nullable = false)
    private String username;

    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;


    @ElementCollection(fetch = FetchType.EAGER)
    List<LibrosRole> librosRole;


}
