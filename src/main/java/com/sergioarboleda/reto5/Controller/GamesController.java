package com.sergioarboleda.reto5.Controller;

import com.sergioarboleda.reto5.Model.Game;
import com.sergioarboleda.reto5.Service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Game")
public class GamesController {

    @Autowired
    private GamesService gameService;

    @GetMapping("/all")
    public List<Game> getAll(){return gameService.getAll();}

    @GetMapping("/{id}")
    public Optional<Game> getGame(@PathVariable("id") int id){return gameService.getGame(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody Game game){ return gameService.save(game);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Game update(@RequestBody Game game){return gameService.update(game);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") int id){return gameService.deleteGame(id);}
}
        