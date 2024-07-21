package kz.roman.shelter.controller;


import kz.roman.shelter.model.entity.Game;
import kz.roman.shelter.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
@Slf4j
public class GameController {

    private final GameService gameService;

    @PostMapping("/new")
    public ResponseEntity<String> createNewGame(@RequestParam int players) {
        log.info("Create new game with {} players", players);
        return ResponseEntity.ok().body(gameService.createNewGame(players));
    }

    @PutMapping("/finish/{code}")
    public ResponseEntity<String> finishGame(@PathVariable String code) {
        log.info("Finish game with code : {}", code);
        return ResponseEntity.ok().body(gameService.finishGame(code));
    }

    @GetMapping("/{code}")
    public ResponseEntity<Game> getGameInformation(@PathVariable("code") String code) {
        log.info("Check game with code : {}", code);
        return ResponseEntity.ok().body(gameService.findByCode(code));
    }
}
