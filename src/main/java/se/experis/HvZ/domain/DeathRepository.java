package se.experis.HvZ.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DeathRepository extends CrudRepository<Death, Long> {
}
