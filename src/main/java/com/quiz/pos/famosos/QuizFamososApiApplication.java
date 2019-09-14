package com.quiz.pos.famosos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.hakai.dragon.world.*")
//@EntityScan("com.enterprise.sib.api.*")
//@EnableJpaRepositories

public class QuizFamososApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizFamososApiApplication.class, args);
	}

}
