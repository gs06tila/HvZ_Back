package se.experis.HvZ.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.HvZ.domain.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    DeathRepository deathRepository;

    @Autowired
    GameRepository gameRepository;

    @GetMapping("/api/setDeath")
    @ResponseBody
    public boolean getPlayer(@RequestParam String biteCode, @RequestParam int killerId) {
        Player victim = new Player();
        Player killer = new Player();
        Game g1 = new Game();

        victim = playerRepository.findPlayerByBiteCode(biteCode).get(0);
        killer = playerRepository.findById((long) killerId).get();
        g1 = killer.getGame();
        //g1 = gameRepository.findById((long) victim.getGa)
        if(victim != null && killer.getBiteCode() != null) {
            victim.setHuman(false);
            System.out.println(victim.getBiteCode() + "--------------------------------------------<");
            System.out.println(killer.getBiteCode() + "--------------------------------------------<");
            Death d1 = new Death(52.24323D, 23.32435D, g1, killer, victim);
            deathRepository.save(d1);

            return true;
        } else {
            return false;
        }


    }
}
