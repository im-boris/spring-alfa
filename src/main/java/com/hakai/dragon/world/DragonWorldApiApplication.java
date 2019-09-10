package com.hakai.dragon.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.hakai.dragon.world.*")
//@EntityScan("com.enterprise.sib.api.*")
//@EnableJpaRepositories

public class DragonWorldApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DragonWorldApiApplication.class, args);
	}

}
