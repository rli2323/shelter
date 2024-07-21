package kz.roman.shelter.repository;

import kz.roman.shelter.model.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CharacterRepository extends ReactiveCrudRepository<Character, UUID> {

    Optional<Character> findByPlayerName(String playerName);
}
