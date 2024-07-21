package kz.roman.shelter.service.impl;

import kz.roman.shelter.exceptions.GameFullException;
import kz.roman.shelter.exceptions.GameNotFoundException;
import kz.roman.shelter.mappers.CharacterMapper;
import kz.roman.shelter.model.AvailableSpecifications;
import kz.roman.shelter.model.dto.CharacterDto;
import kz.roman.shelter.model.entity.Character;
import kz.roman.shelter.model.entity.Game;
import kz.roman.shelter.model.entity.specifications.*;
import kz.roman.shelter.model.enums.Sex;
import kz.roman.shelter.repository.CharacterRepository;
import kz.roman.shelter.repository.GameRepository;
import kz.roman.shelter.service.CharacterService;
import kz.roman.shelter.service.generator.SpecificationGenerator;
import kz.roman.shelter.utils.RandomUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;
    private final GameRepository gameRepository;
    private final SpecificationGenerator specGenerator;


    @Override
    public Mono<CharacterDto> connectToGame(String playerName, String code) {
        return gameRepository.findByCode(code)
                .switchIfEmpty(Mono.error(new GameNotFoundException("Game with code was not found")))
                .publishOn(Schedulers.boundedElastic())
                .flatMap(game -> {
                    Character character = game.getCharacterList()
                            .stream()
                            .filter(chr -> Objects.isNull(chr.getPlayerName()))
                            .findFirst()
                            .orElse(null);
                    if (character == null) {
                        return Mono.error(new GameFullException("Game is full"));
                    }
                    character.setPlayerName(playerName);
                    return characterRepository.save(character)
                            .map(CharacterMapper::characterToDto);
                })
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Transactional
    @Override
    public List<Character> generateNewCharacter(int players, AvailableSpecifications specs, Game game) {
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < players; i++) {
            Character newCharacter = new Character();
            newCharacter.setId(UUID.randomUUID());
            newCharacter.setOccupation(specGenerator.generateOccupation(specs.getAvailableOccupations()));
            newCharacter.setHealth(specGenerator.generateHealth());
            newCharacter.setAge(specGenerator.generateAge());
            newCharacter.setSex(specGenerator.generateSex());
            newCharacter.setBaggage(specGenerator.generateBaggage(specs.getAvailableBaggage()));
            newCharacter.setFact(specGenerator.generateFact(specs.getAvailableFacts()));
            newCharacter.setPhobia(specGenerator.generatePhobia(specs.getAvailablePhobia()));
            newCharacter.setGame(game);

            log.info("Generated new character: {}", newCharacter);
            characterRepository.save(newCharacter);
            characterList.add(newCharacter);
        }
        return characterList;
    }

}
