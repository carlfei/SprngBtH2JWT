package com.example.repository;

import com.example.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Biblioteca extends JpaRepository<Libros, Integer > {
    boolean existsByUsername(String username);
    Libros findByUsername(String username);
    @Transactional
    void deleteByUsername(String username);
}
