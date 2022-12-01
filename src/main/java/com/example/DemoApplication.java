package com.example;

import com.example.model.Libros;
import com.example.model.LibrosRole;
import com.example.service.ServiceExample;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

//https://github.com/murraco/spring-boot-jwt.git
@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	final ServiceExample service;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Override
	public void run(String... params) throws Exception {
		Libros admin = new Libros();
		admin.setUsername("admin");
		admin.setPassword("admin");
	//	admin.setEmail("admin@email.com");
		admin.setLibrosRole(new ArrayList<LibrosRole>(Arrays.asList(LibrosRole.ROLE_ADMIN)));

		service.signup(admin);

		Libros user = new Libros();
		user.setUsername("client");
		user.setPassword("client");
	//	user.setEmail("client@email.com");
		user.setLibrosRole(new ArrayList<LibrosRole>(Arrays.asList(LibrosRole.ROLE_CLIENT)));

		service.signup(user);
	}

}
