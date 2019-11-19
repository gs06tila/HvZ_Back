package se.experis.HvZ.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.experis.HvZ.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ArrayNode getPlayerData(@RequestBody FetchGameInfo fetchGameInfo) {

        /*
        ArrayNode playersdata = objectMapper.createArrayNode();
        ObjectNode playerObject = objectMapper.createObjectNode();

        playerObject.put("key", "value");
        playerObject.put("key1", "value1");
        playerObject.put("key2", "value2");

        playersdata.add(playerObject);

        List<Player> l1 = new ArrayList<>();
        l1 = playerRepository.findAll();

         for(int i =0; i< l1.size(); i++ ){
             System.out.println(l1.get(i).getPlayerId());
             //l1.get(i).getPlayerId()
             //gameUserRepository
             List<GameUser> gameUsers;
             //gameUsers = playerRepository.findByGameUser(l1.get(i).getGameUser());
             //System.out.println(gameUsers.get(0).getUserName());
         }
         */

        //int b2 = gameRepository.findById((long) 1).get().getPlayers().size();
        //System.out.println("b2: " + b2 + "-------------------------------------------------");

        ArrayNode playersData = objectMapper.createArrayNode();
        ObjectNode playerObject = objectMapper.createObjectNode();

        String userName;
        userName = gameRepository.findById((long) fetchGameInfo.getGameId()).get().getPlayers().get(0).getGameUser().getUserName();
        Boolean isHuman;
        isHuman = gameRepository.findById((long) fetchGameInfo.getGameId()).get().getPlayers().get(0).getHuman();
        long squadId;
        squadId = gameRepository.findById((long) fetchGameInfo.getGameId()).get().getPlayers().get(0).getSquadMember().getSquad().getSquadId();

        playerObject.put("userName", userName);
        playerObject.put("isHuman", isHuman);
        playerObject.put("squadId", squadId);

        playersData.add(playerObject);
        playerObject.removeAll();

        playerObject.put("userNams", userName + "s");
        playerObject.put("isHuman", isHuman);
        playerObject.put("squadId", squadId);

        playersData.add(playerObject);


    /*
        ArrayNode playersData = objectMapper.createArrayNode();
        ObjectNode playerObject = objectMapper.createObjectNode();

        String userName;
        Boolean isHuman;
        long squadId;

        int numberOfPlayers = gameRepository.findById((long) 1).get().getPlayers().size();
        //for(int i=1; i < numberOfPlayers + 1 ; i++){
            userName = gameRepository.findById((long)fetchGameInfo.getGameId()).get().getPlayers().get(0).getGameUser().getUserName();
            isHuman = gameRepository.findById((long)fetchGameInfo.getGameId()).get().getPlayers().get(0).getHuman();
            squadId = gameRepository.findById((long)fetchGameInfo.getGameId()).get().getPlayers().get(0).getSquadMember().getSquad().getSquadId();

            playerObject.put("userName", userName);
            playerObject.put("isHuman", isHuman);
            playerObject.put("squadId", squadId);

            playersData.add(playerObject);
            playerObject.removeAll();
      //  }
        */

        return playersData;
    }
}
