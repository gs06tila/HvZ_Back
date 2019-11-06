package se.experis.HvZ;

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

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private GameUserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(HvZApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Date d1 = new Date(2019, 07, 18);
			Date d2 = new Date(119, 6, 19);
			Game g1 = new Game("First HvZ Game", "In Progress", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Perferendis tempora ad cum laudantium, omnis fugit amet iure animi corporis labore repellat magnam perspiciatis explicabo maiores fuga provident a obcaecati tenetur nostrum, quidem quod dignissimos, voluptatem quasi? Nisi quaerat, fugit voluptas ducimus facilis impedit quod dicta, laborum sint iure nihil veniam aspernatur delectus officia culpa, at cupiditate? Totam minima ut deleniti laboriosam dolores cumque in, nesciunt optio! Quod recusandae voluptate facere pariatur soluta vel corrupti tenetur aut maiores, cumque mollitia fugiat laudantium error odit voluptas nobis laboriosam quo, rem deleniti? Iste quidem amet perferendis sed iusto tempora modi illo tempore quibusdam laborum? Dicta aliquam libero, facere, maxime corporis qui officiis explicabo aspernatur non consequatur mollitia iure magnam odit enim. Eligendi suscipit, optio officiis repellat eos quis iure? Omnis, error aliquid quibusdam iste amet nihil nisi cumque magni sequi enim illo autem nesciunt optio accusantium animi commodi tenetur neque eum vitae est.", "Short Description HELLLLLOokeajfpoiefj peowjfcwe", 50.374652, 51.938274, 80.394856, 81.384956, d1, d2);
			gameRepository.save(g1);

			GameUser u1 = new GameUser("Kalle", "Svensson", "Token", "Password", "kalle@kalle.se");
			userRepository.save(u1);
		};
	}

}
