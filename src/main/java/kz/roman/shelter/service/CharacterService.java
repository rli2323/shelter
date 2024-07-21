package kz.roman.shelter.service;

import kz.roman.shelter.model.AvailableSpecifications;
import kz.roman.shelter.model.dto.CharacterDto;
import kz.roman.shelter.model.entity.Character;
import kz.roman.shelter.model.entity.Game;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CharacterService {

    List<Character> generateNewCharacter(int players, AvailableSpecifications specs, Game game);

    Mono<CharacterDto> connectToGame(String playerName, String code);
}
