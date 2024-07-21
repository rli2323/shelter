package kz.roman.shelter.repository;

import kz.roman.shelter.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GameRepository extends ReactiveCrudRepository<Game, UUID> {

    Mono<Game> findByCode(String code);
}
