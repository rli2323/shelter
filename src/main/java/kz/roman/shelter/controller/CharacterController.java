package kz.roman.shelter.controller;

import kz.roman.shelter.model.dto.CharacterDto;
import kz.roman.shelter.service.CharacterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
@Slf4j
public class CharacterController {

    private final CharacterService characterService;

    @PostMapping("/game/{code}")
    public Mono<ResponseEntity<CharacterDto>> connectToGame(@PathVariable String code,
                                            @RequestParam String playerName) {
        log.info("Connect to game and create character");
        return characterService.connectToGame(playerName, code)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
