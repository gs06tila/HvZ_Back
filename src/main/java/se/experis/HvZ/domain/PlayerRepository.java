package se.experis.HvZ.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findPlayerByBiteCode(@Param("biteCode") String biteCode);
    List<Player> findAll();
}
