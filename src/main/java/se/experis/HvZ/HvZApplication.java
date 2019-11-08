package se.experis.HvZ;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.experis.HvZ.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class HvZApplication {

	private static final Logger logger = LoggerFactory.getLogger(HvZApplication.class);

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private GameUserRepository gameUserRepository;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private MissionRepository missionRepository;

	@Autowired
	private ChatRepository chatRepository;

	@Autowired
    private SquadRepository squadRepository;

	@Autowired
	private SquadCreateRepository squadCreateRepository;

	@Autowired
	private SquadMemberRepository squadMemberRepository;



	public static void main(String[] args) {
		SpringApplication.run(HvZApplication.class, args);
		logger.info("Hello spring boot");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			String wallOfText = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Perferendis tempora ad cum laudantium, omnis fugit amet iure animi corporis labore repellat magnam perspiciatis explicabo maiores fuga provident a obcaecati tenetur nostrum, quidem quod dignissimos, voluptatem quasi? Nisi quaerat, fugit voluptas ducimus facilis impedit quod dicta, laborum sint iure nihil veniam aspernatur delectus officia culpa, at cupiditate? Totam minima ut deleniti laboriosam dolores cumque in, nesciunt optio! Quod recusandae voluptate facere pariatur soluta vel corrupti tenetur aut maiores, cumque mollitia fugiat laudantium error odit voluptas nobis laboriosam quo, rem deleniti? Iste quidem amet perferendis sed iusto tempora modi illo tempore quibusdam laborum? Dicta aliquam libero, facere, maxime corporis qui officiis explicabo aspernatur non consequatur mollitia iure magnam odit enim. Eligendi suscipit, optio officiis repellat eos quis iure? Omnis, error aliquid quibusdam iste amet nihil nisi cumque magni sequi enim illo autem nesciunt optio accusantium animi commodi tenetur neque eum vitae est.";

			Date d1 = new Date(2019, 7, 18);
			Date d2 = new Date(119, 6, 19);
			Game g1 = new Game("1 HvZ Game", "Registration", wallOfText, "Short Description HELLLLLOokeajfpoiefj peowjfcwe", 50.374652D, 51.938274D, 80.394856D, 81.384956D, d1, d2);
			gameRepository.save(g1);
			Game g2 = new Game("2 HvZ Game", "In Progress", wallOfText, "Short Description HELLLLLOokeajfpoiefj peowjfcwe", 50.374652D, 51.938274D, 80.394856D, 81.384956D, d1, d2);
			gameRepository.save(g2);
			Game g3 = new Game("3 HvZ Game", "In Progress", wallOfText, "Short Description HELLLLLOokeajfpoiefj peowjfcwe", 50.374652D, 51.938274D, 80.394856D, 81.384956D, d1, d2);
			gameRepository.save(g3);
			Game g4 = new Game("4 HvZ Game", "In Progress", wallOfText, "Short Description HELLLLLOokeajfpoiefj peowjfcwe", 50.374652D, 51.938274D, 80.394856D, 81.384956D, d1, d2);
			gameRepository.save(g4);
			Game g5 = new Game("5 HvZ Game", "Finished", wallOfText, "Short Description HELLLLLOokeajfpoiefj peowjfcwe", 50.374652D, 51.938274D, 80.394856D, 81.384956D, d1, d2);
			gameRepository.save(g5);
			GameUser u1 = new GameUser("u1", "qqqqqqqqq", "Token", "Password", "kalle@kalle.se", "qTheDestroyer");
			gameUserRepository.save(u1);
			GameUser u2 = new GameUser("u2", "wwwwwwwwww", "Token", "Password", "kalle@kalle.se", "wTheDestroyer");
			gameUserRepository.save(u2);
			GameUser u3 = new GameUser("u3", "eeeeeeee", "Token", "Password", "kalle@kalle.se", "eTheDestroyer");
			gameUserRepository.save(u3);
			GameUser u4 = new GameUser("u1", "rrrrrrrrr", "Token", "Password", "kalle@kalle.se", "rTheDestroyer");
			gameUserRepository.save(u4);
			GameUser u5 = new GameUser("u2", "ttttttttt", "Token", "Password", "kalle@kalle.se", "theDestroyer");
			gameUserRepository.save(u5);

			Player p1 = new Player("p1", u3, g1);
			playerRepository.save(p1);

			Squad s1 = new Squad("ZombieHunters", g1);
			squadRepository.save(s1);

			Chat c1 = new Chat("Hello chat message", true, false, true, g1, s1, p1);
			chatRepository.save(c1);

			List<Game> lg1 = new ArrayList<Game>();
			lg1.add(g1);
			lg1.add(g2);
			Mission m1 = new Mission("help", true, true, "kill all", d1, d2, 50.376381D, 51.235437D, lg1);
			missionRepository.save(m1);


			SquadMember sm1 = new SquadMember("leader");
			squadMemberRepository.save(sm1);

			SquadCreate sc1 = new SquadCreate(57.234356, 34.236576, g2, sm1, s1);
			squadCreateRepository.save(sc1);
		};
	}

}
