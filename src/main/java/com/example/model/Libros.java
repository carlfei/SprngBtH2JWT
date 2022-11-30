package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Libros {

    @Id
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String titulo;
    @Column
    private String autor;


}
