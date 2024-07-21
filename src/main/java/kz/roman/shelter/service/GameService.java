package kz.roman.shelter.service;

import kz.roman.shelter.model.dto.CharacterDto;
import kz.roman.shelter.model.entity.Game;
import reactor.core.publisher.Mono;

public interface GameService {

    String createNewGame(int players);

    Mono<Game> findByCode(String code);

    String finishGame(String code);
}
