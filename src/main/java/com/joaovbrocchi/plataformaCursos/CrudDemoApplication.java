package com.joaovbrocchi.plataformaCursos;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {


	@Bean
	CommandLineRunner commandLineRunner(String[] args){
		return runner -> System.out.println("mandando braza");
	}



}
