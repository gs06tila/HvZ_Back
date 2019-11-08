package se.experis.HvZ;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.experis.HvZ.domain.Game;
import se.experis.HvZ.domain.GameRepository;
import se.experis.HvZ.domain.GameUser;
import se.experis.HvZ.domain.GameUserRepository;

import java.util.Date;


@SpringBootApplication
public class HvZApplication {

	private static final Logger logger = LoggerFactory.getLogger(HvZApplication.class);

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private GameUserRepository gameUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(HvZApplication.class, args);
		logger.info("Hello spring boot");
	}

	@Bean
	CommandLineRunner runner() {
	    // Heroku
		return args -> {
			System.out.println("hej");
		};
	}

}
