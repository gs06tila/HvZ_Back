package se.experis.HvZ.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameUserRepository extends CrudRepository<GameUser, Long> {
    GameUser findByUserName(String userName);
}
