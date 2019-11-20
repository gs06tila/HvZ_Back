package se.experis.HvZ.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/api/setDeath")
    @ResponseBody
    public ResponseEntity<Death> getPlayer(@RequestBody DeathCredentials deathCredentials) {
        Player victim = new Player();
        Player killer = new Player();
        Game g1 = new Game();

        victim = playerRepository.findPlayerByBiteCode(deathCredentials.getVictimBiteCode()).get(0);
        killer = playerRepository.findById((long)deathCredentials.getKillerId()).get();
        g1 = killer.getGame();
        if(victim != null && killer.getBiteCode() != null) {
            victim.setHuman(false);
            Death d1 = new Death(deathCredentials.getLat(), deathCredentials.getLng(), g1, killer, victim);
            deathRepository.save(d1);
            return new ResponseEntity<Death>(d1, HttpStatus.OK);
        } else {
            return new ResponseEntity<Death>(new Death(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/playersdata")
    @ResponseBody
    public ArrayNode getPlayerData(@RequestBody FetchGameInfo fetchGameInfo) {

        //ArrayList<ObjectNode> playersDataArray = new ArrayList<>();
        ArrayNode playersDataArray = objectMapper.createArrayNode();
        String userName;
        Boolean isHuman;
        long squadId, playerId;
        double lng,lat;

        int numberOfPlayers = gameRepository.findById((long) fetchGameInfo.getGameId()).get().getPlayers().size();
        for(int i=0; i < numberOfPlayers ; i++){

            ObjectNode playerObject = objectMapper.createObjectNode();
            userName = gameRepository.findById((long) fetchGameInfo.getGameId()).get().getPlayers().get(i).getGameUser().getUserName();
            isHuman = gameRepository.findById((long) fetchGameInfo.getGameId()).get().getPlayers().get(i).getHuman();
            playerId = gameRepository.findById((long) fetchGameInfo.getGameId()).get().getPlayers().get(i).getPlayerId();
            lng = gameRepository.findById((long) fetchGameInfo.getGameId()).get().getPlayers().get(i).getLng();
            lat = gameRepository.findById((long) fetchGameInfo.getGameId()).get().getPlayers().get(i).getLat();

            playerObject.put("userName", userName);
            playerObject.put("isHuman", isHuman);
            playerObject.put("playerId", playerId);
            playerObject.put("lat", lat);
            playerObject.put("lng", lng);

            if(gameRepository.findById((long) 1).get().getPlayers().get(i).getSquadMember() != null) {
                squadId = gameRepository.findById((long) 1).get().getPlayers().get(i).getSquadMember().getSquad().getSquadId();
                playerObject.put("squadId", squadId);
            }else{
                playerObject.put("squadId", -1);
            }

            playersDataArray.add(playerObject);

       }
        return playersDataArray;
    }
}
