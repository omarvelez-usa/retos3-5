package com.sergioarboleda.reto5.Service;

import com.sergioarboleda.reto5.Repository.GamesRepository;
import com.sergioarboleda.reto5.Model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamesService {
    @Autowired
    private GamesRepository gamesRepository;

    public List<Game> getAll(){
        return gamesRepository.getAll();
    }

    public Optional<Game> getGame(int id){
        return gamesRepository.getGame(id);
    }

    public Game save(Game game){
        if(game.getId()==null){
            return gamesRepository.save(game);
        }else{
            Optional<Game> tmpGame = gamesRepository.getGame(game.getId());
            if(tmpGame.isEmpty()) {
                return gamesRepository.save(game);
            }else{
                return game;
            }
        }
    }

    public Game update(Game game){
        if(game.getId()!=null){
            Optional<Game> e=gamesRepository.getGame(game.getId());
            if(!e.isEmpty()){
                if(game.getName()!=null){
                    e.get().setName(game.getName());
                }
                if(game.getDeveloper()!=null){
                    e.get().setDeveloper(game.getDeveloper()); ;
                }
                if(game.getYear()!=null){
                    e.get().setYear(game.getYear());
                }
                if(game.getDescription()!=null){
                    e.get().setDescription(game.getDescription());
                }
                if(game.getCategory()!=null){
                    e.get().setCategory(game.getCategory());
                }
                gamesRepository.save(e.get());
                return e.get();
            }else{
                return game;
            }
        }else{
            return game;
        }
    }

    public boolean deleteGame(int id){
        Boolean aBoolean = getGame(id).map(game -> {
            gamesRepository.delete(game);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
