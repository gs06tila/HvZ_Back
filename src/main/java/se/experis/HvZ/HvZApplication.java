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

	@Autowired
	private DeathRepository deathRepository;



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
		//------------------------------------GAME-----------------------------------------------------//

			Game g1 = new Game("Linköping HvZ Game", "Registration", wallOfText, "Linköping Zombie Killers game Viagraparken", 50.374652D, 51.938274D, 80.394856D, 81.384956D, d1, d2);
			gameRepository.save(g1);
			Game g2 = new Game("Karlskrona HvZ Game", "In Progress", wallOfText, "campus gräsvik hvz lördag den 19/11", 50.374652D, 51.938274D, 80.394856D, 81.384956D, d1, d2);
			gameRepository.save(g2);
			Game g3 = new Game("Malmö HvZ Game", "In Progress", wallOfText, "Malmö turning torso HVZ game", 50.374652D, 51.938274D, 80.394856D, 81.384956D, d1, d2);
			gameRepository.save(g3);
			Game g4 = new Game("Göteborg HvZ Game", "In Progress", wallOfText, "Lisebergs HvZ söndag", 50.374652D, 51.938274D, 80.394856D, 81.384956D, d1, d2);
			gameRepository.save(g4);
			Game g5 = new Game("Stockholm HvZ Game", "Completed", wallOfText, "Gröndalunds hvZ tisdag", 50.374652D, 51.938274D, 80.394856D, 81.384956D, d1, d2);
			gameRepository.save(g5);
			//---------------------------------------Users-----------------------------------------//

			GameUser u1 = new GameUser("Pär", "qqqqqqqqq", "Token", "Password", "kalle@kalle.se", "PärTheDestroyer");
			gameUserRepository.save(u1);
			GameUser u2 = new GameUser("Tim", "wwwwwwwwww", "Token", "Password", "kalle@kalle.se", "TimTheDestroyer");
			gameUserRepository.save(u2);
			GameUser u3 = new GameUser("Edis", "eeeeeeee", "Token", "Password", "kalle@kalle.se", "EdisTheDestroyer");
			gameUserRepository.save(u3);
			GameUser u4 = new GameUser("Mikael", "rrrrrrrrr", "Token", "Password", "kalle@kalle.se", "MikaelTheDestroyer");
			gameUserRepository.save(u4);
			GameUser u5 = new GameUser("Craig", "ttttttttt", "Token", "Password", "kalle@kalle.se", "CraigTheDestroyer");
			gameUserRepository.save(u5);

			//-------------------------------Players-------------------------------------//

			Player p1 = new Player("p1bitecode", u1, g1);
			playerRepository.save(p1);

			Player p2 = new Player("p2bitecode", u2, g1);
			playerRepository.save(p2);

			Player p3 = new Player("p3bitecode", u3, g1);
			playerRepository.save(p3);

			Player p4 = new Player("p4bitecode", u4, g4);
			playerRepository.save(p4);

			Player p5 = new Player("p5bitecode", u5);
			playerRepository.save(p5);

			Player p6 = new Player("p6bitecode", u1, g2);
			playerRepository.save(p6);

			Player p7 = new Player("p7bitecode", u2, g2);
			playerRepository.save(p7);

			Player p8 = new Player("p8bitecode", u3, g2);
			playerRepository.save(p8);

			Player p9 = new Player("p9bitecode", u4, g4);
			playerRepository.save(p9);

			Player p10 = new Player("p10bitecode", u5,g3);
			playerRepository.save(p10);



			//-----------------------------------Squad--------------------------------------------//

			Squad s1 = new Squad("ZombieHunters", g1);
			squadRepository.save(s1);

			Squad s2 = new Squad("Killers", g1);
			squadRepository.save(s1);

			Squad s3 = new Squad("Cowards", g1);
			squadRepository.save(s1);

			Squad s4 = new Squad("YoMamma", g4);
			squadRepository.save(s1);

			Squad s5 = new Squad("Yopapa", g4);
			squadRepository.save(s1);
			//-----------------------------------Chat---------------------------------------------//

			Chat c1 = new Chat("Hello chat message", true, false, g1, s1, p1);
			chatRepository.save(c1);

			Chat c2 = new Chat("Help", true, false,  g1, s1, p2);
			chatRepository.save(c1);

			Chat c3 = new Chat("No", true, false, g1, s1, p3);
			chatRepository.save(c1);

			Chat c4 = new Chat("Test123", true, false,  g1, p1);
			chatRepository.save(c1);

			Chat c5 = new Chat("zombies at mission 2", true, false,  g1, p2);
			chatRepository.save(c1);

			Chat c6 = new Chat("Rip", true, false,  g1, p3);
			chatRepository.save(c1);

			Chat c7 = new Chat("Anyone alive?", true, false,  g1, p4);
			chatRepository.save(c1);

			//----------------------------------Mission-------------------------------------------//

			List<Game> lg1 = new ArrayList<Game>();
			lg1.add(g1);
			lg1.add(g2);
			Mission m1 = new Mission("help", true, true, "kill all", d1, d2, 50.376381D, 51.235437D, lg1);
			missionRepository.save(m1);

			//--------------------------------Squadmembers---------------------------------------//

			SquadMember sm1 = new SquadMember("leader", s1, p1);
			squadMemberRepository.save(sm1);

			SquadMember sm2 = new SquadMember("noob1", s1, p2);
			squadMemberRepository.save(sm2);

			SquadMember sm3 = new SquadMember("noob2", s1, p3);
			squadMemberRepository.save(sm3);

			//------------------------------SquadCreate------------------------------------------//

			SquadCreate sc1 = new SquadCreate(57.234356D, 34.236576D, g1, sm1, s1);
			squadCreateRepository.save(sc1);

			//--------------------------------Deaths-------------------------------------------//

			Death de1 = new Death(81.384956D, 82.384956D, g1, p1, p2);
			deathRepository.save(de1);
		};
	}

}
