package com.example.service;

import com.example.exception.MyException;
import com.example.model.Libros;
import com.example.repository.Biblioteca;
import com.example.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceExample {

    private final Biblioteca biblioteca;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, biblioteca.findByUsername(username).getLibrosRole());
        } catch (AuthenticationException e) {
            throw new MyException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    public String signup(Libros libros) {
        if (!biblioteca.existsByUsername(libros.getUsername())) {
            libros.setPassword(passwordEncoder.encode(libros.getPassword()));
            biblioteca.save(libros);
            return jwtTokenProvider.createToken(libros.getUsername(), libros.getLibrosRole());
        } else {
            throw new MyException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }





}
