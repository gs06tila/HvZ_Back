package se.experis.HvZ.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.experis.HvZ.domain.*;

import java.util.ArrayList;

@RestController
public class PlayerController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    DeathRepository deathRepository;

    @Autowired
    GameUserRepository gameUserRepository;

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

    @PostMapping("/api/playersdata")
    @ResponseBody
    public ArrayList getPlayerData(@RequestBody FetchGameInfo fetchGameInfo) {

        ArrayList<ObjectNode> playersData = new ArrayList<>();
        String userName;
        Boolean isHuman;
        long squadId;

        int numberOfPlayers = gameRepository.findById((long) 1).get().getPlayers().size();
        for(int i=0; i < numberOfPlayers ; i++){
            ObjectNode playerObject = objectMapper.createObjectNode();
            userName = gameRepository.findById((long) 1).get().getPlayers().get(i).getGameUser().getUserName();
            isHuman = gameRepository.findById((long) 1).get().getPlayers().get(i).getHuman();

            playerObject.put("userName", userName);
            playerObject.put("isHuman", isHuman);

            if(gameRepository.findById((long) 1).get().getPlayers().get(i).getSquadMember() != null) {
                squadId = gameRepository.findById((long) 1).get().getPlayers().get(i).getSquadMember().getSquad().getSquadId();
                playerObject.put("squadId", squadId);
            }else{
                playerObject.put("squadId", -1);
            }

            playersData.add(playerObject);

       }
        return playersData;
    }
}
