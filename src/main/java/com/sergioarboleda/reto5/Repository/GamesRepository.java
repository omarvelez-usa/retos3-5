package com.sergioarboleda.reto5.Repository;

import com.sergioarboleda.reto5.Crudrepository.GamesCrudRepository;
import com.sergioarboleda.reto5.Model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GamesRepository {
    @Autowired
    private GamesCrudRepository gamesCrudRepository;

    public List<Game> getAll() {
        return (List<Game>)  gamesCrudRepository.findAll();
    }

    public Optional<Game> getGame(int id){
        return gamesCrudRepository.findById(id);
    }

    public Game save(Game game){
        return gamesCrudRepository.save(game);
    }

    public void delete(Game game){gamesCrudRepository.delete(game);}
}