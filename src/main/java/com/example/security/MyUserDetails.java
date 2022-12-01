package com.example.security;

import com.example.model.Libros;
import com.example.repository.Biblioteca;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {

  private final Biblioteca biblioteca;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final Libros libros = biblioteca.findByUsername(username);

    if (libros == null) {
      throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    return org.springframework.security.core.userdetails.User//
        .withUsername(username)//
        .password(libros.getPassword())//
        .authorities(libros.getLibrosRole())//
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)//
        .build();
  }

}
