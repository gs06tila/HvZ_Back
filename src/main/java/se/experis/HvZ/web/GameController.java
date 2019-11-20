package se.experis.HvZ.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.experis.HvZ.domain.*;

import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/api/getgameinfo")
    @ResponseBody
    public Optional<Game> getGame() {

        Player p1 = new Player();
        GameUser gu1 = new GameUser();

        String s1 = gameRepository.findById((long) 1).get().getPlayers().get(0).getGameUser().getUserName();

        System.out.println(s1 + "------------------------------------------------->");

        return gameRepository.findById((long) 1);
    }
}
