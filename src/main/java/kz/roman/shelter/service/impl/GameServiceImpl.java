package kz.roman.shelter.service.impl;

import kz.roman.shelter.exceptions.GameNotFoundException;
import kz.roman.shelter.model.AvailableSpecifications;
import kz.roman.shelter.model.entity.Game;
import kz.roman.shelter.repository.GameRepository;
import kz.roman.shelter.service.CharacterService;
import kz.roman.shelter.service.GameService;
import kz.roman.shelter.utils.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final CharacterService characterService;
    private final GameRepository gameRepository;

    @Override
    public String createNewGame(int players) {
        AvailableSpecifications specs = AvailableSpecifications.getAvailableSpecifications();
        Game newGame = Game.builder()
                .id(UUID.randomUUID())
                .playersNumber(players)
                .code(RandomUtil.generateRandomCode())
                .isActive(true)
                .isFinished(false)
                .build();
        gameRepository.save(newGame);
        newGame.setCharacterList(characterService.generateNewCharacter(players, specs, newGame));

        return newGame.getCode();
    }

    @Override
    public Mono<Game> findByCode(String code) {
        return gameRepository.findByCode(code)
                .switchIfEmpty(Mono.error(new GameNotFoundException("Game with code was not found")));
    }

    @Override
    public String finishGame(String code) {
        Game game = gameRepository.findByCode(code)
                .blockOptional()
                .orElseThrow(() -> new GameNotFoundException("Game with code was not found"));

        LocalDateTime endDate = LocalDateTime.now();

        game.setIsFinished(true);
        game.setIsActive(false);
        game.setEndDate(endDate);

        gameRepository.save(game);

        return String.format("Game finished at %s", endDate);
    }
}
