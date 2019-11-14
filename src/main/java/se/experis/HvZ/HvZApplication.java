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

			Game g1 = new Game("Linköping HvZ Game", "Registration", wallOfText, "Linköping Zombie Killers game Viagraparken", 56.87111D, 56.87999D, 14.80111D, 14.80999D, d1, d2);
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
			// Password: password

			GameUser u1 = new GameUser("Pär", "qqqqqqqqq", "Token", "$2a$10$wZQmZulYBiFflXoD9UicF.9.UYB7NzUbUAx0qI8Kc.mgZMFj/6M9W", "kalle@kalle.se", "Pär","ADMIN");
			gameUserRepository.save(u1);
			GameUser u2 = new GameUser("Tim", "wwwwwwwwww", "Token", "$2a$10$wZQmZulYBiFflXoD9UicF.9.UYB7NzUbUAx0qI8Kc.mgZMFj/6M9W", "kalle@kalle.se", "Tim","USER");
			gameUserRepository.save(u2);
			GameUser u3 = new GameUser("Edis", "eeeeeeee", "Token", "$2a$10$wZQmZulYBiFflXoD9UicF.9.UYB7NzUbUAx0qI8Kc.mgZMFj/6M9W", "kalle@kalle.se", "EdisTheDestroyer","USER");
			gameUserRepository.save(u3);
			GameUser u4 = new GameUser("Mikael", "rrrrrrrrr", "Token", "$2a$10$wZQmZulYBiFflXoD9UicF.9.UYB7NzUbUAx0qI8Kc.mgZMFj/6M9W", "kalle@kalle.se", "MikaelTheDestroyer", "USER");
			gameUserRepository.save(u4);
			GameUser u5 = new GameUser("Craig", "ttttttttt", "Token", "$2a$10$wZQmZulYBiFflXoD9UicF.9.UYB7NzUbUAx0qI8Kc.mgZMFj/6M9W", "kalle@kalle.se", "CraigTheDestroyer", "USER");
			gameUserRepository.save(u5);
			GameUser u6 = new GameUser("postmanTest", "ttttttttt", "Token", "$2a$10$wZQmZulYBewqdfwfwiFflXoD9UicF.9.UYB7NzUbUAx0qI8Kc.mgZMFj/6M9W", "kalle@kalle.se", "postmanTest", "USER");
			gameUserRepository.save(u6);
			GameUser u7 = new GameUser("Postmantest1", "ttttttttt", "Token", "$2a$10$wZQmZulYBiFflXoD9UicF.9.UYB7NzUbUAx0qI8Kc.mgZMFj/6M9W", "kalle@kalle.se", "postmantest1", "USER");
			gameUserRepository.save(u7);
			GameUser u8 = new GameUser("postmanTest3", "ttttttttt", "Token", "$2a$10$wZQmZulYBewqdfwfwiFflXoD9UicF.9.UYB7NzUbUAx0qI8Kc.mgZMFj/6M9W", "kalle@kalle.se", "postmantest3", "USER");
			gameUserRepository.save(u8);

			//-------------------------------Players-----------------------------------------------//

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

			Player p6 = new Player("p6bitecode", u6, g1);
			playerRepository.save(p6);

			Player p7 = new Player("p7bitecode", u7, g1);
			playerRepository.save(p7);

			Player p8 = new Player("p8bitecode", u8, g1);
			playerRepository.save(p8);



			//-----------------------------------Squad--------------------------------------------//

			Squad s1 = new Squad("ZombieHunters", g1);
			squadRepository.save(s1);

			Squad s2 = new Squad("Killers", g1);
			squadRepository.save(s2);

			Squad s3 = new Squad("Cowards", g1);
			squadRepository.save(s3);

			Squad s4 = new Squad("YoMamma", g4);
			squadRepository.save(s4);

			Squad s5 = new Squad("Yopapa", g4);
			squadRepository.save(s5);
			//-----------------------------------Chat---------------------------------------------//

			Chat c1 = new Chat("Hello chat message", true, false, g1, s1, p1);
			chatRepository.save(c1);

			Chat c2 = new Chat("Help", true, false,  g1, s1, p2);
			chatRepository.save(c2);

			Chat c3 = new Chat("No", true, false, g1, s1, p3);
			chatRepository.save(c3);

			Chat c4 = new Chat("Test123", true, false,  g1, p1);
			chatRepository.save(c4);

			Chat c5 = new Chat("zombies at mission 2", true, false,  g1, p2);
			chatRepository.save(c5);

			Chat c6 = new Chat("Rip", true, false,  g1, p3);
			chatRepository.save(c6);

			Chat c7 = new Chat("Anyone alive?", true, false,  g1, p4);
			chatRepository.save(c7);

			//----------------------------------Mission-------------------------------------------//

			List<Game> lg1 = new ArrayList<Game>();
			lg1.add(g1);
			lg1.add(g2);
			lg1.add(g3);
			lg1.add(g4);
			lg1.add(g5);

			Mission m1 = new Mission("help", true, true, "kill all", d1, d2, 56.87455D, 14.80911D, lg1);
			missionRepository.save(m1);

			Mission m2 = new Mission("mission2", true, true, "Run for your life", d1, d2, 56.87233D, 14.80811D, lg1);
			missionRepository.save(m2);

			Mission m3 = new Mission("Zombies rules yay :D", true, true, "Kill all the humans", d1, d2, 56.87122D, 14.80722D, lg1);
			missionRepository.save(m3);


			//--------------------------------Squadmembers---------------------------------------//

			SquadMember sm1 = new SquadMember("leader", s1, p1);
			squadMemberRepository.save(sm1);

			SquadMember sm2 = new SquadMember("noob1", s1, p2);
			squadMemberRepository.save(sm2);

			SquadMember sm3 = new SquadMember("noob2", s1, p3);
			squadMemberRepository.save(sm3);

			SquadMember sm4 = new SquadMember("TheSupremeLeader", s2, p4);
			squadMemberRepository.save(sm4);

			SquadMember sm5 = new SquadMember("potatoFarmer", s2, p5);
			squadMemberRepository.save(sm5);

			//------------------------------SquadCreate------------------------------------------//

			SquadCreate sc1 = new SquadCreate(57.234356D, 34.236576D, g1, sm1, s1);
			squadCreateRepository.save(sc1);

			SquadCreate sc2 = new SquadCreate(57.234356D, 34.236576D, g1, sm4, s2);
			squadCreateRepository.save(sc2);

			//--------------------------------Deaths-------------------------------------------//

			Death de1 = new Death(56.87677D, 14.80906D, g1, p1, p2);
			deathRepository.save(de1);

			Death de2 = new Death(56.87687D, 14.80926D, g1, p1, p3);
			deathRepository.save(de2);

		};
	}

}
